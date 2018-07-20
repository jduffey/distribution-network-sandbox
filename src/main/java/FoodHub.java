import java.util.HashMap;
import java.util.Map;

public class FoodHub {

    Map<FoodType, Integer> inventory = new HashMap<>();

    public void addToInventory(FoodType product, int qty) {
        inventory.put(product, qty);
    }

    public int getQty(FoodType product) {
        return inventory.get(product);
    }

    public void removeFromInventory(FoodType product, int qty) {
        inventory.put(product, inventory.get(product) - qty);
    }
}
