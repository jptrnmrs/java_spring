package com.ch07.entity;

import com.ch07.DTO.User1DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user1")
public class User1 {

    @Id
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "hp")
    private String hp;

    @Column(name = "age")
    private int age;

    // DTO 변환 메서드
    public User1DTO toDTO() {
        return User1DTO.builder()
                .uid(this.uid)
                .name(this.name)
                .birth(this.birth)
                .hp(this.hp)
                .age(this.age)
                .build();
    }

}
