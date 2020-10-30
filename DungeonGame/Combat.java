import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class Combat extends JFrame implements ActionListener
{
  private static DecimalFormat twoDP = new DecimalFormat("0.00");

  private Player player;
  private Rooms room;
  private Enemies enemy;
  private Shop shop;

  private JFrame frame;
  private JTextArea text;
  private JButton b1;
  private JButton b2;
  private JButton b3;
  private JButton b4;
  private JButton b5;
  private JButton b6;
  private String choice = "";
  public Combat(Player player, Rooms room, Enemies enemy)
  {
    this.player = player;
    this.room = room;
    this.shop = shop;
    this.enemy = enemy;

    frame = new JFrame("Dungeon Game");
    frame.setSize(1000, 640);
    frame.setResizable(false);
    frame.setLayout(null);

    text = new JTextArea("You're are in room " + room.getRoomNumber() + " (" + (room.enemy.length - room.getEnemyCount()) + " enemies left)");
    text.setEditable(false);
    text.append("\n" + enemy.getName() + "\'s HP = " + twoDP.format(enemy.getCurrentHP()) + "/" + twoDP.format(enemy.getMaxHP()));
    text.append("\n HP = " + twoDP.format(player.getCurrentHP()) + "/" + twoDP.format(player.getMaxHP()));

    text.setFont(text.getFont().deriveFont(25f));

    b1 = new JButton("Attack");
    b1.addActionListener(this);
    b2 = new JButton("Skill 1");
    b2.addActionListener(this);
    b3 = new JButton("Skill 2");
    b3.addActionListener(this);
    b4 = new JButton("Skill 3");
    b4.addActionListener(this);
    b5 = new JButton("HP Potion");
    b5.addActionListener(this);
    b6 = new JButton("MP Potion");
    b6.addActionListener(this);

    text.setBounds(30, 20, 940, 280);

    b1.setBounds(0, 400, 333, 200);
    b2.setBounds(333, 400, 334, 66);
    b3.setBounds(333, 466, 334, 67);
    b4.setBounds(333, 533, 334, 66);
    b5.setBounds(667, 400, 333, 100);
    b6.setBounds(667, 500, 333, 100);

    frame.add(text);
    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(b4);
    frame.add(b5);
    frame.add(b6);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
      choice = e.getActionCommand();
      text.setText(null);
      if (choice.equalsIgnoreCase("Attack"))
      {
        if (enemy.getCurrentHP() > 0)
        {
          performAttack();
          if (enemy.getCurrentHP() > 0)
          {
            player.reduceHP(enemy, text);
            if (player.getCurrentHP() <= 0)
            {
              System.out.println("YOU DIED! GAME OVER!");
              frame.dispose();
              System.exit(0);
            }
          }
          else
          {
            System.out.println("You've defeated " + enemy.getName() + ". You have gained exp and gold.");
            player.gainExp();
            player.gainGold(10);
            player.resetActives();
            room.incrementEnemyCount();
            frame.dispose();
          }
        }
      }
      else if (choice.equalsIgnoreCase("Skill 1"))
      {
        if (player.getS1Active() == true)
        {
          System.out.println("Skill 1 is already in effect. It will run out when you have defeated the current enemy");
          text.append("\nSkill 1 is already in effect. It will run out when you have defeated the current enemy");
        }
        else if ((player.getS1Unlock() == true)&&(player.getCurrentMP() >= 10))
        {
          System.out.println("Skill 1 activated");
          text.append("\nSkill 1 activated");
          player.setS1Active(true);
          player.reduceMP(10, text);
        }
        else if ((player.getS1Unlock() == true)&&(player.getCurrentMP() < 10))
        {
          System.out.println("You do not have enough mana. MP = " + player.getCurrentMP() + "/" + player.getMaxMP() + " and the skill requires 10 MP");
          text.append("\nYou do not have enough mana. MP = " + player.getCurrentMP() + "/" + player.getMaxMP() + " and the skill requires 10 MP");
        }
        else
        {
          System.out.println("You haven't learnt this skill yet");
          text.append("\nYou haven't learnt this skill yet");
        }
      }
      else if(choice.equals("Skill 2"))
      {
        if (player.getS2Active() == true)
        {
          System.out.println("Skill 2 is already in effect. It will run out when you have defeated the current enemy");
          text.append("\nSkill 2 is already in effect. It will run out when you have defeated the current enemy");
        }
        else if ((player.getS2Unlock() == true)&&(player.getCurrentMP() >= 20))
        {
          System.out.println("Skill 2 activated");
          player.setS2Active(true);
          player.reduceMP(20, text);
        }
        else if ((player.getS2Unlock() == true)&&(player.getCurrentMP() < 20))
        {
          System.out.println("You do not have enough mana. MP = " + player.getCurrentMP() + "/" + player.getMaxMP() + " and the skill requires 20 MP");
          text.append("\nYou do not have enough mana. MP = " + player.getCurrentMP() + "/" + player.getMaxMP() + " and the skill requires 20 MP");
        }
        else
        {
          System.out.println("You haven't learnt this skill yet");
          text.append("\nYou haven't learnt this skill yet");
        }
      }
      else if (choice.equalsIgnoreCase("Skill 3"))
      {
        if (player.getS3Active() == true)
        {
          System.out.println("Skill 3 is already in effect. It will run out when you have defeated the current enemy");
          text.append("\nSkill 2 is already in effect. It will run out when you have defeated the current enemy");
        }
        else if ((player.getS3Unlock() == true)&&(player.getCurrentMP() >= 30))
        {
          System.out.println("Skill 3 activated");
          player.setS3Active(true);
          player.reduceMP(30, text);
        }
        else if ((player.getS3Unlock() == true)&&(player.getCurrentMP() < 30))
        {
          System.out.println("You do not have enough mana. MP = " + player.getCurrentMP() + "/" + player.getMaxMP() + " and the skill requires 30 MP");
          text.append("\nYou do not have enough mana. MP = " + player.getCurrentMP() + "/" + player.getMaxMP() + " and the skill requires 30 MP");
        }
        else
        {
          System.out.println("You haven't learnt this skill yet");
          text.append("\nYou haven't learnt this skill yet");
        }
      }
      else if(choice.equals("HP Potion"))
      {
        if (player.getCurrentHP() == player.getMaxHP())
        {
          System.out.println("You are already at max HP");
          text.append("\nYou are already at max HP");
        }
        else if (player.getConsumablesHP() > 0)
        {
          player.gainHealth(50);
          player.setConsumablesHP(player.getConsumablesHP() - 1);
          System.out.println("You have used 1 HP potion and now have " + player.getConsumablesHP() + " HP potions left. HP = " + player.getCurrentHP() + "/" + player.getMaxHP());
          text.append("\nYou have used 1 HP potion and now have " + player.getConsumablesHP() + " HP potions left. HP = " + player.getCurrentHP() + "/" + player.getMaxHP());
        }
        else
        {
          System.out.println("You do not have any HP potions remaining");
          text.append("\nYou do not have any HP potions remaining");
        }
      }
      else if (choice.equalsIgnoreCase("MP Potion"))
      {
        if (player.getCurrentMP() == player.getMaxMP())
        {
          System.out.println("You are already at max MP");
          text.append("\nYou are already at max MP");
        }
        else if (player.getConsumablesMP() > 0)
        {
          player.gainMana(50);
          player.setConsumablesMP(player.getConsumablesMP() - 1);
          System.out.println("You have used 1 MP potion and now have " + player.getConsumablesMP() + " MP potions left. MP = " + player.getCurrentMP() + "/" + player.getMaxMP());
          text.append("\nYou have used 1 MP potion and now have " + player.getConsumablesMP() + " MP potions left. MP = " + player.getCurrentMP() + "/" + player.getMaxMP());
        }
        else
        {
          System.out.println("You do not have any MP potions");
          text.append("\nYou do not have any MP potions");
        }
      }
    }

    public void performAttack()
    {
      int option = condition(player);
      if (option == 1){enemy.reduceHP(player, text);}
      else if (option == 2){enemy.reduceHPviaSkillOne(player, text);}
      else if (option == 3){enemy.reduceHPviaSkillTwo(player, text);}
      else if (option == 4){enemy.reduceHPviaSkillThree(player, text);}
      else if (option == 5){enemy.reduceHPviaSkillOneTwo(player, text);}
      else if (option == 6){enemy.reduceHPviaSkillOneThree(player, text);}
      else if (option == 7){enemy.reduceHPviaSkillTwoThree(player, text);}
      else if (option == 8){enemy.reduceHPviaSkillOneTwoThree(player, text);}
    }

    public static int condition(Player player)
    {
      if ((player.getS1Active() == false)&&(player.getS2Active() == false)&&(player.getS3Active() == false)){return 1;}
      else if ((player.getS1Active() == true)&&(player.getS2Active() == false)&&(player.getS3Active() == false)){return 2;}
      else if ((player.getS1Active() == false)&&(player.getS2Active() == true)&&(player.getS3Active() == false)){return 3;}
      else if ((player.getS1Active() == false)&&(player.getS2Active() == false)&&(player.getS3Active() == true)){return 4;}
      else if ((player.getS1Active() == true)&&(player.getS2Active() == true)&&(player.getS3Active() == false)){return 5;}
      else if ((player.getS1Active() == true)&&(player.getS2Active() == false)&&(player.getS3Active() == true)){return 6;}
      else if ((player.getS1Active() == false)&&(player.getS2Active() == true)&&(player.getS3Active() == true)){return 7;}
      else if ((player.getS1Active() == true)&&(player.getS2Active() == true)&&(player.getS3Active() == true)){return 8;}
      else {return 0;}
    }
}
