package cn.xupt.reward.project.constant.domain;

public class StandardScoreSys {
	private String colType;
	private long colValue;
	private long colMoney;
	private String colNote;
	
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public long getColValue() {
		return colValue;
	}
	public void setColValue(long colValue) {
		this.colValue = colValue;
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
		return "StandardScoreSys [colType=" + colType + ", colValue=" + colValue + ", colMoney=" + colMoney
				+ ", colNote=" + colNote + "]";
	}
	
	
}
