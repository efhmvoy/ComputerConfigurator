package ua.cn.stu.computerconfigurator.controller;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Gpu;
import ua.cn.stu.computerconfigurator.model.MotherBoard;
import ua.cn.stu.computerconfigurator.service.MotherBoardService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/motherboard")
public class MotherBoardController {

    private final MotherBoardService motherBoardService;

    public MotherBoardController(MotherBoardService motherBoardService) {
        this.motherBoardService = motherBoardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotherBoard> getGpuById(@PathVariable Long id) {

        MotherBoard result = motherBoardService.getMotherBoardById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MotherBoard>> getAllMotherBoards(@RequestParam(defaultValue = "0") Integer pageNumber,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam( required=false) Set<String> brand ,
                                               @RequestParam(required=false) Set<String> chipset,
                                               @RequestParam(required=false) Set<Long> memorySize,
                                               @RequestParam(required=false) Set<String> memoryType,
                                               @RequestParam(required=false) Set<String> socket,
                                               @RequestParam(required=false) Set<String> formFactor

    )
    {
        Page<MotherBoard> res = motherBoardService.findAllCustrom(pageNumber,pageSize,brand,chipset,memorySize,memoryType,socket,formFactor);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }

    @PostMapping(path = "/add")
    public MotherBoard createMotherBoard(@RequestBody MotherBoard motherBoard)
    {
        return motherBoardService.createMotherboard(motherBoard);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MotherBoard> deleteMotherboard(@PathVariable Long id) {
        motherBoardService.deleteMotherBoard(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
