
package gameplay;
import characters.*;
import com.sun.xml.internal.bind.v2.TODO;
import entities.*;
import pickups.Pickup;
import valuables.*;
import food.*;
import wieldable.FistsOfFury;
import wieldable.Wieldable;

import java.lang.Character;
import java.util.Scanner;
/**
 * This a description of the World class.
 * This class is where the main method is executed and where the game
 * starts, with all the commands.
 *
 * @author jullanq
 */
public class World 
{
	public enum PlayMode {battle,explore;}
	private PlayMode mode;
	private Player player;
	private Room currentRoom;
	private boolean gameInProgress = true;

	public World(Room room)
	{
		this.currentRoom = room;
		this.mode = PlayMode.battle;
		this.mode = PlayMode.explore;
	}

	private void setPlayer(Player player) {
		this.player = player;
	}

	private Player getPlayer() {
		return this.player;
	}


	//--------------------------------------------------------	
	private void play(Player player)
	{
		// THIS IS IMPORTANT
		this.setPlayer(player);

		System.out.println("Welcome player "+this.getPlayer().getName());
		System.out.println(""+this.player.getName()+" is wearing "+this.player.getArmour()+"");
		System.out.println(("Health: "+player.getHealthPoints()+" Confidence: "+player.getConfidenceValue()+" Wielding: "+player.getWeapon()+" "));
		this.onEnterRoom();

		while(gameInProgress)
		{
			switch(this.mode)
			{
			case explore:
				processExploreUserInput();
				break;
			case battle:
				processBattleUserInput();
				break;
			}

		}
	}
	//--------------------------------------------------------	
	private void onEnterRoom()
	{
		Monster monster = this.currentRoom.getMonster();
		if(monster!=null)
		{ 
			boolean appears = monster.appear();
			if(appears)
			{
				readyBattleMode();
			}
			else
			{
				readyExploreMode();
			}
		}
	}

	private void readyBattleMode()
	{
		processBattleUserInput();
	}
	private void readyExploreMode()
	{
		processExploreUserInput();
	}
	private void processExploreUserInput()
	{
		Scanner userInput = new Scanner(System.in);
		String inputCmd = userInput.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(" ");

		switch(tokens[0])
		{
			case "door":
				// pickup the door number from the user input
				int doorNumber = Integer.parseInt(tokens[1]) - 1;
				int doorNumberPrint = doorNumber + 1;
				if(this.currentRoom.getConnectingRooms() != null ) {
					Room[] connectingRooms = this.currentRoom.getConnectingRooms();

					if(doorNumber <= connectingRooms.length) {
						System.out.println(this.player.getName() + " bravely opens door " + doorNumberPrint);
						this.currentRoom = connectingRooms[doorNumber];
						System.out.println(this.currentRoom.getDescription());
					}
				}
				this.currentRoom.getMonster().appear();
				System.out.println("A "+this.currentRoom.getMonster().getMonsterName()+" draw hither! ");
				String weaponReady = tokens[1];
				weapon(weaponReady);
				System.out.println(""+this.player.getName()+" wields "+this.player.getWeapon()+" and is ready for battle.");
				this.onEnterRoom();
				break;
			case "pickup":
				String item = tokens[1];
				pickup(item);
				System.out.println(this.player.getName() + " picks up the " + this.player.getInventory().select(item));
				break;
			case "admire":
				String valuable = tokens[1];
				admire(valuable);
				System.out.println(this.player.getName() + " admires " + this.isItemInRoom(valuable).getDescription());
				break;
			case "exit":
				System.out.println(""+this.player.getName()+" searched everywhere for the exit...");
				System.out.println("  ...and behold,found it.");
				System.out.println("Well done Brave "+this.player.getName()+".");
				System.out.println("Your quest has now ended.");
				break;
			case "describe":
				System.out.println(this.currentRoom.getDescription());

				for(Pickup p : this.currentRoom.getPickupsInRoom().getItems()) {
					System.out.println("There is a " + p + " on the floor.");
				}
				int total = this.currentRoom.getConnectingRooms().length;
				System.out.println("There is " +total+ " door.");
				break;
			case "eat":
				String food = tokens[1];
				eat(food);
			System.out.println("Brave "+this.player.getName()+" ate the "+this.player.getInventory().select(food)+"");
				break;
			case "mobile": //for ENSE501 students only
				break;
			case "stats":
				System.out.println(""+this.player.getName()+" is wearing "+this.player.getArmour()+"");
				System.out.println(("Health: "+player.getHealthPoints()+" Confidence: "+player.getConfidenceValue()+" Wielding: "+player.getWeapon()+" "));
				System.out.println("Brave " + this.player.getName() + " is carrying the following items: " + this.player.getInventory()+ "");
				break;
			case "wield":
				String weapon = tokens[1];
				weapon(weapon);
				System.out.println("Brave "+this.player.getName()+" wields the "+this.player.getInventory().select(weapon)+"");
				break;
			case "help":
				System.out.println("Explore commands: admire, describe, door, eat, exit, help, mobile, open, pickup, quit, stats, wield");
				break;
			case "open":

				break;
			case "quit":
				System.out.println("Player has quit the game.");
				break;
			default:
				break;
		}

	}
	private void processBattleUserInput()
	{
		Scanner userInput = new Scanner(System.in);
		String inputCmd = userInput.next();
		String[] tokens = inputCmd.toLowerCase().split(" ");

		switch(tokens[0])
		{
			case "attack":
				if(this.player.getHealthPoints() > 0) {
					System.out.println("" + this.player.getName() + " attack " + this.currentRoom.getMonster().getDescription() + "");
					System.out.println("" + this.currentRoom.getMonster().getDescription() + " sustains " + this.currentRoom.getMonster().getAmountOfDamage() + " damage.");
					System.out.println("The " + this.currentRoom.getMonster().getMonsterName() + " attacks!");
					System.out.println("" + this.player.getName() + " had sustained " + this.player.defendAttack(this.currentRoom.getMonster()) + " damage!");
					int newHealthPoint = (this.player.getHealthPoints()) - this.player.defendAttack(this.currentRoom.getMonster());
					this.player.setHealthPoints(newHealthPoint);
				}
				else
				{
					System.out.println(""+this.player.getName()+" is wearing "+this.player.getArmour()+"");
					System.out.println(("Health: "+player.getHealthPoints()+" Confidence: "+player.getConfidenceValue()+" Wielding: "+player.getWeapon()+" "));
					System.out.println("Alas! "+this.player.getName()+" has been defeated!");
					System.out.println("You have failed your quest");
				}
				break;
			case "wield":
				String weapon = tokens[1];
				weapon(weapon);
				System.out.println("Brave "+this.player.getName()+" wields the "+this.player.getInventory().select(weapon)+"");
				break;
			case "help":
				System.out.println("Battle commands: attack, wield, help, quit");
				break;
			case "quit":
				System.out.println(""+this.player.getName()+" searched everywhere for the exit...");
				System.out.println("  ...and behold,found it.");
				System.out.println("Well done Brave "+this.player.getName()+".");
				System.out.println("Your quest has now ended.");

				break;
			default:
				//do nothing
				break;

		}
	}

	private void pickup(String item)
	{
		Pickup itemInRoom = isItemInRoom(item);

		if(itemInRoom != null) {
			currentRoom.getPickupsInRoom().remove(itemInRoom);
			this.getPlayer().getInventory().add(itemInRoom);
		}
	}

	private void eat(String food) {

		Pickup pickupFood = this.getPlayer().getInventory().select(food);

		if(pickupFood instanceof Food)
		{
			Food foodInventory = (Food) pickupFood;
			this.getPlayer().eat(foodInventory);
		}

	}

	private void weapon(String weapon)
	{
		Pickup wieldWeapon = this.getPlayer().getInventory().select(weapon);

		if(wieldWeapon instanceof Wieldable)
		{
			Wieldable wieldWeapons = (Wieldable) wieldWeapon;
			this.getPlayer().setWeapon(wieldWeapons);
		}
	}


	private void admire(String item)
	{
		Pickup pickup = this.getPlayer().getInventory().select(item);

		if(pickup instanceof Valuable)
		{
			Valuable valuable = (Valuable) pickup;
			this.getPlayer().admire(valuable);
		}

	}
	private Pickup isItemInRoom(String item) {

		Pickup[] pickups = currentRoom.getPickupsInRoom().getItems();

		for(int i = 0; i <= pickups.length - 1; i++) {
			String inventory = pickups[i].getId();
			if(inventory.equalsIgnoreCase(item)) {
				return pickups[i];
			}
		}
		return null;
	}
	//--------------------------------------------------------
	public static void main(String[] args) 
	{
		World world = ReadWorldDataFile.simpleWorld();
		Player playerOne = new Player("Sir Kendric","Shiny Armour",100,50);
		world.play(playerOne);
	}
	//--------------------------------------------------------
}
