package project.service;

import entity.Promotion;
import org.springframework.stereotype.Service;
import project.dto.PromotionForm;
import project.dto.SimplePromotionDto;
import project.repository.PromotionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService {
    PromotionRepository repo;

    public Promotion findByNo(int no) {
        return repo.findByNo(no);
    }

    public List<SimplePromotionDto> findAllSimple(){
        List<Promotion> proList = repo.findAll();
        List<SimplePromotionDto> simpleList = new ArrayList<>();
        for(Promotion pro : proList){

            SimplePromotionDto simple = new SimplePromotionDto(pro.getNo(), pro.getAnimalNo(), pro.getTitle());
        }

        return simpleList;
    }

}
