package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.MotherBoard;

import java.util.Set;

public interface MotherBoardService {

    MotherBoard getMotherBoardById(Long Id);



    MotherBoard createMotherboard(MotherBoard motherBoard);

    void updateMotherBoard(MotherBoard motherBoard);

    void deleteMotherBoard(Long id);

    Page<MotherBoard> findAllCustrom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<String> chipset,Set<Long> memorySize, Set<String> memoryType, Set<String> socket, Set<String> formFactor);
}
