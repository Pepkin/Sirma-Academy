import java.util.UUID;

public class GroceryItem extends InventoryItem{
    private String category;
    public GroceryItem(String itemID, int quantity, double price) {
        super(itemID, quantity, price);
    }

    @Override
    public double getValue(){
        return getPrice() * getQuantity();
    }

    @Override
    public String getCategory() {
        return "Grocery";
    }

    @Override
    public boolean isPerishable() {
        return true;
    }
}
