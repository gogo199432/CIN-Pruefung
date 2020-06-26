package at.technikumwien.pruefung;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "t_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String brand;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private LocalDate buildYear;

    @JsonIgnore
    public String getName(){
        if(brand == null || brand.isBlank()){
            throw new IllegalArgumentException("Firstname is null or empty");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("LastName is null or empty");
        }
        return brand + " "+ name;
    }
}
