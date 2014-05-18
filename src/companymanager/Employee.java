/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companymanager;

import java.io.Serializable;
import java.lang.*;

/**
 *
 * @author Henry Rizzi
 */
public class Employee implements Serializable {

    /**
     * Constructor for an employee
     *
     * @param aName name of the employee
     * @param aSalary salary of the employee
     */
    public Employee(String aName, Double aSalary) {
        this.name = aName;
        this.salary = aSalary;
    }

    /**
     * return the name of this employee as a String
     *
     * @return String name of the employee
     */
    public String getName() {
        return this.name;
    }

    /**
     * set the name of the employee
     *
     * @param aName name to set for employee
     */
    public void setName(String aName) {
        this.name = aName;
    }

    /**
     * get the salary of provided employee
     *
     * @return Double representation of employee salary
     */
    public Double getSalary() {
        return this.salary;
    }

    /**
     * set the salary of the employee
     *
     * @param aSalary salary to set for employee
     */
    public void setSalary(Double aSalary) {
        this.salary = aSalary;
    }

    /**
     * This method returns a string representing the Employee
     *
     * @return String String representation of the Employee
     */
    public String toString() {
        return getClass().getName().substring(15)
                + "\n Name:            " + name
                + "\n Salary:          " + this.getSalary();
    }

    private String name;
    private Double salary;

}
