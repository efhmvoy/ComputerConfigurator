package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.Gpu;

public interface GpuService {

    Gpu getByName(String name);
    Page<Gpu> getAllByBrand(String brand, Pageable pageable);
    Page<Gpu> getAllByChip(String chip, Pageable pageable);
    Page<Gpu> getAllByMemoryType(String memoryType, Pageable pageable);
    Page<Gpu> getAllByMemorySize(Integer memorySize, Pageable pageable);
    Page<Gpu> getAllByBusWidth(Integer busWidth, Pageable pageable);
}
