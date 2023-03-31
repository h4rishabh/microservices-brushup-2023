package com.hb.organizationservice.mapper;

import com.hb.organizationservice.dto.OrganizationDTO;
import com.hb.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static Organization mapToOrganization(OrganizationDTO organizationDTO){
        Organization organization = new Organization();
        organization.setOrganizationCode(organizationDTO.getOrganizationCode());
        organization.setOrganizationDescription(organizationDTO.getOrganizationDescription());
        organization.setOrganizationName(organizationDTO.getOrganizationName());

        return organization;
    }

    public static OrganizationDTO mapToOrganizationDTO(Organization organization){
        OrganizationDTO organizationDto = new OrganizationDTO();
        organizationDto.setOrganizationCode(organization.getOrganizationCode());
        organizationDto.setOrganizationDescription(organization.getOrganizationDescription());
        organizationDto.setOrganizationName(organization.getOrganizationName());

        return organizationDto;
    }
}
