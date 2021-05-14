package com.omnitracs.platform.device.scheduler.entity.integration;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omnitracs.platform.device.scheduler.custommapper.UUIDMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MDM_PROFILE")
public class MdmProfileEntity {

	@Id
	private String profileGuid;
	private String profileName;
	private String profileType;
	private String profileStatus;
	private String profileDescription;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("createdByUserGuid")
	private UUID createdByUserUuid;
	private Instant createdOnDtm;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("modByUserGuid")
	private UUID modByUserUuid;
	private Instant modOnDtm;
	private String platform;

}