package com.unocabs.phonebrands.service;

import com.unocabs.phonebrands.DTO.PhoneDTO;
import com.unocabs.phonebrands.entity.PhoneEntity;
import com.unocabs.phonebrands.model.PhoneModel;
import com.unocabs.phonebrands.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public List<PhoneDTO> getAllPhone() {
        List<PhoneEntity> phoneEntities = phoneRepository.findAll();
        List<PhoneDTO> phoneDTOList = new ArrayList<>();

        phoneEntities.forEach(phoneEntity -> phoneDTOList.add(PhoneDTO.builder()
                        .phoneName(phoneEntity.getPhoneName())
                        .brandName(phoneEntity.getBrandName())
                        .price(phoneEntity.getPrice())
                .build()));


        return phoneDTOList;
    }


    public List<PhoneDTO> postPhone (PhoneModel phoneModel) {
        phoneRepository.save(PhoneEntity.builder()
                        .phoneId(UUID.randomUUID())
                        .phoneName(phoneModel.getPhoneName())
                        .brandName(phoneModel.getBrandName())
                        .price(phoneModel.getPrice())
                .build());
        return getAllPhone();
    }
}
