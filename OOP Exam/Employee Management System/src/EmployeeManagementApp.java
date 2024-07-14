import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args){
        DatabaseReader fileReader = new DatabaseReader();
        DatabaseWriter fileWriter = new DatabaseWriter();
        Service service = new Service(fileReader, fileWriter);
        Manager manager = new Manager(service);
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Employee Management System");

        boolean isRunning = true;

        while(isRunning){

            displayCommands();
            String[] command = sc.nextLine().split(" ");

            if(!command[0].equalsIgnoreCase("exit")){
                manager.execute(command);
            }else{
                break;
            }

        }


    }

    public static void displayCommands(){
        System.out.println("Enter Command: Add, Edit, Fire, List, Search, Exit");
    }
}

