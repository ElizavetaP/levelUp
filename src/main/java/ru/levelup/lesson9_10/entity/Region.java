package ru.levelup.lesson9_10.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}
