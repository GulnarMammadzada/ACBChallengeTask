package az.acb.crud.challenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {
    private Long id;

    private String name;

    private String code;

    private Double population;
    private double area;

}
