package ua.cn.stu.computerconfigurator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "computers")
@Data
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cpu_id", referencedColumnName = "id")
    private Cpu cpu;

    @OneToOne
    @JoinColumn(name = "motherboard_id", referencedColumnName = "id")
    private MotherBoard motherBoard;

    @OneToOne
    @JoinColumn(name = "ram_id", referencedColumnName = "id")
    private Ram ram;

    @OneToOne
    @JoinColumn(name = "gpu_id", referencedColumnName = "id")
    private Gpu gpu;

    @OneToOne
    @JoinColumn(name = "case_id", referencedColumnName = "id")
    private Case Case;

    @OneToOne
    @JoinColumn(name = "storage_id", referencedColumnName = "id")
    private Storage storage;
    @OneToOne
    @JoinColumn(name = "power_supply_id", referencedColumnName = "id")
    private PowerSupply powerSupply;

    private BigDecimal total;

}
