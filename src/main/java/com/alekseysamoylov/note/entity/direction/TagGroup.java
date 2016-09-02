package com.alekseysamoylov.note.entity.direction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by asamoilov on 02.09.2016.
 */
@Getter
@Setter
@Entity
@Table(name = "TAG_GROUP")
public class TagGroup {

    @Id
    private Long id;

    private List<Tag> tags;


}
