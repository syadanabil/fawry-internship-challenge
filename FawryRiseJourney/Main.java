package FawryRiseJourney;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Define products
        Product cheese = new Product("Cheese 400g", 100, 5, true, false, true, 0.2);
        Product biscuits = new Product("Biscuits 700g", 150, 2, true, false, true, 0.7);
        Product scratchCard = new Product("Scratch Card", 50, 10, false, false, false, 0);
        // Define customer and cart
        Customer customer = new Customer("Syada", 500);
        Cart cart = new Cart();
        //Add products to cart
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        // Check if cart is empty
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        double subtotal = 0;
        double shipping = 30;
        double totalWeight = 0;
        List<Shippable> itemsToShip = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product p = item.product;

            if (p.isExpired()) {
                System.out.println("Error: Product " + p.getName() + " is expired.");
                return;
            }

            if (item.quantity > p.getQuantity()) {
                System.out.println("Error: Not enough stock for " + p.getName());
                return;
            }

            subtotal += item.getTotalPrice();
            if (p.requiresShipping()) {
                itemsToShip.add(p);
                totalWeight += item.getTotalweight();
            }

            p.decreaseQuantity(item.quantity);
        }

        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // Shipment notice
        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            if (item.product.requiresShipping()) {
                System.out.println(item.quantity + "x " + item.product.getName());
            }
        }
        System.out.printf("Total package weight is "+ totalWeight + " \n");

        // Checkout receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("--------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shipping);
        System.out.println("Amount " + total);
        customer.pay(total);
        System.out.println("Customer balance after payment: " + customer.getBalance());
    }
}
