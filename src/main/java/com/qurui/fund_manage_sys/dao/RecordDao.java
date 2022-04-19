package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Record;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface RecordDao {
    List<Map<String, Object>> getRecordsBy(Record record);

    @Update("update record set fund_audit=#{fund_audit} where fund_id=#{fund_id}")
    int auditRecord(Record record);

    @Delete("delete from record where fund_id=#{fund_id}")
    int deleteRecord(Record record);

    int modifyRecord(Record record);

    int submitRecord(Record record);

    @Select("select * from record where fund_id = #{fund_id}")
    Record getRecordById(Record record);

    int deleteRecordByProjId(int fund_proj_id);
}
