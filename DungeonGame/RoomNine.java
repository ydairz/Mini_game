public class RoomNine extends Rooms
{
  public RoomNine()
  {
    super(9, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Hound", 50, 50, 5),
      new Enemies("Fire Hound", 50, 50, 10),
      new Enemies("Scavenger", 40, 40, 15),
      new Enemies("Starving Scavenger", 40, 40, 20),
      new Enemies("Thunder Hound", 30, 30, 25),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("Yellow Key", true));
    player.inventory.add(new Items("SSP (3/3)", true));
    System.out.println("You have obtained a yellow key, a Secret Skill Piece (3/3) and gold bag (60 gold)");
    player.gainGold(60);
  }
}
