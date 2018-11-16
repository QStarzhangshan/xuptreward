package cn.xupt.reward.project.user.domain;

import java.util.Set;

public class Role {
	
	private Long colId;
	private String colRank;
	private String colRankname;
	private String colRemark;
	private Set<Permission> permissions;
	private Set<Menu> menus;


	public Long getColId() {
		return colId;
	}
	public void setColId(Long colId) {
		this.colId = colId;
	}
	public String getColRank() {
		return colRank;
	}
	public void setColRank(String colRank) {
		this.colRank = colRank;
	}
	public String getColRankname() {
		return colRankname;
	}
	public void setColRankname(String colRankname) {
		this.colRankname = colRankname;
	}
	public String getColRemark() {
		return colRemark;
	}
	public void setColRemark(String colRemark) {
		this.colRemark = colRemark;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "Role [colId=" + colId + ", colRank=" + colRank + ", colRankname=" + colRankname + ", colRemark="
				+ colRemark + ", permissions=" + permissions + ", menus=" + menus + "]";
	}


}
