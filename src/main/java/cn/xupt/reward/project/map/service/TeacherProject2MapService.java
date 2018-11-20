package cn.xupt.reward.project.map.service;

import java.util.List;

import cn.xupt.reward.project.map.domain.TeacherProject2Map;

public interface TeacherProject2MapService{

	int addProject2(String colCode, TeacherProject2Map teacherProject2Map);

	List<TeacherProject2Map> listAll(String colTtime, String colSname, String colType, String colSubtype,
			String colStatus1, String colStatus2, String colStatus3);

	TeacherProject2Map findBycolId(int colId);

	int checkPnum(String colPnum);

}
