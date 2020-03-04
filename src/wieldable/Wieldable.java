package wieldable;
import pickups.Pickup;
/**
 * This is a description of the Wieldable class.
 * This class gives the descriptions of the wieldable pickups available
 * in the game.
 *
 * @author jullanq
 */
public abstract class Wieldable extends Pickup
{
    private int low;
    private int high;
    /**
     * A get method for high.
     * @return the maximum damage dealt by the weapon.
     */
    public int getHi() {
        return high;
    }
    /**
     * A get method for low.
     * @return the minimum damage by the weapon.
     */
    public int getLo() {
        return low;
    }
    /**
     * hit method represents the strength of the weapon
     * @return a random number representing the damage that can be
     * dealt by a specific weapon.
     */
    public int hit()
    {
        int random = this.randomNumber(low, high);

        if(random >= low && random > high)
        {
            return random;
        }
        else
        {
            return hit();
        }

    }

    //A constructor gives the description of the wieldable weapons.
    public Wieldable(String descriptions,int low, int high)
    {
        super(descriptions);
        this.low = low;
        this.high = high;
    }
}
