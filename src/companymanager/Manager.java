/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companymanager;

/**
 * Manager class extends Employee and adds a field for a bonus
 *
 * @author Henry Rizzi
 */
public class Manager extends Employee {

    /**
     * Constructor for Manager extending Employee with name, salary, and bonus
     *
     * @param aName name of the manager
     * @param aSalary salary of the manager
     * @param aBonus bonus for the manager
     */
    public Manager(String aName, Double aSalary, Double aBonus) {
        super(aName, aSalary);
        this.bonus = aBonus;
    }

    /**
     * Method to set the bonus of the manager
     *
     * @param aBonus the bonus to be set
     */
    public void setBonus(Double aBonus) {
        this.bonus = aBonus;
    }

    /**
     * method to return the salary of an employee
     *
     * @return Double value representing salary and bonus
     */
    public Double getSalary() {
        return super.getSalary() + this.bonus;
    }

    /**
     * return a string with information about Manager
     *
     * @return String contains information about Manager
     */
    public String toString() {
        return super.toString()
                + "\n Bonus:           " + bonus + "\n";
    }

    private Double bonus;

}
