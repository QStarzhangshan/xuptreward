package cn.xupt.reward.project.school.domain;

public class BaseSchool {
	private long colId;
	private String colSname;
	private String colType;
	private String colIsteach;
	private String colNote;
	public long getColId() {
		return colId;
	}
	public void setColId(long colId) {
		this.colId = colId;
	}
	public String getColSname() {
		return colSname;
	}
	public void setColSname(String colSname) {
		this.colSname = colSname;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getColIsteach() {
		return colIsteach;
	}
	public void setColIsteach(String colIsteach) {
		this.colIsteach = colIsteach;
	}
	public String getColNote() {
		return colNote;
	}
	public void setColNote(String colNote) {
		this.colNote = colNote;
	}
	@Override
	public String toString() {
		return "BaseSchool [colId=" + colId + ", colSname=" + colSname + ", colType=" + colType + ", colIsteach="
				+ colIsteach + ", colNote=" + colNote + "]";
	}

}
