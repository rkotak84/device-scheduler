package com.omnitracs.platform.device.scheduler.entity.device.id;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class DeviceApplicationId implements Serializable {

	private static final long serialVersionUID = 6717892572245406276L;

	private UUID deviceUuid;
	private String appId;

}
