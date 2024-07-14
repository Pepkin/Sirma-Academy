import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.StringTemplate.STR;

public class Employee implements Serializable {
    private String id;
    private String name;
    private String startDate = new SimpleDateFormat("dd-MM-yy").format(new Date());
    private String endDate = null;
    private String department;
    private String role;
    private double salary;

    public Employee(String id, String name, String endDate, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }


    public Employee(String nameChange, String departmentChange, String roleChange, double salaryChange){
        this.name = nameChange;
        this.department = departmentChange;
        this.role = roleChange;
        this.salary = salaryChange;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate.trim();
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return STR."\{this.id}, \{this.name},\{this.startDate}, \{this.endDate}, \{this.department}, \{this.role}, \{this.salary}";
    }
}
