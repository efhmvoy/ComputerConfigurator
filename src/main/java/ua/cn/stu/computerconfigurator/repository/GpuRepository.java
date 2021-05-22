package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Gpu;

import java.util.Set;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {

    @Query(value = "select DISTINCT brands.name from brands,gpus where gpus.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT chip from gpus",nativeQuery = true)
    Set<String> findAllChips();

    @Query(value = "select DISTINCT memory_details.size from memory_details,gpus where gpus.memory_details_id=memory_details.id",nativeQuery = true)
    Set<Long> findAllMemorySize();

    @Query(value = "select DISTINCT memory_details.type from memory_details,gpus where gpus.memory_details_id=memory_details.id",nativeQuery = true)
    Set<String> findAllMemoryType();

    @Query(value = "select DISTINCT bus_width from gpus",nativeQuery = true)
    Set<Long> findAllBusWidth();

    @Query("SELECT g FROM Gpu g WHERE g.brand.name IN (?1) and g.chip in (?2) and g.memoryDetails.size in (?3) and g.memoryDetails.type in (?4) and g.busWidth in (?5) ")
    Page<Gpu> findAllCustom(Set<String> brand, Set<String> chip, Set<Long> memorySize, Set<String> memoryType, Set<Long> busWidth, PageRequest paging);
}
