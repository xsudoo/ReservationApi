package com.example.ReservationApi.Organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")

public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<Organization> getAll(){
        return organizationService.getAll();
    }
    @PostMapping
    public Organization addOrganization (@Valid @RequestBody Organization organization){
        return organizationService.addOrganization(organization);
    }

    @PutMapping
    public Organization updateOrganization(@RequestBody Organization organization){
        return organizationService.updateOrganization(organization);
    }
    @DeleteMapping
    public void deleteOrganization(@RequestParam Long id){
        organizationService.deleteOrganization(id);
    }
}
