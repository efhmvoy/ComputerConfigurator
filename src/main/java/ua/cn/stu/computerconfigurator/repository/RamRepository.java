package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Ram;
import java.util.Set;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long> {

    @Query(value = "select DISTINCT brands.name from brands,rams where rams.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT memory_details.size from memory_details,rams where rams.memory_details_id=memory_details.id",nativeQuery = true)
    Set<Long> findAllMemorySizes();

    @Query(value = "select DISTINCT memory_details.type from memory_details,rams where rams.memory_details_id=memory_details.id",nativeQuery = true)
    Set<String> findAllMemoryTypes();

    @Query(value = "select DISTINCT frequency from rams",nativeQuery = true)
    Set<Long> findAllFrequencies();

    @Query(value = "select DISTINCT timings from rams",nativeQuery = true)
    Set<String> findAllTimings();

    @Query("SELECT r FROM Ram r WHERE r.brand.name IN (?1)  and r.memoryDetails.size in (?2) and r.memoryDetails.type in (?3) and r.frequency in (?4) and r.timings in (?5)")
    Page<Ram> findAllCustom(Set<String> brand, Set<Long> memorySize, Set<String> memoryType, Set<Long> frequency, Set<String> timings, PageRequest paging);
}
