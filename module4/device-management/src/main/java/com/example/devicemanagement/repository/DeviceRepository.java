package com.example.devicemanagement.repository;

import com.example.devicemanagement.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
