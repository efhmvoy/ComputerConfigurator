package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.MotherBoard;
import java.util.Set;

@Repository
public interface MotherBoardRepository extends JpaRepository<MotherBoard, Long> {

    @Query(value = "select DISTINCT brands.name from brands,motherboards where motherboards.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT chipset from motherboards",nativeQuery = true)
    Set<String> findAllChipsets();

    @Query(value = "select DISTINCT memory_details.size from memory_details,motherboards where motherboards.memory_details_id=memory_details.id",nativeQuery = true)
    Set<Long> findAllMemorySizes();

    @Query(value = "select DISTINCT memory_details.type from memory_details,motherboards where motherboards.memory_details_id=memory_details.id",nativeQuery = true)
    Set<String> findAllMemoryTypes();

    @Query(value = "select DISTINCT form_factor from motherboards",nativeQuery = true)
    Set<String> findAllFormFactors();

    @Query(value = "select DISTINCT sockets.name from sockets,motherboards where motherboards.socket_id=sockets.id",nativeQuery = true)
    Set<String> findAllSockets();

    @Query("SELECT m FROM MotherBoard m WHERE m.brand.name IN (?1) and m.chipset in (?2) and m.memoryDetails.size in (?3) and m.memoryDetails.type in (?4) and m.socket.name in (?5) and m.formFactor in(?6)")
    Page<MotherBoard> findAllCustom(Set<String> brand, Set<String> chipset, Set<Long> memorySize, Set<String> memoryType, Set<String> socket, Set<String> formFactor, PageRequest paging);
}
