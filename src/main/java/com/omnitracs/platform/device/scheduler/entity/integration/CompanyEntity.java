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
@Table(name = "company")
public class CompanyEntity {

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("companyGuid")
	private UUID companyUuid;
	private String provType;
	private String provMode;
	private String sfAccountId;
	private String erpCustId;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("adminUserGuid")
	private UUID adminUserUuid;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("qcomCsrUserGuid")
	private UUID qcomCsrUserUuid;
	private String usdotNumber;
	private String scacCode;
	private String companyName;
	private String usersCanLogin;
	private String websiteUrl;
	private String recordScope;
	private String invoiceOption;
	private String recurringChargeOption;
	private String usersCanOverrideCompanyDef;
	private String usersCanChangeEmailAddress;
	private String appProvTxnLock;
	private Instant createDtm;
	private String isCustomer;
	private String isPartner;
	private String isServiceCenter;
	private String supportModel;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("supportCompanyGuid")
	private UUID supportCompanyUuid;
	private String dfltNmcHubId;
	private String dfltQspInstance;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("pmtCardGuid")
	@Column(name = "RECURRING_CHARGE_PMT_CARD_UUID")
	private UUID pmtCardUuid;
	private String phoneConfigType;
	@Column(name = "IS_OT1_CUSTOMER")
	private String isOT1Customer;

}