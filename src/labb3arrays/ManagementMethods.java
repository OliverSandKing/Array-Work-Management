package labb3arrays;

import java.util.Scanner;
// TO DO: Move menu methods to ManagementMainMenu, sort methods and BUG FIX!

public class ManagementMethods {

    static Scanner scnr = new Scanner(System.in);

    static Worker[] employees = new Worker[3];
    static int counter = 3;

    public static void main(String[] args) {
        employees[0] = new Worker("Adam", "Green", "1922-05-05", 20000);
        employees[1] = new Worker("Eva", "Green", "1922-03-05", 40000);
        employees[2] = new Worker("Mimmi", "Gris", "1972-10-05", 60000);

        while (true) {
            menu();
        }
    }

    public static void menu() {

        System.out.println("\n");
        System.out.println("1. Add Worker");
        System.out.println("2. Fire a naughty Worker");
        System.out.println("3. Salary negotiation");
        System.out.println("4. Get info about worker");
        System.out.println("5. See average Salary");
        System.out.println("6. Total monthly salary");
        System.out.println("7. Show a list of all employees\n");

        int chosenOption = scnr.nextInt();
        scnr.nextLine();

        switch (chosenOption) {
            case 1:
                addWorker();
                break;
            case 2:
                System.out.println("What's his/her work ID number?");
                removeWorker(scnr.nextInt());

                break;
            case 3:
                changeSalary();
                break;
            case 4:
                System.out.print("Enter name of worker: ");
                String name = scnr.nextLine();
                getEmployeIDByName(name);
                break;
            case 5:
                averageSalary();
                break;
            case 6:
                totalSalary();
                break;
            case 7:
                printAllEmployees();
                break;
        }

    }

    public static void addWorker() {

        String firstName;
        String lastName;
        String age;
        double salary;

        System.out.print("Add firstname: ");
        firstName = scnr.nextLine();
        System.out.print("Add Lastname: ");
        lastName = scnr.nextLine();
        System.out.print("Add age (YYYY-MM-DD): ");
        age = scnr.nextLine();
        System.out.print("Add salary: ");
        salary = scnr.nextDouble();
        scnr.nextLine();

        if (employees.length == counter) {
            expandEmployeesArray();
        }
        employees[counter] = new Worker(firstName, lastName, age, salary);
        counter++;

    }

    public static void expandEmployeesArray() {
        Worker[] tempArray = new Worker[employees.length + 3];
        for (int i = 0; i < counter; i++) {
            tempArray[i] = employees[i];
        }
        employees = tempArray;
    }

    public static void removeWorker(int ID) {
        boolean noMatch = true;

        for (int i = 0; i < counter; i++) {
            if (ID == employees[i].getID()) {
                for (int j = i; j < counter-1; j++) {
                    employees[j] = employees[j + 1];
                }
                counter--;
                employees[counter] = null;
                noMatch = false;
            }

        }
        if (noMatch) {
            System.out.println("There's no employee with that ID");
        }
    }

    public static void averageSalary() {
        double totalSalary = 0;
        for (int i = 0; i < counter; i++) {
            totalSalary = totalSalary + employees[i].getSalary();
        }
        System.out.println(totalSalary / counter);
    }

    public static void changeSalary() {
        System.out.println("ID number of the worker?");
        int positionOfWorker = getIndexPosOfEmployee(scnr.nextInt());
        System.out.print("New salary: ");
        employees[positionOfWorker].setSalary(scnr.nextInt());

        System.out.println(employees[positionOfWorker].getFirstName() + "new salary is: "
                + employees[positionOfWorker].getSalary());
    }

    public static void totalSalary() {
        double totalSalary = 0;
        for (int i = 0; i < counter; i++) {
            totalSalary = totalSalary + employees[i].getSalary();
        }
        System.out.println(totalSalary);
    }

    public static void getEmployeIDByName(String name) {
        boolean noneFound = true;
        for (int i = 0; i < counter; i++) {
            if (name.equals(employees[i].getFirstName())) {
                System.out.println(employees[i]);
            }
            noneFound = false;
        }
        if (noneFound) {
            System.out.println("No worker with that Name was found");
        }
    }

    public static void printAllEmployees() {
        for (int i = 0; i < counter; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int getIndexPosOfEmployee(int ID) {
        int index = 0;
        for (int i = 0; i < counter; i++) {
            if (ID == employees[i].getID()) {
                index = i;
            }
        }
        return index;
    }
}
