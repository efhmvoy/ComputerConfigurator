package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Gpu;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {

    Gpu findByName (String name);
}
