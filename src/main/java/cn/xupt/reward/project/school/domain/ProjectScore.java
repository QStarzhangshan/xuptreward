package cn.xupt.reward.project.school.domain;

/**
 * 项目类型
 * @author lebronzs
 *
 */
public class ProjectScore {
	private long colId;
	private String colType;
	private String colSubtype;
	private String colFactor;
	private String colSubfac;
	private String colContent;
	private long colValue;
	private long colMoney;
	private String colNote;
	
	
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
	public String getColFactor() {
		return colFactor;
	}
	public void setColFactor(String colFactor) {
		this.colFactor = colFactor;
	}
	public String getColSubfac() {
		return colSubfac;
	}
	public void setColSubfac(String colSubfac) {
		this.colSubfac = colSubfac;
	}
	public String getColContent() {
		return colContent;
	}
	public void setColContent(String colContent) {
		this.colContent = colContent;
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
		return "ProjectScoreSys [colId=" + colId + ", colType=" + colType + ", colSubtype=" + colSubtype
				+ ", colFactor=" + colFactor + ", colSubfac=" + colSubfac + ", colContent=" + colContent + ", colValue="
				+ colValue + ", colMoney=" + colMoney + ", colNote=" + colNote + "]";
	}
	
	
}
