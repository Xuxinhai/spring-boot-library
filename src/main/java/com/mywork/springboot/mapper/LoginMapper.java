package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.Manager;
import com.mywork.springboot.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


public interface LoginMapper {

    //通过账号密码查询读者
    @Select("select * from reader where status=1 and reader_name=#{param1} and reader_password=#{param2}")
    Reader selByNameAndpass(String name,String password);

    //通过账号密码查询管理员
    @Select("select * from manager where status=1 and manager_name=#{param1} and manager_password=#{param2}")
    Manager selManByNameAndpass(String name,String password);
}
