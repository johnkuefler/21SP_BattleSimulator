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
public class Skirmisher extends Unit {

    public Skirmisher(String teamName) {
        super(teamName);

        name = "Skirmisher";
        type = UnitType.SKIRMISHER;
        currentHitPoints = 25;
        maxHitPoints = 25;
        attackDamage = 5;
        pierceDamage = 2;
        armour = 1;
        speed = 5;
    }
}
