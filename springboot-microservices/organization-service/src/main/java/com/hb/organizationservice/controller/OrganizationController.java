package com.hb.organizationservice.controller;

import com.hb.organizationservice.dto.OrganizationDTO;
import com.hb.organizationservice.service.OrganizationService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    // API to Save Organization
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO){
        OrganizationDTO savedOrganization = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // API to get Organization Details
    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDTO> findOrganization(@PathVariable("organization-code") String organizationCode){
        OrganizationDTO organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }

}
