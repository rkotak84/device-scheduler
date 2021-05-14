package com.omnitracs.platform.device.scheduler.repository.integration;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omnitracs.platform.device.scheduler.entity.integration.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

	List<CompanyEntity> findAllByErpCustIdIn(List<String> erpCustIds);

	@Query("FROM CompanyEntity WHERE provMode = 'CUSTOMER' AND usersCanLogin = 'Y' AND isCustomer = 'Y' AND companyName NOT LIKE '%CLSD%'")
	List<CompanyEntity> findAllActiveCompanies();

	List<CompanyEntity> findAllByCompanyNameContainingIgnoreCaseOrErpCustIdContaining(String companyName,
			String erpCustId);

	CompanyEntity findByCompanyUuid(UUID companyUuid);

}