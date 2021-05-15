package ua.cn.stu.ComputerConfigurator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
public class PowerSupply implements Serializable {
    @Id
    @SequenceGenerator(
            name="power_supply_sequence",
            sequenceName = "power_supply_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "power_supply_sequence"
    )
   private Long id;
    private String name;
    private String brand;
    private Integer power;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPower() {
        return power;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private BigDecimal price;

    public PowerSupply(Long id, String name, String brand, Integer power, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.power = power;
        this.price = price;
    }

    public PowerSupply() {

    }
}
