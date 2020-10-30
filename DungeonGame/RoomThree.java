public class RoomThree extends Rooms
{
  public RoomThree()
  {
    super(3, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Troll", 90, 90, 3),
      new Enemies("Orc", 70, 70, 4),
      new Enemies("Goblin", 50, 50, 5),
      new Enemies("Wraith", 30, 30, 8),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("Blue Key", true));
    player.gainGold(50);
    System.out.println("You have obtained a blue key and gold bag (50 gold)");
  }
}
