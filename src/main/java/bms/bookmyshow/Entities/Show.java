package bms.bookmyshow.Entities;

import bms.bookmyshow.Enums.ShowType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Shows")
@Data
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalDate showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    //This is child wrt to the movieEntity
    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    //Show is parent wrt to ticket
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<Ticket> listOfBookedTickets = new ArrayList<>();

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeat> listOfShowSeats = new ArrayList<>();
}
