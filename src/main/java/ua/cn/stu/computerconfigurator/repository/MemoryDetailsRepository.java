package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.MemoryDetails;
import java.util.Optional;

@Repository
public interface MemoryDetailsRepository extends JpaRepository<MemoryDetails, Long> {

    default Optional<MemoryDetails> findBySizeAndType(Long size, String type)
    {
        MemoryDetails memoryDetails = new MemoryDetails();
        memoryDetails.setSize(size);
        memoryDetails.setType(type);
        return this.findOne(Example.of(memoryDetails));
    }

}
