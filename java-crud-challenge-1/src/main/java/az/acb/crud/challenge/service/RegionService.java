package az.acb.crud.challenge.service;


import az.acb.crud.challenge.exception.RegionNotFoundException;
import az.acb.crud.challenge.mapper.RegionMapper;
import az.acb.crud.challenge.model.dto.RegionRequest;
import az.acb.crud.challenge.model.dto.RegionResponse;
import az.acb.crud.challenge.model.entity.Country;
import az.acb.crud.challenge.model.entity.Region;
import az.acb.crud.challenge.repository.CountryRepository;
import az.acb.crud.challenge.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    private final CountryRepository countryRepository;

    public RegionService(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    public RegionResponse createRegion(RegionRequest regionRequest) {
        if(regionRepository.existsByName(regionRequest.getName())) {
            throw new RuntimeException("Region already exists");
        }
        Region region = RegionMapper.toEntity(regionRequest);
        Region savedRegion=regionRepository.save(region);
        return RegionMapper.toResponse(savedRegion);

    }

    public RegionResponse updateRegion(Long id,RegionRequest regionRequest) {
        Region region=regionRepository.findById(id).orElseThrow(()->new RegionNotFoundException("Region with id"+id+" not found"));
        region.setName(regionRequest.getName());
        Region savedRegion=regionRepository.save(region);
        return RegionMapper.toResponse(savedRegion);
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

    public List<RegionResponse> getAllRegions() {
        return regionRepository.findAll()
                .stream()
                .map(RegionMapper::toResponse)
                .toList();
    }
    public RegionResponse getRegionById(Long id) {
        Region region=regionRepository.findById(id).orElseThrow(()->new RegionNotFoundException("Region with id"+id+" not found"));
        return RegionMapper.toResponse(region);
    }
}
