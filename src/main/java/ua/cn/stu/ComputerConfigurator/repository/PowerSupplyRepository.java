package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.PowerSupply;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {
}
