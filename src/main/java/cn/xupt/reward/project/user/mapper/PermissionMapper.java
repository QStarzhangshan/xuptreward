package cn.xupt.reward.project.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {

	List<String> selectPermsByUserId(Long colId);
	
}
