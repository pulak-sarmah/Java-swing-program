import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewConvertor extends JFrame implements ActionListener {
    // components
    private JLabel prompt;
    private JTextField input;
    private JButton convertC;
    private JButton convertF;
    private JTextArea display;
    private KeyPad kpc; // to be designed

    private JPanel inputPanel = new JPanel();
    private JPanel controlPanel = new JPanel(new BorderLayout(0,0));
    private JPanel subPanel = new JPanel();

    // class KeyPad
    private class KeyPad extends JPanel implements ActionListener {
        private final static int NOBUTTONS = 12;
        private JButton buttons [];
        private String [] labels = {"1","2","3","4","5","6","7","8","9","C","0","."};
        public KeyPad() {
            setLayout(new GridLayout(4,3));
            buttons = new JButton[NOBUTTONS];
            for ( int k = 0; k <  buttons.length;k++) {
                buttons[k]= new JButton(labels[k]);
                buttons[k].addActionListener(this);
                add(buttons[k]);
            }
        }
        public void actionPerformed( ActionEvent e) {
            String keyLabel = ((JButton)e.getSource()).getText();
            keyPressCallBack(keyLabel); // from outer class
        }
    } // end of KeyPad class
    public void keyPressCallBack (String s) {
        if  (s.equals("C"))
            input.setText(""); // clear
        else
            input.setText(input.getText() + s);
    }
    public NewConvertor() {
        // create and add

        prompt = new JLabel("Temperature reading :");
        input = new JTextField(10);

        inputPanel.add(prompt);
        inputPanel.add(input);

        // eastern componet
        
        kpc = new KeyPad();

        convertC = new JButton("Celsius");
        convertC.addActionListener(this);
        convertF = new JButton("Farenheit");
        convertF.addActionListener(this);
        controlPanel.add(kpc,"Center");
        
        subPanel.add(convertC);
        subPanel.add(convertF);
        controlPanel.add(subPanel,"South");

        // Third component
        display = new JTextArea(10,20);
        display.setEditable(false);

        // add to main window

        Container  container = getContentPane();
        container.setLayout( new BorderLayout(4,4));
        container.add(inputPanel,"North");
        container.add(controlPanel,"East");
        container.add(display,"Center");
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == convertC){
                double val = Double.parseDouble(input.getText());
                double celsius = (val - 32) * 5.0/9.0;
                if (celsius >= 0.0 && celsius <= 100.0){
                    display.append("Farenheit " + val + " equals" + celsius + "Celsius\n");
                }
                else {
                    display.append("Value is not in range 0.0 - 100.0\n");
                }
            }
            else if (e.getSource() == convertF) {
                double val = Double.parseDouble(input.getText());
                double farenheit = val * 9.0/5.0 + 32.0;
                if (farenheit >= 32.0 && farenheit <= 212.0){
                    display.append("Celsius " + val + " equals" + farenheit + "Farenheit\n");
                }
                else {
                    display.append("Value is not in range 32.0 - 212.0\n");
                }
            }
            
            input.setText("");
        } catch(NumberFormatException ne) {
            display.append("Input error\n");
            input.setText("");
        }
    }

    public static void main(String[] arg) {
        NewConvertor c = new NewConvertor();
        c.setSize(500,500);
        c.setTitle("CS531 oopd Unit-V - Assignment 3");
        c.setVisible(true);

        c.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}

