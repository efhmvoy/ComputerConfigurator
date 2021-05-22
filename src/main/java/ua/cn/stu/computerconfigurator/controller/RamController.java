package ua.cn.stu.computerconfigurator.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Ram;
import ua.cn.stu.computerconfigurator.service.RamService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/ram")
public class RamController {

    private final RamService ramService;

    public RamController(RamService ramService) {
        this.ramService = ramService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ram> getRamById(@PathVariable Long id) {
        Ram result = ramService.getRamById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ram>> getAllRams(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                                 @RequestParam(required=false) Set<String> brand,
                                                                 @RequestParam(required=false) Set<Long> memorySize,
                                                                 @RequestParam(required=false) Set<String> memoryType,
                                                                 @RequestParam(required=false) Set<Long> frequency,
                                                                 @RequestParam(required=false) Set<String> timings
                                                )
    {
        Page<Ram> res = ramService.findAllCustom(pageNumber,pageSize,brand,memorySize,memoryType, frequency,timings);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }

    @PostMapping(path = "/add")
    public Ram createRam(@RequestBody Ram ram)
    {
        return ramService.createRam(ram);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Ram> deleteRam(@PathVariable Long id) {
        ramService.deleteRam(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
