package com.hb.organizationservice.service.impl;

import com.hb.organizationservice.dto.OrganizationDto;
import com.hb.organizationservice.entity.Organization;
import com.hb.organizationservice.mapper.OrganizationMapper;
import lombok.AllArgsConstructor;
import com.hb.organizationservice.repository.OrganizationRepository;
import com.hb.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
