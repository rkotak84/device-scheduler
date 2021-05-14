package com.omnitracs.platform.device.scheduler.repository.appcat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.appcat.AppcatValueEntity;

public interface AppcatValueRepository extends JpaRepository<AppcatValueEntity, Integer> {

}
