package cn.xupt.reward.project.user.domain;

public class Role {
	
	private Long colId;
	private String colRank;
	private String colRankname;
	private String colRemark;
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
	@Override
	public String toString() {
		return "Role [colId=" + colId + ", colRank=" + colRank + ", colRankname=" + colRankname + ", colRemark="
				+ colRemark + "]";
	}
	
	
}
