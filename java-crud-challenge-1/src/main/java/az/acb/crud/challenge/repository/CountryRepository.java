package az.acb.crud.challenge.repository;

import az.acb.crud.challenge.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    @Query("SELECT c FROM Country c LEFT JOIN FETCH c.regions")
    List<Country> findAllWithRegions();
}
