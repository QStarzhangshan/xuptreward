package cn.xupt.reward.project.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.user.domain.Teacher;

@Mapper
public interface TeacherMapper {

	void insertTeacher(Teacher teacher);

	List<Teacher> findAll(@Param("colName") String colName, @Param("colSchool") String colSchool);

	Teacher findByCode(String colCode);

}
