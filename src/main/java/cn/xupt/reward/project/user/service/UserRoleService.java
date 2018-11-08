package cn.xupt.reward.project.user.service;

import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.domain.UserRole;

public interface UserRoleService {

	void insert(UserRole userrole);

	void updateUserRole(User user1);

	int deleteBycolId(Long colId);

}
