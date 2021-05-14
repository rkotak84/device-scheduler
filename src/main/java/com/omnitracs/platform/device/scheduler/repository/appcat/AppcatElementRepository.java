package com.omnitracs.platform.device.scheduler.repository.appcat;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.appcat.AppcatElementEntity;

public interface AppcatElementRepository extends JpaRepository<AppcatElementEntity, UUID> {

}
