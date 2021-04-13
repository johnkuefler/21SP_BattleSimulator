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
public class Archer extends Unit {

    public Archer(String teamName) {
        super(teamName);
        name = "Archer";
        type = UnitType.ARCHER;
        currentHitPoints = 25;
        maxHitPoints = 25;
        attackDamage = 7;
        pierceDamage = 2;
        armour = 0;
        speed = 4;
    }
}
