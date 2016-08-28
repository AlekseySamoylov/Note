package com.alekseysamoylov.note.model;

import com.alekseysamoylov.note.entity.security.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by alekseysamoylov on 8/21/16.
 */
@Getter
@Setter
@ToString
public class WebMessage {
    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String textBody;
}
