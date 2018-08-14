package com.neo.mapper;

import com.neo.entity.UserEntity;
import com.neo.service.base.BaseMapper;
import org.apache.ibatis.annotations.Property;

/**
 * 不仅仅用来作为mybatis的mapper，还需要作为具体service的实现接口
 */

public interface UserMapper extends BaseMapper<UserEntity> {


    void insert(UserEntity user);

    void update(UserEntity obj);
}