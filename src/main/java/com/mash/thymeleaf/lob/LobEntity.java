package com.mash.thymeleaf.lob;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] bytes;
}



