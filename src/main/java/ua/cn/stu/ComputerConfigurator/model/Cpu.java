package ua.cn.stu.ComputerConfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cpus")
@Data
@NoArgsConstructor
public class Cpu {

private Long id;

}
