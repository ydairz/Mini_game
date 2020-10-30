public abstract class Rooms
{
  private int roomNumber;
  private int enemyCount;
  private boolean lootable;
  Enemies[] enemy;

  public Rooms(int roomIndex, int nEnemies, boolean lootable)
  {
    this.roomNumber = roomIndex;
    this.enemyCount = nEnemies;
    this.lootable = lootable;
  }

  public void incrementEnemyCount()
  {
    setEnemyCount(getEnemyCount() + 1);
  }

  public boolean checkClearance(Player player)
  {
    if (getEnemyCount() == enemy.length)
    {
      System.out.println("The room has been rid of enemies");
      return true;
    }
    else
    {
      if (getEnemyCount() == (enemy.length + 1))
      {
        System.out.println("There is only 1 enemy left in the room");
      }
      else
      {
        System.out.println("There are " + getEnemyCount() + " enemies left in the room");
      }
      return false;
    }
  }

  public void searchRoom(Player player, String message)
  {
    System.out.println(message);
    pickUpLoot(player);
    setLootable(false);
  }

  public abstract void pickUpLoot(Player player);

  /* --- Setters --- */
  public void setRoomNumber(int roomNumber){this.roomNumber = roomNumber;}
  public void setEnemyCount(int enemyCount){this.enemyCount = enemyCount;}
  public void setLootable(boolean lootable){this.lootable = lootable;}

  /* --- Getters --- */
  public int getRoomNumber(){return roomNumber;}
  public int getEnemyCount(){return enemyCount;}
  public boolean getLootable(){return lootable;}
}
