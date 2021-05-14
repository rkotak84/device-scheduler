package com.omnitracs.platform.device.scheduler.entity.device.id;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class DeviceAliasId implements Serializable {

	private static final long serialVersionUID = 538288064830723673L;

	private UUID deviceUuid;
	private String namespace;

}