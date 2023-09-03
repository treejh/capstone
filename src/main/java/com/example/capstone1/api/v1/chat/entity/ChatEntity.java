package com.example.capstone1.api.v1.chat.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "MEMBER")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatId;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 10)
    private String name;

    @Min(0)
    @Column(nullable = false)
    private int pay = 0;

    @Column(nullable = false)
    private double temperature = 36.5;

    @Column(nullable = false)
    private String image = "https://server?name=basic_image";

    public ChatEntity(String email, String name, String image) {
        this.email = email;
        this.name = name;
        this.image = image;
    }

}
