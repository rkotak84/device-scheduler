package com.omnitracs.platform.device.scheduler.entity.device;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omnitracs.platform.device.scheduler.custommapper.UUIDMapper;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceApplicationId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(DeviceApplicationId.class)
@Table(name = "DEVICE_APPLICATION")
public class DeviceApplicationEntity {

	@Id
	@JsonProperty("refGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID deviceUuid;

	@Id
	private String appId;

	private String activationCode;

	private String activationStatus;

	private String enabled;

}
