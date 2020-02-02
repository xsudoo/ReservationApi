package com.example.ReservationApi.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrganizationService {


    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    Organization addOrganization(Organization organization){

        if(organizationRepository.findByName(organization.getName())== null){
            return organizationRepository.save(organization);
        }else throw new IllegalArgumentException("Jest juz taka firma");

    }

    List<Organization> getAll(){
        return organizationRepository.findAll();
    }

    Organization updateOrganization(Organization organization){
        Organization organizationToUpdate = organizationRepository.findById(organization.getId()).orElseThrow(()->new NoSuchElementException("Niema takiej firmy"));
        organizationToUpdate.setName(organization.getName());
        return organizationRepository.save(organizationToUpdate);
    }

    void deleteOrganization (Long id){
        Organization organizationToDelete = organizationRepository.findById(id).orElseThrow(()->new NoSuchElementException("Niema takiej firmy"));
        organizationRepository.delete(organizationToDelete);

    }


}
