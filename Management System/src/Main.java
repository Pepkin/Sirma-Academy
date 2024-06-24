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
            System.out.println("2. See all items");
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
                    placeOrder();
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
                    addProduct("Normal");
                    break;
                case "2":
                    addProduct("Electronics");
                    break;
                case "3":
                    addProduct("Grocery");
                    break;
                case "4":
                    addProduct("Fragile");
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
    public static void addProduct(String category) {
        String path = "D:\\Petko\\SirmaAcademy\\Sirma Academy\\Management System\\items.ser";
        System.out.println("Enter the desired product in the following order separated by space: name quantity price");
        System.out.println("Write \"End\" when you want to exit");
        Scanner sc = new Scanner(System.in);
        String[] command = sc.nextLine().split(" ");
        boolean append = new File(path).exists();

        while (!command[0].equals("End")) {
            try (FileOutputStream fos = new FileOutputStream(path, true);
                 ObjectOutputStream oos = append ? new AppendingObjectOutputStream(fos) : new ObjectOutputStream(fos)) {

                String name = command[0];
                int quantity = Integer.parseInt(command[1]);
                double price = Double.parseDouble(command[2]);
                InventoryItem item = null;

                switch (category) {
                    case "Normal":
                        item = new InventoryItem(name, quantity, price);
                        break;
                    case "Electronics":
                        item = new ElectronicsItem(name, quantity, price);
                        break;
                    case "Grocery":
                        item = new GroceryItem(name, quantity, price);
                        break;
                    case "Fragile":
                        item = new FragileItem(name, quantity, price);
                        break;
                }

                if (item != null) {
                    oos.writeObject(item);
                }

            } catch (IOException e) {
                throw new RuntimeException("Error writing to file", e);
            }

            command = sc.nextLine().split(" ");
            append = true;
        }

    }

    //I have used external sources to help me write this part of the code
    private static class AppendingObjectOutputStream extends ObjectOutputStream {
        public AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }

    public static void seeAllItems() {
        List<InventoryItem> loadedItems = loadItems();

        if (loadedItems != null) {
            for (InventoryItem oneItem : loadedItems) {

                if (oneItem.isBreakable()) {
                    System.out.println(STR."Name: \{oneItem.getItemID()} Quantity: \{oneItem.getQuantity()} Price: \{oneItem.getPrice()} Category: \{oneItem.getCategory()} How to handle: \{oneItem.HowToHandle()}");
                } else if (oneItem.isPerishable()) {
                    System.out.println(STR."Name: \{oneItem.getItemID()} Quantity: \{oneItem.getQuantity()} Price: \{oneItem.getPrice()} Category: \{oneItem.getCategory()} Expire Date: \{oneItem.expireDate()}");
                } else {
                    System.out.println(STR."Name: \{oneItem.getItemID()} Quantity: \{oneItem.getQuantity()} Price: \{oneItem.getPrice()} Category: \{oneItem.getCategory()}");
                }

            }

        }
    }

    public static List<InventoryItem> loadItems(){
        List<InventoryItem> loadedItems = new ArrayList<>();
        String path = "D:\\Petko\\SirmaAcademy\\Sirma Academy\\Management System\\items.ser";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            while (true) {
                try {
                    InventoryItem obj = (InventoryItem) ois.readObject();
                    loadedItems.add(obj);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedItems;
    }

    public static void placeOrder() {
        //1. Load all items
        String path = "D:\\Petko\\SirmaAcademy\\Sirma Academy\\Management System\\items.ser";
        List<InventoryItem> loadedItems = loadItems();

        //2.Select item.Name == list.getKey()
        System.out.println("Select which item you want and the value you want it:");
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String itemName = input[0];
        int itemQuantity = Integer.parseInt(input[1]);
        double value = 0;
        boolean append = new File(path).exists();

        //3. item.setQuantity - 1; if(quan == 0) -> remove from list remove(item.getName)
        for (InventoryItem item : loadedItems) {
            if (item.getItemID().equals(itemName)) {
                int newQuantity = item.getQuantity() - itemQuantity;
                value = itemQuantity * item.getPrice();
                item.setQuantity(newQuantity);
                if(item.getQuantity() == 0){
                    loadedItems.remove(item);
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (InventoryItem item : loadedItems) {
                oos.writeObject(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4. Calculate value
        System.out.println("It will cost you: " + value);
        //5. Choose Card or Cash
        System.out.println("Cash or Card?");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        Scanner lol = new Scanner(System.in);
        int yes = Integer.parseInt(lol.nextLine());
        //6. "Pay"
        System.out.println("Paying...");
        System.out.println("Paid");
    }

}