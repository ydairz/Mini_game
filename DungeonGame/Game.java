public class Game
{
  public void runGame(Player player, Rooms[] rooms, Shop shop)
  {
    System.out.println("Which room would you like to explore (input from 1 to 10)? Type \"Shop\", \"Inventory\", \"Finish\" or \"Quit\"");
    InputRoom roomChoice = new InputRoom(player, rooms, shop);
  }
}
