package ua.cn.stu.ComputerConfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.Gpu;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.GpuRepository;
import ua.cn.stu.ComputerConfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.ComputerConfigurator.service.GpuService;

@Service
public class GpuServiceImpl implements GpuService {

    private final GpuRepository gpuRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
    private final BrandRepository brandRepository;
    @Autowired
    public GpuServiceImpl(GpuRepository gpuRepository, MemoryDetailsRepository memoryDetailsRepository, BrandRepository brandRepository) {
        this.gpuRepository = gpuRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Gpu getByName(String name) {
        return null;
    }

    @Override
    public Page<Gpu> getAllByBrand(String brand, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Gpu> getAllByChip(String chip, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Gpu> getAllByMemoryType(String memoryType, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Gpu> getAllByMemorySize(Integer memorySize, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Gpu> getAllByBusWidth(Integer busWidth, Pageable pageable) {
        return null;
    }

    @Override
    public Gpu createGpu(Gpu gpu) {
        return null;
    }

    @Override
    public void updateGpu(Gpu gpu) {

    }

    @Override
    public void deleteGpu(Long id) {

    }
}
