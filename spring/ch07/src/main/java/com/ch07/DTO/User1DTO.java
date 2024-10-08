package com.ch07.DTO;

import com.ch07.entity.User1;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    // 엔티티 변환 메서드
    public User1 toEntity(){
        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }

}
