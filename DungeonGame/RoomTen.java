public class RoomTen extends Rooms
{
  public RoomTen()
  {
    super(10, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Demonic Dragon", 1000, 1000, 20),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("End Key", true));
    System.out.println("You have obtained the end key, use it to finish the game by typing \"Finish\"");
  }
}
