import java.util.Date;

public class InventoryItem extends AbstractItem{
    private String itemID;
    private int quantity;
    private double price;

    public InventoryItem(){

    }

    public InventoryItem(String itemID, int quantity, double price) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemID() {
        return itemID;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
