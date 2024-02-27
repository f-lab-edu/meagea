package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class DiaryLog {

    public DiaryLog(int promotionNo, int fileNo, String body) {
        this.promotionNo = promotionNo;
        this.fileNo = fileNo;
        this.body = body;
        this.createDate = LocalDate.now();
        this.modifyDate = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int promotionNo;
    private int fileNo;
    private String body;
    private LocalDate createDate;
    private LocalDate modifyDate;
}