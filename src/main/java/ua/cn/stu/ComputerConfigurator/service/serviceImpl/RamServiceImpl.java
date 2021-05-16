package ua.cn.stu.ComputerConfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.Ram;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.ComputerConfigurator.repository.RamRepository;
import ua.cn.stu.ComputerConfigurator.service.RamService;

@Service
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;
    private final BrandRepository brandRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
   @Autowired
    public RamServiceImpl(RamRepository ramRepository, BrandRepository brandRepository, MemoryDetailsRepository memoryDetailsRepository) {
        this.ramRepository = ramRepository;
        this.brandRepository = brandRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
    }




    @Override
    public Ram getByName(String name) {
        return null;
    }

    @Override
    public Page<Ram> getAllByBrand(String brand, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Ram> getAllByMemoryType(String memoryType, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Ram> getAllByFrequency(Integer frequency, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Ram> getAllByTimings(String timings, Pageable pageable) {
        return null;
    }

    @Override
    public Ram createRam(Ram ram) {
        return null;
    }

    @Override
    public void updateRam(Ram ram) {

    }

    @Override
    public void deleteRam(Long id) {

    }
}
