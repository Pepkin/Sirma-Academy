import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader implements Reader {
    @Override
    public List<Employee> read(String filePath) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                String id = data[0];
                String name = data[1];
                String department = data[2];
                String role = data[3];
                double salary = Double.parseDouble(data[4].replace(",","."));
                Employee employee = new Employee(
                        id, name, department, role, salary);
                employees.add(employee);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
