package com.omnitracs.platform.device.scheduler.entity.device.id;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class DeviceGroupMemberId implements Serializable {

	private static final long serialVersionUID = -8029304613640538042L;

	private UUID deviceGroupUuid;
	private UUID deviceUuid;

}
