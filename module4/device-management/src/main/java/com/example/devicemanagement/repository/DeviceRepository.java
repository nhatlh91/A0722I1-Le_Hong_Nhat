package com.example.devicemanagement.repository;

import com.example.devicemanagement.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> findAllByBrandContainsOrModelContainsOrDescriptionContains(String brand, String model, String description);
    Page<Device> findAllByBrandContainsOrModelContainsOrDescriptionContains(Pageable pageable, String brand, String model, String description);
    List<Device> findAllByStatus(String status);
}
