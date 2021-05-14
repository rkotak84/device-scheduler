package com.omnitracs.platform.device.scheduler.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceAttributeEntity;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceAttributeId;

public interface DeviceAttributeRepository extends JpaRepository<DeviceAttributeEntity, DeviceAttributeId> {

}
