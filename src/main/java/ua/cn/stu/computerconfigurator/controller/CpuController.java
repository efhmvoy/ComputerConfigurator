package ua.cn.stu.computerconfigurator.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Case;
import ua.cn.stu.computerconfigurator.model.Cpu;
import ua.cn.stu.computerconfigurator.service.CpuService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/cpu")
public class CpuController {

    private final CpuService cpuService;

    public CpuController(CpuService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cpu> getCpuById(@PathVariable Long id) {
       Cpu result = cpuService.getCpuById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cpu>> getAllCpus(@RequestParam(defaultValue = "0") Integer pageNumber,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam( required=false) Set<String> brand ,
                                               @RequestParam(required=false) Set<Long> coreCount,
                                               @RequestParam(required=false) Set<Long> threadCount,
                                               @RequestParam(required=false) Set<String> socket,
                                               @RequestParam(required=false) Set<String> model,
                                               @RequestParam(required=false) Set<String> frequency
                                               )
    {
        Page<Cpu> res = cpuService.findAllCustom(pageNumber, pageSize,brand,coreCount, threadCount,socket,model,frequency);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }

    @PostMapping(path = "/add")
    public Cpu createCpu(@RequestBody Cpu cpu)
    {
        return cpuService.createCpu(cpu);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Cpu> deleteCpu(@PathVariable Long id) {
        cpuService.deleteCpu(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
