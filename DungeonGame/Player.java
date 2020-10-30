import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTextArea;

public abstract class Player
{
  private double maxHP;
  private double currentHP;
  private double maxMP;
  private double currentMP;
  private double AD;
  private int critChance;
  private int exp;
  private int gold;
  private int consumablesHP;
  private int consumablesMP;
  private int eliminations;
  private boolean s1Unlock;
  private boolean s2Unlock;
  private boolean s3Unlock;
  private boolean s1Active;
  private boolean s2Active;
  private boolean s3Active;
  ArrayList<Items> inventory = new ArrayList<Items>();
  private static DecimalFormat twoDP = new DecimalFormat("0.00");

  public Player(double maxHP, double currentHP, double maxMP, double currentMP, double AD, int critChance, int exp, int gold, int consumablesHP, int consumablesMP, int eliminations)
  {
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.maxMP = maxMP;
    this.currentMP = currentMP;
    this.AD = AD;
    this.critChance = critChance;
    this.exp = exp;
    this.gold = gold;
    this.consumablesHP = consumablesHP;
    this.consumablesMP = consumablesMP;
    this.eliminations = eliminations;
    this.s1Unlock = false;
    this.s1Active = false;
    this.s2Unlock = false;
    this.s2Active = false;
    this.s3Unlock = false;
    this.s3Active = false;
  }

  public double skillOne(Player player, JTextArea text){
    return getAD();}
  public abstract double skillTwo(Player player);
  public abstract double skillThree(Player player);

  /* --- Reduce stat methods --- */
  public void reduceHP(Enemies enemy, JTextArea text)
  {
    setCurrentHP(getCurrentHP() - enemy.getAD());
    text.append("\nYou were hit for " + twoDP.format(enemy.getAD()) + " damage. (HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
    System.out.println("You were hit for " + twoDP.format(enemy.getAD()) + " damage. (HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
  }

  public void loseHP(double reduction, JTextArea text)
  {
    setCurrentHP(getCurrentHP() - reduction);
    text.append("\nYou lost " + twoDP.format(reduction) + " HP. (HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
    System.out.println("You lost " + twoDP.format(reduction) + " HP. (HP = " + twoDP.format(getCurrentHP()) + "/" + twoDP.format(getMaxHP()) + ")");
  }

  public void reduceMP(double reduction, JTextArea text)
  {
    setCurrentMP(getCurrentMP() - reduction);
    text.append("\nYou consumed " + twoDP.format(reduction) + " MP. (MP = " + twoDP.format(getCurrentMP()) + "/" + twoDP.format(getMaxMP()) + ")");
    System.out.println("You consumed " + twoDP.format(reduction) + " MP. (MP = " + twoDP.format(getCurrentMP()) + "/" + twoDP.format(getMaxMP()) + ")");
  }

  public void reduceGold(int reduction)
  {
    setGold(getGold() - reduction);
  }
  /* --- End of reduce stat methods --- */

  /* --- Gain stat methods --- */
  public void gainHealth(double addition)
  {
    if ((getCurrentHP() + 50) >= getMaxHP())
    {
      setCurrentHP(getMaxHP());
    }
    else
    {
      setCurrentHP(getCurrentHP() + addition);
    }
  }

  public void gainMana(double addition)
  {
    if ((getCurrentMP() + 50) >= getMaxMP())
    {
      setCurrentMP(getMaxMP());
    }
    else
    {
      setCurrentMP(getCurrentMP() + addition);
    }
  }

  public void gainExp()
  {
    setEliminations(getEliminations() + 1);
    setExp(getExp() + 25);
    if (getExp() >= 100)
    {
      levelUp("\n--- You've leveled up! Max HP and MP + 25, AD + 10, Crit Chance + 5%");
      setExp(0);
    }
  }

  public void gainGold(int addition)
  {
    setGold(getGold() + addition);
  }

  public void gainConsumablesHP(int addition)
  {
    setConsumablesHP(getConsumablesHP() + addition);
  }

  public void gainConsumablesMP(int addition)
  {
    setConsumablesMP(getConsumablesMP() + addition);
  }

  public void unlockSkillThree()
  {
      setS3Unlock(true);
  }
  /* --- Gain stat methods --- */

  /* --- Reset stat methods --- */
  public void resetActives()
  {
    setS1Active(false);
    setS2Active(false);
  }
  /* --- End of reset stat methods ---*/

  public void levelUp(String message)
  {
    System.out.println(message);
    setMaxHP(getMaxHP() + 25);
    setMaxMP(getMaxMP() + 25);
    setAD(getAD() + 10);
    setCritChance(getCritChance() + 5);
  }

  public boolean checkBlueKey()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "Blue Key")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkRedKey()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "Red Key")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkGreenKey()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "Green Key")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkYellowKey()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "Yellow Key")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkAllKey()
  {
      boolean conditionBlue = checkBlueKey();
      boolean conditionRed = checkRedKey();
      boolean conditionGreen = checkGreenKey();
      boolean conditionYellow = checkYellowKey();
      if ((conditionBlue == true)&&(conditionRed == true)&&(conditionGreen == true)&&(conditionYellow == true))
      {
          return true;
      }
      else
      {
          return false;
      }
  }

  public boolean checkEndKey()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "End Key")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkPartOne()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "SSP (1/3)")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkPartTwo()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "SSP (2/3)")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkPartThree()
  {
      boolean condition = false;
      Items object;
      for (int i = 0; i < inventory.size(); i++)
      {
          object = inventory.get(i);
          if ((object.getName() == "SSP (3/3)")&&(object.getPossess() == true))
          {
              condition = true;
          }
      }
      return condition;
  }

  public boolean checkForParts()
  {
      boolean conditionOne = checkPartOne();
      boolean conditionTwo = checkPartTwo();
      boolean conditionThree = checkPartThree();
      if ((conditionOne == true)&&(conditionTwo == true)&&(conditionThree == true))
      {
          return true;
      }
      else
      {
          return false;
      }
  }

  /* --- User input methods --- */
  public static String inputOption(String message)
  {
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
  /* --- End of user input methods --- */

  /* --- Setters --- */
  public void setMaxHP(double maxHP){this.maxHP = maxHP;}
  public void setCurrentHP(double currentHP){this.currentHP = currentHP;}
  public void setMaxMP(double maxMP){this.maxMP = maxMP;}
  public void setCurrentMP(double currentMP){this.currentMP = currentMP;}
  public void setAD(double AD){this.AD = AD;}
  public void setCritChance(int critChance){this.critChance = critChance;}
  public void setExp(int exp){this.exp = exp;}
  public void setGold(int gold){this.gold = gold;}
  public void setConsumablesHP(int consumablesHP){this.consumablesHP = consumablesHP;}
  public void setConsumablesMP(int consumablesMP){this.consumablesMP = consumablesMP;}
  public void setEliminations(int eliminations){this.eliminations = eliminations;}
  public void setS1Unlock(boolean s1Unlock){this.s1Unlock = s1Unlock;}
  public void setS2Unlock(boolean s2Unlock){this.s2Unlock = s2Unlock;}
  public void setS3Unlock(boolean s3Unlock){this.s3Unlock = s3Unlock;}
  public void setS1Active(boolean s1Active){this.s1Active = s1Active;}
  public void setS2Active(boolean s2Active){this.s2Active = s2Active;}
  public void setS3Active(boolean s3Active){this.s3Active = s3Active;}
  /* --- End of setters --- */

  /* --- Getters --- */
  public double getMaxHP(){return maxHP;}
  public double getCurrentHP(){return currentHP;}
  public double getMaxMP(){return maxMP;}
  public double getCurrentMP(){return currentMP;}
  public double getAD(){return AD;}
  public int getCritChance(){return critChance;}
  public int getExp(){return exp;}
  public int getGold(){return gold;}
  public int getConsumablesHP(){return consumablesHP;}
  public int getConsumablesMP(){return consumablesMP;}
  public int getEliminations(){return eliminations;}
  public boolean getS1Unlock(){return s1Unlock;}
  public boolean getS2Unlock(){return s2Unlock;}
  public boolean getS3Unlock(){return s3Unlock;}
  public boolean getS1Active(){return s1Active;}
  public boolean getS2Active(){return s2Active;}
  public boolean getS3Active(){return s3Active;}
  /* --- End of getters --- */
}
