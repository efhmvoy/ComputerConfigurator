package ua.cn.stu.ComputerConfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "memory_details")
@Data
@NoArgsConstructor
public class MemoryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Type;

    private Long size;
}
