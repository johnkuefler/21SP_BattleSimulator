/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib.Units;

import Lib.Unit;
import Lib.UnitType;

/**
 *
 * @author johnk
 */
public class Swordsman extends Unit {

    public Swordsman(String teamName) {
        super(teamName);
        name = "Swordsman";
        type = UnitType.SWORD;
        currentHitPoints = 30;
        maxHitPoints = 30;
        attackDamage = 5;
        pierceDamage = 0;
        armour = 2;
        speed = 2;
    }
}
