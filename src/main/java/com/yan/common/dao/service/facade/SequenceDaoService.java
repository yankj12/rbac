package com.yan.common.dao.service.facade;

import com.yan.common.model.Sequence;

public interface SequenceDaoService {

	public final static String MAPPER_NAME_SPACE ="com.yan.common.mapping.SequenceMapper";
	
	void insertSequence(Sequence sequence);
	
	long setVal(String name, long currentValue);
	
	long currVal(String name);
	
	long nextVal(String name);
}
