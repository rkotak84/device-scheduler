package com.omnitracs.platform.device.scheduler.entity.device.id;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class DeviceAttributeId implements Serializable {

	private static final long serialVersionUID = -7724633413240433182L;

	private UUID deviceUuid;
	private String attributeName;

}
