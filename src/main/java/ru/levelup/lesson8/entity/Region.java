package ru.levelup.lesson8.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "REGION")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

}
