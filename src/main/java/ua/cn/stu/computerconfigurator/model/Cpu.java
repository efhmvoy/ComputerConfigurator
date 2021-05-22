package ua.cn.stu.computerconfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cpus")
@Data
@NoArgsConstructor
public class Cpu {

private Long id;

}
