package com.mywork.springboot.mapper;

import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.pojo.ReturnRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ReturnRecordMapper {

    //插入归还记录
    @Insert("insert into return_record values(default," +
            "#{readerId},#{bookId},#{borrowDate},#{returnDate},1)")
    int insReturnRecord(ReturnRecord record);

    List<ReturnRecord> selAllRecordByReader(@Param("reader")Reader reader,@Param("record") ReturnRecord record);

    //删除
    @Update("update return_record set status=0 where record_id=#{param1}")
    int delReturnRecordById(Integer recordId);

}
