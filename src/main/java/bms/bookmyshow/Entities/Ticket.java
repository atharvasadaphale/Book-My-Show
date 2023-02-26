package bms.bookmyshow.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "Tickets")
@Data
@NoArgsConstructor

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private LocalDate showDate;

    private LocalTime showTime;

    private int totalAmount;

    private String ticketId = UUID.randomUUID().toString();

    private String theaterName;


    @JoinColumn
    @ManyToOne
    private User user;


    //Ticket is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private Show show;
}
