package com.omnitracs.platform.device.scheduler.entity.device;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omnitracs.platform.device.scheduler.custommapper.UUIDMapper;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceAliasId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DEVICE_ALIAS")
@IdClass(DeviceAliasId.class)
public class DeviceAliasEntity {

	@Id
	@JsonDeserialize(using = UUIDMapper.class)
	@JsonProperty("deviceGuid")
	private UUID deviceUuid;

	@Id
	private String namespace;

	private String alias;

}
