import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InventoryGUI extends JFrame implements ActionListener
{
    private JFrame frame;
    private JButton b1;
    private JTextArea text;
    public InventoryGUI(Player player)
    {
        frame = new JFrame("Dungeon Game");
        frame.setSize(800, 640);
        frame.setResizable(false);
        frame.setLayout(null);

        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(325, 390, 350, 250);
        text = new JTextArea(displayInfo(player));
        text.setFont(text.getFont().deriveFont(25f));
        text.setBounds(30, 20, 940, 280);
        
        frame.add(b1);
        frame.add(text);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String choice = e.getActionCommand();
        if (choice.equalsIgnoreCase("Back"))
        {
            frame.dispose();
        }
    }
    
    public String displayInfo(Player player)
    {
        String info = "INVENTORY\n";
        if (player.inventory.size() == 0)
        {
           info = info + "Your inventory is empty";
        }
        else
        {
           info = info + "You currently possess:\n";
           for (int i = 0; i < player.inventory.size(); i++)
           {
               info = info + "\n" + player.inventory.get(i);
           }
           if (player.checkForParts() == true)
           {
               info = info + "You have all Secret Skill Parts. You've unlocked skill 3";
               player.unlockSkillThree();
           }
        }
        return info;   
    }
}
