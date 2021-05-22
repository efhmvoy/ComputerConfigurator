package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.Cpu;

import java.util.Set;

public interface CpuService {



    Page<Cpu> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brands, Set<Long> coreCount, Set<Long> threadCount, Set<String> socket, Set<String> model, Set<String> frequency);

    Cpu createCpu(Cpu cpu);

    void updateCpu(Cpu cpu);

    void deleteCpu(Long id);

    Cpu getCpuById(Long id);
}
