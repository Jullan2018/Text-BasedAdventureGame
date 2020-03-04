package food;
import pickups.Consumable;
/**
 * A description of the Food class
 * This class gives the description of the each food.
 *
 * @author jullanq
 */
public abstract class Food extends Consumable
{
    private int restoreHealthPoints;
    /**
     * A set method for the player's restored health
     * @param healthPoints
     */
    public void setHealthPoints(int healthPoints) {
        this.restoreHealthPoints = healthPoints;
    }
    /**
     * A get method for the player's restored health
     * @return the restored health point
     */
    public int getHealthPoints() {
        return restoreHealthPoints;
    }

    //A constructor that gives the description of each food.
    public Food(String description) {
        super(description);
    }
}
