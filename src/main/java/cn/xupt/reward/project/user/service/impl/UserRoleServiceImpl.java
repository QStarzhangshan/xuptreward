package cn.xupt.reward.project.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.domain.UserRole;
import cn.xupt.reward.project.user.mapper.UserRoleMapper;
import cn.xupt.reward.project.user.service.UserRoleService;

@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleMapper userroleMapper;
	
	@Override
	public void insert(UserRole userrole) {
		userroleMapper.insert(userrole);
		
	}

	@Override
	public void updateUserRole(User user1) {
		userroleMapper.updateUserRole(user1);
	}

	@Override
	public void deleteBycolId(Long colId) {
		userroleMapper.deleteBycolId(colId);
		
	}

	
}
