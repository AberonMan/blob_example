package com.mash.thymeleaf.lob;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.mash.thymeleaf.lob.ImageUtil.loadImage;

@SpringBootApplication
@RequiredArgsConstructor
public class LobExampleApplication implements CommandLineRunner {

    private final LobRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(LobExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LobEntity lobEntity = new LobEntity();
        byte[] bytes = loadImage();
        lobEntity.setBytes(bytes);
        repository.save(lobEntity);
    }


}

