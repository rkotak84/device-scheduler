package com.omnitracs.platform.device.scheduler.entity.integration.primarykeys;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class GrantAppToCompanyId implements Serializable {

	private static final long serialVersionUID = -8837319378030755631L;

	private UUID companyUuid;

	private String appId;
}
