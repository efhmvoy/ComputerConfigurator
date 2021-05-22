package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.PowerSupply;
import java.util.Set;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

    @Query(value = "select DISTINCT brands.name from brands,power_supplies where power_supplies.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT power from power_supplies",nativeQuery = true)
    Set<Long> findAllPowers();

    @Query("SELECT p FROM PowerSupply p WHERE p.brand.name IN (?1) and p.power in (?2)")
    Page<PowerSupply> findAllCustom(Set<String> brand, Set<Long> power, PageRequest paging);
}
