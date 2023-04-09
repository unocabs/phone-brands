package com.unocabs.phonebrands.repository;

import com.unocabs.phonebrands.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepository extends JpaRepository <PhoneEntity, UUID> {
    PhoneEntity findByPhoneId(UUID phoneId);
}
