package com.alekseysamoylov.note.entity.text;

import com.alekseysamoylov.note.entity.security.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by alekseysamoylov on 8/20/16.
 */
@Getter
@Setter
@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TEXT_BODY")
    private String text;
}
