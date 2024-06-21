import java.util.UUID;

public class ElectronicsItem extends InventoryItem{
    private String category;

    public ElectronicsItem(String itemID, int quantity, double price) {
        super(itemID, quantity, price);
        this.setBreakable(false);
        this.setPerishable(false);
    }

    @Override
    public double getValue(){
        return getPrice() * getQuantity();
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }


}
