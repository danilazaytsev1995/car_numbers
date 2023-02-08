package DanilaZaytsev.car_numbers.models;

import javax.persistence.*;

@Entity
@Table(name = "car_number")
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "car_number")
    private String car_number;

    public Number(Long id, String number) {
        this.id = id;
        this.car_number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }
}
