package com.sber.dz7;

import java.io.Serializable;
import java.util.Objects;

public class Armor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int defense;

    public Armor() {}

    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Armor{name='" + name + "', defense=" + defense + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor armor)) return false;
        return defense == armor.defense && Objects.equals(name, armor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, defense);
    }
}
