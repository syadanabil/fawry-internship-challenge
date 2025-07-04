package FawryRiseJourney;
import java.util.*;
public class ShippingService {
    public static void ship(List<Shippable>items){
        System.out.println("**shipment**");
        double totalWeight=0;
        for(int i=0;i<items.size();i++){
            Shippable item=items.get(i);
            System.out.println("- "+item.getName());
            totalWeight = totalWeight+ item.getweight();
        }
        System.out.println("total weight is" +totalWeight);


    }
}
