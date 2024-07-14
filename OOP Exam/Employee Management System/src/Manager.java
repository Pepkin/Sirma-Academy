import java.util.Scanner;

public class Manager {
    Service service;
    Scanner scanner = new Scanner(System.in);

    public Manager(Service service) {
        this.service = service;
    }


    public void execute(String[] command) {

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

        String[] input = new String[5];
        try{
            input = scanner.nextLine().split(", ");
            if (input.length != 5) {
                throw new IllegalArgumentException("Please enter exactly 5 values separated by commas.");
            }
        } catch (ArrayStoreException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        String id = input[0];
        String name = input[1];
        String department = input[2];
        String role = input[3];
        double salary;
        try {
           salary = Double.parseDouble(input[4]);
           if(salary >= 0){
               throw new RuntimeException("Salary must be a valid number.");
           }
        } catch (NumberFormatException e) {
            System.err.println("Salary must be a valid number.");
            return;  // Exit the method if salary is invalid
        }
        Employee employee = new Employee(id, name, null, department, role, salary);
        this.service.addEmployee(employee);
    }

    public void Edit(String id){
        System.out.println("Enter Name, Department, Role, Salary ");
        String[] inputChange = new String[4];
        try{
            inputChange = scanner.nextLine().split(", ");
            if (inputChange.length != 4) {
                throw new IllegalArgumentException("Please enter exactly 4 values separated by commas.");
            }
        }catch (ArrayStoreException e){
            System.err.println("Words should be separated with \", \"");
        }
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

    public void Search(String where, String what){
        this.service.searchEmployees(where, what);
    }
}
