package ua.cn.stu.ComputerConfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "gpus")
@Data
@NoArgsConstructor
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String chip;

    @OneToOne
    @JoinColumn(name="brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToOne
    @JoinColumn(name="memory_details_id", referencedColumnName = "id")
    private MemoryDetails memoryDetails;

    private Long busWidth;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    private BigDecimal price;


}
