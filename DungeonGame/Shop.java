import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shop extends JFrame implements ActionListener
{
  private Player player;
  private Rooms[] rooms;
  private Shop shop;

  private JFrame frame;
  private JTextArea text;
  private JButton b1;
  private JButton b2;
  private JButton b3;
  private JButton b4;
  private JButton b5;
  private String choice = "";

  public void chooseSkill(Player player)
  {
    this.player = player;
    this.rooms = rooms;
    this.shop = shop;

    frame = new JFrame("Dungeon Game Shop");
    frame.setSize(1000, 640);
    frame.setResizable(false);
    frame.setLayout(null);

    text = new JTextArea(displayInfo(player));
    text.setEditable(false);
    b1 = new JButton("Skill 1");
    b1.addActionListener(this);
    b2 = new JButton("Skill 2");
    b2.addActionListener(this);
    b3 = new JButton("HP Potion");
    b3.addActionListener(this);
    b4 = new JButton("MP Potion");
    b4.addActionListener(this);
    b5 = new JButton("Back");
    b5.addActionListener(this);

    b1.setBounds(0, 0, 250, 250);
    b2.setBounds(250, 0, 250, 250);
    b3.setBounds(500, 0, 250, 250);
    b4.setBounds(750, 0, 250, 250);
    b5.setBounds(325, 390, 350, 250);
    text.setBounds(0, 250, 800, 140);

    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(b4);
    frame.add(b5);
    frame.add(text);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
    choice = e.getActionCommand();
    text.setText(null);
    if (choice.equalsIgnoreCase("Skill 1"))
    {
      if ((player.getS1Unlock() == false)&&(player.getGold() >= 50))
      {
        System.out.println("\n--- Skill Book 1 obtained. Skill 1 unlocked.");
        text.append("Skill Book 1 obtained. Skill 1 unlocked.\n" + displayInfo(player));
        player.inventory.add(new Items("Skill Book 1", true));
        player.setS1Unlock(true);
        player.reduceGold(50);
      }
      else if(player.getS1Unlock() == true)
      {
        System.out.println("\n--- You have already learnt this skill");
        text.append("You have already learnt this skill\n" + displayInfo(player));
      }
      else
      {
        System.out.println("\n--- You do not have enough gold to buy this skill. The item costs 50 gold, but you currently have " + player.getGold() + " gold");
        text.append("You do not have enough gold to buy this skill. The item costs 50 gold, but you currently have " + player.getGold() + " gold\n" + displayInfo(player));
      }
    }
    else if (choice.equalsIgnoreCase("Skill 2"))
    {
      if ((player.getS2Unlock() == false)&&(player.getGold() >= 100))
      {
        System.out.println("\n--- Skill Book 2 obtained. Skill 2 unlocked.");
        text.append("Skill Book 2 obtained. Skill 2 unlocked.\n" + displayInfo(player));
        player.inventory.add(new Items("Skill Book 2", true));
        player.setS2Unlock(true);
        player.reduceGold(100);
      }
      else if(player.getS2Unlock() == true)
      {
        System.out.println("\n--- You have already learnt this skill");
        text.append("You have already learnt this skill\n" + displayInfo(player));
      }
      else
      {
        System.out.println("\n--- You do not have enough gold to buy this skill. The item costs 100 gold, but you currently have " + player.getGold() + " gold");
        text.append("You do not have enough gold to buy this skill. The item costs 100 gold, but you currently have " + player.getGold() + " gold\n" + displayInfo(player));
      }
    }
    else if (choice.equalsIgnoreCase("HP Potion"))
    {
      if ((player.getConsumablesHP() < 5)&&(player.getGold() >= 30))
      {
        System.out.println("\n--- Bought 1 HP potion.");
        text.append("Bought 1 HP potion.\n" + displayInfo(player));
        player.gainConsumablesHP(1);
        player.reduceGold(30);
      }
      else if(player.getConsumablesHP() == 5)
      {
        System.out.println("\n--- You have already the maximum amout of HP potions");
        text.append("You have already the maximum amout of HP potions\n" + displayInfo(player));
      }
      else
      {
        System.out.println("\n--- You do not have enough gold to buy a HP potion. The item costs 30 gold, but you currently have " + player.getGold() + " gold");
        text.append("You do not have enough gold to buy a HP potion. The item costs 30 gold, but you currently have " + player.getGold() + " gold\n" + displayInfo(player));
      }
    }
    else if (choice.equalsIgnoreCase("MP Potion"))
    {
      if ((player.getConsumablesMP() < 5)&&(player.getGold() >= 30))
      {
        System.out.println("\n--- Bought 1 MP potion.");
        text.append("Bought 1 MP potion.\n" + displayInfo(player));
        player.gainConsumablesMP(1);
        player.reduceGold(30);
      }
      else if(player.getConsumablesMP() == 5)
      {
        System.out.println("\n--- You have already the maximum amout of MP potions");
        text.append("You have already the maximum amout of MP potions\n" + displayInfo(player));
      }
      else
      {
        System.out.println("\n--- You do not have enough gold to buy a MP potion. The item costs 30 gold, but you currently have " + player.getGold() + " gold");
        text.append("You do not have enough gold to buy a MP potion. The item costs 30 gold, but you currently have\n" + displayInfo(player));
      }
    }
    else if (choice.equalsIgnoreCase("Back"))
    {
      frame.dispose();
    }
  }

  public static String displayInfo(Player player)
  {
    String info = "You currently have " + player.getGold() + " gold\n";
    info = info + "HP potion --- worth 30 gold\n";
    info = info + "MP potion --- worth 30 gold\n";
    info = info + "Skill 1 --- worth 50 gold\n";
    info = info + "Skill 2 --- worth 100 gold";
    return info;
  }
}
