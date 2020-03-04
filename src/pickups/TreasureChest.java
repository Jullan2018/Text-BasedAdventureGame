package pickups;
import openable.Openable;
import openable.Opener;
/**
 * This is a description of TreasureChest class.
 * This class gives the description of a treasure chest.
 *
 * @author jullanq
 */
public class TreasureChest extends Openable
{
    //A constructor that gives the description of a treasure chest.
    public TreasureChest(Pickup content)
    {
        super(content, "Treasure Chest");
    }

    /**
     * An overridden method from openable class.
     * @param opener
     */
    @Override
    public void unlockWith(Opener opener) { }


}
