package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Promotion {
    public Promotion(Animal animal) {

    }
    public Promotion(){};

    // 입양 홍보 게시글 정보
    private int no;
    private Animal animal;
    private String introduction;
    private String condition;
}
