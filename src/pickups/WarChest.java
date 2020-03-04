package pickups;
import openable.Openable;
import openable.Opener;
/**
 * This is a description of WarChest class.
 * This class gives the description of a war chest.
 *
 * @author jullanq
 */
public class WarChest extends Openable
{
    /**
     * An overridden method from openable class.
     * @param opener
     */
    @Override
    public void unlockWith(Opener opener) {};

    //A constructor that gives the description of a war chest.
    public WarChest(Pickup content)
    {
        super(content, "War Chest");
    }


}
