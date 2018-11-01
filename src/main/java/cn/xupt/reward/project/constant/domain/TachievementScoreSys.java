package cn.xupt.reward.project.constant.domain;

public class TachievementScoreSys {
	private String colType;
	private String colClass;
	private String colMoney;
	private String colNote;
	private long colId;
	
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getColClass() {
		return colClass;
	}
	public void setColClass(String colClass) {
		this.colClass = colClass;
	}
	public String getColMoney() {
		return colMoney;
	}
	public void setColMoney(String colMoney) {
		this.colMoney = colMoney;
	}
	public String getColNote() {
		return colNote;
	}
	public void setColNote(String colNote) {
		this.colNote = colNote;
	}
	public long getColId() {
		return colId;
	}
	public void setColId(long colId) {
		this.colId = colId;
	}
	
	
	@Override
	public String toString() {
		return "TachievementScoreSys [colType=" + colType + ", colClass=" + colClass + ", colMoney=" + colMoney
				+ ", colNote=" + colNote + ", colId=" + colId + "]";
	}
	
	
}
