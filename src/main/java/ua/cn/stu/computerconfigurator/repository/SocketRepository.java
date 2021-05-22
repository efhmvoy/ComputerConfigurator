package ua.cn.stu.computerconfigurator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.cn.stu.computerconfigurator.model.Socket;

import java.util.Optional;

@Repository
public interface SocketRepository extends JpaRepository<Socket, Long> {

    @Query("SELECT s FROM Socket s WHERE s.name = ?1")
    Optional<Socket> findByName (String name);

}
