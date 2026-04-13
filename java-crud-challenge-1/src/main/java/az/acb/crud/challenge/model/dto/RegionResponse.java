package az.acb.crud.challenge.model.dto;

import az.acb.crud.challenge.model.entity.Country;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionResponse {

    private Long id;
    private String name;

    private String description;
    private Country countryId;

}
