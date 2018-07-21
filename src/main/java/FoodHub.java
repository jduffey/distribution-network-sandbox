import java.util.HashMap;
import java.util.Map;

public class FoodHub {
    HierarchyLevel level;

    Map<FoodType, Integer> inventory = new HashMap<>();

    public void setHierarchyLevel(HierarchyLevel level) {
        this.level = level;
    }

    public HierarchyLevel getHierarchyLevel() {
        return this.level;
    }

    public int getQty(FoodType product) {
        return inventory.get(product);
    }

    public void addToInventory(FoodType product, int qtyToAdd) {
        if (inventory.get(product) == null) {
            inventory.put(product, qtyToAdd);
        } else
            inventory.put(product, inventory.get(product) + qtyToAdd);
    }

    public void removeFromInventory(FoodType product, int qty) {
        if (qty > inventory.get(product)) {
            throw new ArithmeticException("Cannot remove more than what's in inventory.");
        } else
            inventory.put(product, inventory.get(product) - qty);
    }
}
