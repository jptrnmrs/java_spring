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
@Table(name = "parent")
public class Parent {

    @Id
    private String pid;

    @Column(name = "name")
    private String name;


    @Column(name = "birth")
    private String birth;

    @Column(name = "addr")
    private String addr;



}
