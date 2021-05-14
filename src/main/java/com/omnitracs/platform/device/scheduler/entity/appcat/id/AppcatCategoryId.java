package com.omnitracs.platform.device.scheduler.entity.appcat.id;

import java.io.Serializable;

import lombok.Data;

@Data
public class AppcatCategoryId implements Serializable {

	private static final long serialVersionUID = -5872093201941627034L;

	private String appId;
	private Integer categoryId;

}
