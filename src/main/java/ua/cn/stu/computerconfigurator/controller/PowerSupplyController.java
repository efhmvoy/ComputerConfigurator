package ua.cn.stu.computerconfigurator.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Gpu;
import ua.cn.stu.computerconfigurator.model.PowerSupply;
import ua.cn.stu.computerconfigurator.service.PowerSupplyService;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/power_supply")
public class PowerSupplyController
{

    private final PowerSupplyService powerSupplyService;

    public PowerSupplyController(PowerSupplyService powerSupplyService) {
        this.powerSupplyService = powerSupplyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PowerSupply>> getAllPowerSupplies(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                                 @RequestParam(required=false) Set<String> brand,
                                                                 @RequestParam(required=false) Set<Long> power)
    {
        Page<PowerSupply> res = powerSupplyService.findAllCustom(pageNumber,pageSize,brand,power);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PowerSupply> getPowerSupplyById(@PathVariable Long id) {
        PowerSupply result = powerSupplyService.getPowerSupplyById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    @PostMapping(path = "/add")
    public PowerSupply createPowerSupply(@RequestBody PowerSupply powerSupply)
    {
        return powerSupplyService.createPowerSupply(powerSupply);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PowerSupply> deletePowerSupply(@PathVariable Long id) {
        powerSupplyService.deletePowerSupply(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

