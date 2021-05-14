package com.omnitracs.platform.device.scheduler.repository.appcat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.appcat.AppcatCategoryEntity;
import com.omnitracs.platform.device.scheduler.entity.appcat.id.AppcatCategoryId;

public interface AppcatCategoryRepository extends JpaRepository<AppcatCategoryEntity, AppcatCategoryId> {

}
