package Part_3_GUI;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI
{
    public void start()
    {
        // Creating a frame
        JFrame frame1 = new JFrame("Project 3"); // create a frame
        frame1.setResizable(false); // Prevent user from resizing the window
        frame1.setSize(800, 600); // size of the window
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // When clicked close button - exit
        //frame1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); When clicked close button - just ignore)

        // simple buttons creation
        JButton button = new JButton("Don't click me!");
        JButton button2 = new JButton("DO NOT Click me!");

        // Creating labels
        JLabel label1 = new JLabel("Hey there, it said DO NOT click, but I see you like to risk");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        // Creating  Images to use in my program
        ImageIcon image = new ImageIcon("/Users/alexseiichenko/IdeaProjects/SDT_101_Project3/src/Part_3_GUI/images.png");
        ImageIcon image_stop = new ImageIcon("/Users/alexseiichenko/IdeaProjects/SDT_101_Project3/src/Part_3_GUI/Picture.png");
        // Creating image label
        JLabel imageLabel = new JLabel(image);
        Button show = new Button("Show an image");
        // When user will click "Show" a new pop-up window with an image will open
        show.addActionListener(e -> JOptionPane.showMessageDialog(frame1, imageLabel));

        JLabel label2 = new JLabel("Hi, This is Project 3");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        frame1.add(label2, "Center");

        // Text fields
        TextField textField = new TextField("You can write your text here");
        frame1.add(textField, "West");

        // Adding functionality to the first button and text field using a lambda expression, which is available only in Java 8
        button.addActionListener(e -> {
            frame1.add(button2, "South");
            frame1.add(label1, "Center");
            frame1.setVisible(true); // show the changes
        });

        textField.addActionListener(e -> {
            String inp = textField.getText();
            JOptionPane.showMessageDialog(frame1, "You've wrote " + inp + "?!", "User input", JOptionPane.PLAIN_MESSAGE);
        });

        // Adding functionality to the second button using an anonymous inner class
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Here we create a pop-up window that shows us a label with an image
                        JLabel labelAlert = new JLabel("OH I UNDERSTAND YOU'RE BRAVE! Next time you click button with " +
                                "the same message again, be careful, maybe it will wipe down your entire drive");
                        labelAlert.setIcon(image_stop);
                        JOptionPane.showMessageDialog(frame1, labelAlert);
                    }
                });

        // Here I create a new button which will create a new window with something in it using lambda expression
        JButton button3 = new JButton("New window");
        frame1.add(button3, "East");
        // using lambda expression to add functionality to my button
        // I could do it in a separate method to make the code more readable
        button3.addActionListener(e -> {
            JFrame frame2 = new JFrame("New WINDOW");
            frame2.setSize(400,400);
            frame2.setResizable(true); // window will be resizable
            frame2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // User won't be able to close it

            // set layout for our new window
            JPanel panel1 = new JPanel();
            GridLayout gridLayout = new GridLayout(6,6);
            panel1.setLayout(gridLayout);
            // Here I create new buttons and labels for my new window
            JButton changeColor = new JButton("Change color");
            changeColor.addActionListener(b -> panel1.setBackground(new Color(0xE7, 0x58, 0x3A)));

            JButton messageD = new JButton("Try me");
            // Button which will show a pop-up with a choice
            // showInputDialog
            messageD.addActionListener(b -> {
                try
                {
                    int op = Integer.parseInt(JOptionPane.showInputDialog(panel1, "How old are you?"));
                    if (op < 14)
                    {
                        JOptionPane.showMessageDialog(panel1, "YOU'RE TOO YOUNG!");
                    }
                    else {JOptionPane.showMessageDialog(panel1, "That's interesting");}
                }

                catch (Exception c)
                {
                    JOptionPane.showMessageDialog(panel1, "THIS IS NOT THE PROPER ANSWER!");
                }
                frame2.setVisible(true);
            });

            JButton ex = new JButton("EXIT");
            // showConfirmDialog
            ex.addActionListener(b -> {
                int option = JOptionPane.showConfirmDialog(panel1, "You sure you want to exit?");
                if(option == JOptionPane.YES_OPTION)
                {
                    System.exit(405);
                }

            });
            // add stuff for our window
            panel1.add(show);
            panel1.add(changeColor);
            panel1.add(messageD);
            panel1.add(nextWindow()); // add a button to create a new window
            panel1.add(ex);

            frame2.add(panel1);
            frame2.setVisible(true);
        });

        // Add a new button to the frame
        frame1.add(button, "North");
        // Make the frame visible
        frame1.setVisible(true);
    }

    public JButton nextWindow()
    {
        JButton button = new JButton("Next Window");
        button.addActionListener(e ->
                {
                    JFrame frame = new JFrame(); // create a new window
                    frame.setSize(1000,1000); // set window size
                    JPanel panel = new JPanel(); // create a new panel
                    FlowLayout flow = new FlowLayout(); // create a flow layout
                    panel.setLayout(flow); // set box layout to the panel

                    // Image
                    ImageIcon image = new ImageIcon("/Users/alexseiichenko/IdeaProjects/SDT_101_Project3/src/Part_3_GUI/Memphis-Style-Backgrunds.jpg");
                    JLabel imageLabel = new JLabel(image);

                    // Buttons and functionality
                    JLabel label1 = new JLabel("Hey there, this is an example of a FLOW layout!");
                    label1.setFont(new Font("Arial", Font.PLAIN, 15));
                    label1.setForeground(new Color(139, 0, 0));

                    // Event handler using lambda expression to create an exit button
                    JButton button1 = new JButton("Exit");
                    button1.addActionListener(c -> {
                        int option = JOptionPane.showConfirmDialog(panel, "You sure you want to exit?");
                        if(option == JOptionPane.YES_OPTION)
                        {
                            System.exit(405); // when "Yes" - terminate the app
                        }
                    });
                    // add elements to the panel
                    panel.add(label1);
                    panel.add(button1);
                    panel.add(imageLabel);
                    // add panel with UI to the frame and show it
                    frame.add(panel);
                    frame.setVisible(true);
                });
        return button;
    }
}
