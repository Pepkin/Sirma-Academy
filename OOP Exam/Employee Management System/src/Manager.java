import java.io.File;
import java.util.Scanner;

public class Manager {
    Service service;
    Scanner scanner = new Scanner(System.in);

    public Manager(Service service) {
        this.service = service;
    }


    public void execute(String[] command) {
        File file = new File("employees.csv");
        if (file.exists()) {
            this.service.initialize();
        }

        switch (command[0].toLowerCase()) {
            case "add":
                Add();
                break;
            case "edit":
                Edit(command[1]);
                break;
            case "fire":
                Fire(command[1]);
                break;
            case "list":
                List();
                break;
            case "search":
                Search(command[1], command[2]);
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    public void Add(){
        System.out.println("Enter: Id, Name, Department, Role, Salary");
        String[] input = scanner.nextLine().split(", ");
        String id = input[0];
        String name = input[1];
        String department = input[2];
        String role = input[3];
        double salary = Double.parseDouble(input[4]);
        Employee employee = new Employee(id, name, department, role, salary);
        this.service.addEmployee(employee);
    }

    public void Edit(String id){
        String[] inputChange = scanner.nextLine().split(", ");
        System.out.println("Enter Name, Department, Role, Salary ");
        String nameChange = inputChange[0];
        String departmentChange = inputChange[1];
        String roleChange = inputChange[2];
        double salaryChange = Double.parseDouble(inputChange[3]);
        Employee employeeChange = new Employee(nameChange, departmentChange, roleChange, salaryChange);
        this.service.editEmployee(id, employeeChange);
    }

    public void Fire(String id){
        this.service.fireEmployee(id);
        this.service.saveData("employees.csv");
    }

    public void List(){
        this.service.listEmployees();
    }

    public void Search(String type, String query){
        this.service.searchEmployees(type, query);
    }
}
