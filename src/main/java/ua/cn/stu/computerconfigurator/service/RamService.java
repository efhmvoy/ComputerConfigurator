package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.Ram;

import java.util.Set;

public interface RamService {



    Ram createRam(Ram ram);

    void updateRam(Ram ram);

    void deleteRam(Long id);

    Ram getRamById(Long id);

    Page<Ram> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<Long> memorySize, Set<String> memoryType, Set<Long> frequency, Set<String> timings);
}
