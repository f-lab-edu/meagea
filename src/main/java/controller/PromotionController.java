package controller;

import dto.PromotionForm;
import entity.Animal;
import entity.Promotion;
import dto.SimplePromotionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PromotionController {

    @PostMapping("/promotion")
    public Promotion writePromotion(@RequestBody PromotionForm form) {
        Animal animal = new Animal();
        animal.setAge(form.getAge());
        animal.setActivity(form.getActivity());
        animal.setFriendly(form.getFriendly());
        animal.setDetail(form.getDetail());
        animal.setKind(form.getKind());
        animal.setName(form.getName());
        animal.setNeuter(form.isNeuter());
        animal.setPlace(form.getPlace());
        animal.setSociality(form.getSociality());
        animal.setWeight(form.getWeight());
        animal.setHealthState(form.getHealthState());
        animal.setAdoptionState(form.getAdoptionState());

        Promotion pro = new Promotion(animal);
        pro.setCondition(form.getCondition());
        pro.setIntroduction(form.getIntroduction());
        pro.setIntroduction(form.getIntroduction());

        return pro;
    }

    @GetMapping("/promotion")
    public Promotion getPromotion(int no){
        Promotion pro = new Promotion();
        pro.setNo(no);

        return pro;
    }

    @GetMapping("/all-promotion")
    public List<SimplePromotionDto> getAllPromotion() {
        List<SimplePromotionDto> simpleList = new ArrayList<>();


        return simpleList;
    }
}
