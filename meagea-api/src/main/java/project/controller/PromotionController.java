package project.controller;

import entity.Animal;
import entity.AnimalFile;
import entity.Promotion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.service.PromotionService;
import project.unit.AnimalFileManager;
import project.dto.PromotionForm;
import project.dto.SimplePromotionDto;

import java.io.IOException;
import java.util.ArrayList;
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
    public Promotion getPromotion(@PathVariable int no){
        return proService.findByNo(no);
    }

    @GetMapping("/all-promotion-title")
    public List<SimplePromotionDto> getAllPromotionTitle() {
        return proService.findAllSimple();
    }
}