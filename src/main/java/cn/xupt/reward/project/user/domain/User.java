package cn.xupt.reward.project.user.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import cn.xupt.reward.framework.web.domain.BaseEntity;


public class User extends BaseEntity{

    private static final long serialVersionUID = 1L;
    private Long colId;
    private String colCode;
    private String colName;
    private String colPasswd;
    private String colSex;
    private String colEducation;
    private Date colEntryDate;
    private Date colLeavetime;
    private String colEmail;
    private String colTelephone;
    private String colIdcard;
    private String colBankcard;
    private Long colRole;
    private Long colRank;
    private Long colTemp;
    private Timestamp colTime;
    private String colNote;
    private String colPinyin;
    private String colPinyinf;
    private String colImg;
    private Long colViewRole;
    private String colPasstime;
    private Set<Role> roles;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    
    public String getColIdcard() {
		return colIdcard;
	}

    

	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public void setColIdcard(String colIdcard) {
		this.colIdcard = colIdcard;
	}


	public String getColBankcard() {
		return colBankcard;
	}


	public void setColBankcard(String colBankcard) {
		this.colBankcard = colBankcard;
	}


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

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColPasswd() {
        return colPasswd;
    }

    public void setColPasswd(String colPasswd) {
        this.colPasswd = colPasswd;
    }

    public String getColSex() {
        return colSex;
    }

    public void setColSex(String colSex) {
        this.colSex = colSex;
    }

    public String getColEducation() {
        return colEducation;
    }

    public void setColEducation(String colEducation) {
        this.colEducation = colEducation;
    }

    public Date getColEntryDate() {
        return colEntryDate;
    }

    public void setColEntryDate(Date colEntryDate) {
        this.colEntryDate = colEntryDate;
    }

    public Date getColLeavetime() {
        return colLeavetime;
    }

    public void setColLeavetime(Date colLeavetime) {
        this.colLeavetime = colLeavetime;
    }

    public String getColEmail() {
        return colEmail;
    }

    public void setColEmail(String colEmail) {
        this.colEmail = colEmail;
    }

    public String getColTelephone() {
        return colTelephone;
    }

    public void setColTelephone(String colTelephone) {
        this.colTelephone = colTelephone;
    }

    public Long getColRole() {
        return colRole;
    }

    public void setColRole(Long colRole) {
        this.colRole = colRole;
    }

    public Long getColRank() {
        return colRank;
    }

    public void setColRank(Long colRank) {
        this.colRank = colRank;
    }

    
    public Long getColViewRole() {
		return colViewRole;
	}

	public void setColViewRole(Long colViewRole) {
		this.colViewRole = colViewRole;
	}


	public String getColPasstime() {
		return colPasstime;
	}

	public void setColPasstime(String colPasstime) {
		this.colPasstime = colPasstime;
	}

	public Long getColTemp() {
        return colTemp;
    }

    public void setColTemp(Long colTemp) {
        this.colTemp = colTemp;
    }

    public Timestamp getColTime() {
        return colTime;
    }

    public void setColTime(Timestamp colTime) {
        this.colTime = colTime;
    }

    public String getColNote() {
        return colNote;
    }

    public void setColNote(String colNote) {
        this.colNote = colNote;
    }

    public String getColPinyin() {
        return colPinyin;
    }

    public void setColPinyin(String colPinyin) {
        this.colPinyin = colPinyin;
    }

    public String getColPinyinf() {
        return colPinyinf;
    }

    public void setColPinyinf(String colPinyinf) {
        this.colPinyinf = colPinyinf;
    }

    public String getColImg() {
        return colImg;
    }

    public void setColImg(String colImg) {
        this.colImg = colImg;
    }


	@Override
	public String toString() {
		return "User [colId=" + colId + ", colCode=" + colCode + ", colName=" + colName + ", colPasswd=" + colPasswd
				+ ", colSex=" + colSex + ", colEducation=" + colEducation + ", colEntryDate=" + colEntryDate
				+ ", colLeavetime=" + colLeavetime + ", colEmail=" + colEmail + ", colTelephone=" + colTelephone
				+ ", colIdcard=" + colIdcard + ", colBankcard=" + colBankcard + ", colRole=" + colRole + ", colRank="
				+ colRank + ", colTemp=" + colTemp + ", colTime=" + colTime + ", colNote=" + colNote + ", colPinyin="
				+ colPinyin + ", colPinyinf=" + colPinyinf + ", colImg=" + colImg + ", colViewRole=" + colViewRole
				+ ", colPasstime=" + colPasstime + ", roles=" + roles + "]";
	}


    

}
