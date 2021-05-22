package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.Cpu;
import ua.cn.stu.computerconfigurator.model.Gpu;

import java.util.Set;

public interface GpuService {

    Page<Gpu> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<String> chip, Set<Long> memorySize, Set<String> memoryType, Set<Long> busWidth);

    Gpu getGpuById(Long id);

    Gpu createGpu(Gpu gpu);

    void updateGpu(Gpu gpu);

    void deleteGpu(Long id);

}
