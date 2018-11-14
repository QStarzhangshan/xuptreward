package cn.xupt.reward.project.user.domain;

import java.util.Set;

public class Role {
	
	private Long colRid;
	private String colRank;
	private String colRankname;
	private String colRemark;
	private Set<Permission> permissions;

	public Long getColRid() {
		return colRid;
	}
	public void setColRid(Long colRid) {
		this.colRid = colRid;
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
	@Override
	public String toString() {
		return "Role [colRid=" + colRid + ", colRank=" + colRank + ", colRankname=" + colRankname + ", colRemark="
				+ colRemark + ", permissions=" + permissions + "]";
	}


	
	
}
