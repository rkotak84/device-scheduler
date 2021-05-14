package com.omnitracs.platform.device.scheduler.entity.device;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omnitracs.platform.device.scheduler.custommapper.UUIDMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DEVICE")
public class DeviceEntity {

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("deviceGuid")
	private UUID deviceUuid;

	private String deviceId;

	@JsonProperty("companyGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID companyUuid;

	private String deviceType;

	private String provType;

	private String provMode;

	private String serialNumber;

	private String serialNumberNs;

	@JsonProperty("createdByUserGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID createdByUserUuid;

	private Instant createdOnDtm;

	@JsonProperty("modByUserGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID modByUserUuid;

	private Instant modOnDtm;

	@JsonProperty("commonGatewayType")
	private String comGatewayType;

	@JsonProperty("commonGatewayInstance")
	private String comGatewayInstance;

	private String deviceIdNs;

	private String status;

	private Instant lastCommDtm;

}
