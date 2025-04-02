package com.devops.provisioning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProvisioningController {

    @Value("${vm.name}")
    private String vmName;

    @Value("${commit.hash}")
    private String commitHash;

    @GetMapping("/")
    public String getVmName() {
        log.info("Response generated from :: {}", vmName);
        return "Hello from :: " + vmName + " || the app deployed with commit hash :: " + commitHash;
    }
}
