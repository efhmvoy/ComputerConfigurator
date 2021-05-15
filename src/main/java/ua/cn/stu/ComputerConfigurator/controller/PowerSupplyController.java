package ua.cn.stu.ComputerConfigurator.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.cn.stu.ComputerConfigurator.model.PowerSupply;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/power")
public class PowerSupplyController {
    @GetMapping("/zxc")
    public List<PowerSupply> getAllPowerSupplies()
    {
       // return List.of("zxc","qwe");
        return List.of(new PowerSupply(1L,"Be quit zxc", "Be quit",750,new BigDecimal(228)));
    }
}
