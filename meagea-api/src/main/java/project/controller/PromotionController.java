package project.controller;

import entity.Promotion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.dto.PromotionModifyDto;
import project.service.PromotionService;
import project.dto.PromotionForm;
import project.dto.SimplePromotionDto;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/meagea")
public class PromotionController {

    private final PromotionService proService;

    @PostMapping("/promotion")
    public Promotion addPromotion(@ModelAttribute PromotionForm form) throws IOException {
        return proService.savePromotion(form);
    }

    @GetMapping("/promotion/{no}")
    public Promotion getPromotion(@PathVariable int no) {
        return proService.findByNo(no);
    }

    @GetMapping("/all-promotion-title")
    public List<SimplePromotionDto> getAllPromotionTitle() {
        return proService.findAllSimple();
    }

    @PatchMapping("/promotion")
    public Promotion modifyPromotion(@ModelAttribute PromotionModifyDto modifyDto) {
        return proService.updatePromotion(modifyDto);
    }

    @DeleteMapping("/promotion/{no}")
    public void deletePromotion(@PathVariable int no) {
        proService.deletePromotion(no);
    }
}