package ua.cn.stu.ComputerConfigurator.controller;



import org.springframework.web.bind.annotation.*;
import ua.cn.stu.ComputerConfigurator.model.PowerSupply;
import ua.cn.stu.ComputerConfigurator.service.PowerSupplyService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/power")
public class PowerSupplyController
{

    private final PowerSupplyService powerSupplyService;

    public PowerSupplyController(PowerSupplyService powerSupplyService) {
        this.powerSupplyService = powerSupplyService;
    }

    @GetMapping("/zxc")
    public List<PowerSupply> getAllPowerSupplies()
    {
        List<PowerSupply> list = new ArrayList<>();
        list.add(new PowerSupply());
      return list;
    };

    @PostMapping(path = "/api/power")
    public PowerSupply createPowerSupply(@RequestBody PowerSupply powerSupply)
    {
        return powerSupplyService.createPowerSupply(powerSupply);
    }


}

