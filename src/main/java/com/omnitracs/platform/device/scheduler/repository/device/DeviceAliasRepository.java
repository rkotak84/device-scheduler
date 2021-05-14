package com.omnitracs.platform.device.scheduler.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceAliasEntity;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceAliasId;

public interface DeviceAliasRepository extends JpaRepository<DeviceAliasEntity, DeviceAliasId> {

}
