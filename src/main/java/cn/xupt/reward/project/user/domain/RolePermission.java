package cn.xupt.reward.project.user.domain;

import cn.xupt.reward.framework.web.domain.BaseEntity;

public class RolePermission extends BaseEntity{
	
	private Long roleId;
	private Long permissionId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
	@Override
	public String toString() {
		return "RolePermission [roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}
	
	
}
