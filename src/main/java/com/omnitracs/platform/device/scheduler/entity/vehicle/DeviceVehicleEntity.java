package com.omnitracs.platform.device.scheduler.entity.vehicle;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEVICE_VEHICLE")
public class DeviceVehicleEntity {

	@Id
	private UUID deviceUuid;
	private String vehicleGuid;
	private String vehicleId;
	private UUID vehicleCompanyUuid;

}
