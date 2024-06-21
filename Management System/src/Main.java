import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            //1 Welcome - Ask what they want to do
            System.out.println("Storage Management System");
            System.out.println("Choose what do you want to do [1-4]");
            //--Add items - 2
            System.out.println("1. Add items");
            //--See all items - 3
            System.out.println("2. See all items"); //TO DO... Category is now showing, FIX IT
            //--Place Order
            System.out.println("3. Place order");
            //--Exit
            System.out.println("4. Exit");
            System.out.print("Tour Choice: ");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    seeAllItems();
                    break;
                case "3":
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }

        //3 See all items function
        //3.1 Deserialize every item in the files and add it to a List
        //3.2 Print all items
    }

    public static void addProduct() {
        boolean isRunning = true;
        while (isRunning) {
            //2 Determine the type of product they want to add
            System.out.println("What product do you want to add");
            System.out.println("Choose from [1-4]");
            System.out.println("1. Not specified");
            System.out.println("2. Electric");
            System.out.println("3. Grocery");
            System.out.println("4. Fragile");
            System.out.println();
            System.out.println("5. Back");
            System.out.print("Tour Choice: ");

            //2.1 Send them to appropriate place to help them add the items to the desired place

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    addNormalProduct();
                    break;
                case "2":
                    addElectricProduct();
                    break;
                case "3":
                    addGroceryProduct();
                    break;
                case "4":
                    addFragileProduct();
                    break;
                case "5":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }

        }

    }

    //2.2 Save the input in files every time they choose [Done]
    public static void addNormalProduct() {

        List<InventoryItem> list = loadItems("D:\\Petko\\SirmaAcademy\\Management System\\items.ser");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name, quantity and price of the item separated with an empty space:");
        System.out.println("Type \"End\" when you want to exit ");

        String inputLine = sc.nextLine();

        while (!inputLine.equals("End")) {
            String[] input = inputLine.split(" ");
            try {
                InventoryItem item = new InventoryItem(input[0], Integer.parseInt(input[1]), Double.parseDouble(input[2]));
                list.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter the data in the format: name quantity price");
            }

            inputLine = sc.nextLine();
        }

        saveItems(list, "D:\\Petko\\SirmaAcademy\\Management System\\items.ser");

    }

    public static void addElectricProduct() {
        List<InventoryItem> list = loadItems("D:\\Petko\\SirmaAcademy\\Management System\\electricItems.ser");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name, quantity and price of the item separated with an empty space:");
        System.out.println("Type \"End\" when you want to exit ");

        String inputLine = sc.nextLine();

        while (!inputLine.equals("End")) {
            String[] input = inputLine.split(" ");
            try {
                InventoryItem item = new ElectronicsItem(input[0], Integer.parseInt(input[1]), Double.parseDouble(input[2]));
                list.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter the data in the format: name quantity price");
            }

            inputLine = sc.nextLine();
        }

        saveItems(list, "D:\\Petko\\SirmaAcademy\\Management System\\electricItems.ser");
    }





    public static void addGroceryProduct() {

        List<InventoryItem> list = loadItems("D:\\Petko\\SirmaAcademy\\Management System\\groceryItems.ser");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name, quantity and price of the item separated with an empty space:");
        System.out.println("Type \"End\" when you want to exit ");

        String inputLine = sc.nextLine();

        while (!inputLine.equals("End")) {
            String[] input = inputLine.split(" ");
            try {
                InventoryItem item = new GroceryItem(input[0], Integer.parseInt(input[1]), Double.parseDouble(input[2]));
                list.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter the data in the format: name quantity price");
            }

            inputLine = sc.nextLine();
        }

        saveItems(list, "D:\\Petko\\SirmaAcademy\\Management System\\groceryItems.ser");

    }

    public static void addFragileProduct() {

        List<InventoryItem> list = loadItems("D:\\Petko\\SirmaAcademy\\Management System\\fragileItems.ser");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name, quantity and price of the item separated with an empty space:");
        System.out.println("Type \"End\" when you want to exit ");

        String inputLine = sc.nextLine();

        while (!inputLine.equals("End")) {
            String[] input = inputLine.split(" ");
            try {
                InventoryItem item = new FragileItem(input[0], Integer.parseInt(input[1]), Double.parseDouble(input[2]));
                list.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter the data in the format: name quantity price");
            }

            inputLine = sc.nextLine();
        }

        saveItems(list, "D:\\Petko\\SirmaAcademy\\Management System\\fragileItems.ser");
    }

    private static List<InventoryItem> loadItems(String filePath) {
        List<InventoryItem> items = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            items = (List<InventoryItem>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return items;
    }

    private static void saveItems(List<InventoryItem> items, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void seeAllItems() {
        List<InventoryItem> loadedItems = new ArrayList<>();
        String path1 = "D:\\Petko\\SirmaAcademy\\Management System\\items.ser";
        String path2 = "D:\\Petko\\SirmaAcademy\\Management System\\electricItems.ser";
        String path3 = "D:\\Petko\\SirmaAcademy\\Management System\\groceryItems.ser";
        String path4 = "D:\\Petko\\SirmaAcademy\\Management System\\fragileItems.ser";
        String[] paths = {path1, path2, path3, path4};

        for (String path : paths) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
                List<InventoryItem> items = (List<InventoryItem>) ois.readObject();
                loadedItems.addAll(items);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // Print the loaded persons
        if (loadedItems != null) {
            for (InventoryItem item : loadedItems) {

                if (item.isBreakable()){
                    System.out.println(STR."Name: \{item.getItemID()} Quantity: \{item.getQuantity()} Price: \{item.getPrice()} Category: \{item.getCategory()} How to handle: \{item.HowToHandle()}");
                } else if (item.isPerishable()) {
                    System.out.println(STR."Name: \{item.getItemID()} Quantity: \{item.getQuantity()} Price: \{item.getPrice()} Category: \{item.getCategory()} Expire Date: \{item.expireDate()}");
                }else{
                    System.out.println(STR."Name: \{item.getItemID()} Quantity: \{item.getQuantity()} Price: \{item.getPrice()} Category: \{item.getCategory()}");
                }

            }

        }
    }

}