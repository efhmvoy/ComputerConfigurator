package ua.cn.stu.ComputerConfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.PowerSupply;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.PowerSupplyRepository;
import ua.cn.stu.ComputerConfigurator.service.PowerSupplyService;

@Service
public class PowerSupplyServiceImpl implements PowerSupplyService {

    private final PowerSupplyRepository powerSupplyRepository;
    private final BrandRepository brandRepository;
    @Autowired
    public PowerSupplyServiceImpl(PowerSupplyRepository powerSupplyRepository, BrandRepository brandRepository) {
        this.powerSupplyRepository = powerSupplyRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public PowerSupply getByName(String name) {
        return null;
    }

    @Override
    public Page<PowerSupply> getAllByBrand(String brand, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PowerSupply> getAllByPower(Integer power, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PowerSupply> getAllPowerSupplies(Pageable pageable) {
        return null;
    }

    @Override
    public PowerSupply createPowerSupply(PowerSupply powerSupply) {

        PowerSupply res = powerSupplyRepository.save(powerSupply);
        return res;
    }

    @Override
    public void updatePowerSupply(PowerSupply powerSupply) {

    }

    @Override
    public void deletePowerSupply(Long id) {

    }
}
