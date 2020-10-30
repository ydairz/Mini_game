import java.text.DecimalFormat;
import javax.swing.JTextArea;

public class Enemies
{
  private String name;
  private double maxHP;
  private double currentHP;
  private double AD;
  private static DecimalFormat twoDP = new DecimalFormat("0.00");

  public Enemies(String name, double maxHP, double currentHP, double AD)
  {
    this.name = name;
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.AD = AD;
  }

  public void reduceHP(Player player, JTextArea text)
  {
    if (player.getCritChance() < (Math.random()*100))
    {
      setCurrentHP(getCurrentHP() - player.getAD());
      text.append("You dealt " + twoDP.format(player.getAD()) + " to the " + getName() +  ". (" +  getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
      System.out.println("You dealt " + twoDP.format(player.getAD()) + " to the " + getName() +  ". (" +  getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
    }
    else
    {
      setCurrentHP(getCurrentHP() - (player.getAD()*2));
      text.append("You've critically stroke the " + getName() + " for " + twoDP.format(player.getAD()*2) + ". (" +  getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
      System.out.println("You've critically stroke the " + getName() + " for " + twoDP.format(player.getAD()*2) + ". (" +  getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
    }
  }

  public void reduceHPviaSkill(Player player, JTextArea text, double damageDealt)
  {
    if (player.getCritChance() < (Math.random()*100))
    {
      setCurrentHP(getCurrentHP() - damageDealt);
      text.append("You dealt " + twoDP.format(damageDealt) + " to the " + getName() + ". (" + getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
      System.out.println("You dealt " + twoDP.format(damageDealt) + " to the " + getName() + ". (" + getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
    }
    else
    {
      damageDealt = damageDealt*2;
      setCurrentHP(getCurrentHP() - damageDealt);
      text.append("You've critically stroke the " + getName() + " for " + twoDP.format(damageDealt) + ". (" +  getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
      System.out.println("You've critically stroke the " + getName() + " for " + twoDP.format(damageDealt) + ". (" +  getName() + "\'s HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
    }
  }

  public void reduceHPviaSkillOne(Player player, JTextArea text)
  {
    double bonusDamage = player.skillOne(player, text);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  public void reduceHPviaSkillTwo(Player player, JTextArea text)
  {
    double bonusDamage = player.skillTwo(player);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  public void reduceHPviaSkillThree(Player player, JTextArea text)
  {
    double bonusDamage = player.skillThree(player);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  public void reduceHPviaSkillOneTwo(Player player, JTextArea text)
  {
    double bonusDamage = player.skillOne(player, text) + player.skillTwo(player);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  public void reduceHPviaSkillOneThree(Player player, JTextArea text)
  {
    double bonusDamage = player.skillOne(player, text) + player.skillThree(player);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  public void reduceHPviaSkillTwoThree(Player player, JTextArea text)
  {
    double bonusDamage = player.skillTwo(player) + player.skillThree(player);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  public void reduceHPviaSkillOneTwoThree(Player player, JTextArea text)
  {
    double bonusDamage = player.skillOne(player, text) + player.skillTwo(player) + player.skillThree(player);
    double damageDealt = player.getAD() + bonusDamage;
    reduceHPviaSkill(player, text, damageDealt);
  }

  /* --- Setters --- */
  public void setName(String name){this.name = name;}
  public void setMaxHP(double maxHP){this.maxHP = maxHP;}
  public void setCurrentHP(double currentHP){this.currentHP = currentHP;}
  public void setAD(double AD){this.AD = AD;}

  /* --- Getters --- */
  public String getName(){return name;}
  public double getMaxHP(){return maxHP;}
  public double getCurrentHP(){return currentHP;}
  public double getAD(){return AD;}
  /* --- End of getters --- */
}
