package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "promotion")
@NoArgsConstructor
public class Promotion {
    // 입양 홍보 게시글 정보
    public Promotion(String title, int animalNo, String introduction, String condition) {
        this.title = title;
        this.animalNo = animalNo;
        this.introduction = introduction;
        this.condition = condition;
//        this.fileNoList = fileNoList;
        this.createDate = LocalDate.now();
        this.modifyDate = LocalDate.now();
//        this.adoptionFormNoList = new ArrayList<>();
//        this.diaryNoList = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private int animalNo;
    private String introduction;
    private String condition;
//    private List<Integer> adoptionFormNoList;
//    private List<Integer> diaryNoList;
//    private List<Integer> fileNoList;
    private LocalDate createDate;
    private LocalDate modifyDate;
}
