public class RoomTwo extends Rooms
{
  public RoomTwo()
  {
    super(2, 0, false);
    enemy = new Enemies[]
    {
      new Enemies("Skeleton Archer", 50, 50, 3),
      new Enemies("Skeleton Mage", 70, 70, 4),
      new Enemies("Skeleton Swordsman", 80, 80, 5),
      new Enemies("Skeleton Blademaster", 100, 100, 7),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    System.out.println("No items here...");
  }
}
