package ua.cn.stu.computerconfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "power_supplies")
@Data
@NoArgsConstructor
public class PowerSupply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name="brand_id", referencedColumnName = "id")
    private Brand brand;

    private Long power;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    private BigDecimal price;

}
