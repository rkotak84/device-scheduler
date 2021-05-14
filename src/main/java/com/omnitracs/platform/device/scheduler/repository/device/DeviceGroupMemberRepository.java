package com.omnitracs.platform.device.scheduler.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnitracs.platform.device.scheduler.entity.device.DeviceGroupMemberEntity;
import com.omnitracs.platform.device.scheduler.entity.device.id.DeviceGroupMemberId;

public interface DeviceGroupMemberRepository extends JpaRepository<DeviceGroupMemberEntity, DeviceGroupMemberId> {

}
