import javax.swing.JTextArea;

public class Marksman extends Player
{
  public Marksman()
  {
    super(100, 100, 50, 50, 10, 20, 0, 0, 5, 5, 0);
  }

  @Override
  public double skillOne(Player player, JTextArea text) /* Damage multiplier based on your crit chance */
  {
    double divisor = 100;
    double bonusDamage = getAD()*(getCritChance() / divisor);
    return bonusDamage;
  }

  public double skillTwo(Player player) /* Deal bonus damage based on 10% of your AD */
  {
    double bonusDamage = getAD()*0.1;
    return bonusDamage;
  }

  public double skillThree(Player player) /* Each attack has a chance, based on double your crit chance, to deal 100 bonus damage */
  {
      if ((player.getCritChance()*2) < (Math.random()*100)) {return (100);}
      else {return 0;}
  }
}
