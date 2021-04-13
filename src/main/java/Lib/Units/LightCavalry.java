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
public class LightCavalry extends Unit {

    public LightCavalry(String teamName) {
        super(teamName);
        name = "Light Cavalry";
        type = UnitType.HORSE;
        currentHitPoints = 50;
        maxHitPoints = 50;
        attackDamage = 10;
        pierceDamage = 0;
        armour = 3;
        speed = 3;
    }
}
