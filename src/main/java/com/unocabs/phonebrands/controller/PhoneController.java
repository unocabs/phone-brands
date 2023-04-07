package com.unocabs.phonebrands.controller;

import com.unocabs.phonebrands.DTO.PhoneDTO;
import com.unocabs.phonebrands.model.PhoneModel;
import com.unocabs.phonebrands.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    public List<PhoneDTO> getAllPhone() {
        return phoneService.getAllPhone();
    }

    @PostMapping
    public List<PhoneDTO> postPhone(@RequestBody PhoneModel phoneModel) {
        return phoneService.postPhone(phoneModel);
    }
}
