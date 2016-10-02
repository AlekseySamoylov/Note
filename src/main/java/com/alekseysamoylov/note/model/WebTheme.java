package com.alekseysamoylov.note.model;

import lombok.Getter;

/**
 * Created by alekseysamoylov on 10/2/16.
 */
@Getter
public class WebTheme {
    private long themeMask;
    private String name;

    private WebTheme(long themeMask, String name) {
        this.themeMask = themeMask;
        this.name = name;
    }

    public static final WebTheme MAIN_THEME = new WebTheme(1 << 0, "Главная тема");
    public static final WebTheme TEST = new WebTheme(1 << 1, "Главная тема");

}
