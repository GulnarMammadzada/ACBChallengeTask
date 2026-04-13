package az.acb.crud.challenge.controller;

import az.acb.crud.challenge.model.dto.RegionRequest;
import az.acb.crud.challenge.model.dto.RegionResponse;
import az.acb.crud.challenge.model.entity.Region;
import az.acb.crud.challenge.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping
    public RegionResponse createRegion(@Valid @RequestBody RegionRequest regionRequest) {
        return regionService.createRegion(regionRequest);
    }

    @GetMapping
    public List<RegionResponse> getRegions() {
        return regionService.getAllRegions();
    }
    @GetMapping("/{id}")
    public RegionResponse getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRegionById(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
    @PutMapping("/{id}")
    public RegionResponse updateRegion(@PathVariable Long id, @Valid @RequestBody RegionRequest regionRequest) {
        return regionService.updateRegion(id, regionRequest);
    }
}
