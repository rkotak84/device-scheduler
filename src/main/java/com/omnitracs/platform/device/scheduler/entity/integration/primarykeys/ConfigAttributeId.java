package com.omnitracs.platform.device.scheduler.entity.integration.primarykeys;

import java.io.Serializable;

import lombok.Data;

@Data
public class ConfigAttributeId implements Serializable {

	private static final long serialVersionUID = -1079428052002295650L;

	private String configId;
	private String attrName;
}
