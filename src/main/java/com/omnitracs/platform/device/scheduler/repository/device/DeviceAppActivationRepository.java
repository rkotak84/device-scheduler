package com.omnitracs.platform.device.scheduler.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceAppActivationEntity;

public interface DeviceAppActivationRepository extends JpaRepository<DeviceAppActivationEntity, String> {

}