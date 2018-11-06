package cn.xupt.reward.project.school.domain;

public class BaseSubSchool {
	private long colId;
	private String colDname;
	private String colType;
	private String colSchool;
	private String colNote;
	
	
	public long getColId() {
		return colId;
	}
	public void setColId(long colId) {
		this.colId = colId;
	}
	
	public String getColDname() {
		return colDname;
	}
	public void setColDname(String colDname) {
		this.colDname = colDname;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getColSchool() {
		return colSchool;
	}
	public void setColSchool(String colSchool) {
		this.colSchool = colSchool;
	}
	public String getColNote() {
		return colNote;
	}
	public void setColNote(String colNote) {
		this.colNote = colNote;
	}
	@Override
	public String toString() {
		return "BaseSubSchool [colId=" + colId + ", colDname=" + colDname + ", colType=" + colType + ", colSchool="
				+ colSchool + ", colNote=" + colNote + "]";
	}

}
