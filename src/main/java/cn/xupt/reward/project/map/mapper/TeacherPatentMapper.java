package cn.xupt.reward.project.map.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.map.domain.TeacherReward;

@Mapper
public interface TeacherPatentMapper {

	List<TeacherReward> findAll(@Param("colDate") String colDate,@Param("colSname") String colSname,@Param("colType") String colType,@Param("colStatus1") String colStatus1,@Param("Money") String money);

}
