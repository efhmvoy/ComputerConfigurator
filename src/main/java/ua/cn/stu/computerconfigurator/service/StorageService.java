package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.Storage;

import java.util.Set;

public interface StorageService {

    Storage createStorage(Storage storage);

    void updateStorage(Storage storage);

    void deleteStorage(Long id);

    Storage getStorageById(Long id);

    Page<Storage> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<Long> memorySize, Set<String> memoryType,Set<String> storageType);
}
