package com.irilind.macro.weight;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class WeightService {

    WeightRepository repository;

    public WeightService(WeightRepository repository) {
        this.repository = repository;
    }
    public List<Weight> getWeightById(Integer id) {
        List<Weight> weight = repository.findAllByUserId(id);
        weight.sort(Comparator.comparing(Weight::getCreatedAt));
        return weight;
    }

    public Weight createWeight(Weight weight) {
        return repository.save(weight);
    }

}
