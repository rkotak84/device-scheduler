package com.omnitracs.platform.device.scheduler.entity.integration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.omnitracs.platform.device.scheduler.entity.integration.primarykeys.ApplicationAttributeId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ApplicationAttributeId.class)
@Table(name = "APPLICATION_ATTRIBUTE")
public class ApplicationAttributeEntity {

	@Id
	@Column(name = "APP_ID")
	private String appId;
	@Id
	@Column(name = "ATTRIB_NAME")
	private String name;
	@Column(name = "ATTRIB_GROUP")
	private String group;
	@Column(name = "ATTRIB_VALUE")
	private String value;

	@OneToOne
	@JoinColumn(name = "ATTRIB_VALUE", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private MdmProfileEntity mdmProfileEntity;

}