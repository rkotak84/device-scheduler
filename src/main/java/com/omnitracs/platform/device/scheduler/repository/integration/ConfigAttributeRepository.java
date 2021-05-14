package com.omnitracs.platform.device.scheduler.repository.integration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.integration.ConfigAttributeEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.primarykeys.ConfigAttributeId;

public interface ConfigAttributeRepository extends JpaRepository<ConfigAttributeEntity, ConfigAttributeId> {

	List<ConfigAttributeEntity> findAllByConfigId(String configId);
}
