package project.controller;

import entity.Animal;
import entity.AnimalFile;
import entity.Promotion;
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
@RequestMapping("/meagea")
public class PromotionController {

    private PromotionService proService;

    public PromotionController(PromotionService proService) {
        this.proService = proService;
    }

    @PostMapping("/promotion")
    public Promotion writePromotion(@ModelAttribute PromotionForm form) throws IOException {
        List<Integer> fileNoList = new ArrayList<>();
        AnimalFileManager fileMan = new AnimalFileManager();
        for(MultipartFile m : form.getImageList()) {
            AnimalFile animalFile = new AnimalFile(1, m.getOriginalFilename(), fileMan.serverFile(m), "promotion");
            fileNoList.add(animalFile.getNo());
        }

        Animal animal = new Animal(form.getName(), form.getAge(), form.getWeight(), form.isNeuter(), form.getKind(),
                                   form.getDetail(), form.getPlace(), form.getHealthState(), form.getActivity(),
                                   form.getSociality(),form.getFriendly());

        return new Promotion(form.getTitle(), animal.getNo(), form.getIntroduction(),
                                        form.getCondition());
    }

    @GetMapping("/promotion/{no}")
    public Promotion getPromotion(@PathVariable int no){
        return new Promotion("제목", 1, "설명", "입양조건");
    }

    @GetMapping("/all-promotion-title")
    public List<SimplePromotionDto> getAllPromotionTitle() {
        int data = 10;
        List<SimplePromotionDto> simpleList = new ArrayList<>();
        for(int i = 0; i <= data; i++){
            SimplePromotionDto simple = new SimplePromotionDto(i, i,"사지말고 입양하세요" + i,
                                                        "초코" + i, "암컷", 1 + i, "고양이");
            simpleList.add(simple);
        }

        return simpleList;
    }
}