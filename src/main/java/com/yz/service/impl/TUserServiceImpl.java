package com.yz.service.impl;

import com.yz.entity.TUser;
import com.yz.dao.TUserDao;
import com.yz.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-11 11:34:24
 */
@Service
public class TUserServiceImpl implements TUserService {

    private static final long DATE_FORMAT = 86_400_000L;

    @Autowired
    private TUserDao tUserDao;

    @Override
    public void stopOrRerun(int id) {
        TUser user = tUserDao.queryById(id);
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(user.getDuration());
        int durTime = Integer.parseInt(m.replaceAll("").trim());
        if(user.getState().equals("使用中")){
            int time = Integer.parseInt(String.valueOf((((long) durTime) * DATE_FORMAT - (System.currentTimeMillis() - user.getCreateTime().getTime())) / DATE_FORMAT));
            tUserDao.stop(id, time + 1);
        }else {
            long mTime = System.currentTimeMillis()+((long) durTime) * DATE_FORMAT;
            tUserDao.rerun(id,new Date(),durTime,new Date(mTime));
        }
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Integer id) {
        return this.tUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAll() {
        return this.tUserDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     */
    @Override
    public void insert(TUser tUser) {
        Date now = new Date();
        tUser.setCreateTime(now);
        if(tUser.getType().equals("次卡")){
            tUser.setDuration(tUser.getDuration()+"次");
            tUser.setEndTime(null);
        }else {
            Date end = new Date(now.getTime() + (Long.parseLong(tUser.getDuration()) * 24 * 60 * 60 * 1000));
            tUser.setEndTime(end);
            tUser.setDuration(tUser.getDuration()+"天");
        }
        tUser.setState("使用中");
        this.tUserDao.insert(tUser);
    }

    @Override
    public void renew(int time,int id) {
        TUser tUser = tUserDao.queryById(id);
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(tUser.getDuration());
        int durTime = Integer.parseInt(m.replaceAll("").trim());
        String duration;
        Date date = null;
        if (tUser.getType().equals("次卡")){
            duration = durTime + time + "次";
        }else {
            date = new Date(tUser.getCreateTime().getTime() + ((long) (durTime + time)) * 24 * 60 * 60 * 1000);
            duration = durTime + time + "天";
        }
        tUserDao.renew(duration,date,id);
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserDao.deleteById(id) > 0;
    }
}