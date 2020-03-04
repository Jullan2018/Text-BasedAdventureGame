package pickups;
/**
 * This is a description of the Consumable class.
 * The class takes the description of all object that is c
 * consumable.
 *
 * @author jullanq
 */
public abstract class Consumable extends Pickup
{
    private boolean objectConsumed;

    /**
     * A get method for objectConsumed.
     * @return the consumed object
     */
    public boolean isObjectConsumed() {
        return objectConsumed;
    }
    /**
     * A set method for objectConsumed.
     * @param objectConsumed
     */
    public void setObjectConsumed(boolean objectConsumed) {
        this.objectConsumed = objectConsumed;
    }

    //A constructor that gives the description of Consumable.
    public Consumable(String descriptions)
    {
        super(descriptions);
    }

}
