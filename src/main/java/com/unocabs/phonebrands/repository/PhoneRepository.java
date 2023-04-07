package com.unocabs.phonebrands.repository;

import com.unocabs.phonebrands.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository <PhoneEntity, Long> {
}
