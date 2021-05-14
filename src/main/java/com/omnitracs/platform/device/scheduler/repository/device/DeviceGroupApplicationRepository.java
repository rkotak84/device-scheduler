package com.omnitracs.platform.device.scheduler.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceGroupApplicationEntity;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceGroupApplicationId;

public interface DeviceGroupApplicationRepository
		extends JpaRepository<DeviceGroupApplicationEntity, DeviceGroupApplicationId> {
}