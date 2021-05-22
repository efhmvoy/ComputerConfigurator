package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.PowerSupply;

import java.util.Set;


public interface PowerSupplyService {

    Page<PowerSupply> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<Long> power);

    PowerSupply createPowerSupply(PowerSupply powerSupply);

    void updatePowerSupply(PowerSupply powerSupply);

    void deletePowerSupply(Long id);

    PowerSupply getPowerSupplyById(Long id);
}
