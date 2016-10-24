package com.alekseysamoylov.note.entity.price;

import lombok.*;

import javax.persistence.*;

/**
 * Created by alekseysamoylov on 10/24/16.
 */
@Entity
@Table(name = "price")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String value;

    @Column
    private String details;
//
//    @ManyToOne
//    @JoinColumn(name = "price_group_id")
//    private PriceGroup priceGroup;

}