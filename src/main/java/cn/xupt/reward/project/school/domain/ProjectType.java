package cn.xupt.reward.project.school.domain;

/**
 * 项目类型的下属类型
 * @author lebronzs
 *
 */
public class ProjectType {
	private long colId;
	private String colType;
	private String colSubtype;
	
	public long getColId() {
		return colId;
	}
	public void setColId(long colId) {
		this.colId = colId;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getColSubtype() {
		return colSubtype;
	}
	public void setColSubtype(String colSubtype) {
		this.colSubtype = colSubtype;
	}
	@Override
	public String toString() {
		return "ProjectType [colId=" + colId + ", colType=" + colType + ", colSubtype=" + colSubtype + "]";
	}
	
	
	
}
