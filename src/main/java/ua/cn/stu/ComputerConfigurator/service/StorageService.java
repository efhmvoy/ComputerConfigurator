package ua.cn.stu.ComputerConfigurator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.cn.stu.ComputerConfigurator.model.Storage;

public interface StorageService {

    Storage getByName(String name);

    Page<Storage> getAllByBrand(String brand);

    Page<Storage> getAllByStorageType(String type, Pageable pageable);

    Page<Storage> getAllByMemorySize(Integer size, Pageable pageable);

    Storage createStorage(Storage storage);

    void updateStorage(Storage storage);

    void deleteStorage(Long id);

}
