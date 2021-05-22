package ua.cn.stu.computerconfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.*;
import ua.cn.stu.computerconfigurator.repository.BrandRepository;
import ua.cn.stu.computerconfigurator.repository.ImageRepository;
import ua.cn.stu.computerconfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.computerconfigurator.repository.RamRepository;
import ua.cn.stu.computerconfigurator.service.RamService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;
    private final BrandRepository brandRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
    private final ImageRepository imageRepository;
   @Autowired
    public RamServiceImpl(RamRepository ramRepository, BrandRepository brandRepository, MemoryDetailsRepository memoryDetailsRepository, ImageRepository imageRepository) {
        this.ramRepository = ramRepository;
        this.brandRepository = brandRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
       this.imageRepository = imageRepository;
   }

    @Override
    public Page<Ram> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<Long> memorySize, Set<String> memoryType, Set<Long> frequency, Set<String> timings) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));

        if(brand==null)
        {
            brand=ramRepository.findAllBrands();
        }
        if(memorySize==null)
        {
            memorySize=ramRepository.findAllMemorySizes();
        }

        if(memoryType==null)
        {
            memoryType=ramRepository.findAllMemoryTypes();
        }
        if(frequency==null)
        {
            frequency=ramRepository.findAllFrequencies();
        }

        if(timings==null)
        {
            timings=ramRepository.findAllTimings();
        }

        return ramRepository.findAllCustom(brand,memorySize,memoryType,frequency,timings, paging);
    }

    @Override
    public Ram getRamById(Long id) {
        return ramRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find powerSupply by id: " + id));
    }

    @Override
    public Ram createRam(Ram ram) {
        Optional<Brand> brandByName = brandRepository.findByName(ram.getBrand().getName());
        brandByName.ifPresent(ram::setBrand);
        Optional<MemoryDetails> memoryDetailsByName = memoryDetailsRepository.findBySizeAndType(ram.getMemoryDetails().getSize(),ram.getMemoryDetails().getType());
        memoryDetailsByName.ifPresent(ram::setMemoryDetails);
        brandRepository.save(ram.getBrand());
        memoryDetailsRepository.save(ram.getMemoryDetails());
        imageRepository.save(ram.getImage());
        return ramRepository.save(ram);
    }

    @Override
    public void updateRam(Ram ram) {

    }

    @Override
    public void deleteRam(Long id) {
        if(!ramRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find ram by id: " + id); }
        ramRepository.deleteById(id);
    }
}
