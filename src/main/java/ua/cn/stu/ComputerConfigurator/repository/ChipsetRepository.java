package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Chipset;

@Repository
public interface ChipsetRepository extends JpaRepository<Chipset, Long> {
    Chipset findByName (String name);
}
