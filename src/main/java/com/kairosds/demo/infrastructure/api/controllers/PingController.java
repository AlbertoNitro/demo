package com.kairosds.demo.infrastructure.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PingController.PING)
public class PingController {

    public static final String PING = "/ping";

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public void ping() {
        // Empty for framework
    }

}
