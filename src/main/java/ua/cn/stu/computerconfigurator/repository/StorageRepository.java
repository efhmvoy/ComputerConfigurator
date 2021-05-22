package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Storage;

import java.util.Set;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Query(value = "select DISTINCT brands.name from brands,storages where storages.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT memory_details.size from memory_details,storages where storages.memory_details_id=memory_details.id",nativeQuery = true)
    Set<Long> findAllMemorySizes();

    @Query(value = "select DISTINCT memory_details.type from memory_details,storages where storages.memory_details_id=memory_details.id",nativeQuery = true)
    Set<String> findAllMemoryTypes();

    @Query(value = "select DISTINCT storage_type from rams",nativeQuery = true)
    Set<String> findAllStorageTypes();

    @Query("SELECT s FROM Storage s WHERE s.brand.name IN (?1)  and s.memoryDetails.size in (?2) and s.memoryDetails.type in (?3) and s.storageType in (?4) ")
    Page<Storage> findAllCustom(Set<String> brand, Set<Long> memorySize, Set<String> memoryType, Set<String> storageType, PageRequest paging);
}
