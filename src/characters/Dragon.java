package characters;
/**
 * A description of the Dragon class
 * This class gives the description of the specific monster.
 *
 * @author jullanq
 */
public class Dragon extends Monster
{
    //constructor that return the description of this Monster.
    public Dragon(int probability)
    {
        super("Dragon","Green dragon",100, probability, 0);
    }
}
