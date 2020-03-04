package valuables;
import pickups.Consumable;
/**
 * This is a description of Valuable class
 * This class gives the description of the specific valuable.
 *
 * @author jullanq
 */
public abstract class Valuable extends Consumable
{
    private int objectValue;
    /**
     * A get method for objectValue.
     * @return the object's value
     */
    public int getObjectValue() {
        return objectValue;
    }
    /**
     * A set method for objectValue.
     * @param objectValue
     */
    public void setObjectValue(int objectValue) {
        this.objectValue = objectValue;
    }
    //A constructor that gives the description of a specific valuable.
    public Valuable(String descriptions, int objectValue)
    {
        super(descriptions);
        this.objectValue = objectValue;
    }


}
