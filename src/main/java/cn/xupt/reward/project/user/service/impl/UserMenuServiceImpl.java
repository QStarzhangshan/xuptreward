package cn.xupt.reward.project.user.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.mapper.UserMenuMapper;
import cn.xupt.reward.project.user.service.UserMenuService;

@Service
public class UserMenuServiceImpl implements UserMenuService{

	@Autowired
	private UserMenuMapper userMenumapper;
	
	@Override
	public User selectperm(String colCode) {
		return userMenumapper.selectperm(colCode);
	}

}
