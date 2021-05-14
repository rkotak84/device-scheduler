package com.omnitracs.platform.device.scheduler.repository.integration;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omnitracs.platform.device.scheduler.entity.integration.LinkedCompanyAccountEntity;

public interface LinkedCompanyAccountRepository extends JpaRepository<LinkedCompanyAccountEntity, UUID> {

	List<LinkedCompanyAccountEntity> findAllByOwnerCompanyUuid(UUID ownerCompanyUuid);

	@Query("select ownerCompanyUuid from LinkedCompanyAccountEntity where xrsCompanyId = ?1")
	List<UUID> getOwnerCompanyByXRSCompanyId(String xrsCompanyId);

}