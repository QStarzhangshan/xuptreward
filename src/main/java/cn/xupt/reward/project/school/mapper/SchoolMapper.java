package cn.xupt.reward.project.school.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.xupt.reward.project.school.domain.BaseSchool;

@Mapper
public interface SchoolMapper {

	List<BaseSchool> findAll();

	List<BaseSchool> findOne(String colSchool);

}
