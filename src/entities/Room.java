package entities;
import characters.Monster;
import gameplay.Inventory;
/**
 * This is a description of Room.
 * This is a class that gives the description of the room in the world game.
 *
 * @author jullanq
 */
public class Room extends Entity
{
    private Monster monster;
    private Inventory pickupsInRoom;
    private Room[] connectingRooms;
    private boolean finalRoom;

    /**
     * A get method for pickupsInRoom.
     * @return pickupsInRoom
     */
    public Inventory getPickupsInRoom() {
        return pickupsInRoom;
    }
    /**
     * A set method for pickupsInRoom.
     * @param pickupsInRoom
     */
    public void setPickupsInRoom(Inventory pickupsInRoom) {
        this.pickupsInRoom = pickupsInRoom;
    }
    /**
     * A get method for monster.
     * @return the monster in the game.
     */
    public Monster getMonster() {
        return monster;
    }
    /**
     * A set method for monster
     * @param monster
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    /**
     * A get method for finalRoom
     * @return the final room
     */
    public boolean isFinalRoom() {
        return finalRoom;
    }
    /**
     * A set method for finalRoom
     * @param finalRoom
     */
    public void setFinalRoom(boolean finalRoom) {
        this.finalRoom = finalRoom;
    }
    /**
     * A get method for connectingRoom
     * @return connectingRooms
     */
    public Room[] getConnectingRooms() {
        return connectingRooms;
    }
    /**
     * A set method for connectingRoom
     * @param connectingRooms
     */
    public void setConnectingRooms(Room[] connectingRooms) {
        this.connectingRooms = connectingRooms;
    }

    //a constructor that gives the descriptions of the rooms.
    public Room(String description, Inventory pickupsInRoom, Room[] connectingRooms)
    {
        super(description);
        this.pickupsInRoom =pickupsInRoom;
        this.connectingRooms = connectingRooms;
    }

    //a default constructor for Room class
    public Room()
    {
        this.monster = null;
        this.pickupsInRoom = null;
        this.connectingRooms = null;
        this.finalRoom = false;
    }

}
