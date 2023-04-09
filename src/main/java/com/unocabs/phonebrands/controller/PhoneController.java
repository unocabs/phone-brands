package com.unocabs.phonebrands.controller;

import com.unocabs.phonebrands.DTO.PhoneDTO;
import com.unocabs.phonebrands.model.PhoneModel;
import com.unocabs.phonebrands.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    public List<PhoneDTO> getAllPhone() {
        return phoneService.getAllPhone();
    }

    @GetMapping ("/{phoneId}")
    public PhoneDTO getByPhoneId (@PathVariable UUID phoneId) {
        return phoneService.getByPhoneId(phoneId);
    }

    @PostMapping
    public List<PhoneDTO> postPhone(@RequestBody PhoneModel phoneModel) {
        return phoneService.postPhone(phoneModel);
    }

    @DeleteMapping ("/{phoneId}")
    public List<PhoneDTO> deleteByPhoneId (@PathVariable UUID phoneId) {
        return phoneService.deleteByPhoneId(phoneId);
    }

    @PutMapping("/{phoneId}")
    public PhoneDTO updatePhone (@PathVariable UUID phoneId, @RequestBody PhoneModel updatedModel) {
        return phoneService.updatePhone(phoneId, updatedModel);
    }
}
