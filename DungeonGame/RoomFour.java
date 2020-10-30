public class RoomFour extends Rooms
{
  public RoomFour()
  {
    super(4, 0, true);
    enemy = new Enemies[]
    {
      new Enemies("Mimic", 50, 50, 4),
      new Enemies("Mimic", 70, 70, 6),
      new Enemies("Big Mimic", 200, 200, 10),
    };
  }

  @Override
  public void pickUpLoot(Player player)
  {
    player.inventory.add(new Items("SSP (1/3)", true));
    System.out.println("You have obtained a Secret Skill Piece (1/3)");
  }
}
