package com.yan.common.dao.service.facade;

import java.util.List;

import com.yan.common.model.TransCode;

public interface TransCodeDaoService {

	public final static String MAPPER_NAME_SPACE ="com.yan.common.mapping.TransCodeMapper";
	
	List<TransCode> getTransCodeListByCodeType(String appCode, String codeType);
	
	TransCode getTransCodeByCodeTypeAndCodeCode(String appCode, String codeType, String codeCode);
	
	void insertTransCode(TransCode transCode);
	
	void updateTransCodeByCodeTypeAndCodeCode(TransCode transCode);
	
	void updateTransCodeValidStatus(TransCode transCode);
}
