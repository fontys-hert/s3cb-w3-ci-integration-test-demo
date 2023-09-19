package nl.timo.semester3week2demo.weapon;

public class Weapon {
    private String name;
    private Integer ammo;

    public Weapon(String name, Integer ammo) {
        this.name = name;
        this.ammo = ammo;
    }

    public String getName() {
        return name;
    }

    public Integer getAmmo() {
        return ammo;
    }
}
