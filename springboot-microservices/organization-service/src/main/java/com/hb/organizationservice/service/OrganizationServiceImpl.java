package com.hb.organizationservice.service;

import com.hb.organizationservice.dto.OrganizationDTO;
import com.hb.organizationservice.mapper.OrganizationMapper;
import com.hb.organizationservice.entity.Organization;
import com.hb.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements  OrganizationService{

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDTO);
        Organization savedOrg = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDTO(savedOrg);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDTO organizationDTO = OrganizationMapper.mapToOrganizationDTO(organization);
        return organizationDTO;
    }


}
