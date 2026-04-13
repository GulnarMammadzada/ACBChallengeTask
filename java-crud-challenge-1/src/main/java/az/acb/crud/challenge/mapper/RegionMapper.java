package az.acb.crud.challenge.mapper;

import az.acb.crud.challenge.model.dto.RegionRequest;
import az.acb.crud.challenge.model.dto.RegionResponse;
import az.acb.crud.challenge.model.entity.Region;

public class RegionMapper {

    public static RegionResponse toResponse(Region region) {
        return new RegionResponse(
                region.getId(),
                region.getName(),
                region.getDescription(),
                region.getCountry_id()
        );
    }

    public static Region toEntity(RegionRequest regionRequest) {
        Region region = new Region();
        region.setName(regionRequest.getName());
        region.setDescription(regionRequest.getDescription());
        region.setCountry_id(regionRequest.getCountryId());
        return region;
    }

}
