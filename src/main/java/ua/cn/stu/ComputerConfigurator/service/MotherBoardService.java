package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.MotherBoard;

public interface MotherBoardService {

    MotherBoard getByName(String name);

    Page<MotherBoard> getAllByBrand(String brand, Pageable pageable);

    Page<MotherBoard> getAllByChipset(String chipset, Pageable pageable);

    Page<MotherBoard> getAllByFormFactor(String FormFactor, Pageable pageable);

    Page<MotherBoard> getAllByMemoryType(String memoryType, Pageable pageable);

    MotherBoard createMotherboard(MotherBoard motherBoard);

    void updateMotherBoard(MotherBoard motherBoard);

    void deleteMotherBoard(Long id);

}
