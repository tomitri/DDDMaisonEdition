package com.ddd.domain;



public class Skill {

    private final String nameSkill;
    private final String xp;

    private Skill(String nameSkill, String xp) {
        this.nameSkill = nameSkill;
        this.xp = xp;
    }

    public static Skill of(String nameSkill, String xp) {
        return new Skill(nameSkill, xp);
    }

}
