/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companymanager;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;
import java.util.*;

/**
 * This class defines functions for a list of Employees
 *
 * @author Henry Rizzi
 */
public class Emplist extends ArrayList<Employee> implements Serializable {

    //-- Constructor for a new Emplist --//
    public Emplist() {
        list = new ArrayList<Employee>();
    }

    /**
     * Method to add any type of Employee to list
     *
     * @param anEmployee: stipulates the employee to be added
     */
    public <t extends Employee> void addEmployee(t anEmployee) {
        this.add(anEmployee);
    }

    /**
     * Class to create a new EmployeeComparator object with type representing
     * the way in which the objects should be compared
     */
    public class EmployeeComparator implements Comparator<Employee> {

        public EmployeeComparator(int aType) {
            if (aType == NAME) {
                type = NAME;
            }
            if (aType == SALARY) {
                type = SALARY;
            }
        }

        /**
         * Compare the two employees supplied
         *
         * @param emp1 first employee to be compared
         * @param emp2 second employee to be compared
         */
        public int compare(Employee emp1, Employee emp2) {
            if (type == NAME) //Choice was made to ignore case, as case shouldn't change order
            {
                return emp1.getName().compareToIgnoreCase(emp2.getName());
            }
            if (type == SALARY) //getsalary method is used as this determines actual salary//
            {
                return emp1.getSalary().compareTo(emp2.getSalary());
            }
            else {
                return 0;
            }
        }
        //type will be used to determine type of sorting//
        private int type;
    }

    /**
     * Sorts the list using the type of sorting defined by type if the list is
     * to be sorted by name, input NAME. If by Salary input SALARY
     *
     * @param int type of sorting algorithm to use to sort the list
     */
    public void sortList(int type) {
        if (type == NAME) {
            Comparator<Employee> compByName = new EmployeeComparator(type);
            Collections.sort(this, compByName);
        }
        if (type == SALARY) {
            Comparator<Employee> compBySalary = new EmployeeComparator(type);
            Collections.sort(this, compBySalary);
        }
    }
    
    /**
     * Method to delete employee with specified name from list
     * 
     * @param aName name of the employee to be deleted
     */
    public void delEmp(String aName){
        for (int i = 0; i < this.size(); i++){
            if(this.get(i).getName().equals(aName))
                this.remove(i);
        }
    }

    /**
     * Method to create string of this list
     *
     * @return String representation of the list
     */
    public String printEmplist() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            s += this.get(i) + "\n";
        }
        return s;
    }

    /**
     * Method to return string of only the Salaried employees
     *
     * @return string with only the Salaried Employees
     */
    public String printSalariedList() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Salaried) {
                s += this.get(i) + "\n";
            }
        }
        return s;
    }

    /**
     * Method to return string of only Hourly employees
     *
     * @return String with only Hourly employees
     */
    public String printHourlyList() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Hourly) {
                s += this.get(i) + "\n";
            }
        }
        return s;
    }

    /**
     * Method to return string of only Managers
     *
     * @return string with only Managers
     */
    public String printManagerList() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Manager) {
                s += this.get(i) + "\n";
            }
        }
        return s;
    }

    /**
     * Method to save this to designated filename
     *
     * @param aString String of filename
     */
    public void saveEmployeeList(String aString) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(aString));
            out.writeObject(this);
            out.close();
        } catch (FileNotFoundException e) {
            System.err.print("File not found! Try again");
        } catch (IOException e) {
            System.err.print("Oh no! the IO is messed up! Try again.");
        }
    }

    /**
     * Method to load employee list of designated filename
     *
     * @param aString string representing the name of file
     * @return Emplist An emplist read from file
     */
    public static Emplist loadEmployeeList(String aString) {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(aString));
            Emplist e = (Emplist) in.readObject();
            in.close();
            return e;
        } catch (ClassNotFoundException e) {
            System.err.printf("Class was not found. Try again");
            return new Emplist();
        } catch (FileNotFoundException e) {
            System.err.print("File could not be found! Emptiness was loaded!");
            return new Emplist();
        } catch (IOException e) {
            System.err.print(
                    "IOException! What could have happened?! Try again");
            return new Emplist();
        }
    }

    /**
     * Set the overtime rate for all of the Salaried Employees in list
     *
     * @param aRate the new rate to set for all Salaried Employees
     */
    public void setOvertimeRate(Double aRate) {
        //Go through all of the employees in the list//
        for (int i = 0; i < this.size(); i++) {
            //if it is a Salaried, set the overtime rate//
            if (this.get(i) instanceof Salaried) {
                ((Salaried) this.get(i)).setOvertimeRate(aRate);
            }
        }
    }

    /**
     * Set the hourly rate for all of the Hourly Employees in list
     *
     * @param aRate the new rate to set for all Hourly Employees
     */
    public void setHourlyRate(Double aRate) {
        //Go through all of the employees in the list//
        for (int i = 0; i < this.size(); i++) {
            //if it is Hourly, set the hourly rate//
            if (this.get(i) instanceof Hourly) {
                ((Hourly) this.get(i)).setHourlyRate(aRate);
            }
        }
    }

    //----//-- Variables for class --//----//
    private ArrayList<Employee> list;
    final static public int NAME = 0;
    final static public int SALARY = 1;
}
