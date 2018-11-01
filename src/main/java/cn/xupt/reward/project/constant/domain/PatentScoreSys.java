package cn.xupt.reward.project.constant.domain;

public class PatentScoreSys {
	private String colType;
	private String colStatus;
	private long colValue;
	private long colMoney;
	private String colNote;
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getColStatus() {
		return colStatus;
	}
	public void setColStatus(String colStatus) {
		this.colStatus = colStatus;
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
		return "PatentScoreSys [colType=" + colType + ", colStatus=" + colStatus + ", colValue=" + colValue
				+ ", colMoney=" + colMoney + ", colNote=" + colNote + "]";
	}
	
	
}
