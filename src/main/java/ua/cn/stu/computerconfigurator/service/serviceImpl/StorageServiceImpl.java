package ua.cn.stu.computerconfigurator.service.serviceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.Brand;
import ua.cn.stu.computerconfigurator.model.MemoryDetails;
import ua.cn.stu.computerconfigurator.model.Storage;
import ua.cn.stu.computerconfigurator.repository.BrandRepository;
import ua.cn.stu.computerconfigurator.repository.ImageRepository;
import ua.cn.stu.computerconfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.computerconfigurator.repository.StorageRepository;
import ua.cn.stu.computerconfigurator.service.StorageService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;
    private final BrandRepository brandRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
    private final ImageRepository imageRepository;

    public StorageServiceImpl(StorageRepository storageRepository, BrandRepository brandRepository, MemoryDetailsRepository memoryDetailsRepository, ImageRepository imageRepository) {
        this.storageRepository = storageRepository;
        this.brandRepository = brandRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
        this.imageRepository = imageRepository;
    }


    @Override
    public Storage getStorageById(Long id) {
        return storageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find powerSupply by id: " + id));
    }

    @Override
    public Storage createStorage(Storage storage) {

        Optional<Brand> brandByName = brandRepository.findByName(storage.getBrand().getName());
        brandByName.ifPresent(storage::setBrand);
        Optional<MemoryDetails> memoryDetailsByName = memoryDetailsRepository.findBySizeAndType(storage.getMemoryDetails().getSize(),storage.getMemoryDetails().getType());
        memoryDetailsByName.ifPresent(storage::setMemoryDetails);
        brandRepository.save(storage.getBrand());
        memoryDetailsRepository.save(storage.getMemoryDetails());
        imageRepository.save(storage.getImage());
        return storageRepository.save(storage);
    }

    @Override
    public Page<Storage> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<Long> memorySize, Set<String> memoryType,Set<String> storageType) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));

        if(brand==null)
        {
            brand=storageRepository.findAllBrands();
        }
        if(memorySize==null)
        {
            memorySize=storageRepository.findAllMemorySizes();
        }
        if(memoryType==null)
        {
            memoryType=storageRepository.findAllMemoryTypes();
        }
        if(storageType==null)
        {
            storageType=storageRepository.findAllStorageTypes();
        }

        return storageRepository.findAllCustom(brand,memorySize,memoryType,storageType, paging);
    }

    @Override
    public void updateStorage(Storage storage) {

    }

    @Override
    public void deleteStorage(Long id) {
        if(!storageRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find storage by id: " + id); }
        storageRepository.deleteById(id);
    }
}
