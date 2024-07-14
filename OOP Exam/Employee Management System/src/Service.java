import java.io.File;
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

    public Service(DatabaseReader fileReader, DatabaseWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        initialize();
    }

    public void initialize() {
        if (!isInitialized) {  // initialize only if not done before
            employees.addAll(fileReader.read(filePath));
            isInitialized = true;
        }
    }

    public void saveData(String filePath) {
        fileWriter.write(filePath, employees);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

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


    public void listEmployees() {
        for (Employee employee : employees){
            if(employee.getEndDate().equals("null")){
                System.out.println(employee);
            }else{

            }
        }
    }

    public void fireEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                DateFormat data = new SimpleDateFormat("dd-MM-yy");
                Date obj = new Date();
                employee.setEndDate(data.format(obj));
                break;
            }
        }
    }

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