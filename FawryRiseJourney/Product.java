package FawryRiseJourney;

public class Product implements Shippable { //دي ال اتريبيوتس
    private String name;
    private double price;
    private int quantity;
    private boolean expirable;
    private boolean expired;
    private boolean requiresShipping;
    private double weight;

    public Product (String name, double price,int quantity,
                   boolean expirable,boolean expired, boolean requiresShipping,
                   double weight){ // دي ال كنسركتورز
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.expirable=expirable;
        this.expired=expired;
        this.requiresShipping=requiresShipping;
        this.weight=weight;

    }
    @Override
    public String getName(){
        return name;
    }
    public double getprice(){
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        return expirable && expired;
    }

    public boolean requiresShipping() {
        return requiresShipping;
    }
    @Override
    public double getweight() {
        return weight;
    }
    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }



}
