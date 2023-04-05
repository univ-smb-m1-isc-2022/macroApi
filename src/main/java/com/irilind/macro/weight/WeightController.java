package com.irilind.macro.weight;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/weight")
public class WeightController {
    WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> createWeight(@RequestBody Weight weight){
        Weight service = weightService.createWeight(weight);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Weight>> getWeightById(@PathVariable Integer id){
        List<Weight> service = weightService.getWeightById(id);
        return ResponseEntity.ok(service);
    }
}
