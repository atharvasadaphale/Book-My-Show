package bms.bookmyshow.Entities;


import bms.bookmyshow.Enums.Genre;
import bms.bookmyshow.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String movieName;

    private double ratings;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //this is parent wrt to shows
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showEntityList = new ArrayList<>();
}
