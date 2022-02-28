import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ConvertorOn06_01_2022 extends JFrame implements ActionListener {


	// components
	private JLabel prompt;
	private JTextField input;
	private JButton convert;
	private JTextArea display;
	private KeyPad kpc;		// to be designed

	private JPanel inputPanel = new JPanel();
	private JPanel controlPanel = new JPanel(new BorderLayout(0,0));
	
	// class KeyPad
	
	private class KeyPad extends JPanel implements ActionListener{

		private final static int NOBUTTONS = 12;
		private JButton buttons [];
		private String [] labels = {"1","2","3","4","5","6","7","8","C","0","."};
		public KeyPad(){
			setLayout(new GridLayout(4,3));
			buttons = new JButton[NOBUTTONS];
			for ( int k = 0; k <  buttons.length;k++){
				buttons[k]= new JButton(labels[k]);
				buttons[k].addActionListener(this);
				add(buttons[k]);
			}
		}
		public void actionPerformed( ActionEvent e){

			String keyLabel = ((JButton)e.getSource()).getText();
			keyPressCallBack(keyLabel); // from outer class
		}
	 } // end pf KeyPad

	public void keyPressCallBack (String s){

		if  (s.equals("C"))
			input.setText(""); // clear 
		else	
			input.setText(input.getText() + s);


	}
	public ConvertorOn06_01_2022(){
	
		// create and add
	
		prompt = new JLabel("Temperature in Celsius :");
		input = new JTextField(10);
		
		inputPanel.add(prompt);
		inputPanel.add(input);

		// ester componet
		
		kpc = new KeyPad();
		
		convert = new JButton("Convert");
                convert.addActionListener(this);
		controlPanel.add(kpc,"Center");
		controlPanel.add(convert,"South");
		

		// Third component
		display = new JTextArea(10,20);
		display.setEditable(false);

		// add to main wondow
	
		Container  container = getContentPane();
		container.setLayout( new BorderLayout(4,4));
		container.add(inputPanel,"North");
		container.add(controlPanel,"East");
		container.add(display,"Center");


	}
	public void actionPerformed(ActionEvent e){
		try{
			double celsius = Double.parseDouble(input.getText());
			double farenheit = celsius * 9.0/5.0 + 32.0;
			display.append("Celsius " + celsius + " equals " + farenheit + "Farenheit\n");
			input.setText("");
		}catch(NumberFormatException ne){
			display.append("Input error\n");
			input.setText("");
		}
	}

	public static void main(String[] arg){

		Convertor c = new Convertor();
		c.setSize(400,300);
		c.setTitle("CS531-oopd-Unit-V");
		c.setVisible(true);
                
		c.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}});
		

	}
}

