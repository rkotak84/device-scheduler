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
@Table(name = "DEVICE_APP_ACTIVATION")
public class DeviceAppActivationEntity {

	@Id
	@JsonProperty("tokenId")
	private String activationCode;

	@JsonProperty("cargo")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID deviceUuid;

	private Instant expiryDtm;

	private Instant createDtm;

}
