package com.sber.dz7;

import java.io.Serializable;
import java.util.Objects;

public class Hero implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int lvl;
    private Weapon weapon;
    private Armor armor;

    public Hero() {}

    public Hero(String name, int lvl, Weapon weapon, Armor armor) {
        this.name = name;
        this.lvl = lvl;
        this.weapon = weapon;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Hero{name='" + name + "', lvl=" + lvl +
                ", weapon=" + weapon + ", armor=" + armor + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return lvl == hero.lvl && Objects.equals(name, hero.name)
                && Objects.equals(weapon, hero.weapon) && Objects.equals(armor, hero.armor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lvl, weapon, armor);
    }
}
