package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.PowerSupply;



public interface PowerSupplyService {

    PowerSupply getByName(String name);
    Page<PowerSupply> getAllByBrand(String brand, Pageable pageable);
    Page<PowerSupply> getAllByPower(Integer power, Pageable pageable);
    Page<PowerSupply> getAllPowerSupplies(Pageable pageable);

}
