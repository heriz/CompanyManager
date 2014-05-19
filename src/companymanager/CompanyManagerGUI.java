/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companymanager;

import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Constructor class for the GUI
 *
 * @author Henry Rizzi
 */
public class CompanyManagerGUI {

    //----//-- Fields Declaration Area --//----//
    private JButton saveButton;
    private JButton loadButton;
    private JButton addButton;
    private JButton delButton;
    private JButton sort;
    private JButton setRate;
    private JLabel showButton;
    private JTextArea empListDisplay;
    private JPanel bottomButtons;
    private JPanel topArea;
    private JPanel mainWindow;
    private JScrollPane textScroller;

    private final String[] employeeTypes = 
    {"All", "Salaried", "Hourly", "Manager"};

    private JFrame frame;

    /*
     Constructor for the CompanyManagerGUI
     Will create a new GUI for all the functions in Emplist
     */
    public CompanyManagerGUI() {
        //----//-- Create the Buttons --//----//
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        addButton = new JButton("Add Employee");
        delButton = new JButton("Delete Employee");
        showButton = new JLabel("Show Type:  ");
        sort = new JButton("Sort List");
        setRate = new JButton("Set Rate");
        empListDisplay = new JTextArea(35, 45);
        bottomButtons = new JPanel();
        topArea = new JPanel();
        mainWindow = new JPanel();
        textScroller = new JScrollPane(empListDisplay);
        textScroller.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        final JComboBox empBox = new JComboBox(employeeTypes);
        final Emplist list = new Emplist();
        empListDisplay.setText(list.printEmplist());
        empListDisplay.setEditable(false);
        empListDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        //----//-- Add ActionListeners to the buttons --//----//
        empBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //---- Index 0 is "All" option ----//
                if (empBox.getSelectedIndex() == 0) {
                    empListDisplay.setText(list.printEmplist());
                }
                //---- Index 1 is "Salaried" option ----//
                if (empBox.getSelectedIndex() == 1) {
                    empListDisplay.setText(list.printSalariedList());
                }
                //---- Index 2 is "Hourly" option ----//
                if (empBox.getSelectedIndex() == 2) {
                    empListDisplay.setText(list.printHourlyList());
                }
                //---- Index 3 is "Manager" option ----//
                if (empBox.getSelectedIndex() == 3) {
                    empListDisplay.setText(list.printManagerList());
                }
            }
        });
        /*
         This will create a new popup window which then asks the
         user to make a selection, upon which point it will create another
         popup box with fields in which the user enters the required information.
         */
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //String array which contains the different types of Employees//
                String[] employees = {"Salaried",
                    "Hourly",
                    "Manager"};
                //----//-- Get a String from the users selection--//----//
                String s = (String) JOptionPane.showInputDialog(null,
                        "Pick a type to add",
                        "Type selector",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        //Default option is salaried//
                        employees, employees[0]);

                //create a name for the empty string for easier checking//
                String empty = new String("");
                //----//-- Create text fields for data retrieval --//----//
                JTextField nameField = new JTextField(10);
                JTextField salaryField = new JTextField(10);
                JTextField rateField = new JTextField(10);
                JTextField hoursField = new JTextField(10);
                JTextField bonusField = new JTextField(10);
                JTextField overTimeHoursField = new JTextField(10);

                //----//-- Make Panels for each of the fields --//----//
                JPanel namePanel = new JPanel();
                namePanel.add(new JLabel("Name:"));
                namePanel.add(nameField);

                JPanel salaryPanel = new JPanel();
                salaryPanel.add(new JLabel("Salary (number):"));
                salaryPanel.add(salaryField);

                JPanel timePanel = new JPanel();
                timePanel.add(new JLabel("Hours (number):"));
                timePanel.add(hoursField);

                JPanel overTimePanel = new JPanel();
                overTimePanel.add(new JLabel("Overtime Hours (number):"));
                overTimePanel.add(overTimeHoursField);

                JPanel ratePanel = new JPanel();
                ratePanel.add(new JLabel("Rate (number):"));
                ratePanel.add(rateField);

                JPanel bonusPanel = new JPanel();
                bonusPanel.add(new JLabel("Bonus (number):"));
                bonusPanel.add(bonusField);

                //If prior selection was "Salaried"//
                if (s == employees[0]) {
                    //Create the new Salaried Panel//
                    JPanel salariedPanel = new JPanel();
                    salariedPanel.setLayout(
                            new BoxLayout(salariedPanel, BoxLayout.X_AXIS));
                    salariedPanel.add(namePanel);
                    salariedPanel.add(salaryPanel);
                    salariedPanel.add(overTimePanel);
                    salariedPanel.add(ratePanel);

                    //Create a new JOptionPane with SalariedPanel//
                    int result = JOptionPane.showConfirmDialog(null,
                            salariedPanel,
                            "Please input data for new Salaried",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
                    /*
                     Make sure the user has selected the OK Button & no fields
                     blank
                     */
                    if (result == JOptionPane.OK_OPTION
                            && !(nameField.getText().equals(empty))
                            && !(salaryField.getText().equals(empty))
                            && !(overTimeHoursField.getText().equals(empty))
                            && !(rateField.getText().equals(empty))) {
                        //Add a Salaried created from fields to list//
                        list.add(new Salaried(
                                nameField.getText(),
                                Double.parseDouble(salaryField.getText()),
                                Double.parseDouble(overTimeHoursField.getText()),
                                Double.parseDouble(rateField.getText())));
                    }
                    //Refresh list//
                    empListDisplay.setText(list.printEmplist());
                }
                //If prior selection was Hourly//
                if (s == employees[1]) {
                    //Create the new hourly Panel//
                    JPanel hourlyPanel = new JPanel();
                    hourlyPanel.setLayout(
                            new BoxLayout(hourlyPanel, BoxLayout.X_AXIS));
                    hourlyPanel.add(namePanel);
                    hourlyPanel.add(timePanel);
                    hourlyPanel.add(ratePanel);

                    //Create a new JOptionPane with hourlyPanel//
                    int result = JOptionPane.showConfirmDialog(null,
                            hourlyPanel,
                            "Please input data for new hourly",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
                    /*
                     Make sure the user has selected the OK Button & no fields
                     blank
                     */
                    if (result == JOptionPane.OK_OPTION
                            && !(nameField.getText().equals(empty))
                            && !(hoursField.getText().equals(empty))
                            && !(rateField.getText().equals(empty))) {
                        //Add an Hourly created from fields to list//
                        list.add(new Hourly(
                                nameField.getText(),
                                Double.parseDouble(hoursField.getText()),
                                Double.parseDouble(rateField.getText())));

                    }
                    //Refresh list//
                    empListDisplay.setText(list.printEmplist());
                }
                //If prior selection was Manager//
                if (s == employees[2]) {
                    //Create the new Manager panel//
                    JPanel managerPanel = new JPanel();
                    managerPanel.setLayout(
                            new BoxLayout(managerPanel, BoxLayout.X_AXIS));
                    managerPanel.add(namePanel);
                    managerPanel.add(salaryPanel);
                    managerPanel.add(bonusPanel);

                    //Create a new JOptionPane using ManagerPanel//
                    int result = JOptionPane.showConfirmDialog(null,
                            managerPanel,
                            "Please input data for new manager", 
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
                    /*
                     Make sure the user has selected the OK Button & no fields
                     blank
                     */
                    if (result == JOptionPane.OK_OPTION
                            && !(nameField.getText().equals(empty))
                            && !(salaryField.getText().equals(empty))
                            && !(bonusField.getText().equals(empty))) {
                        //Add new Manager from fields to the list//
                        list.add(new Manager(
                                nameField.getText(),
                                Double.parseDouble(salaryField.getText()),
                                Double.parseDouble(bonusField.getText())));
                    }
                    //Refresh list//
                    empListDisplay.setText(list.printEmplist());
                }
            }
        });
        
        //Create a dialog when the delButton is pressed//
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Create a new panel to hold the elements//
                JPanel namePanel = new JPanel();
                namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
                namePanel.add(new JLabel("Enter Name: "));
                JTextField inputName = new JTextField(10);
                namePanel.add(inputName);
                //Create a new JOptionPane with area for emp input//
                int result = JOptionPane.showConfirmDialog(null, namePanel,
                        "Input employee name for deletion", 
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION
                        && !(inputName.getText().equals(""))) {
                    list.delEmp(inputName.getText());
                    empListDisplay.setText(list.printEmplist());
                }
            }
        });

        //Create a dialog when the saveButton is pressed//
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Create a new JPanel which has a field to enter a filename//
                JPanel filePanel = new JPanel();
                filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.X_AXIS));
                filePanel.add(new JLabel("Enter Name: "));
                JTextField inputName = new JTextField(10);
                filePanel.add(inputName);
                //Create a new JOptionPane with space to input filename//
                int result = JOptionPane.showConfirmDialog(null, filePanel,
                        "Please input file name", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                //check to see if confirmed, if no name choose name *.dat//
                if (result == JOptionPane.OK_OPTION
                        && !(inputName.getText().equals(""))) {
                    list.saveEmployeeList(inputName.getText() + ".dat");
                    empListDisplay.setText("List Saved! \n\n"
                            + list.printEmplist());
                }
                if (result == JOptionPane.OK_OPTION
                        && inputName.getText().equals("")) {
                    list.saveEmployeeList("*.dat");
                    empListDisplay.setText("List Saved! \n\n"
                            + list.printEmplist());
                }
            }
        });

        //Create a dialog from which to choose the file to load//
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Create a new loadPanel//
                JPanel loadPanel = new JPanel();
                loadPanel.setLayout(new BoxLayout(loadPanel, BoxLayout.X_AXIS));
                loadPanel.add(new JLabel("Select Name:"));

                //current folder representation == .//
                File folder = new File(".");
                //Create a FilenameFilter based on .dat ending//
                FilenameFilter textFilter = new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        String lowercaseName = name.toLowerCase();
                        if (lowercaseName.endsWith(".dat")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                };

                //Get all the files in the current folder ending in .dat//
                File[] files = folder.listFiles(textFilter);
                //Create matching string array//
                String[] filesString = new String[files.length];
                /*
                 Copy data from file array into string array getting rid of
                 starting ./ using substring function
                 */
                for (int i = 0; i < files.length; i++) {
                    filesString[i] = files[i].toString().substring(2);
                }

                //Use this new string to create a JComboBox for selectino//
                JComboBox inputName = new JComboBox(filesString);
                loadPanel.add(inputName);
                int result = JOptionPane.showConfirmDialog(null, loadPanel,
                        "Please select file name",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                /*
                 Make sure that there are files capable of being loaded and 
                 user selected the OK option
                 */
                if (result == JOptionPane.OK_OPTION
                        && filesString.length > 0) {
                    //Clear the list//
                    list.clear();
                    //create a new list opject//
                    Emplist newList = Emplist.loadEmployeeList(
                            (String) inputName.getSelectedItem());
                    //add all items of newlist into old list//
                    for (int i = 0; i < newList.size(); i++) {
                        list.add(newList.get(i));
                    }
                    //Set display to show the new list//
                    empListDisplay.setText("Loaded Successfully! \n\n"
                            + list.printEmplist());
                }
            }
        });

        //Sort the list by either name or salary and refresh display//
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Create a string array of sort methods
                String[] sortStyle = {"Name", "Salary"};
                //----//-- Get a String from the users selection--//----//
                String s = (String) JOptionPane.showInputDialog(null,
                        "Sort list by: ",
                        "Selection",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        //Default option is salaried//
                        sortStyle, sortStyle[0]);
                if (s == sortStyle[0]) {
                    list.sortList(Emplist.NAME);
                    empListDisplay.setText(list.printEmplist());
                }
                if (s == sortStyle[1]) {
                    list.sortList(Emplist.SALARY);
                    empListDisplay.setText(list.printEmplist());
                }
            }
        }
        );

        //Create a new popup which asks for the new overtime rate//
        setRate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String[] setTypes = {"Hourly", "Salaried"};
                String s = (String) JOptionPane.showInputDialog(null,
                        "Select type of Employee: ",
                        "Change the Rate for Selected Type",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        //Default option is salaried//
                        setTypes, setTypes[0]);
                //If changing the hourly rate for Hourly//
                if (s == setTypes[0]) {
                    //create hourlyfield to access entry//
                    JTextField hourlyField = new JTextField(10);
                    JPanel hourlyPanel = new JPanel();
                    hourlyPanel.add(new JLabel("New Rate:"));
                    hourlyPanel.add(hourlyField);
                    //Create the new pane and save result//
                    int result
                            = JOptionPane.showConfirmDialog(null, hourlyPanel,
                                    "Please input new Hourly Rate",
                                    JOptionPane.OK_CANCEL_OPTION);
                    //if OK selected and not field not blank, set//
                    if (result == JOptionPane.OK_OPTION
                            && !(hourlyField.getText().equals(""))) {
                        Double input =
                                Double.parseDouble(hourlyField.getText());
                        list.setHourlyRate(input);
                    }
                    empListDisplay.setText(list.printEmplist());
                }
                //if changing the overtime rate for Salaried//
                if (s == setTypes[1]) {
                    //Make new overtime field//
                    JTextField overtimeField = new JTextField(10);
                    JPanel overtimePanel = new JPanel();
                    overtimePanel.add(new JLabel("New Rate:"));
                    overtimePanel.add(overtimeField);
                    //create new Pane and save the result to see if ok selected//
                    int result
                            = JOptionPane.showConfirmDialog(null, overtimePanel,
                                    "Please input new overtime rate",
                                    JOptionPane.OK_CANCEL_OPTION);
                    //if ok selected and textfield not blank, set new rate//
                    if (result == JOptionPane.OK_OPTION
                            && !(overtimeField.getText().equals(""))) {
                        Double input = 
                                Double.parseDouble(overtimeField.getText());
                        //set using input parsed to double//
                        list.setOvertimeRate(input);
                    }
                    empListDisplay.setText(list.printEmplist());
                }
            }
        });

        //----//-- Set up the layout of all the buttons and fields --//----//
        bottomButtons.setLayout(new BoxLayout(bottomButtons, BoxLayout.X_AXIS));
        bottomButtons.add(saveButton);
        bottomButtons.add(loadButton);
        bottomButtons.add(sort);
        bottomButtons.add(setRate);
        bottomButtons.add(addButton);
        bottomButtons.add(delButton);

        topArea.setLayout(new BoxLayout(topArea, BoxLayout.X_AXIS));
        topArea.add(showButton);
        topArea.add(empBox);

        mainWindow.setLayout(new BorderLayout());
        mainWindow.add(topArea, BorderLayout.NORTH);
        mainWindow.add(textScroller, BorderLayout.CENTER);
        mainWindow.add(bottomButtons, BorderLayout.SOUTH);

        //----//-- Set up the frame adding window --//----//
        frame = new JFrame("CompanyManager");
        frame.add(mainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Just use the main method to generate a new GUI
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalAccessException,
            UnsupportedLookAndFeelException,
            ClassNotFoundException,
            InstantiationException {
        //Set the look of the UIManager to System//
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //Create a new CompanyManagerGUI!//
        new CompanyManagerGUI();
    }
}
