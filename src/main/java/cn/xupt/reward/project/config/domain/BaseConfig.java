package cn.xupt.reward.project.config.domain;

public class BaseConfig<timestamp> {
	private long colId;
	private String colName;
	private String colDescript;
	private String colValue;
	private timestamp colBeginverify;
	private timestamp colEndverify;
	private String colNote;
	public long getColId() {
		return colId;
	}
	public void setColId(long colId) {
		this.colId = colId;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getColDescript() {
		return colDescript;
	}
	public void setColDescript(String colDescript) {
		this.colDescript = colDescript;
	}
	public String getColValue() {
		return colValue;
	}
	public void setColValue(String colValue) {
		this.colValue = colValue;
	}
	public timestamp getColBeginverify() {
		return colBeginverify;
	}
	public void setColBeginverify(timestamp colBeginverify) {
		this.colBeginverify = colBeginverify;
	}
	public timestamp getColEndverify() {
		return colEndverify;
	}
	public void setColEndverify(timestamp colEndverify) {
		this.colEndverify = colEndverify;
	}
	public String getColNote() {
		return colNote;
	}
	public void setColNote(String colNote) {
		this.colNote = colNote;
	}
	
	@Override
	public String toString() {
		return "BaseConfig [colId=" + colId + ", colName=" + colName + ", colDescript=" + colDescript + ", colValue="
				+ colValue + ", colBeginverify=" + colBeginverify + ", colEndverify=" + colEndverify + ", colNote="
				+ colNote + "]";
	}
}
