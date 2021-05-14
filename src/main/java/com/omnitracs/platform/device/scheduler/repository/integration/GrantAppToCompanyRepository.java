package com.omnitracs.platform.device.scheduler.repository.integration;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.integration.GrantAppToCompanyEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.primarykeys.GrantAppToCompanyId;

public interface GrantAppToCompanyRepository extends JpaRepository<GrantAppToCompanyEntity, GrantAppToCompanyId> {

	List<GrantAppToCompanyEntity> findAllByCompanyUuid(UUID companyUuid);

}
