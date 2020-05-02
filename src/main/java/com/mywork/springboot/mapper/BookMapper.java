package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {

    //分页查询所有的书籍,按条件
    List<Book> selAllBook(@Param("bookName") String bookName, @Param("bookAuthor") String bookAuthor,
                          @Param("bookPub") String bookPub, @Param("bookstyleId") Integer bookstyleId);

    //通过id查找书籍详细信息
    Book selBookDetailsById(@Param("bookId") Integer bookId);

    //通过id更新库存（num-1）
    @Update("update book set book_num=book_num-1 where status=1 and book_id=#{param1}")
    int updBookNumById(int bookId);

    //通过id更新库存（num+1）
    @Update("update book set book_num=book_num+1 where status=1 and book_id=#{param1}")
    int updBookNumById_plus(int bookId);

    //删除 id
    @Update("update book set status=0 where book_id = #{bookId}")
    int delBookById(Integer bookId);

    //插入
    @Insert("insert into book values(default,#{bookName},#{bookstyleId},#{bookAuthor},#{bookPub}," +
            "#{bookLocation},#{bookUpdate,jdbcType=DATE},#{bookPrice},#{bookNum},#{bookDescription},1)")
    int insBook(Book book);
}
