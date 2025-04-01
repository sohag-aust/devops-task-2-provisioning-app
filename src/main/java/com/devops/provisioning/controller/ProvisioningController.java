package com.devops.provisioning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvisioningController {

    @Value("${vm.name}")
    private String vmName;

    @GetMapping("/")
    public String getVmName() {
        return "Hello from :: " + vmName;
    }
}
