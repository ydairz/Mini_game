public class RoomSix extends Rooms
{
  public RoomSix()
  {
    super(6, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Goblin Swordsman", 50, 50, 5),
      new Enemies("Goblin Spearman", 70, 70, 6),
      new Enemies("Goblin Axeman", 100, 100, 7),
      new Enemies("Goblin Knight", 130, 130, 8),
      new Enemies("Goblin Guardian", 150, 150, 10),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("Red Key", true));
    System.out.println("You have obtained a red key");
  }
}
