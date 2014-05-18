/*
 * Copyright (C) 2014 Henry
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package companymanager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henry
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String name = "Carl";
        Double sal = 0.0;
        Employee instance = new Employee(name, sal);
        String expResult = name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String aName = "Sam";
        Employee instance = new Employee("orange", 0.0);
        instance.setName(aName);
        String result = instance.getName();
        assertEquals(aName, result);
    }

    /**
     * Test of getSalary method, of class Employee.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Double sal = 50.0;
        Employee instance = new Employee("instance", sal);
        Double expResult = sal;
        Double result = instance.getSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSalary method, of class Employee.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        Double aSalary = 120.0;
        Employee instance = new Employee("instance", 50.0);
        instance.setSalary(aSalary);
        Double result = instance.getSalary();
        assertEquals(aSalary, result);
    }
    
    /**
     * Test of the toString method, of class Employee.
     */
    @Test
    public void testToString(){
        System.out.println("toString");
        String name = "Employee";
        Double salary = 50.0;
        Employee instance = new Employee(name, salary);
        String result = instance.toString();
        String expResult = "Employee" 
                + "\n Name:            " + name
                + "\n Salary:          " + salary;
        assertEquals(expResult,result);
    }
}
