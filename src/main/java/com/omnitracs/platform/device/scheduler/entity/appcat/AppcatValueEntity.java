package com.omnitracs.platform.device.scheduler.entity.appcat;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "APPCAT_VALUE")
public class AppcatValueEntity {

	@Id
	private Integer txnId;

	private UUID appcatUuid;

	@Column(columnDefinition = "TEXT")
	private String value;

	private String status;

	@Column(name = "APPCAT_LEVEL")
	private Integer level;

	@Column(name = "APPCAT_LEVEL_ID")
	private String levelId;

}
