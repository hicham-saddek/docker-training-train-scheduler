package com.welovejava.palindrom.app.http.controllers;

import com.welovejava.palindrom.app.models.Train;
import com.welovejava.palindrom.app.payloads.TrainDto;
import com.welovejava.palindrom.app.services.TrainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/trains")
public class TrainController {

    protected ModelMapper mapper;
    protected TrainService service;

    @Autowired
    TrainController(ModelMapper mapper, TrainService service) {
        this.service = service;
        this.mapper = mapper;
    }

    protected ResponseEntity<Map<String, Object>> success(String name, Object item) {
        return ResponseEntity.ok(Map.of("status", "success", name, item));
    }

    protected ResponseEntity<Map<String, Object>> failure(String message) {
        return ResponseEntity.ok(Map.of("status", "failure", "cause", message));
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> viewAll() {
        return success("trains", service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> view(@PathVariable int id) {
        Train train = service.getOne(id);
        if (train == null) return failure("Train id T-%03d was not found".formatted(id));
        return success("train", train);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> create(TrainDto dto) {
        if (dto.isNotValid()) return failure("Your request is not valid");
        return success("train", service.create(mapper.map(dto, Train.class)));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int id, TrainDto dto) {
        if (dto.isNotValid()) return failure("Your request is not valid");
        return success("train", service.update(id, mapper.map(dto, Train.class)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> destroy(@PathVariable int id) {
        return success("deleted", service.delete(id));
    }
}