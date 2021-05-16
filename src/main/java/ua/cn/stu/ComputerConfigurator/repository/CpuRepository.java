package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Cpu;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Long> {

    Cpu findByName (String name);
}
