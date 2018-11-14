package cn.xupt.reward.project.user.domain;

public class Permission {
	private Long colPid;
	private String colPermissionname;
	private String colPermission;

	public Long getColPid() {
		return colPid;
	}
	public void setColPid(Long colPid) {
		this.colPid = colPid;
	}
	public String getColPermissionname() {
		return colPermissionname;
	}
	public void setColPermissionname(String colPermissionname) {
		this.colPermissionname = colPermissionname;
	}
	public String getColPermission() {
		return colPermission;
	}
	public void setColPermission(String colPermission) {
		this.colPermission = colPermission;
	}
	@Override
	public String toString() {
		return "Permission [colPid=" + colPid + ", colPermissionname=" + colPermissionname + ", colPermission="
				+ colPermission + "]";
	}

	
	
}
