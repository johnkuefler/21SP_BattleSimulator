/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Lib.Unit;
import java.util.Scanner;

/**
 *
 * @author johnk
 */
public class CombatSimulator {

    private boolean debug;

    private Unit unit1;
    private Unit unit2;

    public Unit getUnit1() {
        return unit1;
    }

    public Unit getUnit2() {
        return unit2;
    }

    public boolean combatOver() {
        return unit1.getCurrentHitPoints() == 0 || unit2.getCurrentHitPoints() == 0;
    }

    public CombatSimulator(Unit u1, Unit u2, boolean debug) {
        unit1 = u1;
        unit2 = u2;
        this.debug = debug;
    }

    public void Fight() 
    {
        // faster unit attacks first
        if (unit1.getSpeed() > unit2.getSpeed()) {
            if (debug) {
                System.out.println(unit1.getTeam() + " " + unit1.getName() + " attacks " + unit2.getTeam() + " " + unit2.getName());
            }
        } else {
            if (debug) {
                System.out.println(unit2.getTeam() + " " + unit2.getName() + " attacks " + unit1.getTeam() + " " + unit1.getName());
            }
        }

        if (unit1.getSpeed() > unit2.getSpeed()) {
            unit2 = unit1.attack(unit2);
            if (unit2.getCurrentHitPoints() == 0) {
                return;
            }

            unit1 = unit2.attack(unit1);
            if (unit1.getCurrentHitPoints() == 0) {
                return;
            }
        } else {
            unit1 = unit2.attack(unit1);
            if (unit1.getCurrentHitPoints() == 0) {
                return;
            }

            unit2 = unit1.attack(unit2);
            if (unit2.getCurrentHitPoints() == 0) {
                return;
            }
        }

        // allows player to hit enter or some key on the keyboard before next fight is shown
        if (debug) {
            unit1.printBasicUnitInfo();
            unit2.printBasicUnitInfo();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Press enter to continue...");
            keyboard.nextLine();
        }
    }
}
