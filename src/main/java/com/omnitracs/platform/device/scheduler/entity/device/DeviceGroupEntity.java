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
@Table(name = "DEVICE_GROUP")
public class DeviceGroupEntity {

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("deviceGroupGuid")
	private UUID deviceGroupUuid;

	@JsonProperty("coDeviceGroupId")
	private String deviceGroupName;

	private String deviceGroupType;

	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("companyGuid")
	private UUID companyUuid;

	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("createdByUserGuid")
	private UUID createdByUserUuid;

	private Instant createdOnDtm;

	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("modByUserGuid")
	private UUID modByUserUuid;

	private Instant modOnDtm;

	private Integer modVersion;

	private String isDefault;

	private String status;

	private Integer nmcProfileId;

}
