package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Log {

    public Log(int promotionNo, String body) {
        this.no = (int)(Math.random()*10000);
        this.promotionNo = promotionNo;
        this.body = body;
        this.makeDate = LocalDate.now();
        this.modifyDate = LocalDate.now();
    }

    @Id
    private int no;
    private int promotionNo;
    private String body;
    private LocalDate makeDate;
    private LocalDate modifyDate;
}
