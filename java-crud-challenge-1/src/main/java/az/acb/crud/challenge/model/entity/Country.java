package az.acb.crud.challenge.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String code;

    private Double population;

    private double area;

    @OneToMany(mappedBy = "country",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Region> regions;


}
