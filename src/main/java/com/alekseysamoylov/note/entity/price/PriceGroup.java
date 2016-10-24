package com.alekseysamoylov.note.entity.price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alekseysamoylov on 10/24/16.
 */
@Entity
@Table(name = "price_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "price_group_id")
    private List<Price> prices;

    @Override
    public String toString() {
        return "id " + id
                + " title " + title;
    }
}