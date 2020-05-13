package com.yz.dao;

import com.yz.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * (TUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-11 11:34:23
 */
@Mapper
@Repository
public interface TUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUser queryById(Integer id);

    /**
     * 查询指定行数据
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

    void renew(String duration, Date date, int id);

    void stop(int id,int time);
    void rerun(int id,Date updateTime,int time,Date endTime);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    int update(TUser tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}