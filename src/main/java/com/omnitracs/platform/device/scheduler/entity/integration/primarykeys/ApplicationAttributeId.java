package com.omnitracs.platform.device.scheduler.entity.integration.primarykeys;

import java.io.Serializable;

import lombok.Data;

@Data
public class ApplicationAttributeId implements Serializable {

	private static final long serialVersionUID = -2571364504629020651L;

	private String appId;
	private String name;

}
