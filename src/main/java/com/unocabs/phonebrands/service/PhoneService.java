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
                        .phoneId(phoneEntity.getPhoneId())
                        .phoneName(phoneEntity.getPhoneName())
                        .brandName(phoneEntity.getBrandName())
                        .price(phoneEntity.getPrice())
                .build()));

        return phoneDTOList;
    }


    public PhoneDTO getByPhoneId(UUID phoneId) {
        PhoneEntity phoneEntity = phoneRepository.findByPhoneId(phoneId);
        PhoneDTO phoneDTOById = PhoneDTO.builder()
                .phoneId(phoneEntity.getPhoneId())
                .phoneName(phoneEntity.getPhoneName())
                .brandName(phoneEntity.getBrandName())
                .price(phoneEntity.getPrice())
                .build();

        return phoneDTOById;
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

    public PhoneDTO updatePhone(UUID phoneId, PhoneModel updatedModel) {
        PhoneEntity oldPhoneEntity = phoneRepository.findByPhoneId(phoneId);

        PhoneEntity newPhoneEntity = PhoneEntity.builder()
                .phoneId(phoneId)
                .phoneName(updatedModel.getPhoneName().isBlank() ?  oldPhoneEntity.getPhoneName() : updatedModel.getPhoneName())
                .brandName(updatedModel.getBrandName().isBlank() ?  oldPhoneEntity.getBrandName() : updatedModel.getBrandName())
                .price(updatedModel.getPrice() == 0 ?  oldPhoneEntity.getPrice() : updatedModel.getPrice())
                .build();

        return PhoneDTO.builder()
                .phoneName(newPhoneEntity.getPhoneName())
                .brandName(newPhoneEntity.getBrandName())
                .price(newPhoneEntity.getPrice())
                .build();
    }

    public List<PhoneDTO> deleteByPhoneId(UUID phoneId) {
        PhoneEntity phoneEntity = phoneRepository.findByPhoneId(phoneId);

        if (phoneEntity != null) {
            phoneRepository.delete(phoneEntity);
        }

        assert phoneEntity != null;
        PhoneDTO phoneDTOById = PhoneDTO.builder()
                .phoneId(phoneEntity.getPhoneId())
                .phoneName(phoneEntity.getPhoneName())
                .brandName(phoneEntity.getBrandName())
                .price(phoneEntity.getPrice())
                .build();

        return getAllPhone();
    }
}
