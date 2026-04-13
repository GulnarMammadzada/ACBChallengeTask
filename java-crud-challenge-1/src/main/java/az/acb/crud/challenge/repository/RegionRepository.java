package az.acb.crud.challenge.repository;

import az.acb.crud.challenge.model.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {

    boolean existsByName(String name);
}
