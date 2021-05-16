package ua.cn.stu.ComputerConfigurator.service.serviceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.Storage;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.ComputerConfigurator.repository.StorageRepository;
import ua.cn.stu.ComputerConfigurator.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;
    private final BrandRepository brandRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;

    public StorageServiceImpl(StorageRepository storageRepository, BrandRepository brandRepository, MemoryDetailsRepository memoryDetailsRepository) {
        this.storageRepository = storageRepository;
        this.brandRepository = brandRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
    }


    @Override
    public Storage getByName(String name) {
        return null;
    }

    @Override
    public Page<Storage> getAllByBrand(String brand) {
        return null;
    }

    @Override
    public Page<Storage> getAllByStorageType(String type, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Storage> getAllByMemorySize(Integer size, Pageable pageable) {
        return null;
    }

    @Override
    public Storage createStorage(Storage storage) {
        return null;
    }

    @Override
    public void updateStorage(Storage storage) {

    }

    @Override
    public void deleteStorage(Long id) {

    }
}
