package ua.cn.stu.computerconfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "storages")
@Data
@NoArgsConstructor
public class Storage {

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

    private String storageType;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    private BigDecimal price;


}
