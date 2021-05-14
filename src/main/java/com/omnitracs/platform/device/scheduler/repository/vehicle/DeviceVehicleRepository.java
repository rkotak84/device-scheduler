package com.omnitracs.platform.device.scheduler.repository.vehicle;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.vehicle.DeviceVehicleEntity;

public interface DeviceVehicleRepository extends JpaRepository<DeviceVehicleEntity, UUID> {

}
