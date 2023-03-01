package bms.bookmyshow.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;


    @Column(unique = true,nullable = false)
    private String email;

    @NonNull
    @Column(unique = true)
    private String mobNo;

    private String address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets = new ArrayList<>();
}
