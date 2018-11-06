package cn.xupt.reward.project.school.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.school.domain.ProjectType;

@Mapper
public interface ProjectTypeMapper {

	List<ProjectType> findAllByType(@Param("colType") String colType);

	
}
