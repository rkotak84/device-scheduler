package com.omnitracs.platform.device.scheduler.entity.integration;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
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
@Table(name = "LINKED_COMPANY_ACCOUNT")
public class LinkedCompanyAccountEntity {

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("companyAccountGuid")
	private UUID companyAccountUuid;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("ownerCompanyGuid")
	private UUID ownerCompanyUuid;
	private String isPrimary;
	private String nmcAccount;
	private String nmcAuxId;
	private String qspCompanyId;
	private String hosCompanyId;
	private String csaCompanyId;
	private String adminNote;
	private Instant createDtm;
	private String creatorDbUser;
	@Column(name = "RN_BU_ID")
	private String rnBusinessUnitId;
	private String qspInstance;
	private String nmcHubId;
	private String xrsCompanyId;
	private String xrsOrgId;
	private String mapProvider;
	private String allowBingBirdEye;
	private String syncToCp;
	private String xrsCompanyGuid;
	private String xrsInstance;
	private String xrsBillingCode;
	private String rnCustId;
	private String rnInstanceId;
	private Integer txnId;

}