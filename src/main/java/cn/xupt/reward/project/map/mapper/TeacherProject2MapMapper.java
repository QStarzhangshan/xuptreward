
package cn.xupt.reward.project.map.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.map.domain.TeacherProject2Map;

@Mapper
public interface TeacherProject2MapMapper {

	int addProject2(String colCode, TeacherProject2Map teacherProject2Map);

	List<TeacherProject2Map> listAll(String colTtime, String colSname, String colType, String colSubtype,
			@Param("colStatus1") String colStatus1, String colStatus2, String colStatus3);
	
}
