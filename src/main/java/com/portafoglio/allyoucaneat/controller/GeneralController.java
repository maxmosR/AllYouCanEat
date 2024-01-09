package com.portafoglio.allyoucaneat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/logininfo")
public class GeneralController {

    @GetMapping("/string")
    String stringaConsol(){
        return "maxitos";
    }
//    @GetMapping("googlelogin")
//    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
//        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
//    }
}
