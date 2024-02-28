package project;


import entity.Animal;
import entity.Promotion;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import project.dto.PromotionForm;
import project.dto.SimplePromotionDto;
import project.repository.AnimalFileRepository;
import project.repository.AnimalRepository;
import project.repository.PromotionRepository;
import project.service.PromotionService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PromotionServiceTest {

    @Mock
    PromotionRepository proRepo;
    @Mock
    private AnimalRepository animalRepo;
    @Mock
    private AnimalFileRepository fileRepo;
    @InjectMocks
    private PromotionService service;

    @Test
    public void savePromotionTest() throws IOException {
        Animal animal = new Animal("머핀", 5, "암컷", 3.5, true, "친칠라",
                                    "동네", 2, 1, 2, 1);
        given(animalRepo.findById(anyInt())).willReturn(Optional.of(animal));
        List<MultipartFile> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            File file = new File("src\\main\\java\\project\\image\\" + "file" + i + ".jpg");
            MockMultipartFile mul = new MockMultipartFile("file" + i, new FileInputStream(file));
            list.add(mul);
        }
        PromotionForm form = mock(PromotionForm.class);
        given(form.getImageList()).willReturn(list);
        Promotion pro = new Promotion("제목", 5, "내용", "내용2");
        given(proRepo.save(any())).willReturn(pro);

        Promotion result = service.savePromotion(form);

        verify(animalRepo, times(2)).findById(anyInt());
        Assertions.assertThat(result.getTitle()).isEqualTo("제목");
    }

    @Test
    public void findByNoTest(){
        Promotion pro = new Promotion("제목", 5, "내용", "내용2");
        given(proRepo.findById(10)).willReturn(Optional.of(pro));

        int result = service.findByNo(10).getAnimalNo();
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void findAllSimpleTest(){
        List<Promotion> proList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            proList.add(new Promotion("제목", i, "내용", "내용2"));
        }
        given(proRepo.findAll()).willReturn(proList);
        Animal animal = new Animal("머핀", 5, "암컷", 3.5, true, "친칠라",
                                    "동네", 2, 1, 2, 1);
        given(animalRepo.findById(anyInt())).willReturn(Optional.of(animal));

        List<SimplePromotionDto> result = service.findAllSimple();

        for(SimplePromotionDto dto : result) {
            Assertions.assertThat(dto.getTitle()).isEqualTo("제목");
        }
    }
}
