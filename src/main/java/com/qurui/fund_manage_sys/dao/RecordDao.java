package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Record;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface RecordDao {
    @Select("select * from fund_record")
    List<Map<String, Object>> getAllRecords();
    @Select("select * from fund_record where fund_username = #{fund_username}")
    List<Map<String, Object>> getUserRecords(Record record);
    @Update("update fund_record set fund_audit=#{fund_audit} where fund_id=#{fund_id}")
    int auditRecord(Record record);
    @Select("select * from fund_record where fund_id=#{fund_id} and fund_audit!=0")
    Record checkIfAudited(Record record);
    @Delete("delete from fund_record where fund_id=#{fund_id}")
    int deleteRecord(Record record);
    @Update("update fund_record " +
            "set fund_amount=#{fund_amount}, " +
            "fund_date=#{fund_date}, " +
            "fund_category=#{fund_category}, fund_change_date=now() " +
            "where fund_id=#{fund_id} and fund_audit=0")
    int modifyRecord(Record record);
    @Insert("INSERT INTO fund_record (fund_amount, fund_date, fund_category, fund_username) " +
            "VALUES (#{fund_amount}, #{fund_date}, #{fund_category}, #{fund_username})")
    int submitRecord(Record record);
}