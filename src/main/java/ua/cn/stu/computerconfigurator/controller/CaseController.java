package ua.cn.stu.computerconfigurator.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Case;
import ua.cn.stu.computerconfigurator.service.CaseService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/case")
public class CaseController
{
    private final CaseService caseService;

    public CaseController(CaseService caseService)
    {

        this.caseService = caseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Case> getCaseById(@PathVariable Long id) {
       Case result = caseService.getCaseyById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Case>> getAllCases(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam( required=false) Set<String> brands,
                                                  @RequestParam( required=false) Set<String>  formFactors)
    {

        Page<Case> res = caseService.findAllCustom(pageNumber,pageSize,brands,formFactors);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }


    @PostMapping(path = "/add")
    public ResponseEntity<Case> createCase(@RequestBody Case cas)
    {
       caseService.createCase(cas);
        return new ResponseEntity<>(cas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Case> updateCase(@PathVariable Long id, @RequestBody Case cas)
    {
        caseService.updateCase(cas);
        return new ResponseEntity<>(cas, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Case> deleteCase(@PathVariable Long id) {
        caseService.deleteCase(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
