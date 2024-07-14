import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DatabaseWriter implements Writer {
    @Override
    public void write(String filePath, List<Employee> employees) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath) {
        })) {
            int size = employees.size();
            for (int i = 0; i < size; i++) {
                Employee employee = employees.get(i);
                bw.write(String.format("%s,%s,%s,%s,%s,%s,%.2f",
                        employee.getId(), employee.getName(), employee.getStartDate(), employee.getEndDate(), employee.getDepartment(),
                        employee.getRole(), employee.getSalary()));
                if (i < size - 1) {
                    bw.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}