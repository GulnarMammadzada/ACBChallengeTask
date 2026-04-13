package az.acb.crud.challenge.controller;

import az.acb.crud.challenge.model.dto.CountryRequest;
import az.acb.crud.challenge.model.dto.CountryResponse;
import az.acb.crud.challenge.model.entity.Country;
import az.acb.crud.challenge.service.CountryService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public CountryResponse saveCountry(@Valid @RequestBody CountryRequest countryRequest) {
        return countryService.createCountry(countryRequest);
    }
    @GetMapping
    public List<CountryResponse> getAllCountry() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryResponse getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }
    @PutMapping("/{id}")
    public  CountryResponse updateCountry(@PathVariable Long id, @Valid @RequestBody CountryRequest countryRequest) {
        return countryService.updateCountry(id, countryRequest);
    }
    @GetMapping
    public List<CountryResponse> getAllCountriesWithRegions() {
        return countryService.getAllCountriesWithRegions();
    }
    @DeleteMapping
    public void deleteCountryById(@RequestParam Long id) {
        countryService.deleteCountryById(id);
    }

}
