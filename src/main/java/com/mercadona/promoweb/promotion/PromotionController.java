package com.mercadona.promoweb.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController

public class PromotionController {
    @Autowired
    private PromotionRepository promotionRepository;

    @GetMapping("/promotions")
    public Iterable<Promotion> getPromotions() {
        return promotionRepository.findAll();
    }

    @GetMapping("/promotions/{id}")
    public Promotion getPromotion(@PathVariable Long id) {
        return promotionRepository.findById(id).orElseThrow(() -> new PromotionNotFoundException(id));
    }

    @PostMapping("/promotions")
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @PutMapping("/promotions/{id}")
    public Promotion updatePromotion(@RequestBody Promotion promotion, @PathVariable Long id) {
        if (promotion.getId() != id) {
            throw new PromotionIdMismatchException();
        }
        promotionRepository.findById(id).orElseThrow(() -> new PromotionNotFoundException(id));
        return promotionRepository.save(promotion);
    }

    @DeleteMapping("/promotions/{id}")
    public void deletePromotion(@PathVariable Long id) {
        promotionRepository.findById(id).orElseThrow(() -> new PromotionNotFoundException(id));
        promotionRepository.deleteById(id);
    }    
}
