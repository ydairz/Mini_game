Student name: Yasir Mohamed Dahir
Student number: 190009658
Skype name: live:ydair

Please run the program using the MainMethod class.

LEVEL YOU WISH THE MINI-PROJECT TO BE MARKED FOR: 1,  2 and 3

LEVEL ONE

I have superclasses (13 in total) called [Warrior, Mage, Marksman, RoomOne, RoomTwo, RoomThree, RoomFour, RoomFive, RoomSix, RoomSeven, RoomEight, RoomNine and RoomTen]
This superclass is extended into at least three subclasses called [Player and Rooms]

Subclasses - Warrior, Mage and Marksman.

Subclasses [Warrior, Mage and Marksman] extends the superclass by adding multiple properties and getters and setters from its superclass [Player]. The name(s) of the attributes inherited by this subclass are [maxHP, currentHP, maxMP, currentMP, AD, critChance, exp, gold, consumablesHP, consumablesMP, eliminations, S#Unlock (# = 1,2,3), S#Active (# = 1,2,3), inventory]
These/this new properties/property are used by the subclass in the following way:
[
These attributes are the stats of the playable character.
MaxHP - shows the maximum health capacity of the player.
CurrentHP - shows the current health of the player. If this falls to 0, the game will end.
MaxMP - shows the maximum mana capacity of the player.
CurrentMP - shows the current mana of the player. If this falls to 0, the player will not be able to use any of the available skills in the game.
AD - the attack damage of the player.
critChance - used to determine if the player's attack will critically strike (which allows the player to deal double damage)
exp - shows the players experience points. When the player reaches 100 exp, the player's base stats will be increased by an amount.
consumablesHP/MP - shows the number of consumables the player owns.
eliminations - shows the number of enemies the player has defeated.
S#Unlock - used to determine if the player owns a skill or not.
s#Active - used to determine if the player has a skill active or not.
inventory - an array list that is used as an inventory system in the game.
]
Subclass [Warrior, Mage and Marksman] extends the superclass by overriding 3 methods; these methods are the different skills the player can obtain. The following methods:
[
skillOne method - 12 lines for Warrior and Mage subclasses, 3 lines for Marksman subclass. 
skillTwo method - 2 lines for all three subclasses.
skillThree method - 1 line for Warrior subclass, 2 lines for Mage subclass and Marksman subclass.
]
These overridden methods are used in the working code in the following places:
[
all methods are three lines of code...
public void reduceHPviaSkillOne(Player player, JTextArea text) in the Enemies class
public void reduceHPviaSkillTwo(Player player, JTextArea text) in the Enemies class 
public void reduceHPviaSkillThree(Player player, JTextArea text)
public void reduceHPviaSkillOneTwo(Player player, JTextArea text)
public void reduceHPviaSkillOneThree(Player player, JTextArea text)
public void reduceHPviaSkillTwoThree(Player player, JTextArea text)
public void reduceHPviaSkillOneTwoThree(Player player, JTextArea text)

These methods will determine how much damage the player will deal to an enemy based on the skill/skills that the player has active at the time of combat.
]

Subclasses - RoomOne, RoomTwo, RoomThree, RoomFour, RoomFive, RoomSix, RoomSeven, RoomEight, RoomNine and RoomTen.

Subclass [RoomOne, RoomTwo, RoomThree, RoomFour, RoomFive, RoomSix, RoomSeven, RoomEight, RoomNine and RoomTen] extends the superclass by adding multiple attributes and getters and setters from its superclass Rooms. The name(s) of the added attributes are
[
roomNumber - which indicates the room's number that the player is in.
enemyCount - shows the number of enemies in the room.
lootable - used to determine if the room is lootable.
enemy - an array that contains all the enemies in a room.
]
These subclasses extends the superclass "Rooms" by overriding the following method:
[
pickUpLoot method - 1 line for RoomOne, RoomTwo, RoomFive. 2 Lines for RoomFour, RoomSix, RoomEight and RoomTen. 3 lines for RoomThree, RoomSeven. 4 Lines for RoomNine.
]
These overridden methods are used in the working code in the following places:
[
room.searchRoom(player, "There seems to be something hidden in the room"); ----->>> public void searchRoom(Player player, String message)
the searchRoom method contains the pickUpLoot method, which will allow the player to pick up the lootable items from a chosen room.
]

LEVEL TWO

[
Polymorphism is a concept in Object-Oriented programming where a class (subclass) can inherit attributes and methods from another class (a superclass).
While the attributes are universaly the same for in the subclasses, the inherited methods to perform different outcomes.
Thus, a single actions can be performed leading to different outcomes.
]

[
public class Warrior extends Player - the warrior class will inherit all the attributes and methods from the player class.
public class Mage extends Player - the warrior class will inherit all the attributes and methods from the player class.
public class Marksman extends Player - the warrior class will inherit all the attributes and methods from the player class.
public class RoomOne extends Rooms - the RoomOne inherits the methods and attributes from Rooms.
public class RoomTwo extends Rooms - the RoomTwo inherits the methods and attributes from Rooms.
public class RoomThree extends Roomss - the RoomThree inherits the methods and attributes from Rooms.
public class RoomFour extends Roomss - the RoomFour inherits the methods and attributes from Rooms.
public class RoomFive extends Roomss - the RoomFive inherits the methods and attributes from Rooms.
public class RoomSix extends Roomss - the RoomSix inherits the methods and attributes from Rooms.
public class RoomSeven extends Roomss - the RoomSeven inherits the methods and attributes from Rooms.
public class RoomEight extends Roomss - the RoomEight inherits the methods and attributes from Rooms.
public class RoomNine extends Roomss - the RoomNine inherits the methods and attributes from Rooms.
public class RoomTen extends Roomss - the RoomTen inherits the methods and attributes from Rooms.
]

[
Instead of writing new methods and attributes for each subclass, I can reuse methods and attributes of an existing class.
For example, each of the skills that the subclasses of the Player class have all do different actions. For simplicity, instead of creating new methods for each skill,
the same method calls are used , the method will do a unique actions based on the reference of the object (either a reference to Warrior, Mage or Marksman). 
]

LEVEL THREE

InputClass class:
Java swing is in use in the class. A frame is implemented with 3 button components, which represent the different roles the player can use (either warrior, mage or marksman).
The user will need to press one of the three buttons to initiate the game by choosing their role (implemented by using an action listener). Once chosen, a new frame will open emulating the game.

InputRoom class:
In the game the user can choose from 10 different rooms; clicking on one of the rooms will open another frame, which emulates the combat system. Once an enemy is defeated, the player is return to the previous frame.
Certain rooms will require a key (which can be obtained by exploring rooms), and until the player obtains a valid key for a locked room, it will not open. The shop will open yet another frame showing the items that the player can purchase.
The inventory button will show the players inventory in the console. The player can only finish the game by obtain a special key, but once obtained and the button clicked on, the game will end. Naturally, the player can choose to quit the game, closing the frame.

Combat class:
When emulating the combat system, the user can is shown a text box (Text area) containing information about the player and the enemy it is currently facing. The player can click on five buttons. Each button will give an action and modify the text box.
By doing so, the information in the text box is updated. Once the enemy is defeated, the frame will close.

[
Exception at save game (in InputRoom class line 271 to 283) and load game (in InputRoom class line 295 to 321):
A try and catch statement is used in order to save the game and load the game. The try statement is tested for errors, while the program is running. If an error is found, the catch statement will occur.
The catch statement is to be executed, if an error occurs in the try block, printing out an error message in the console, as well as the respective error types.
When loading, file not found exception will occur if a save file (a text file named save.txt) is not found. An IO exception will occur, if the saving will not occur.
]

[
Save game (in InputRoom class lines 271 to 283):
When the user presses on the save game button, the program will create a save file in text format. The file will be called "save.txt".
This text will contain information about the players statistics (the attributes of the Player class).
Load game (in Input class lines 295 to 321):
When the user presses on the load game button, the program will attempt to read the "save.txt" file. If the file exists, it will set the player's statistics to whatever are on the text file.
If the file doesn't exist, then an IO exception occurs.
]

