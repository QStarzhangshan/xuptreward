package cn.xupt.reward.project.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.xupt.reward.project.user.domain.Teacher;

@Mapper
public interface TeacherMapper {

	void insertTeacher(Teacher teacher);

}
