package com.alekseysamoylov.note.entity.direction;

import com.alekseysamoylov.note.entity.text.Message;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * Created by asamoilov on 02.09.2016.
 */
@Getter
@Setter
@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    private TagGroup tagGroup;

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            name = "MESSAGE_TAG",
            joinColumns = @JoinColumn(name = "TAG_ID"),
            inverseJoinColumns = @JoinColumn(name = "MESSAGE_ID"))
    private List<Message> messages;
}
