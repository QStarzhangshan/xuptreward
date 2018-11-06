package cn.xupt.reward.project.user.domain;

import cn.xupt.reward.framework.web.domain.BaseEntity;

public class UserRole extends BaseEntity{
	
	private Long usersId;
	private Long roleId;
	public Long getUsersId() {
		return usersId;
	}
	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserRole [usersId=" + usersId + ", roleId=" + roleId + "]";
	}
	
	
}
