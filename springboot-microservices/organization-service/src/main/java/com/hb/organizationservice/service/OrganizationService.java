package com.hb.organizationservice.service;

import com.hb.organizationservice.dto.OrganizationDTO;

public interface OrganizationService {
    OrganizationDTO saveOrganization(OrganizationDTO organizationDto);

    OrganizationDTO getOrganizationByCode(String organizationCode);
}
