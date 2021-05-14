package com.omnitracs.platform.device.scheduler.entity.device.id;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class DeviceGroupApplicationId implements Serializable {

	private static final long serialVersionUID = -6640843627612754463L;

	private UUID deviceGroupUuid;
	private String appId;

}
