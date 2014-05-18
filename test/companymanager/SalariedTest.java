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
public class SalariedTest {
    
    public SalariedTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of getSalary method, of class Salaried.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Double aSalary = 2000.0;
        Double nHours = 20.0;
        Double aRate = 10.0;
        Salaried instance = new Salaried("Salaried", aSalary, nHours, aRate);
        Double expResult = aSalary + (nHours * aRate);
        Double result = instance.getSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOvertime method, of class Salaried.
     */
    @Test
    public void testSetOvertime() {
        System.out.println("setOvertime");
        Double nOTH = 20.0;
        Double salary = 200.0;
        Double rate = 10.0;
        Salaried instance = new Salaried("Salaried", salary, 10.0, rate);
        instance.setOvertime(nOTH);
        Double result = (instance.getSalary() - salary) / rate;
        assertEquals(nOTH, result);
    }

    /**
     * Test of setOvertimeRate method, of class Salaried.
     */
    @Test
    public void testSetOvertimeRate() {
        System.out.println("setOvertimeRate");
        Double nOTR = 15.0;
        Double salary = 200.0;
        Double hours = 20.0;        
        Salaried instance = new Salaried("Salaried", salary, hours, 5.0);
        instance.setOvertimeRate(nOTR);
        Double result = (instance.getSalary() - salary) / hours;
        assertEquals(nOTR, result);
    }
    
    /**
     * Test of toString method, of class Manager.
     */
    @Test
    public void testToString(){
        System.out.println("toString");
        String name = "Salaried";
        Double salary = 50.0;
        Double hours = 10.0;
        Double rate = 15.0;
        Salaried instance = new Salaried(name, salary, hours, rate);
        String results = instance.toString();
        String expResults = "Salaried" 
                + "\n Name:            " + name
                + "\n Salary:          " + ((salary) + (hours * rate))
                + "\n Overtime Hours:  " + hours
                + "\n Overtime Rate:   " + rate + "\n";
        assertEquals(expResults, results);
    }
}
