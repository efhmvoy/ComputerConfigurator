package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.Ram;

public interface RamService {

    Ram getByName(String name);

    Page<Ram> getAllByBrand(String brand, Pageable pageable);

    Page<Ram> getAllByMemoryType(String memoryType, Pageable pageable);

    Page<Ram> getAllByFrequency(Integer frequency,Pageable pageable );

    Page<Ram> getAllByTimings(String timings, Pageable pageable);

    Ram createRam(Ram ram);

    void updateRam(Ram ram);

    void deleteRam(Long id);

}
