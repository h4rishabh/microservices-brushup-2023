package com.hb.organizationservice.controller;

import com.hb.organizationservice.dto.OrganizationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.hb.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Rest APIs for Organization Service",
        description = "Get Organization, Create Organization"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    // Build Save Organization REST API


    @Operation(
            summary = "Create Organization Rest API",
            description = "Used to create new Organization in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDto){
        OrganizationDTO savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // Get Organization by Code REST API

    @Operation(
            summary = "Create Organization Rest API",
            description = "Used to create new Organization in Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDTO organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}
