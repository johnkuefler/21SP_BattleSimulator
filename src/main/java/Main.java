import Engine.CombatSimulator;
import Lib.Unit;
import Lib.UnitType;
import Lib.Units.Archer;
import Lib.Units.LightCavalry;
import Lib.Units.Skirmisher;
import Lib.Units.Spearman;
import Lib.Units.Swordsman;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johnk
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Unit> playerArmy = new ArrayList<Unit>();
        ArrayList<Unit> computerArmy = new ArrayList<Unit>();

        addXUnitsToTeam(playerArmy, 50, new Archer("Player"));
        addXUnitsToTeam(playerArmy, 50, new Swordsman("Player"));
        addXUnitsToTeam(playerArmy, 50, new LightCavalry("Player"));
        addXUnitsToTeam(playerArmy, 50, new Spearman("Player"));
        addXUnitsToTeam(playerArmy, 50, new Skirmisher("Player"));

        addXUnitsToTeam(computerArmy, 50, new Archer("Computer"));
        addXUnitsToTeam(computerArmy, 50, new Swordsman("Computer"));
        addXUnitsToTeam(computerArmy, 50, new LightCavalry("Computer"));
        addXUnitsToTeam(computerArmy, 50, new Spearman("Computer"));
        addXUnitsToTeam(computerArmy, 50, new Skirmisher("Computer"));

        // print beginning numbers
        System.out.println("Player Army:");
        printArmyInfo(playerArmy);
        System.out.println("Computer Army:");
        printArmyInfo(computerArmy);

        // randomize armies
        Collections.shuffle(playerArmy);
        Collections.shuffle(computerArmy);

        // make armies fight each other until one is empty
        while (playerArmy.size() > 0 && computerArmy.size() > 0) {

            Unit unit1 = playerArmy.get(0);
            Unit unit2 = computerArmy.get(0);

            CombatSimulator simulator = new CombatSimulator(unit1, unit2, false);
            while (!simulator.combatOver()) {
                simulator.Fight();
            }

            // remove the unit that died from that players army
            if (simulator.getUnit1().getCurrentHitPoints() <= 0) {
                playerArmy.remove(0);
            }
            if (simulator.getUnit2().getCurrentHitPoints() <= 0) {
                computerArmy.remove(0);
            }

            // randomize armies after every fight
            Collections.shuffle(playerArmy);
            Collections.shuffle(computerArmy);
        }

        // report ending numbers
        System.out.println("Player Army:");
        printArmyInfo(playerArmy);
        System.out.println("Computer Army:");
        printArmyInfo(computerArmy);
    }

    public static void addXUnitsToTeam(ArrayList<Unit> army, int numToAdd, Unit unit) {
        for (int i = 1; i <= numToAdd; i++) {
            army.add(unit);
        }
    }

    public static void printArmyInfo(ArrayList<Unit> army) {
        int archerCount = 0;
        int swordsmanCount = 0;
        int cavalryCount = 0;
        int skirmisherCount = 0;
        int spearmanCount = 0;

        for (Unit unit : army) {
            if (unit.getType() == UnitType.ARCHER) {
                archerCount++;
            }
            if (unit.getType() == UnitType.SWORD) {
                swordsmanCount++;
            }
            if (unit.getType() == UnitType.HORSE) {
                cavalryCount++;
            }
            if (unit.getType() == UnitType.SPEAR) {
                spearmanCount++;
            }
            if (unit.getType() == UnitType.SKIRMISHER) {
                skirmisherCount++;
            }
        }

        System.out.println("-----------------------");
        System.out.println("Archers: " + archerCount);
        System.out.println("Swordsman: " + swordsmanCount);
        System.out.println("Cavalry: " + cavalryCount);
        System.out.println("Spearman: " + spearmanCount);
        System.out.println("Skirmishers: " + skirmisherCount);
        System.out.println("-----------------------");

    }
}
