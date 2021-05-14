package com.omnitracs.platform.device.scheduler.repository.device;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceGroupEntity;

public interface DeviceGroupRepository extends JpaRepository<DeviceGroupEntity, UUID> {

}
