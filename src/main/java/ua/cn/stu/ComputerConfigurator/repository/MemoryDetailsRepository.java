package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.MemoryDetails;

@Repository
public interface MemoryDetailsRepository extends JpaRepository<MemoryDetails, Long> {

}
