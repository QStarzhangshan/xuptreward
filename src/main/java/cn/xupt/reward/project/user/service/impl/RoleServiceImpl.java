package cn.xupt.reward.project.user.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.common.utils.StringUtils;
import cn.xupt.reward.project.user.domain.Role;
import cn.xupt.reward.project.user.mapper.RoleMapper;
import cn.xupt.reward.project.user.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Set<String> selectRoleBycolId(Long colId) {
        List<Role> perms = roleMapper.selectRolesByColId(colId);
        Set<String> permsSet = new HashSet<>();
        for (Role perm : perms)
        {
            if (StringUtils.isNotNull(perms))
            {
                permsSet.addAll(Arrays.asList(perm.getColRankname().trim().split(",")));
            }
        }
        return permsSet;
	}

}
