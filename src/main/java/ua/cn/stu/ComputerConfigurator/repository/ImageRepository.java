package ua.cn.stu.ComputerConfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.ComputerConfigurator.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
