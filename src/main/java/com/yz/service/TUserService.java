package com.yz.service;

import com.yz.entity.TUser;
import java.util.List;

/**
 * (TUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-11 11:34:23
 */
public interface TUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<TUser> queryAll();

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     */
    void insert(TUser tUser);

    void renew(int time,int id);

    void stopOrRerun(int id);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    TUser update(TUser tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}