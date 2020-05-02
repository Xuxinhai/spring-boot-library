package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.Reader;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ReaderMapper {

    //更新reader by id
    @Update("update reader set reader_phone=#{readerPhone},reader_email=#{readerEmail} " +
            "where status=1 and reader_id=#{readerId}")
    int updReaderById(Reader reader);

    //修改密码
    @Update("update reader set reader_password=#{param1} where status=1 and reader_id=#{param2}")
    int updReaderPassById(String password,int id);

    //按条件查找所有读者
    List<Reader> selAllReader(Reader reader);

    //删除读者
    @Update("update reader set status=0 where reader_id = #{param1}")
    int delReaderById(Integer readerId);

    //添加读者
    @Insert("insert into reader values(default,#{readerName},#{readerPassword},null,null,1)")
    int insReader(Reader reader);
}
