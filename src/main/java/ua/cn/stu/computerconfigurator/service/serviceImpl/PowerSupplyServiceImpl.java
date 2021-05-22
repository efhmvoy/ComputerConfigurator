package ua.cn.stu.computerconfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.Brand;
import ua.cn.stu.computerconfigurator.model.PowerSupply;
import ua.cn.stu.computerconfigurator.repository.BrandRepository;
import ua.cn.stu.computerconfigurator.repository.ImageRepository;
import ua.cn.stu.computerconfigurator.repository.PowerSupplyRepository;
import ua.cn.stu.computerconfigurator.service.PowerSupplyService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class PowerSupplyServiceImpl implements PowerSupplyService {

    private final PowerSupplyRepository powerSupplyRepository;
    private final BrandRepository brandRepository;
    private final ImageRepository imageRepository;
    @Autowired
    public PowerSupplyServiceImpl(PowerSupplyRepository powerSupplyRepository, BrandRepository brandRepository, ImageRepository imageRepository) {
        this.powerSupplyRepository = powerSupplyRepository;
        this.brandRepository = brandRepository;
        this.imageRepository = imageRepository;
    }



    @Override
    public PowerSupply getPowerSupplyById(Long id) {
        return powerSupplyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find powerSupply by id: " + id));
    }


    @Override
    public Page<PowerSupply> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<Long> power) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));
        if(brand==null)
        {
            brand=powerSupplyRepository.findAllBrands();
        }
        if(power==null)
        {
            power=powerSupplyRepository.findAllPowers();
        }
        return powerSupplyRepository.findAllCustom(brand,power, paging);
    }

    @Override
    public PowerSupply createPowerSupply(PowerSupply powerSupply) {

          Optional<Brand> brandByName = brandRepository.findByName(powerSupply.getBrand().getName());
          brandByName.ifPresent(powerSupply::setBrand);
          brandRepository.save(powerSupply.getBrand());
          imageRepository.save(powerSupply.getImage());
          PowerSupply res = powerSupplyRepository.save(powerSupply);
          return res;

    }

    @Override
    public void updatePowerSupply(PowerSupply powerSupply) {

    }

    @Override
    public void deletePowerSupply(Long id) {
        if(!powerSupplyRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find powersupply by id: " + id); }
        powerSupplyRepository.deleteById(id);
    }
}
