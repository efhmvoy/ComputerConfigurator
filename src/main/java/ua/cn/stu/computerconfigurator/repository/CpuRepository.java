package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Cpu;

import java.util.Set;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Long> {

    @Query(value = "select DISTINCT brands.name from brands,cpus where cpus.brand_id=brands.id",nativeQuery = true)
    Set<String> findAllBrands();

    @Query(value = "select DISTINCT core_count from cpus",nativeQuery = true)
    Set<Long> findAllCoreCount();

    @Query(value = "select DISTINCT thread_count from cpus",nativeQuery = true)
    Set<Long> findAllThreadCount();

    @Query(value = "select DISTINCT sockets.name from sockets,cpus where cpus.socket_id=sockets.id",nativeQuery = true)
    Set<String> findAllSockets();

    @Query(value = "select DISTINCT model from cpus",nativeQuery = true)
    Set<String> findAllModels();

    @Query(value = "select DISTINCT frequency from cpus",nativeQuery = true)
    Set<String> findAllFormFrequencies();

    @Query("SELECT c FROM Cpu c WHERE c.brand.name IN (?1) and c.coreCount in (?2) and c.threadCount in (?3) and c.socket.name in (?4) and c.model in (?5) and c.frequency in(?6)")
    Page<Cpu> findAllCustom(Set<String> brands, Set<Long> coreCount, Set<Long> threadCount, Set<String> socket, Set<String> model, Set<String> frequency, PageRequest paging);
}
