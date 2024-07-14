import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    private final List<Employee> employees = new ArrayList<>();
    private final DatabaseReader fileReader;
    private final DatabaseWriter fileWriter;
    private final String filePath = "employees.csv";
    private boolean isInitialized = false;

    //Constructor
    public Service(DatabaseReader fileReader, DatabaseWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        initialize();
    }

    //Opens the file and allows it to be modified
    public void initialize() {
        if (!isInitialized) {  // initialize only if not done before
            File file = new File(filePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            employees.addAll(fileReader.read(filePath));
            isInitialized = true;
        }
    }

    //Saves the data in the file
    public void saveData(String filePath) {
        fileWriter.write(filePath, employees);
    }

    //Adds an Employee to the Database
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    //Edits the Employee information
    public void editEmployee(String id, Employee newDetails) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(newDetails.getName());
                employee.setDepartment(newDetails.getDepartment());
                employee.setRole(newDetails.getRole());
                employee.setSalary(newDetails.getSalary());
                return;
            }else{
                System.out.println("Employee not found.");
            }
        }

    }

    //Lists all employees that are not Fired
    public void listEmployees() {
        for (Employee employee : employees){

            if(employee.getEndDate() == null || employee.getEndDate().equals("null")){
                System.out.println(employee);
            }else{

            }

        }

    }

    //Fires an Employee
    public void fireEmployee(String id) {
        for (Employee employee : employees) {

            if (employee.getId().equals(id)) {
                DateFormat data = new SimpleDateFormat("dd-MM-yy");
                Date obj = new Date();
                employee.setEndDate(data.format(obj));
                break;
            }

        }

        System.out.println("Employee not found!");

    }

    //Searches an Employee by: Name, Department or Id and if that Employee is still employed is displayed
    public void searchEmployees(String where, String what) {
        boolean nothingFound = true;
        for (Employee employee : employees) {
            if ((where.equalsIgnoreCase("name") && employee.getName().equalsIgnoreCase(what))
                    || (where.equalsIgnoreCase("id") && employee.getId().equalsIgnoreCase(what))
                    || (where.equalsIgnoreCase("department") && employee.getDepartment().equalsIgnoreCase(what))) {

                if(employee.getEndDate().equals("null")){
                    System.out.println(employee);
                    nothingFound = false;
                }

            }
        }
        if(nothingFound){
            System.out.println("Nothing found");
        }
    }
}