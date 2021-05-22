package ua.cn.stu.computerconfigurator.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cn.stu.computerconfigurator.model.Ram;
import ua.cn.stu.computerconfigurator.model.Storage;
import ua.cn.stu.computerconfigurator.service.StorageService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/storage")
public class StorageController {

    private final StorageService storageService;

    public StorageController( StorageService storageService) {

        this.storageService = storageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storage> getStorageById(@PathVariable Long id) {
        Storage result = storageService.getStorageById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Storage>> getAllStorages(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(required=false) Set<String> brand,
                                                @RequestParam(required=false) Set<Long> memorySize,
                                                @RequestParam(required=false) Set<String> memoryType,
                                                @RequestParam(required=false) Set<String> storageType
    )
    {
        Page<Storage> res = storageService.findAllCustom(pageNumber,pageSize,brand,memorySize,memoryType,storageType);
        return new ResponseEntity<>(res.getContent(), HttpStatus.OK);

    }

    @PostMapping(path = "/add")
    public Storage createStorage(@RequestBody Storage storage)
    {
        return storageService.createStorage(storage);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Storage> deleteRam(@PathVariable Long id) {
        storageService.deleteStorage(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
