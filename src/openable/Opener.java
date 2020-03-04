package openable;
import pickups.Pickup;
/**
 * This is a description of the Opener abstract class.
 * This is a subclass of Pickup and this gives a descriptions of all the
 * item that are opener such a key or lockpick.
 *
 * @author jullanq
 */
public abstract class Opener extends Pickup
{
    public Opener(String descriptions)
    {
        super(descriptions);
    }
}
