import javax.swing.JTextArea;

public class Mage extends Player
{
  public Mage()
  {
    super(100, 100, 250, 250, 10, 0, 0, 0, 5, 5, 0);
  }

  @Override
  public double skillOne(Player player, JTextArea text) /* Does bonus damage based on 5% maximum mana, but will consume half the mana based on the bonus damage dealt*/
  {
    if (getCurrentMP() >= getMaxMP()*0.1)
    {
      double bonusDamage = (getMaxMP()*0.05);
      reduceMP(getMaxMP()*0.025, text);
      return bonusDamage;
    }
    else
    {
      System.out.println("You are below the minimum threshold MP requirement for skill one. Skill one deactivated");
      setS1Active(false);
      return 0;
    }
  }

  public double skillTwo(Player player) /* Deal bonus damage based on 10% missing mana */
  {
    double bonusDamage = (getMaxMP() - getCurrentMP())*0.1;
    return bonusDamage;
  }

  public double skillThree(Player player) /* Each attack will permanently increase your maximum mana by 5 */
  {
      setMaxMP(getMaxMP() + 5);
      return 0;
  }
}
