package cn.xupt.reward.project.school.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.school.domain.BaseSubSchool;

@Mapper
public interface SubSchoolMapper {

	List<BaseSubSchool> findAllBySchool(@Param(value="colSname") String colSname);

}
