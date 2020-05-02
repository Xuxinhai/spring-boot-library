package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.Manager;
import org.apache.ibatis.annotations.Update;

public interface ManagerMapper {

    //通过id修改密码

    @Update("update manager set manager_password=#{managerPassword} where manager_id=#{managerId}")
    int updPass(Manager manager);
}
