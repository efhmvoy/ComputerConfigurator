package ua.cn.stu.computerconfigurator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Gpu;
import ua.cn.stu.computerconfigurator.service.GpuService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(path = "/api/gpu")
public class GpuController {

    private final GpuService gpuService;
    @Autowired
    public GpuController(GpuService gpuService) {
        this.gpuService = gpuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gpu> getGpuById(@PathVariable Long id) {

        Gpu result = gpuService.getGpuById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gpu>> getAllGpus(@RequestParam(defaultValue = "0") Integer pageNumber,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam( required=false) Set<String> brand ,
                                               @RequestParam(required=false)  Set<String> chip,
                                               @RequestParam(required=false)  Set<Long> memorySize,
                                               @RequestParam(required=false)  Set<String> memoryType,
                                               @RequestParam(required=false) Set<Long> busWidth

    )
    {
        Page<Gpu> res = gpuService.findAllCustom(pageNumber,pageSize,brand,chip,memorySize,memoryType,busWidth);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }

    @PostMapping(path = "/add")
    public Gpu createGpu(@RequestBody Gpu gpu)
    {
        return gpuService.createGpu(gpu);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Gpu> deleteGpu(@PathVariable Long id) {
        gpuService.deleteGpu(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
