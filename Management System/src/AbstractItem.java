import java.io.Serializable;
import java.util.Date;

abstract class AbstractItem implements ItemProps, Breakable, Categorizable, Perishable, Sellable, Serializable {
    private String name = "";
    private String description = "";
    private int quantity = 0;
    private double price = 0;
    private String category = "none";
    private boolean breakable = false;
    private boolean perishable = false;

    @Override
    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public String expireDate() {
        Date date = new Date();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear() + 1;
        return (day + " " + month + " " + year);
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public void setBreakable(boolean isBreakable) {
        this.breakable = isBreakable;
    }

    @Override
    public String HowToHandle() {
        return "";
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice(){
        return this.price;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public void showDescription() {
        System.out.println(description);
    }

    @Override
    public double getValue() {
        return price * quantity;
    }
}
