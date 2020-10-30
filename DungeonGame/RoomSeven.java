public class RoomSeven extends Rooms
{
  public RoomSeven()
  {
    super(7, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Dragon Hatchling", 150, 150, 5),
      new Enemies("Dragon", 300, 300, 15),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("SSP (2/3)", true));
    player.gainGold(70);
    System.out.println("You have obtained a Secret Skill Piece (2/3) and gold bag (70 gold)");
  }
}
