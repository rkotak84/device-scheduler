package com.omnitracs.platform.device.scheduler.repository.integration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.integration.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, String> {

	List<ApplicationEntity> findByAppIdIn(List<String> appIds);

}