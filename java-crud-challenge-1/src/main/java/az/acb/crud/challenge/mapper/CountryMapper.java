package az.acb.crud.challenge.mapper;

import az.acb.crud.challenge.model.dto.CountryRequest;
import az.acb.crud.challenge.model.dto.CountryResponse;
import az.acb.crud.challenge.model.entity.Country;

public class CountryMapper {

    public static CountryResponse toResponse(Country country) {
        return new CountryResponse(
                country.getId(),
                country.getName(),
                country.getCode(),
                country.getPopulation(),
                country.getArea());
    }

    public static Country toEntity(CountryRequest countryRequest){
        Country country = new Country();
        country.setName(countryRequest.getName());
        country.setCode(countryRequest.getCode());
        country.setPopulation(countryRequest.getPopulation());
        country.setArea(countryRequest.getArea());
        return country;
    }

}
