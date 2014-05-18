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
public class HourlyTest {
    
    public HourlyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getSalary method, of class Hourly.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Double nHours = 20.0;
        Double aRate = 15.0;
        Hourly instance = new Hourly("Hourly", nHours, aRate);
        Double expResult = nHours * aRate;
        Double result = instance.getSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHours method, of class Hourly.
     */
    @Test
    public void testSetHours() {
        System.out.println("setHours");
        Double nHours = 20.0;
        Double rate = 5.0;
        Hourly instance = new Hourly("Houry", 18.0, rate);
        instance.setHours(nHours);
        Double results = instance.getSalary() / rate;
        assertEquals(nHours, results);
    }

    /**
     * Test of setHourlyRate method, of class Hourly.
     */
    @Test
    public void testSetHourlyRate() {
        System.out.println("setHourlyRate");
        Double aRate = 10.0;
        Double nHours = 18.0;
        Hourly instance = new Hourly("Hourly", nHours, 5.);
        instance.setHourlyRate(aRate);
        Double results = instance.getSalary()/ nHours;
        assertEquals(aRate, results);
    }
    /**
     * Test of toString method, of class Hourly.
     */
    @Test
    public void testToString(){
        System.out.println("toString");
        String name = "Hourly";
        Double hours = 50.0;
        Double rate = 10.0;
        Hourly instance = new Hourly(name, hours, rate);
        String results = instance.toString();
        String expResults = "Hourly" 
                + "\n Name:            " + name
                + "\n Salary:          " + (hours * rate)
                + "\n Hours:           " + hours
                + "\n Hourly Rate:     " + rate + "\n";
        assertEquals(expResults,results);
    }
}
