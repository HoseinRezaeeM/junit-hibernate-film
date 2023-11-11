package entity;



import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

//@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    private String directory;
    private String description;
    private BigInteger length;
    private String language;
    private Integer rating;

    public Film(String title, BigInteger length) {
        this.title = title;
        this.length = length;
    }
}
