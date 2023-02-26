package bms.bookmyshow.Entities;


import bms.bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name="Show_Seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;

    private int price; //price of CLASSIC Seat for that particualr

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Date bookedAt;


    //many seats for a show
    @ManyToOne
    @JoinColumn
    private Show show;
}
