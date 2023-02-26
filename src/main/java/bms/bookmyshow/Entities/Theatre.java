package bms.bookmyshow.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Theatres")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;


    //This is the parent wrt to theaterSeats
    //one theatre has many seats
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<TheatreSeat> theaterSeatEntityList = new ArrayList<>();

    //one theatre has many shows
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<Show> showEntityList;
}
