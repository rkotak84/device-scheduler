package com.omnitracs.platform.device.scheduler.entity.integration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.omnitracs.platform.device.scheduler.entity.integration.primarykeys.ConfigAttributeId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ConfigAttributeId.class)
@Table(name = "CONFIG_ATTRIBUTE")
public class ConfigAttributeEntity {

	@Id
	private String configId;
	@Id
	private String attrName;
	private String attrValue;
	private String attrDescription;
}
