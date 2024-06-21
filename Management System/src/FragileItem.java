public class FragileItem extends InventoryItem {
    private String category;

    public FragileItem(String itemID, int quantity, double price) {
        super(itemID, quantity, price);
    }

    @Override
    public double getValue() {
        return getQuantity() * getPrice();
    }

    @Override
    public String HowToHandle() {
        return "Handle with care";
    }

    @Override
    public String getCategory() {
        return "Fragile";
    }

    @Override
    public boolean isBreakable() {
        return true;
    }
}
