package az.acb.crud.challenge.repository;

import az.acb.crud.challenge.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
