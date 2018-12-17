package com.mash.thymeleaf.lob;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;

import static com.mash.thymeleaf.lob.ImageUtil.loadImage;

@Controller
@RequiredArgsConstructor
public class LobController {

    private final LobRepository repository;

    @RequestMapping("/finn")
    public String  getFinn(Model model) {
        repository.findAll()
                .stream()
                .findFirst()
                .map(LobEntity::getBytes)
                .map(Base64.getEncoder()::encodeToString)
                .ifPresent(
                        bytes -> model.addAttribute("image", bytes));
        return "lob";
    }

    @GetMapping("/create/finn")
    public @ResponseBody String createFinn() {
        LobEntity lobEntity = new LobEntity();
        byte[] bytes = loadImage();
        lobEntity.setBytes(bytes);
        repository.save(lobEntity);
        return "Finn created";
    }


}
