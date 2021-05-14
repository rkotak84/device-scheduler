package com.omnitracs.platform.device.scheduler.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceApplicationEntity;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceApplicationId;

public interface DeviceApplicationRepository extends JpaRepository<DeviceApplicationEntity, DeviceApplicationId> {

}