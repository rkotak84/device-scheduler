package com.omnitracs.platform.device.scheduler.repository.integration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.integration.ApplicationAttributeEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.primarykeys.ApplicationAttributeId;

public interface ApplicationAttributeRepository
		extends JpaRepository<ApplicationAttributeEntity, ApplicationAttributeId> {

}