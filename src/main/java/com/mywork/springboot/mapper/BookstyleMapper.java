package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.Bookstyle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookstyleMapper {

    @Select("select * from book_style where status=1")
    List<Bookstyle> selAllBookstyle();
}
