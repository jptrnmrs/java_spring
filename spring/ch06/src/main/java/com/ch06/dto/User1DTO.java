package com.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;


}
