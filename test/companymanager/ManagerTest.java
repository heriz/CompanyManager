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
public class ManagerTest {
    
    public ManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of getSalary method, of class Manager.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Double aSalary = 2000.0;
        Double aBonus = 250.0;
        Manager instance = new Manager("Manager", aSalary, aBonus);
        Double expResult = aSalary + aBonus;
        Double result = instance.getSalary();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setBonus method, of class Manager.
     */
    @Test
    public void testSetBonus() {
        System.out.println("setBonus");
        Double aBonus = 2500.0;
        Double salary = 1000.0;
        Manager instance = new Manager("Manager", salary, 200.0);
        instance.setBonus(aBonus);
        Double result = instance.getSalary() - salary;
        assertEquals(aBonus, result);
    }
    /**
     * Test of toString method, of class Manager.
     */
    @Test
    public void testToString(){
        System.out.println("toString");
        String name = "Manager";
        Double salary = 50.0;
        Double bonus = 10.0;
        Manager instance = new Manager(name, salary, bonus);
        String results = instance.toString();
        String expResults = "Manager" 
                + "\n Name:            " + name
                + "\n Salary:          " + (salary + bonus)
                + "\n Bonus:           " + bonus + "\n";
        assertEquals(expResults, results);
    }
}
