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
import java.lang.*;
/**
 *
 * @author Henry
 */
public class EmplistTest {
    
    public EmplistTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addEmployee method, of class Emplist.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        Employee anEmployee = new Employee("Cat", 200.0);
        Emplist instance = new Emplist();
        instance.addEmployee(anEmployee);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of sortList method, of class Emplist.
     */
    @Test
    public void testSortList() {
        System.out.println("sortList");
        int typeN = Emplist.NAME;
        int typeS = Emplist.SALARY;
        Double lowSal = 300.0;
        String lowNam = "A";
        Emplist instance = new Emplist();
        Salaried s = new Salaried("A", 5000.0, 50.0, 10.0);
        Hourly h = new Hourly("B", 20.0, 15.0);
        Employee e = new Employee("C", 350.0);
        String startType = h.toString();
        instance.add(s);
        instance.add(h);
        instance.add(e);
        instance.sortList(typeN);
        String resultNam = instance.get(0).getName();
        assertEquals(instance.get(0).getName(), lowNam);
        instance.sortList(typeS);
        Double resultSal = instance.get(0).getSalary();
        assertEquals(resultSal, lowSal);
    }
    /**
     * Test of delEmp method, of class Emplist.
     */
    
    @Test
    public void testDelEmp(){
        System.out.println("delEmp");
        Emplist instance = new Emplist();
        Manager m1 = new Manager("A", 2000.0, 500.0);
        Manager m2 = new Manager("B", 200.0, 2000.0);
        Hourly h1 = new Hourly("C", 20.0, 10.0);
        Hourly h2 = new Hourly("D",100.0, 150.0);
        Salaried s1 = new Salaried("E", 200.0, 50.0, 15.0);
        Salaried s2 = new Salaried("F", 300.0, 15.0, 20.0);
        instance.add(m1);
        instance.add(m2);
        instance.add(h1);
        instance.add(h2);
        instance.add(s1);
        instance.add(s2);
        int expResult = 5;
        instance.delEmp("A");
        int result = instance.size();
        assertEquals(expResult, result);
        int expResult2 = 4;
        instance.delEmp("C");
        int result2 = instance.size();
        assertEquals(expResult2,result2);
    }

    
    /**
     * Test of printEmplist method, of class Emplist.
     */
    
    @Test
    public void testPrintEmplist() {
        System.out.println("printEmplist");
        Emplist instance = new Emplist();
        Manager m1 = new Manager("A", 2000.0, 500.0);
        Manager m2 = new Manager("B", 200.0, 2000.0);
        Hourly h1 = new Hourly("C", 20.0, 10.0);
        Hourly h2 = new Hourly("D",100.0, 150.0);
        Salaried s1 = new Salaried("E", 200.0, 50.0, 15.0);
        Salaried s2 = new Salaried("F", 300.0, 15.0, 20.0);
        instance.add(m1);
        instance.add(m2);
        instance.add(h1);
        instance.add(h2);
        instance.add(s1);
        instance.add(s2);
        String expResult = instance.get(0).toString() + "\n" +
                instance.get(1).toString() + "\n" +
                instance.get(2).toString() + "\n" +
                instance.get(3).toString() + "\n" +
                instance.get(4).toString() + "\n" +
                instance.get(5).toString() + "\n";
        String result = instance.printEmplist();
        assertEquals(expResult, result);
    }

    /**
     * Test of printSalariedList method, of class Emplist.
     */
    
    @Test
    public void testPrintSalariedList() {
        System.out.println("printSalariedList");
        Emplist instance = new Emplist();
        Manager m1 = new Manager("A", 2000.0, 500.0);
        Manager m2 = new Manager("B", 200.0, 2000.0);
        Hourly h1 = new Hourly("C", 20.0, 10.0);
        Hourly h2 = new Hourly("D",100.0, 150.0);
        Salaried s1 = new Salaried("E", 200.0, 50.0, 15.0);
        Salaried s2 = new Salaried("F", 300.0, 15.0, 20.0);
        instance.add(m1);
        instance.add(m2);
        instance.add(h1);
        instance.add(h2);
        instance.add(s1);
        instance.add(s2);
        String expResult = instance.get(4).toString() + "\n" +
                instance.get(5).toString() + "\n";
        String result = instance.printSalariedList();
        assertEquals(expResult, result);
    }

    /**
     * Test of printHourlyList method, of class Emplist.
     */
    
    @Test
    public void testPrintHourlyList() {
        System.out.println("printHourlyList");
        Emplist instance = new Emplist();
        Manager m1 = new Manager("A", 2000.0, 500.0);
        Manager m2 = new Manager("B", 200.0, 2000.0);
        Hourly h1 = new Hourly("C", 20.0, 10.0);
        Hourly h2 = new Hourly("D",100.0, 150.0);
        Salaried s1 = new Salaried("E", 200.0, 50.0, 15.0);
        Salaried s2 = new Salaried("F", 300.0, 15.0, 20.0);
        instance.add(m1);
        instance.add(m2);
        instance.add(h1);
        instance.add(h2);
        instance.add(s1);
        instance.add(s2);
        String expResult = instance.get(2).toString() + "\n" +
                instance.get(3).toString() + "\n";
        String result = instance.printHourlyList();
        assertEquals(expResult, result);
    }

    /**
     * Test of printManagerList method, of class Emplist.
     */
    
    @Test
    public void testPrintManagerList() {
        System.out.println("printManagerList");
        Emplist instance = new Emplist();
        Manager m1 = new Manager("A", 2000.0, 500.0);
        Manager m2 = new Manager("B", 200.0, 2000.0);
        Hourly h1 = new Hourly("C", 20.0, 10.0);
        Hourly h2 = new Hourly("D",100.0, 150.0);
        Salaried s1 = new Salaried("E", 200.0, 50.0, 15.0);
        Salaried s2 = new Salaried("F", 300.0, 15.0, 20.0);
        instance.add(m1);
        instance.add(m2);
        instance.add(h1);
        instance.add(h2);
        instance.add(s1);
        instance.add(s2);
        String expResult = instance.get(0).toString() + "\n" +
                instance.get(1).toString() + "\n";
        String result = instance.printManagerList();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveEmployeeList and loadEmployeeList methods, of class Emplist.
     */
    
    @Test
    public void testSaveLoadEmployeeList() {
        System.out.println("saveEmployeeList + loadEmployeeList");
        String aString = "Employees.dat";
        Emplist instance = new Emplist();
        Employee sam = new Employee("Sam", 200.0);
        instance.add(sam);
        instance.saveEmployeeList(aString);
        String expResult = instance.get(0).getName();
        String result = Emplist.loadEmployeeList(aString).get(0).getName();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of setOvertimeRate method, of class Emplist.
     */
    @Test
    public void testSetOvertimeRate() {
        System.out.println("setOvertimeRate");
        Double aRate = 15.0;
        Double salary = 200.0;
        Double hours = 10.0;
        Emplist instance = new Emplist();
        instance.add(new Salaried("A", salary, hours, 35.0));
        instance.add(new Salaried("B", salary, hours, 20.0));
        instance.add(new Hourly("C", hours, 40.0));
        instance.add(new Manager("D", salary, 500.0));
        Double befHResult = instance.get(2).getSalary();
        Double befMResult = instance.get(3).getSalary();
        instance.setOvertimeRate(aRate);
        Double expResult = salary + (aRate * hours);
        assertEquals(instance.get(0).getSalary(), expResult);
        assertEquals(instance.get(1).getSalary(), expResult);
        assertEquals(instance.get(2).getSalary(), befHResult);
        assertEquals(instance.get(3).getSalary(), befMResult);
    }

    /**
     * Test of setHourlyRate method, of class Emplist.
     */
    @Test
    public void testSetHourlyRate() {
        System.out.println("setHourlyRate");
        Double aRate = 15.0;
        Double salary = 200.0;
        Double hours = 10.0;
        Emplist instance = new Emplist();
        instance.add(new Hourly("A", hours, 35.0));
        instance.add(new Hourly("B", hours, 20.0));
        instance.add(new Salaried("C", salary, hours, 40.0));
        instance.add(new Manager("D", salary, 500.0));
        Double befSResult = instance.get(2).getSalary();
        Double befMResult = instance.get(3).getSalary();
        instance.setHourlyRate(aRate);
        Double expResult = aRate * hours;
        assertEquals(instance.get(0).getSalary(), expResult);
        assertEquals(instance.get(1).getSalary(), expResult);
        assertEquals(instance.get(2).getSalary(), befSResult);
        assertEquals(instance.get(3).getSalary(), befMResult);
    }
    
}
