package com.yan.common.model;

import java.io.Serializable;

public class Sequence implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * name
	 * varchar(50) not null 
	 * pk
	 */
    private String name;
    
    /**
     * current_value
     * bigint not null
     */
    private Long currentValue;
    
    /**
     * increment
     * int not null
     * default 1
     */
    private int increment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}
    
}
