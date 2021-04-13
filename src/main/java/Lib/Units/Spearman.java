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
public class Spearman extends Unit {

    public Spearman(String teamName) {
        super(teamName);

        name = "Spearman";
        type = UnitType.SPEAR;
        currentHitPoints = 30;
        maxHitPoints = 30;
        attackDamage = 6;
        pierceDamage = 1;
        armour = 2;
        speed = 2;
    }
}
