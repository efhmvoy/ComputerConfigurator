package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
