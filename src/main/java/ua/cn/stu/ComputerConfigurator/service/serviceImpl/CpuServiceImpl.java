package ua.cn.stu.ComputerConfigurator.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.Cpu;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.ChipsetRepository;
import ua.cn.stu.ComputerConfigurator.repository.CpuRepository;
import ua.cn.stu.ComputerConfigurator.service.CpuService;

@Service
public class CpuServiceImpl implements CpuService {

    private final BrandRepository brandRepository;
    private final ChipsetRepository chipsetRepository;
    private final CpuRepository cpuRepository;
    @Autowired
    public CpuServiceImpl(BrandRepository brandRepository, ChipsetRepository chipsetRepository, CpuRepository cpuRepository) {
        this.brandRepository = brandRepository;
        this.chipsetRepository = chipsetRepository;
        this.cpuRepository = cpuRepository;
    }

    @Override
    public Cpu getByName(String name) {
        return null;
    }

    @Override
    public Page<Cpu> getAllByBrand(String brand, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Cpu> getAllByCoreCount(Integer coreCount, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Cpu> getAllByThreadCount(Integer threadCount, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Cpu> getAllByChipset(String chipset, Pageable pageable) {
        return null;
    }

    @Override
    public Cpu createCpu(Cpu cpu) {
        return null;
    }

    @Override
    public void updateCpu(Cpu cpu) {

    }

    @Override
    public void deleteCpu(Long id) {

    }
}
