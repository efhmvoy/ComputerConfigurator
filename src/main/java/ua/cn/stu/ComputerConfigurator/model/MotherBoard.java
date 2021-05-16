package ua.cn.stu.ComputerConfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "motherboards")
@Data
@NoArgsConstructor
public class MotherBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name="brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToOne
    @JoinColumn(name="memory_details_id", referencedColumnName = "id")
    private MemoryDetails memoryDetails;

    @OneToOne
    @JoinColumn(name = "chipset_id", referencedColumnName = "id")
    private Chipset chipset;

    private String formFactor;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    private BigDecimal price;



}
