package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Weapon implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int damage;

    public Weapon() {}

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    @Override
    public String toString() {
        return name + damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon weapon)) return false;
        return damage == weapon.damage && Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damage);
    }
}
