package az.acb.crud.challenge.service;

import az.acb.crud.challenge.exception.CountryNotFoundException;
import az.acb.crud.challenge.mapper.CountryMapper;
import az.acb.crud.challenge.model.dto.CountryRequest;
import az.acb.crud.challenge.model.dto.CountryResponse;
import az.acb.crud.challenge.model.entity.Country;
import az.acb.crud.challenge.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country country= CountryMapper.toEntity(countryRequest);
        Country savedCountry = countryRepository.save(country);
        return CountryMapper.toResponse(savedCountry);
    }

    public List<CountryResponse> getAllCountriesWithRegions() {
        return countryRepository.findAllWithRegions()
                .stream()
                .map(CountryMapper::toResponse)
                .toList();
    }

    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(CountryMapper::toResponse)
                .toList();
    }

    public CountryResponse getCountryById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException("Country with id"+ id+" not found"));
        return CountryMapper.toResponse(country);
    }

    public CountryResponse updateCountry(Long id,CountryRequest countryRequest) {
        Country country = countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException("Country with id"+ id+" not found"));
        country.setName(countryRequest.getName());
        country.setCode(countryRequest.getCode());
        Country savedCountry = countryRepository.save(country);
        return CountryMapper.toResponse(savedCountry);
    }

    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }

}
