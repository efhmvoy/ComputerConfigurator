package ua.cn.stu.ComputerConfigurator.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chipsets")
@Data
@NoArgsConstructor
public class Chipset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
