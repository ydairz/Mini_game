public class RoomOne extends Rooms
{
  public RoomOne()
  {
    super(1, 0, false);
    enemy = new Enemies[]
    {
      new Enemies("Zombie", 30, 30, 1),
      new Enemies("Skeleton", 40, 40, 2),
      new Enemies("Lich", 50, 50, 3),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    System.out.println("No items here...");
  }
}
