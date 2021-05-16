package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.Cpu;

public interface CpuService {
    Cpu getByName(String name);

    Page<Cpu> getAllByBrand(String brand, Pageable pageable);

    Page<Cpu> getAllByCoreCount(Integer coreCount, Pageable pageable);

    Page<Cpu> getAllByThreadCount(Integer threadCount, Pageable pageable);

    Page<Cpu> getAllByChipset(String chipset, Pageable pageable);

    Cpu createCpu(Cpu cpu);

    void updateCpu(Cpu cpu);

    void deleteCpu(Long id);
}
