import java.util.ArrayList;
import java.util.List;

public class DistributionNetwork {

    List<FoodHub> allHubs = new ArrayList<>();

    public void addHub(FoodHub hubToBeAdded) {
        allHubs.add(hubToBeAdded);
    }

    public void transferInventory(FoodHub fromHub, FoodHub toHub, FoodType product, int qty) {
        fromHub.removeFromInventory(product, qty);
        toHub.addToInventory(product, qty);
    }
}
