public class RoomEight extends Rooms
{
  public RoomEight()
  {
    super(8, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Zombie", 30, 30, 1),
      new Enemies("Skeleton", 40, 40, 2),
      new Enemies("Lich", 50, 50, 3),
      new Enemies("Armoured Zombie", 60, 60, 4),
      new Enemies("Armoured Skeleton", 70, 70, 5),
      new Enemies("Empowered Lich", 80, 80, 6),
      new Enemies("Demonic Ravager", 90, 90, 7),
      new Enemies("Demonic Marauder", 100, 100, 8),
      new Enemies("Skeleton Guardian", 110, 110, 9),
      new Enemies("Skeleton Illusionist", 120, 120, 10),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("Green Key", true));
    System.out.println("You have obtained a green key");
  }
}
