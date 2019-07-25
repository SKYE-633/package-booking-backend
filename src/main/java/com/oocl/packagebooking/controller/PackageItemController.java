package com.oocl.packagebooking.controller;


import com.oocl.packagebooking.entity.PackageItem;
import com.oocl.packagebooking.service.PackageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:8088", "http://localhost:8081" }, maxAge = 6000)
public class PackageItemController {

    @Autowired
    private PackageItemService packageItemService;

    @PostMapping("/items")
    public ResponseEntity<PackageItem> save(@RequestBody  PackageItem packageItem){
        return ResponseEntity.status(HttpStatus.CREATED).body(packageItemService.save(packageItem));
    }

    @GetMapping("/items")
    public ResponseEntity<List<PackageItem>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(packageItemService.findAll());
    }

    @GetMapping("/items/{status}")
    public ResponseEntity<List<PackageItem>> findByStatus(@PathVariable String status){
        return ResponseEntity.status(HttpStatus.OK).body(packageItemService.findByStatus(status));
    }

    @PutMapping("/items")
    public ResponseEntity<PackageItem> findByStatus(@RequestBody  PackageItem packageItem){
        return ResponseEntity.status(HttpStatus.OK).body(packageItemService.save(packageItem));
    }
}
