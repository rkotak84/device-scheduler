package com.omnitracs.platform.device.scheduler.entity.device;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omnitracs.platform.device.scheduler.custommapper.UUIDMapper;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceGroupMemberId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(DeviceGroupMemberId.class)
@Table(name = "DEVICE_GROUP_MEMBER")
public class DeviceGroupMemberEntity {

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("deviceGroupGuid")
	private UUID deviceGroupUuid;

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("deviceGuid")
	private UUID deviceUuid;

	private String membershipStatus;

	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("createdByUserGuid")
	private UUID createdByUserUuid;

	private Instant createdOnDtm;

	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("modByUserGuid")
	private UUID modByUserUuid;

	private Instant modOnDtm;

	private Integer modVersion;

}
