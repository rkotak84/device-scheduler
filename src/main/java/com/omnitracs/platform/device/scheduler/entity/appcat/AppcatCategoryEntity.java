package com.omnitracs.platform.device.scheduler.entity.appcat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omnitracs.platform.device.scheduler.entity.appcat.id.AppcatCategoryId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(AppcatCategoryId.class)
@Table(name = "APPCAT_CATEGORY")
public class AppcatCategoryEntity {

	@Id
	private String appId;

	@Id
	@JsonProperty("attrCatId")
	private Integer categoryId;

	@JsonProperty("attrCatName")
	private String categoryName;

	@JsonProperty("attrCatSortOrder")
	private Integer sortOrder;

}
