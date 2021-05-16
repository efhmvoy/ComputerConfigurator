package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Ram;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long> {
    Ram findByName (String name);
}
