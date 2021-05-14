package com.omnitracs.platform.device.scheduler.repository.device;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceEntity;

public interface DeviceRepository extends JpaRepository<DeviceEntity, UUID> {

}