package cn.xupt.reward.project.user.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.common.utils.StringUtils;
import cn.xupt.reward.project.user.mapper.PermissionMapper;
import cn.xupt.reward.project.user.service.PermissionService;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public Set<String> selectPermissionBycolId(Long colId) {
		List<String> perms = permissionMapper.selectPermsByUserId(colId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (StringUtils.isNotEmpty(perm))
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
	}

}
