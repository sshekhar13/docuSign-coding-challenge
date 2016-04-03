package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.InputController;

/**
 * This is the View Applet class that launches the application where you can enter the 
 * command in one text field and on clicking Process you can see the optput 
 * in the next text field.
 * 
 * You can either run this file and launch the application
 * or you can run the PajamaPartyDriver.java and enter the command
 * in the console to get the desired output.
 * 
 * @author Shashank Shekhar
 *
 */
public class GettingReadyUI extends JApplet implements ActionListener {
    JTextField textField1, textField2;
    Button process;

    public void init() {
        this.setSize(600, 300);
        Label label1 = new Label("Enter Command: ");
        textField1 = new JTextField(20);
        Box box1 = Box.createHorizontalBox();
        box1.add(label1);
        box1.add(textField1);

        Label label2 = new Label("Output: ");
        textField2 = new JTextField(40);
        textField2.setEditable(false);
        Box box2 = Box.createHorizontalBox();
        box2.add(label2);
        box2.add(new Label(" "));
        box2.add(textField2);

        process = new Button("Process");
        process.addActionListener(this);
        Box box3 = Box.createHorizontalBox();
        box3.add(process);

        Box filler = Box.createHorizontalBox();
        filler.add(new Label(""));

        Box dialog = Box.createVerticalBox();
        dialog.add(box1);
        dialog.add(box2);
        dialog.add(filler);
        dialog.add(box3);

        JPanel panel = new JPanel();
        Border runBorder = BorderFactory.createMatteBorder(1, 1, 1, 1,
                Color.black);
        panel.setBorder(runBorder);
        panel.add(dialog);
        Container cp = getContentPane();
        cp.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        String input = textField1.getText();
        InputController controller = new InputController();
        String result = controller.parseAndReturnOutput(input);
        textField2.setText(result);
    }

}
