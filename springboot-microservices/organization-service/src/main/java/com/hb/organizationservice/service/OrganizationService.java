package com.hb.organizationservice.service;

import com.hb.organizationservice.dto.OrganizationDTO;

public interface OrganizationService {
    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO getOrganizationByCode(String organizationCode);
}
