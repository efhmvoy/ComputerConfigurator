package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    Storage findByName (String name);
}
