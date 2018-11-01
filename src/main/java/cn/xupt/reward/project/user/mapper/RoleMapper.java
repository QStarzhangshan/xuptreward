package cn.xupt.reward.project.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.xupt.reward.project.user.domain.Role;

@Mapper
public interface RoleMapper {

	public List<Role> selectRolesByColId(Long colId);
	

}
