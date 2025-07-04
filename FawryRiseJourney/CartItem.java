package FawryRiseJourney;

public class CartItem {
    Product product;
    int quantity;
    public CartItem(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    public double getTotalPrice(){
        return product.getprice()*quantity;
    }
    public double getTotalweight(){
        return product.requiresShipping()? product.getweight() *quantity:0;
    }
}
