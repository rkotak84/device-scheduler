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
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceAttributeId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(DeviceAttributeId.class)
@Table(name = "DEVICE_ATTRIBUTE")
public class DeviceAttributeEntity {

	@Id
	@JsonProperty("deviceGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID deviceUuid;

	@Id
	@JsonProperty("attrName")
	private String attributeName;

	@JsonProperty("attrValueType")
	private String attributeType;

	@JsonProperty("attrValueString")
	private String attributeValueString;

	@JsonProperty("attrValueDateTime")
	private Instant attributeValueDateTime;

	@JsonProperty("attrValueInteger")
	private Integer attributeValueInteger;

	@JsonProperty("modByUserGuid")
	@JsonDeserialize(using = UUIDMapper.class)
	private UUID modByUserUuid;

	private Instant modOnDtm;

	@JsonProperty("groupModVersion")
	private Integer modVersion;

	private String namespace;

}
