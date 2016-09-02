package com.alekseysamoylov.note.entity.text;

import com.alekseysamoylov.note.entity.direction.Tag;
import com.alekseysamoylov.note.entity.security.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(mappedBy = "messages")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Tag> tags;
}
