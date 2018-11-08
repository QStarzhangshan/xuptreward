package cn.xupt.reward.project.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.domain.UserRole;

@Mapper
public interface UserRoleMapper {

	void insert(UserRole userrole);

	void updateUserRole(User user1);

	int deleteBycolId(@Param("colId") Long colId);
	
}
