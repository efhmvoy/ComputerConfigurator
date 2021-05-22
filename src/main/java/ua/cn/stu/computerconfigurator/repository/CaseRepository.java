package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Case;
import java.util.Set;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {

    @Query("SELECT c FROM Case c WHERE c.brand.name IN (?1) and c.formFactor in (?2)")
    Page<Case> findAllCustom(Set<String> brands, Set<String> formFactors, PageRequest pageRequest);

    @Query(value = "select DISTINCT brands.name from brands,cases where cases.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT form_factor from cases",nativeQuery = true)
    Set<String> findAllFormFactors();

}
