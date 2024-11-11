/*
 * Name:Jiasong Hou
 * ID: W0499503
 * Project: Assignment2
 * Date: 2024/11/11
 * */
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Staff>  staffList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        boolean end = false;

        do{
            String[] options = {"Student", "Staff", "Finish"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option", "Accounting App",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            //choose Student
            if(choice == 0){
                studentInput(studentList);
            }
            //choose Staff
            else if (choice == 1){
                staffInput(staffList);
            }
            //choose Finish
            else {
                displayResults(studentList,staffList);
                end = true;
            }
        }while(!end);
    }

    private static void studentInput(ArrayList<Student> studentList) {
        String name = JOptionPane.showInputDialog("Enter Student Name:");
        //check if name is empty
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid information");
            return;
        }
        //check if address is empty
        String address = JOptionPane.showInputDialog("Enter Student Address:");
        if (address == null || address.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid information");
            return;
        }

        String yearInString = JOptionPane.showInputDialog("Enter Student Year (1-4):");
        //check if year is available(1-4)
        try {
            int year = Integer.parseInt(yearInString);
            if (year < 1 || year > 4) {
                JOptionPane.showMessageDialog(null, "Please enter valid information");
                return;
            }
            studentList.add(new Student(name, address, year));
        }
        //year not available
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
    }

    //similar to the studentInput
    private static void staffInput(ArrayList<Staff> staffList) {
        String name = JOptionPane.showInputDialog("Enter Staff Name:");
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid information");
            return;
        }

        String address = JOptionPane.showInputDialog("Enter Staff Address:");
        if (address == null || address.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid information");
            return;
        }

        String yearsOfServiceStr = JOptionPane.showInputDialog("Enter staff years of service:");
        try {
            int yearsOfService = Integer.parseInt(yearsOfServiceStr);
            if (yearsOfService <= 0 || yearsOfService >= 30) {
                JOptionPane.showMessageDialog(null, "Please enter valid information");
                return;
            }
            staffList.add(new Staff(name, address, yearsOfService));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number.");
        }
    }

    //append output from arraylists
    private static void displayResults(ArrayList<Student> studentList, ArrayList<Staff> staffList) {
        StringBuilder report = new StringBuilder();
        double totalIncoming = 0;
        double totalOutgoing = 0;

        //append student details
        report.append("Students: [Total: ").append(studentList.size()).append("]\n");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            report.append(i + 1).append(". ").append(student.toString()).append("\n");
            totalIncoming += student.getFeeOfTerm();
        }

        //append staff details
        report.append("Staff: [Total: ").append(staffList.size()).append("]\n");
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            report.append(i + 1).append(". ").append(staff.toString()).append("\n");
            totalOutgoing += staff.getWeeklyPay();
        }

        //append results
        report.append("\nResults:");
        report.append("\nOutgoing: $").append(String.format("%.2f", totalOutgoing));
        report.append("\nIncoming: $").append(String.format("%.2f", totalIncoming));
        report.append("\nTotal: $").append(String.format("%.2f", totalIncoming - totalOutgoing));

        JOptionPane.showMessageDialog(null, report.toString());
    }

}


