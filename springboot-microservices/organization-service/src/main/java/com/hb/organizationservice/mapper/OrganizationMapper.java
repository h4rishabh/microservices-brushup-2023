package com.hb.organizationservice.mapper;

import com.hb.organizationservice.dto.OrganizationDTO;
import com.hb.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDTO mapToOrganizationDto(Organization organization){
        OrganizationDTO organizationDto = new OrganizationDTO(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
        return organizationDto;
    }

    public static Organization mapToOrganization(OrganizationDTO organizationDto){
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()
        );
        return organization;
    }
}
