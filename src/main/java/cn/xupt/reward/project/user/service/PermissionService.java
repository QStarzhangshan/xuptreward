package cn.xupt.reward.project.user.service;

import java.util.Set;

public interface PermissionService {
	
	public Set<String> selectPermissionBycolId(Long colId);
}
