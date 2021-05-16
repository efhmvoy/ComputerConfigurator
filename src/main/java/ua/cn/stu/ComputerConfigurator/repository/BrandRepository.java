package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByName (String name);
}
