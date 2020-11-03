import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 

  JButton increaseButton;
  JButton resetButton;

  JLabel increaseLabel;
  JLabel counterLabel;

  JTextField increaseText;
  JTextField counterText;

  JPanel mainPanel;
   
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    mainPanel = new JPanel();
    
    mainPanel.setLayout(null);

    increaseButton = new JButton("Increase");
    increaseButton.setBounds(100, 100, 100, 50);
    resetButton = new JButton("Reset");
    resetButton.setBounds(220, 100, 100, 50);

    increaseLabel = new JLabel("Increase By:");
    increaseLabel.setBounds(100, 200, 100, 50);
    counterLabel = new JLabel("Counter:");
    counterLabel.setBounds(100, 300, 100, 50);

    increaseText = new JTextField();
    increaseText.setBounds(200, 200, 100, 50);
    counterText = new JTextField("0");
    counterText.setBounds(200, 300, 100, 50);


    increaseButton.setActionCommand("Increase");
    resetButton.setActionCommand("Reset");

    increaseButton.addActionListener(this);
    resetButton.addActionListener(this);



    mainPanel.add(increaseButton);
    mainPanel.add(resetButton);
    mainPanel.add(increaseLabel);
    mainPanel.add(counterLabel);
    mainPanel.add(increaseText);
    mainPanel.add(counterText);

    frame.add(mainPanel);
   
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // get the numbers that the user entered 
    String userNum = increaseText.getText();
    String count = counterText.getText();
    // convert these String into integers

    int countNum = Integer.parseInt(count);

    int numUser = Integer.parseInt(userNum);


    if(command.equals("Increase")){
      int countAdded = countNum + numUser;
      counterText.setText("" + countAdded);
    
    if(numUser == 10){
      counterText.setText("10");
      }
}   if(command.equals("Reset")){
      counterText.setText("0");
}
      


  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
