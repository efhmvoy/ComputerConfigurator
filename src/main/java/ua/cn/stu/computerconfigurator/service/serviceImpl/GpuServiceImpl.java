package ua.cn.stu.computerconfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.*;
import ua.cn.stu.computerconfigurator.repository.BrandRepository;
import ua.cn.stu.computerconfigurator.repository.GpuRepository;
import ua.cn.stu.computerconfigurator.repository.ImageRepository;
import ua.cn.stu.computerconfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.computerconfigurator.service.GpuService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class GpuServiceImpl implements GpuService {

    private final GpuRepository gpuRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
    private final BrandRepository brandRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public GpuServiceImpl(GpuRepository gpuRepository, MemoryDetailsRepository memoryDetailsRepository, BrandRepository brandRepository, ImageRepository imageRepository) {
        this.gpuRepository = gpuRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
        this.brandRepository = brandRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Page<Gpu> findAllCustom  (Integer pageNumber, Integer pageSize, Set<String> brand, Set<String> chip, Set<Long> memorySize, Set<String> memoryType, Set<Long> busWidth) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));

        if(brand==null)
        {
            brand=gpuRepository.findAllBrands();
        }
        if(chip==null)
        {
            chip=gpuRepository.findAllChips();
        }
        if(memorySize==null)
        {
            memorySize=gpuRepository.findAllMemorySize();
        }
        if(memoryType==null)
        {
            memoryType=gpuRepository.findAllMemoryType();
        }
        if(busWidth==null)
        {
            busWidth=gpuRepository.findAllBusWidth();
        }


        return gpuRepository.findAllCustom(brand,chip,memorySize,memoryType,busWidth, paging);
    }

    @Override
    public Gpu getGpuById(Long id) {
        return gpuRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find case by id: " + id));
    }

    @Override
    public Gpu createGpu(Gpu gpu) {

        Optional<Brand> brandByName = brandRepository.findByName(gpu.getBrand().getName());
        brandByName.ifPresent(gpu::setBrand);
        Optional<MemoryDetails> memoryDetailsByName = memoryDetailsRepository.findBySizeAndType(gpu.getMemoryDetails().getSize(),gpu.getMemoryDetails().getType());
        memoryDetailsByName.ifPresent(gpu::setMemoryDetails);

        brandRepository.save(gpu.getBrand());
        memoryDetailsRepository.save(gpu.getMemoryDetails());
        imageRepository.save(gpu.getImage());
        Gpu res = gpuRepository.save(gpu);
        return res;
    }

    @Override
    public void updateGpu(Gpu gpu) {

    }

    @Override
    public void deleteGpu(Long id) {
        if(!gpuRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find gpu by id: " + id); }
        gpuRepository.deleteById(id);
    }
}
