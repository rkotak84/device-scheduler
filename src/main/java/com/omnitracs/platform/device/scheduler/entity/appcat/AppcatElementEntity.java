package com.omnitracs.platform.device.scheduler.entity.appcat;

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
@Table(name = "APPCAT_ELEMENT")
public class AppcatElementEntity {

	@Id
	@JsonProperty("apcatGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID appcatUuid;

	@JsonProperty("apcatId")
	private Integer appcatId;

	@JsonProperty("attrName")
	private String appcatName;

	@JsonProperty("attrType")
	private String appcatType;

	private String appId;

	@JsonProperty("attrCatId")
	private Integer categoryId;

	@JsonProperty("attrStatus")
	private String status;

	private String uiWidget;

	private String uiInputMask;

	private String title;

	private String description;

	private String allowedValue;

	private String capaIdRead;

	private String capaIdWrite;

	private String isLocked;

}
