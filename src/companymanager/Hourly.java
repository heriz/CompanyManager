/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companymanager;

/**
 * Hourly class extends Employee and adds fields for number of hours and rate
 *
 * @author Henry Rizzi
 */
public class Hourly extends Employee {

    public Hourly(String aName, Double nHours, Double aRate) {
        super(aName, aRate * nHours);
        this.hours = nHours;
        this.hourlyRate = aRate;
    }

    /**
     * Set the number of hours worked for an Hourly
     *
     * @param nHours the number of hours to set
     */
    public void setHours(Double nHours) {
        this.hours = nHours;
    }

    /**
     * Set the hourly rate of the provided Hourly
     *
     * @param aRate the rate to set to
     */
    public void setHourlyRate(Double aRate) {
        this.hourlyRate = aRate;
    }

    /**
     * Return the salary of this Hourly
     *
     * @return Double representing salary
     */
    public Double getSalary() {
        return this.hours * this.hourlyRate;
    }

    /**
     * Return information about the object as a String to be printed
     *
     * @return String information about the passed Hourly
     */
    public String toString() {
        return super.toString()
                + "\n Hours:           " + hours
                + "\n Hourly Rate:     " + hourlyRate + "\n";
    }

    private Double hours;
    private Double hourlyRate;

}
