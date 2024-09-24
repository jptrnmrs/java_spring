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
@Table(name = "child")
public class Child {

    @Id
    private String cid;

    @Column(name = "name")
    private String name;


    @Column(name = "hp")
    private String hp;

    @Column(name = "parent")
    private String parent;


}
