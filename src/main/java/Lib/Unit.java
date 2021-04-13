/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

/**
 *
 * @author johnk
 */
public class Unit {

    protected String name;
    protected UnitType type;
    protected int currentHitPoints;
    protected int maxHitPoints;
    protected int attackDamage;
    protected int pierceDamage;
    protected int armour;
    protected String teamName;
    protected int speed;

    public Unit(String team) {
        teamName = team;
    }

    public String getTeam() {
        return teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int hitPoints) {

        this.currentHitPoints = hitPoints;
        if (this.currentHitPoints < 0) {
            this.currentHitPoints = 0;
        }
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getPierceDamage() {
        return pierceDamage;
    }

    public void setPierceDamage(int pierceDamage) {
        this.pierceDamage = pierceDamage;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Unit attack(Unit defender) {
        int totalDamageAmount = calculateDamageAmount(defender);

        defender.applyDamage(totalDamageAmount);

        return defender;
    }

    private int calculateDamageAmount(Unit defender) {
        double attackBonusPercentage = calculateAttackBonusPercentage(defender);

        int armourAmount = defender.getArmour() - this.pierceDamage;
        if (armourAmount < 0) {
            armourAmount = 0;
        }
        double totalAttack = (attackBonusPercentage * this.attackDamage) - armourAmount;

        // always do at least 1 damage
        if (totalAttack <= 1) {
            totalAttack = 1;
        }
        return (int) totalAttack;
    }

    private double calculateAttackBonusPercentage(Unit defender) {
        double bonus = 1;
        // HORSE good vs ARCHER and SWORD
        if (type == UnitType.HORSE && (defender.getType() == UnitType.ARCHER || defender.getType() == UnitType.SWORD)) {
            bonus += 2;
        }

        // SPEAR good vs HORSE
        if (type == UnitType.SPEAR && (defender.getType() == UnitType.HORSE)) {
            bonus += 1;
        }
        // SKIRMISHER good vs ARCHER
        if (type == UnitType.SKIRMISHER && (defender.getType() == UnitType.ARCHER)) {
            bonus += 1.6;
        }

        // SWORD good vs SKIRMISHER and ARCHER
        if (type == UnitType.SWORD && (defender.getType() == UnitType.SKIRMISHER || defender.getType() == UnitType.ARCHER)) {
            bonus += 1;
        }

        return bonus;
    }

    public void applyDamage(int damageAmount) {
        setCurrentHitPoints(currentHitPoints -= damageAmount);
    }

    public void printHP() {
        System.out.println("HP: " + currentHitPoints + "/" + maxHitPoints);
    }

    public void printBasicUnitInfo() {
        System.out.println(teamName + " - " + name + " - HP: " + currentHitPoints + "/" + maxHitPoints);
    }

    @Override
    public String toString() {
        return "Unit{" + "name=" + name + ", type=" + type + ", currentHitPoints=" + currentHitPoints + ", maxHitPoints=" + maxHitPoints + ", attackDamage=" + attackDamage + ", pierceDamage=" + pierceDamage + ", armour=" + armour + '}';
    }
}
