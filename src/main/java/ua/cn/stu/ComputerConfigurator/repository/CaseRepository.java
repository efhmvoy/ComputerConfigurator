package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
    Case findByName (String name);

}
