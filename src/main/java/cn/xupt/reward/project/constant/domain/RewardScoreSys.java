package cn.xupt.reward.project.constant.domain;

public class RewardScoreSys {
	private String colName;
	private String colType;
	private String colClass;
	private long colOrder;
	private long colMoney;
	private String colNote;
	
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
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
	public long getColOrder() {
		return colOrder;
	}
	public void setColOrder(long colOrder) {
		this.colOrder = colOrder;
	}
	public long getColMoney() {
		return colMoney;
	}
	public void setColMoney(long colMoney) {
		this.colMoney = colMoney;
	}
	public String getColNote() {
		return colNote;
	}
	public void setColNote(String colNote) {
		this.colNote = colNote;
	}
	@Override
	public String toString() {
		return "RewardScoreSys [colName=" + colName + ", colType=" + colType + ", colClass=" + colClass + ", colOrder="
				+ colOrder + ", colMoney=" + colMoney + ", colNote=" + colNote + "]";
	}
	
	
}
