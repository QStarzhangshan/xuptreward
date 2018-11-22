package cn.xupt.reward.project.constant.domain;

/**
 * 科研获奖基本信息
 * @author lebronzs
 *
 */
public class RewardScore {
	private String colRname;
	private String colType;
	private String colClass;
	private long colOrder;
	private long colMoney;
	private String colNote;
	

	public String getColRname() {
		return colRname;
	}
	public void setColRname(String colRname) {
		this.colRname = colRname;
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
		return "RewardScore [colRname=" + colRname + ", colType=" + colType + ", colClass=" + colClass + ", colOrder="
				+ colOrder + ", colMoney=" + colMoney + ", colNote=" + colNote + "]";
	}

	
}
