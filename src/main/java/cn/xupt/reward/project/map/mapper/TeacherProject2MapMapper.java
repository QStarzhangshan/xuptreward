
package cn.xupt.reward.project.map.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.map.domain.TeacherProject2Map;

@Mapper
public interface TeacherProject2MapMapper {

	int addProject2(String colCode, TeacherProject2Map teacherProject2Map);

	List<TeacherProject2Map> listAll(@Param("colTtime") String colTtime,@Param("colSname") String colSname,@Param("colType") String colType,
			@Param("colSubtype")String colSubtype, @Param("colStatus1") String colStatus1,@Param("colStatus2") String colStatus2, @Param("colStatus3") String colStatus3);

	TeacherProject2Map findBycolId(@Param("colId") int colId);

	int checkPnum(@Param("colPnum") String colPnum);
	
}
