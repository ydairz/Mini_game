public class RoomFive extends Rooms
{
  public RoomFive()
  {
    super(5, 0, false);
    enemy = new Enemies[]
    {
      new Enemies("Ghost", 60, 60, 5),
      new Enemies("Phantom", 70, 70, 6),
      new Enemies("Mummy", 90, 90, 7),
      new Enemies("Undead Mob", 120, 120, 8),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    System.out.println("No items here...");
  }
}
