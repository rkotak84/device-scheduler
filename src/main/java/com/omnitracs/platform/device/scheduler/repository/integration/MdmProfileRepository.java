package com.omnitracs.platform.device.scheduler.repository.integration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.integration.MdmProfileEntity;

public interface MdmProfileRepository extends JpaRepository<MdmProfileEntity, String> {

}