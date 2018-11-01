package cn.xupt.reward.project.user.domain;

import cn.xupt.reward.framework.web.domain.BaseEntity;


public class Teacher extends BaseEntity{
	
	private Long colId;
	private String colCode;
	private String colTitle;
	private String colSchool;
	private String colDepartment;
	private String colSubdepartment;
	private String colDuty;
	private String colStarttime;
	private String colEndtime;
	private String colJobtype;
	private String colJobname;
	private String colJobclass;
	private String colJobdb;
	private String colIsfdy;
	private String colNote;
	public Long getColId() {
		return colId;
	}
	public void setColId(Long colId) {
		this.colId = colId;
	}
	public String getColCode() {
		return colCode;
	}
	public void setColCode(String colCode) {
		this.colCode = colCode;
	}
	public String getColTitle() {
		return colTitle;
	}
	public void setColTitle(String colTitle) {
		this.colTitle = colTitle;
	}
	public String getColSchool() {
		return colSchool;
	}
	public void setColSchool(String colSchool) {
		this.colSchool = colSchool;
	}
	public String getColDepartment() {
		return colDepartment;
	}
	public void setColDepartment(String colDepartment) {
		this.colDepartment = colDepartment;
	}
	public String getColSubdepartment() {
		return colSubdepartment;
	}
	public void setColSubdepartment(String colSubdepartment) {
		this.colSubdepartment = colSubdepartment;
	}
	public String getColDuty() {
		return colDuty;
	}
	public void setColDuty(String colDuty) {
		this.colDuty = colDuty;
	}
	public String getColStarttime() {
		return colStarttime;
	}
	public void setColStarttime(String colStarttime) {
		this.colStarttime = colStarttime;
	}
	public String getColEndtime() {
		return colEndtime;
	}
	public void setColEndtime(String colEndtime) {
		this.colEndtime = colEndtime;
	}
	public String getColJobtype() {
		return colJobtype;
	}
	public void setColJobtype(String colJobtype) {
		this.colJobtype = colJobtype;
	}
	public String getColJobname() {
		return colJobname;
	}
	public void setColJobname(String colJobname) {
		this.colJobname = colJobname;
	}
	public String getColJobclass() {
		return colJobclass;
	}
	public void setColJobclass(String colJobclass) {
		this.colJobclass = colJobclass;
	}
	public String getColJobdb() {
		return colJobdb;
	}
	public void setColJobdb(String colJobdb) {
		this.colJobdb = colJobdb;
	}
	public String getColNote() {
		return colNote;
	}
	public void setColNote(String colNote) {
		this.colNote = colNote;
	}
	
	public String getColIsfdy() {
		return colIsfdy;
	}
	public void setColIsfdy(String colIsfdy) {
		this.colIsfdy = colIsfdy;
	}
	@Override
	public String toString() {
		return "Teacher [colId=" + colId + ", colCode=" + colCode + ", colTitle=" + colTitle + ", colSchool="
				+ colSchool + ", colDepartment=" + colDepartment + ", colSubdepartment=" + colSubdepartment
				+ ", colDuty=" + colDuty + ", colStarttime=" + colStarttime + ", colEndtime=" + colEndtime
				+ ", colJobtype=" + colJobtype + ", colJobname=" + colJobname + ", colJobclass=" + colJobclass
				+ ", colJobdb=" + colJobdb + ", colIsfdy=" + colIsfdy + ", colNote=" + colNote + "]";
	}
	
	
	
	
}
