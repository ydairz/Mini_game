import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class InputRoom extends JFrame implements ActionListener
{
  private Player player;
  private Rooms[] rooms;
  private Shop shop;

  private JFrame frame;
  private JButton b1;
  private JButton b2;
  private JButton b3;
  private JButton b4;
  private JButton b5;
  private JButton b6;
  private JButton b7;
  private JButton b8;
  private JButton b9;
  private JButton b10;
  private JButton b11;
  private JButton b12;
  private JButton b13;
  private JButton b14;
  private JButton b15;
  private JButton b16;
  private String choice = "";
  public InputRoom(Player player, Rooms[] rooms, Shop shop)
  {
    this.player = player;
    this.rooms = rooms;
    this.shop = shop;

    frame = new JFrame("Dungeon Game");
    frame.setSize(1000, 640);
    frame.setResizable(false);
    frame.setLayout(null);

    b1 = new JButton("Room 1");
    b1.addActionListener(this);
    b2 = new JButton("Room 2");
    b2.addActionListener(this);
    b3 = new JButton("Room 3");
    b3.addActionListener(this);
    b4 = new JButton("Room 4");
    b4.addActionListener(this);
    b5 = new JButton("Room 5");
    b5.addActionListener(this);
    b6 = new JButton("Room 6");
    b6.addActionListener(this);
    b7 = new JButton("Room 7");
    b7.addActionListener(this);
    b8 = new JButton("Room 8");
    b8.addActionListener(this);
    b9 = new JButton("Room 9");
    b9.addActionListener(this);
    b10 = new JButton("Room 10");
    b10.addActionListener(this);
    b11 = new JButton("Shop");
    b11.addActionListener(this);
    b12 = new JButton("Inventory");
    b12.addActionListener(this);
    b13 = new JButton("Finish");
    b13.addActionListener(this);
    b14 = new JButton("Quit");
    b14.addActionListener(this);
    b15 = new JButton("Save");
    b15.addActionListener(this);
    b16 = new JButton("Load");
    b16.addActionListener(this);

    b1.setIcon(new ImageIcon("ImageRoom1.jpg"));
    b2.setIcon(new ImageIcon("ImageRoom2.jpg"));
    b3.setIcon(new ImageIcon("ImageRoom3.jpg"));
    b4.setIcon(new ImageIcon("ImageRoom4.jpg"));
    b5.setIcon(new ImageIcon("ImageRoom5.jpg"));
    b6.setIcon(new ImageIcon("ImageRoom6.jpg"));
    b7.setIcon(new ImageIcon("ImageRoom7.jpg"));
    b8.setIcon(new ImageIcon("ImageRoom8.jpg"));
    b9.setIcon(new ImageIcon("ImageRoom9.jpg"));
    b10.setIcon(new ImageIcon("ImageRoom10.jpg"));
    b11.setIcon(new ImageIcon("ImageShop.jpg"));
    b12.setIcon(new ImageIcon("ImageInventory.jpg"));
    b13.setIcon(new ImageIcon("ImageFinish.jpg"));
    b14.setIcon(new ImageIcon("ImageQuitGame.jpg"));
    b1.setBounds(0, 0, 200, 213);
    b2.setBounds(200, 0, 200, 213);
    b3.setBounds(400, 0, 200, 213);
    b4.setBounds(600, 0, 200, 213);
    b5.setBounds(800, 0, 200, 213);
    b6.setBounds(0, 213, 200, 213);
    b7.setBounds(200, 213, 200, 213);
    b8.setBounds(400, 213, 200, 213);
    b9.setBounds(600, 213, 200, 214);
    b10.setBounds(800, 213, 200, 214);
    b11.setBounds(0, 426, 200, 213);
    b12.setBounds(200, 426, 200, 213);
    b13.setBounds(600, 426, 200, 214);
    b14.setBounds(800, 426, 200, 214);
    b15.setBounds(400, 426, 100, 213);
    b16.setBounds(500, 426, 100, 213);

    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(b4);
    frame.add(b5);
    frame.add(b6);
    frame.add(b7);
    frame.add(b8);
    frame.add(b9);
    frame.add(b10);
    frame.add(b11);
    frame.add(b12);
    frame.add(b13);
    frame.add(b14);
    frame.add(b15);
    frame.add(b16);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
      choice = e.getActionCommand();
      boolean condition = false;
      if (choice.equalsIgnoreCase("Room 1"))
      {
          setRoom1();
      }
      else if (choice.equalsIgnoreCase("Room 2"))
      {
          setRoom2();
      }
      else if(choice.equals("Room 3"))
      {
          setRoom3();
      }
      else if (choice.equalsIgnoreCase("Room 4"))
      {
        if (player.checkBlueKey() == true)
        {
         setRoom4();
        }
        else
        {
         System.out.println("You do not have the blue key. Try searching the rooms for the key.");
         condition = true;
        }
      }
      else if(choice.equals("Room 5"))
      {
          setRoom5();
      }
      else if (choice.equalsIgnoreCase("Room 6"))
      {
          setRoom6();
      }
      else if(choice.equals("Room 7"))
      {
        if (player.checkRedKey() == true)
        {
         setRoom7();
        }
        else
        {
         System.out.println("You do not have the red key. Try searching the rooms for the key.");
         condition = true;
        }
      }
      else if (choice.equalsIgnoreCase("Room 8"))
      {
          setRoom8();
      }
      else if(choice.equals("Room 9"))
      {
        if (player.checkGreenKey() == true)
        {
         setRoom9();
        }
        else
        {
         System.out.println("You do not have the green key. Try searching the rooms for the key.");
         condition = true;
        }
      }
      else if(choice.equals("Room 10"))
      {
        if (player.checkAllKey() == true)
        {
         setRoom10();
        }
        else
        {
         System.out.println("You do not have all the keys. Try searching the rooms for the key.");
         condition = true;
        }
      }
      else if(choice.equals("Shop"))
      {
          setShop();
      }
      else if (choice.equalsIgnoreCase("Inventory"))
      {
          setInventory();
      }
      else if(choice.equals("Finish"))
      {
          setFinish();
      }
      else if(choice.equals("Quit"))
      {
          setQuit();
      }
      if ((choice.equals("Shop"))||(choice.equals("Inventory"))||(choice.equals("Finish"))||(choice.equals("Quit"))||(choice.equals("Save"))||(choice.equals("Load")))
      {
        if (choice.equalsIgnoreCase("Shop"))
        {
          System.out.println("\n--- Accessing shop...");
          shop.chooseSkill(player);
        }
        else if (choice.equalsIgnoreCase("Inventory"))
        {
            InventoryGUI inventorygui = new InventoryGUI(player);
        }
        else if (choice.equalsIgnoreCase("Finish"))
        {
            if (player.checkEndKey() == true)
            {
                System.out.println("You've completed the game! TY FOR PLAYING :)");
                System.exit(0);
            }
            else
            {
                System.out.println("\n--- You haven't gotten the end key yet. You can find it in room 10");
            }
        }
        else if (choice.equalsIgnoreCase("Quit"))
        {
          System.out.print("Leaving game. Turning off...");
          frame.dispose();
          System.exit(0);
        }
        else if (choice.equalsIgnoreCase("Save"))
        {
            saveGame(player);
        }
        else if (choice.equalsIgnoreCase("Load"))
        {
            loadGame(player);
        }
      }
      else
      {
        if (condition == false)
        {
          Rooms room = outputRoom(rooms, choice);
          go2Room(player, room);
        }
        else
        {
          System.out.println("You can obtain the \"blue key\" from room 3, the \"red key\" from room 6, the \"green key\" from room 8 and the \"yellow key\" from room 9");
        }
      }
    }
    
    public static void saveGame(Player player)
    {
       try
       {
           PrintWriter saveFile = new PrintWriter(new FileWriter("save.txt"));
           saveFile.println(saveString(player));
           saveFile.close();
       }
       catch (Exception ex)
       {
           System.out.println("ERROR: couldn't save file.");
           ex.printStackTrace();
       }
       
    }
    
    public static String saveString(Player player)
    {
        String save = player.getMaxHP() + "\n" + player.getCurrentHP() + "\n" + player.getMaxMP() + "\n" + player.getCurrentMP() +  "\n" + player.getAD() + "\n";
        save = save + player.getCritChance() + "\n" + player.getExp() + "\n" + player.getGold() + "\n" + player.getConsumablesHP() + "\n"; 
        save = save + player.getConsumablesMP() + "\n" + player.getEliminations();
        return save;
    }
    
    public static void loadGame(Player player)
    {
        File loadFile = new File("save.txt");
        try
        {
            Scanner scanner = new Scanner(loadFile);
            for (int i = 0; i < 11; i++)
            {
                if (i == 0) {player.setMaxHP(Double.parseDouble(scanner.nextLine()));}
                else if (i == 1) {player.setCurrentHP(Double.parseDouble(scanner.nextLine()));}
                else if (i == 2) {player.setMaxMP(Double.parseDouble(scanner.nextLine()));}
                else if (i == 3) {player.setCurrentMP(Double.parseDouble(scanner.nextLine()));}
                else if (i == 4) {player.setAD(Double.parseDouble(scanner.nextLine()));}
                else if (i == 5) {player.setCritChance(Integer.parseInt(scanner.nextLine()));}
                else if (i == 6) {player.setExp(Integer.parseInt(scanner.nextLine()));}
                else if (i == 7) {player.setGold(Integer.parseInt(scanner.nextLine()));}
                else if (i == 8) {player.setConsumablesHP(Integer.parseInt(scanner.nextLine()));}
                else if (i == 9) {player.setConsumablesMP(Integer.parseInt(scanner.nextLine()));}
                else if (i == 10) {player.setEliminations(Integer.parseInt(scanner.nextLine()));}
            }
        }
        catch (Exception ex)
        {
            System.out.println("ERROR: couldn't load file");
            ex.printStackTrace();
        }
    }

    public static Rooms outputRoom(Rooms[] rooms, String choice)
    {
      if (choice.equals("0"))
      {
        System.out.println("Room 1 chosen");
        return rooms[0];
      }
      else if (choice.equals("1"))
      {
        System.out.println("Room 2 chosen");
        return rooms[1];
      }
      else if (choice.equals("2"))
      {
        System.out.println("Room 3 chosen");
        return rooms[2];
      }
      else if (choice.equals("3"))
      {
        System.out.println("Room 4 chosen");
        return rooms[3];
      }
      else if (choice.equals("4"))
      {
        System.out.println("Room 5 chosen");
        return rooms[4];
      }
      else if (choice.equals("5"))
      {
        System.out.println("Room 6 chosen");
        return rooms[5];
      }
      else if (choice.equals("6"))
      {
        System.out.println("Room 7 chosen");
        return rooms[6];
      }
      else if (choice.equals("7"))
      {
        System.out.println("Room 8 chosen");
        return rooms[7];
      }
      else if (choice.equals("8"))
      {
        System.out.println("Room 9 chosen");
        return rooms[8];
      }
      else if (choice.equals("9"))
      {
        System.out.println("Room 10 chosen");
        return rooms[9];
      }
      else /* this else statement cannot be reached as the string variable choice, in this method, will always be an numbers from 0 to 9 */
      {
        return rooms[10];
      }
    }

    public void go2Room(Player player, Rooms room)
    {
      if ((room.getLootable() == true)&&(room.getEnemyCount() == room.enemy.length))
      {
        room.searchRoom(player, "There seems to be something hidden in the room");
      }
      else if ((room.getLootable() == false)&&(room.getEnemyCount() == room.enemy.length))
      {
        System.out.println("Room " + room.getRoomNumber() + " has already been cleared and there are no items to pick up...");
      }
      else
      {
        System.out.println("Engaging enemies");
        emulateCombat(player, room);
      }
    }

    public void emulateCombat(Player player, Rooms room)
    {
      if (room.getEnemyCount() == room.enemy.length)
      {
        System.out.println("The room has been cleared");
      }
      else
      {
        Enemies enemy = room.enemy[room.getEnemyCount()];
        Combat combat = new Combat(player, room, enemy);
      }
    }

  public void setRoom1(){this.choice = "0";}
  public void setRoom2(){this.choice = "1";}
  public void setRoom3(){this.choice = "2";}
  public void setRoom4(){this.choice = "3";}
  public void setRoom5(){this.choice = "4";}
  public void setRoom6(){this.choice = "5";}
  public void setRoom7(){this.choice = "6";}
  public void setRoom8(){this.choice = "7";}
  public void setRoom9(){this.choice = "8";}
  public void setRoom10(){this.choice = "9";}
  public void setShop(){this.choice = "Shop";}
  public void setInventory(){this.choice = "Inventory";}
  public void setFinish(){this.choice = "Finish";}
  public void setQuit(){this.choice = "Quit";}

  public String getRoom(){return choice;}
}
