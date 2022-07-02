import java.time.*;
import java.util.*;

/*
Вам необходимо реализовать следующий функционал
Список сотрудников должен позволять
     - добавлять,
     - удалять,
     - изменять тип сотрудника,
     - привязывать сотрудника к менеджеру,
     - сортировать список по фамилиям, датам принятия на работу.
 */

public class Main {
    public static void main(String[] args) {

        //local
        int command = 1;
        int command_next = 1;
        int i = 0;
        int index = 0;
        int index_next = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        Scanner scanner = new Scanner(System.in);

        //object_list
        ArrayList<Persona> list_employee = new ArrayList<Persona>();

        //start_reestr
        //employee
        Persona em1 = new Employee("Ivan",
                LocalDate.of(1980, 12, 01),
                LocalDate.of(2015, 02, 15));

        //other_employee
        Persona em5 = new Other_Employee("Victor",
                LocalDate.of(1979, 02, 15),
                LocalDate.of(2020, 12, 30));

        //manager
        Persona em10 = new Manager("Boris",
                LocalDate.of(1988, 07, 30),
                LocalDate.of(2013, 02, 15));

        //list_add
        list_employee.add(em1);
        list_employee.add(em5);
        list_employee.add(em10);

        while (command != 7) {

            System.out.println("Enter command: " + "\n" +
                    "0 - View_List, " +
                    "1 - New_Employee, " +
                    "2 - Delete_Emloyee, " + "\n" +
                    "3 - Reload_type_Employee " +
                    "4 - Set_Employee_for_Manager " +
                    "5 - Sort_List_for_Name " + "\n" +
                    "6 - Sort_List_for_Date " +
                    "7 - Exit" + "\n");

            try {

                command = Integer.parseInt(scanner.nextLine());

                // View_List
                if (command == 0) {
                    System.out.printf("View_List \n");
                    i = 0;
                    for (Persona object : list_employee) {
                        System.out.println(i + " " + object.getParam());
                        i += 1;
                    }
                }

                // New_Employee
                if (command == 1) {
                    System.out.printf("New_Employee \n");
                    //Name
                    System.out.printf("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.printf(name + "\n");

                    //Birthday
                    System.out.printf("Enter Birthday YYYY MM DD: ");

                    year = Integer.parseInt(scanner.nextLine());
                    month = Integer.parseInt(scanner.nextLine());
                    day = Integer.parseInt(scanner.nextLine());

                    LocalDate birthday = LocalDate.of(year, month, day);
                    System.out.printf(birthday + "\n");

                    //Date_of_employment
                    System.out.printf("Date_of_employment YYYY MM DD: ");

                    year = Integer.parseInt(scanner.nextLine());
                    month = Integer.parseInt(scanner.nextLine());
                    day = Integer.parseInt(scanner.nextLine());

                    LocalDate date_of_employment = LocalDate.of(year, month, day);
                    System.out.printf(date_of_employment + "\n");

                    //add_new
                    list_employee.add(new Employee(name, birthday, date_of_employment));

                }

                // Delete_Emloyee
                if (command == 2) {
                    System.out.printf("Delete_Emloyee \n" + "Enter index: ");
                    index = Integer.parseInt(scanner.nextLine());
                    list_employee.remove(index);

                    i = 0;
                    for (Persona object : list_employee) {
                        System.out.println(i + " " + object.getParam());
                        i += 1;
                    }

                }

                // Reload_type_Employee
                if (command == 3) {
                    System.out.printf("Reload_type_Employee \n" +
                            "Enter Index Employee: ");
                    index = Integer.parseInt(scanner.nextLine());

                    System.out.printf(list_employee.get(index).getParam());

                    System.out.printf("Enter type_Employee \n" +
                            "1 - Employee \n" +
                            "2 - Manager \n" +
                            "3 - Other Employee \n");

                    command_next = Integer.parseInt(scanner.nextLine());

                    if (command_next == 1) {
                        list_employee.add(new Employee(
                                list_employee.get(index).getName(),
                                list_employee.get(index).getBirthday(),
                                list_employee.get(index).getDate_of_employment()));
                        list_employee.remove(index);


                    }

                    if (command_next == 2) {
                        list_employee.add(new Manager(
                                list_employee.get(index).getName(),
                                list_employee.get(index).getBirthday(),
                                list_employee.get(index).getDate_of_employment()));
                        list_employee.remove(index);
                    }

                    if (command_next == 3) {
                        list_employee.add(new Other_Employee(
                                list_employee.get(index).getName(),
                                list_employee.get(index).getBirthday(),
                                list_employee.get(index).getDate_of_employment()));
                        list_employee.remove(index);
                    }

                }

                // Set_Employee_for_Manager
                if (command == 4) {
                    System.out.printf("Set_Employee_for_Manager \n" +
                            "Enter Index Manager: ");

                    index = Integer.parseInt(scanner.nextLine());

                    System.out.printf("\n Enter Index Employee: ");
                    index_next = Integer.parseInt(scanner.nextLine());

                    ((Manager) list_employee.get(index)).setList_employee(list_employee.get(index_next));
                    System.out.printf("\n Link ok \n ");

                }

                // Sort_List_for_Name
                if (command == 5) {
                    System.out.printf("Sort_List_for_Name \n");
                    Comparator<Persona> comparator = Comparator.comparing(obj -> obj.getName());
                    list_employee.sort(comparator);

                    i = 0;
                    for (Persona object : list_employee) {
                        System.out.println(i + " " + object.getParam());
                        i += 1;
                    }

                }

                // Sort_List_for_Date_of_employment
                if (command == 6) {
                    System.out.printf("Sort_List_for_Date_of_employment \n");

                    Comparator<Persona> comparator_date = Comparator.comparing(obj -> obj.getDate_of_employment());
                    list_employee.sort(comparator_date);

                    i = 0;
                    for (Persona object : list_employee) {
                        System.out.println(i + " " + object.getParam());
                        i += 1;
                    }

                }

                //исключение, если команда не 1, 2, 3
                if (command != 0 & command != 1 & command != 3 & command != 4 & command != 5 & command != 6 & command != 7) {
                    System.out.println("Error: wrong command\n Specify another command\n");
                }

            } catch (NumberFormatException e) {
                System.err.println("Error: wrong command\n Specify another command\n");

            }

        }

        System.out.println("Goodbye\n");
    }

}
