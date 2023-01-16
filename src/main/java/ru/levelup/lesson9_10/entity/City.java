package ru.levelup.lesson9_10.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private Integer id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "population")
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;

    public String toString() {
        return "City(id=" + this.getId() + ", nameRu=" + this.getNameRu() + ", nameEn=" + this.getNameEn() +
                ", population=" + this.getPopulation() + ", region=" + this.getRegion() + ")";
    }
}
