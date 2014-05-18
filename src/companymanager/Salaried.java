/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companymanager;

/**
 * Salaried class extends Employee and adds fields for overtime hours and rate
 *
 * @author Henry Rizzi
 */
public class Salaried extends Employee {

    /**
     * Construct a Salaried employee
     *
     * @param aName the name of the employee
     * @param aSalary the salary of the Salaried Employee
     * @param nOTH the number of overtime hours for employee
     * @param nOTR the rate at which the Salaried gets paid for overtime
     */
    public Salaried(String aName, Double aSalary, Double nOTH, Double nOTR) {
        //The salary of a Salaried is computed from the salary + overtime 
        //compensation
        super(aName, aSalary);
        this.overtimeHours = nOTH;
        this.overtimeRate = nOTR;
    }

    /**
     * set the number of hours worked overtime for the employee given
     *
     * @param nOTH the new number of hours to set for the employee
     */
    public void setOvertime(Double nOTH) {
        this.overtimeHours = nOTH;
    }

    /**
     * set the overtime rate of the employee given
     *
     * @param nOTR the new rate to be set for employee
     */
    public void setOvertimeRate(Double nOTR) {
        this.overtimeRate = nOTR;
    }

    /**
     * get the salary of employee
     *
     * @return Double salary of given Salaried
     */
    public Double getSalary() {
        return super.getSalary() + (this.overtimeHours * this.overtimeRate);
    }

    /**
     * return a string representing the Salaried
     *
     * @return String string representing Salaried
     */
    public String toString() {
        return super.toString()
                + "\n Overtime Hours:  " + overtimeHours
                + "\n Overtime Rate:   " + overtimeRate + "\n";
    }
    //----//-- Fields --//----//
    private Double overtimeHours;
    private Double overtimeRate;

}
