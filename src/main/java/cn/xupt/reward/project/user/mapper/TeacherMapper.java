package cn.xupt.reward.project.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.user.domain.Teacher;

@Mapper
public interface TeacherMapper {

	void insertTeacher(Teacher teacher);

	List<Teacher> findAll(@Param("colSname") String colSname, @Param("colDname") String colDname);

	Teacher findByCode(String colCode);

	void updateTeacher(Teacher teacher1);

	int deleteBycolId(@Param("colId") Long colId);

}
