package FawryRiseJourney;
import java.util.*;
public class Cart {
    private List<CartItem>items=new ArrayList<>();
    public  boolean add(Product product,int quantity){
     if(quantity<=0||quantity> product.getQuantity()){
         System.out.println("invalid quantity");
         return false;
     }
     items.add(new CartItem(product,quantity));
     return true;
    }

    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
