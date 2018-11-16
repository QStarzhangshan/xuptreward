package cn.xupt.reward.project.user.domain;

public class Permission {
	private Long colId;
	private String colPermissionname;
	private String colPermission;


	public Long getColId() {
		return colId;
	}
	public void setColId(Long colId) {
		this.colId = colId;
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
		return "Permission [colId=" + colId + ", colPermissionname=" + colPermissionname + ", colPermission="
				+ colPermission + "]";
	}

	
	
}
