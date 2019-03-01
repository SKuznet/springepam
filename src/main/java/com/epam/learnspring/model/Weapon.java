package com.epam.learnspring.model;

import org.springframework.stereotype.Service;

@Service
public class Weapon {
    private String weaponName;

    public Weapon() {
    }

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

}