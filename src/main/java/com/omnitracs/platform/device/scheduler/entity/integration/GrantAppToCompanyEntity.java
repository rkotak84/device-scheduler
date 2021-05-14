package com.omnitracs.platform.device.scheduler.entity.integration;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omnitracs.platform.device.scheduler.custommapper.UUIDMapper;
import com.omnitracs.platform.device.scheduler.entity.integration.primarykeys.GrantAppToCompanyId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(GrantAppToCompanyId.class)
@Table(name = "GRANT_APP_TO_COMPANY")
public class GrantAppToCompanyEntity {

	@Id
	private String appId;
	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("refGuid")
	private UUID companyUuid;
	private String provMode;
	private Instant createDtm;
	private String creatorDbUser;
	private Instant trialStartDtm;
	private Instant trialEndDtm;
	private Integer txnId;

}
