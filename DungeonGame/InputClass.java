import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class InputClass extends JFrame implements ActionListener
{
  private JFrame frame;
  private JButton b1;
  private JButton b2;
  private JButton b3;
  private String choice = "";
  public InputClass()
  {
    frame = new JFrame("Dungeon Game");
    frame.setSize(800, 640);
    frame.setResizable(false);
    frame.setLayout(null);

    b1 = new JButton("Warrior");
    b1.addActionListener(this);
    b2 = new JButton("Mage");
    b2.addActionListener(this);
    b3 = new JButton("Marksman");
    b3.addActionListener(this);

    b1.setIcon(new ImageIcon("ImageWarrior.jpg"));
    b2.setIcon(new ImageIcon("ImageMage.jpg"));
    b3.setIcon(new ImageIcon("ImageMarksman.jpg"));
    b1.setBounds(0, 0, 266, 640);
    b2.setBounds(266, 0, 267, 640);
    b3.setBounds(533, 0, 266, 640);
    frame.add(b1);
    frame.add(b2);
    frame.add(b3);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
      choice = e.getActionCommand();
      if (choice.equalsIgnoreCase("Warrior"))
      {
          setWarrior();
      }
      else if (choice.equalsIgnoreCase("Mage"))
      {
          setMage();
      }
      else if(choice.equals("Marksman"))
      {
          setMarksman();
      }
      frame.dispose();
      Player player = generatePlayer(choice);
      Rooms[] rooms = generateRoom();
      Shop shop = new Shop();
      generateGame(player, rooms, shop);
    }

    public static Player generatePlayer(String choice)
    {
        if (choice.equalsIgnoreCase("Warrior"))
        {
            System.out.println("Warrior chosen");
            return (new Warrior());
        }
        else if (choice.equalsIgnoreCase("Mage"))
        {
            System.out.println("Mage chosen");
            return (new Mage());
        }
        else
        {
            System.out.println("Marksman chosen");
            return (new Marksman());
        }
    }

    public static Rooms[] generateRoom()
    {
        Rooms[] rooms = new Rooms[]
        {
            new RoomOne(),
            new RoomTwo(),
            new RoomThree(),
            new RoomFour(),
            new RoomFive(),
            new RoomSix(),
            new RoomSeven(),
            new RoomEight(),
            new RoomNine(),
            new RoomTen(),
        };
        return rooms;
    }

    public static void generateGame(Player player, Rooms[] rooms, Shop shop)
    {
        Game game = new Game();
        game.runGame(player, rooms, shop);
    }

  public void setWarrior(){this.choice = "Warrior";}
  public void setMage(){this.choice = "Mage";}
  public void setMarksman(){this.choice = "Marksman";}

  public String getChoice(){return choice;}
}
