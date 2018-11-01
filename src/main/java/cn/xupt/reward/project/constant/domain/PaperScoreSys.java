package cn.xupt.reward.project.constant.domain;

public class PaperScoreSys {
	private String colType;
	private long colOrder;
	private long colValue;
	private String colMoney;
	private String colNote;
	
	
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public long getColOrder() {
		return colOrder;
	}
	public void setColOrder(long colOrder) {
		this.colOrder = colOrder;
	}
	public long getColValue() {
		return colValue;
	}
	public void setColValue(long colValue) {
		this.colValue = colValue;
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
	@Override
	public String toString() {
		return "PaperScoreSys [colType=" + colType + ", colOrder=" + colOrder + ", colValue=" + colValue + ", colMoney="
				+ colMoney + ", colNote=" + colNote + "]";
	}
	
	
	
}
