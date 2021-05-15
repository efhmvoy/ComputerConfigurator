package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.Case;



public interface CaseService {

    Case getByName(String name);
    Page<Case> getAllByBrand(String brand, Pageable pageable);
    Page<Case> getAllByFormFactor(String formFactor, Pageable pageable);
}
