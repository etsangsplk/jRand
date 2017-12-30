package me.xdrop.jrand.generators.person;

import me.xdrop.jrand.Generator;
import me.xdrop.jrand.annotation.Facade;

@Facade(accessor = "gender")
public class GenderGenerator extends Generator<String> {

    private String male;
    private String female;

    public GenderGenerator() {
    }

    GenderGenerator format(String male, String female) {
        this.male = male;
        this.female = female;
        return this;
    }

    @Override
    public String gen() {
        if (random().randBool()) {
           return male != null ? male : "M";
        } else {
            return female != null ? female : "F";
        }
    }
}