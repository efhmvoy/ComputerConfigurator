package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
