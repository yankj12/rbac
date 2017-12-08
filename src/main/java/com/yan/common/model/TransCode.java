package com.yan.common.model;

import java.io.Serializable;
import java.util.Date;

public class TransCode implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * appcode VARCHAR(10) NOT NULL
	 */
	private String appCode;
	
	
	/**
     * codetype VARCHAR(100) NOT NULL,
     */
	private String codeType;
	
	/**
	 * codetypename VARCHAR(100),
	 */
	private String codeTypeName; 
	
    /**
     * codecode VARCHAR(100) NOT NULL,
     */
	private String codeCode;
	
    /**
     * codename VARCHAR(100),
     */
	private String codeName;
	
    /**
     * codevalue VARCHAR(100),
     */
	private String codeValue;
	
    /**
     * remark VARCHAR(255),
     */
	private String remark;
	
    /**
     * validstatus VARCHAR(2) DEFAULT '1',
     */
	private String validStatus;
	
    /**
     * inserttime DATETIME,
     */
	private Date insertTime;
	
    /**
     * updatetime DATE,
     */
	private Date updateTime;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeTypeName() {
		return codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}

	public String getCodeCode() {
		return codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
