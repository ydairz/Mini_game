import javax.swing.JTextArea;

public class Warrior extends Player
{
  public Warrior()
  {
    super(200, 200, 50, 50, 15, 0, 0, 0, 5, 5, 0);
  }

  @Override
  public double skillOne(Player player, JTextArea text) /* Does bonus damage based on 5% maximum health, but will consume half the health based on the bonus damage dealt*/
  {
    if (getCurrentHP() >= getMaxHP()*0.1)
    {
      double bonusDamage = (getMaxHP()*0.05);
      loseHP(getMaxHP()*0.025, text);
      return bonusDamage;
    }
    else
    {
      System.out.println("You are below the minimum threshold HP requirement for skill one. Skill one deactivated");
      setS1Active(false);
      return 0;
    }
  }

  public double skillTwo(Player player) /* Deal bonus damage based on 10% missing health */
  {
    double bonusDamage = (getMaxHP() - getCurrentHP())*0.1;
    return bonusDamage;
  }

  public double skillThree(Player player) /* Deal 3 times your normal damage as bonus damage */
  {
      return (getAD()*3);
  }
}
