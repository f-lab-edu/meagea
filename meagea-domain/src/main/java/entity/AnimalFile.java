package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "animal_file")
@NoArgsConstructor
public class AnimalFile {

    public AnimalFile(int promotionNo, String uploadFileName, String serverFileName, String property) {
        this.promotionNo = promotionNo;
        this.uploadFileName = uploadFileName;
        this.serverFileName = serverFileName;
        this.property = property;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int promotionNo;
    private int diaryLogNo;
    private String uploadFileName;
    private String serverFileName;
    private String property;
}
