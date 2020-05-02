package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.BorrowRecord;
import com.mywork.springboot.pojo.Reader;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BorrowRecordMapper {

    @Insert("insert into borrow_record values(default,#{readerId}," +
            "#{bookId},#{borrowDate},#{shouldReturnDate},0,1)")
    int insBorrowRecord(BorrowRecord record);


    List<BorrowRecord> selAllRecordByReaderId(@Param("reader") Reader reader,@Param("record") BorrowRecord record) ;

    //还书设置状态
    @Update("update borrow_record set return_status=1 where record_id=#{param1} and status=1")
    int updateReturnStaById(int recordId);

    //删除
    @Update("update borrow_record set status=0 where record_id=#{param1}")
    int delBorrowRecordById(Integer recordId);


}
