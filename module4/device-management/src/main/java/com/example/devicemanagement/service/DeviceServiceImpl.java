package com.example.devicemanagement.service;

import com.example.devicemanagement.entity.Device;
import com.example.devicemanagement.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class DeviceServiceImpl implements Service<Device> {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Page<Device> findAll(Pageable pageable) {
        return deviceRepository.findAll(pageable);
    }

    @Override
    public List<Device> search(String keyword) {
        return deviceRepository.findAllByBrandContainsOrModelContainsOrDescriptionContains(keyword,keyword,keyword);
    }

    public Page<Device> searchWithPaging(Pageable pageable, String keyword) {
        return deviceRepository.findAllByBrandContainsOrModelContainsOrDescriptionContains(pageable, keyword,keyword,keyword);
    }

    @Override
    public Device findById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public List<Device> findAllByStatus(String status) {
        return deviceRepository.findAllByStatus(status);
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
