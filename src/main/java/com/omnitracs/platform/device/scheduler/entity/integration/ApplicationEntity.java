package com.omnitracs.platform.device.scheduler.entity.integration;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "APPLICATION")
public class ApplicationEntity {

	@Id
	private String appId;
	private String appType;
	private String appName;
	private String provType;
	private String qspAppIdLicense;
	private String availability;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("rootLinkGroupGuid")
	private UUID rootLinkGroupUuid;
	@Column(name = "PROV_NEEDS_SF")
	private String provNeedsSF;
	@Column(name = "PROV_NEEDS_NMC")
	private String provNeedsNMC;
	@Column(name = "PROV_NEEDS_SP")
	private String provNeedsSP;
	@Column(name = "PROV_NEEDS_QDC")
	private String provNeedsQDC;
	@Column(name = "PROV_NEEDS_RN")
	private String provNeedsRN;
	@Column(name = "PROV_NEEDS_XRS")
	private String provNeedsXRS;
	private String provNeedsSylectus;
	private String grantCapaToUser;
	private String grantCapaToLinkedUser;
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("serviceAccountUserGuid")
	@Column(name = "SVC_ACCT_USER_UUID")
	private UUID serviceAccountUserUuid;
	private String parentAppId;
	private String mdmProfile;
	private String mdmBetaProfile;
	private String appDescription;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "APP_ID", insertable = false, updatable = false)
	private List<ApplicationAttributeEntity> attributeEntities;

}