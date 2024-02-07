package controller;

import dto.PromotionForm;
import dto.SimplePromotionDto;
import entity.Animal;
import entity.AnimalFile;
import entity.AnimalFileManager;
import entity.Promotion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PromotionController {
    @PostMapping("meagea/promotion")
    public Promotion writePromotion(@RequestBody PromotionForm form) throws IOException {
        List<MultipartFile> multiList = new ArrayList<>();
        form = new PromotionForm("제목", "머핀", multiList, 4, 3.5, true, "고양이",
                                "삼색이", "인근 슈퍼 앞", 5, 5, 3, 5,
                                "귀엽습니다.", "집을 많이 비우시는 분은 안됩니다.");

        List<Integer> fileNoList = new ArrayList<>();
        AnimalFileManager fileMan = new AnimalFileManager();
        for(MultipartFile m : form.getMultipartFileList()) {
            AnimalFile animalFile = new AnimalFile(m.getOriginalFilename(), fileMan.serverFile(m));
            fileNoList.add(animalFile.getNo());
        }

        Animal animal = new Animal(form.getName(), form.getAge(), form.getWeight(), form.isNeuter(), form.getKind(),
                                   form.getDetail(), form.getPlace(), form.getHealthState(), form.getActivity(),
                                   form.getSociality(),form.getFriendly());
        Promotion pro = new Promotion(10, form.getTitle(), animal.getNo(), form.getIntroduction(),
                                        form.getCondition(), fileNoList);

        return pro;
    }

    @GetMapping("meagea/promotion/{no}")
    public Promotion getPromotion(int no){

        return new Promotion(no,"제목", 1, "설명", "입양조건", new ArrayList<Integer>());
    }

    @GetMapping("meagea/all-promotion-title")
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