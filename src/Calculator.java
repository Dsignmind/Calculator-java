import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame implements ActionListener{

	public static final int WIDTH = 300;
    public static final int HEIGHT = 400;
    private Double doubleValue = 0.0, tempDoubleValue = 0.0;
    private Integer intValue = 0, tempIntValue = 0;
    private boolean reset = true, plus = false, minus = false, nextExpected = false, doubleOperation = false;

    private JLabel blank_text;
    private JPanel UpperPanel, DisplayResultPanel, DisplayEnteredPanel, LowerButtonPanel;
    private JTextField enteredText, resultText;
    private JButton clearB, negB, sineB, eqB, plusB, minusB, B0, B1, B2, B3, B4, B5, B6, B7, B8, B9;
    private JButton[] numButtons = new JButton[10];
    
    public static void main(String[] args)
    {
        Calculator gui = new Calculator();
        gui.setVisible(true);
    }
    
    public Calculator(){
    	super("Calculator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
	
        UpperPanel = new JPanel( );
        UpperPanel.setLayout(new GridLayout(2,1));
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutChoice = new JMenuItem("About");
        aboutChoice.addActionListener(this);
        helpMenu.add(aboutChoice);
        JMenu exitMenu = new JMenu("Exit");
        JMenuItem exitChoice = new JMenuItem("Exit");
        exitChoice.addActionListener(this);
        exitMenu.add(exitChoice);
        
        DisplayResultPanel = new JPanel();
        DisplayResultPanel.setLayout(new BorderLayout());
        resultText = new JTextField();
        resultText.setEditable(false);
        DisplayResultPanel.add(resultText, BorderLayout.CENTER);
        UpperPanel.add(DisplayResultPanel);
        DisplayEnteredPanel = new JPanel();
        DisplayEnteredPanel.setLayout(new BorderLayout());
        enteredText = new JTextField();
        enteredText.setEditable(false);
        enteredText.setText("0");
        DisplayEnteredPanel.add(enteredText, BorderLayout.CENTER);
        UpperPanel.add(DisplayEnteredPanel);
        add(UpperPanel, BorderLayout.NORTH);
        
        LowerButtonPanel = new JPanel();
        LowerButtonPanel.setLayout(new GridLayout(5,4));
        clearB = new JButton("Clear");
        clearB.addActionListener(this);
        LowerButtonPanel.add(clearB);
        negB = new JButton("Neg");
        negB.addActionListener(this);
        LowerButtonPanel.add(negB);
        sineB = new JButton("Sine");
        sineB.addActionListener(this);
        LowerButtonPanel.add(sineB);
        blank_text = new JLabel(" ");
        LowerButtonPanel.add(blank_text);
        for(int i = 7; i < 10; i++){
        	numButtons[i] = new JButton(" " + i + " ");
        	numButtons[i].addActionListener(this);
        	LowerButtonPanel.add(numButtons[i]);
        }
        /*B7 = new JButton(" 7 ");
        B7.addActionListener(this);
        LowerButtonPanel.add(B7);
        B8 = new JButton(" 8 ");
        B8.addActionListener(this);
        LowerButtonPanel.add(B8);
        B9 = new JButton(" 9 ");
        B9.addActionListener(this);
        LowerButtonPanel.add(B9);*/
        blank_text = new JLabel(" ");
        LowerButtonPanel.add(blank_text);
        for(int i = 4; i < 7; i++){
        	numButtons[i] = new JButton(" " + i + " ");
        	numButtons[i].addActionListener(this);
        	LowerButtonPanel.add(numButtons[i]);
        }
        /*B4 = new JButton(" 4 ");
        B4.addActionListener(this);
        LowerButtonPanel.add(B4);
        B5 = new JButton(" 5 ");
        B5.addActionListener(this);
        LowerButtonPanel.add(B5);
        B6 = new JButton(" 6 ");
        B6.addActionListener(this);
        LowerButtonPanel.add(B6);*/
        blank_text = new JLabel(" ");
        LowerButtonPanel.add(blank_text);
        for(int i = 1; i < 4; i++){
        	numButtons[i] = new JButton(" " + i + " ");
        	numButtons[i].addActionListener(this);
        	LowerButtonPanel.add(numButtons[i]);
        }
        /*B1 = new JButton(" 1 ");
        B1.addActionListener(this);
        LowerButtonPanel.add(B1);
        B2 = new JButton(" 2 ");
        B2.addActionListener(this);
        LowerButtonPanel.add(B2);
        B3 = new JButton(" 3 ");
        B3.addActionListener(this);
        LowerButtonPanel.add(B3);*/
        blank_text = new JLabel(" ");
        LowerButtonPanel.add(blank_text);
        numButtons[0] = new JButton(" 0 ");
    	numButtons[0].addActionListener(this);
    	LowerButtonPanel.add(numButtons[0]);
        /*B0 = new JButton(" 0 ");
        B0.addActionListener(this);
        LowerButtonPanel.add(B0);*/
        plusB = new JButton(" + ");
        plusB.addActionListener(this);
        LowerButtonPanel.add(plusB);
        minusB = new JButton(" - ");
        minusB.addActionListener(this);
        LowerButtonPanel.add(minusB);
        eqB = new JButton(" = ");
        eqB.addActionListener(this);
        LowerButtonPanel.add(eqB);
        add(LowerButtonPanel);
       
        JMenuBar bar = new JMenuBar( );
        bar.add(helpMenu);
        bar.add(exitMenu);
        setJMenuBar(bar);
    }    
    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand( );

        if (buttonString.equals("Exit"))
        {
        	System.exit(0);
        }
        else if (buttonString.equals("About"))
        {
        	new About();
        }
        else if (buttonString.equals(" - "))
        {
        	minus = true;
        	doubleValue = Double.valueOf(enteredText.getText());
        	if(doubleValue % 1 != 0){
        		tempDoubleValue = Double.valueOf(enteredText.getText());
            	resultText.setText(Double.toString(tempDoubleValue) + " -");
            	doubleOperation = true;
        	}
        	else{
	        	tempIntValue = Integer.valueOf(enteredText.getText());
	        	resultText.setText(Integer.toString(tempIntValue) + " -");
        	}
        	nextExpected = true;
        }
        else if (buttonString.equals(" + "))
        {
        	plus = true;
        	doubleValue = Double.valueOf(enteredText.getText());
        	if(doubleValue % 1 != 0){
        		tempDoubleValue = Double.valueOf(enteredText.getText());
            	resultText.setText(Double.toString(tempDoubleValue) + " +");
            	doubleOperation = true;
        	}
        	else{
	        	tempIntValue = Integer.valueOf(enteredText.getText());
	        	resultText.setText(Integer.toString(tempIntValue) + " +");
        	}
        	nextExpected = true;
        }
        else if (buttonString.equals(" = "))
        {
        	String tempString;
        	if(minus){
        		tempString = resultText.getText();
        		if(doubleOperation){
        			tempDoubleValue -= Double.valueOf(enteredText.getText());
        			resultText.setText(tempString + " " + enteredText.getText());
            		enteredText.setText(String.format("%.2f",tempDoubleValue));
            		doubleOperation = false;
        		}
        		else{
	        		tempIntValue -= Integer.valueOf(enteredText.getText());
	        		resultText.setText(tempString + " " + enteredText.getText());
	        		enteredText.setText(Integer.toString(tempIntValue));
        		}
        		nextExpected = false;
        		minus = false;
        	}
        	else if(plus){
        		tempString = resultText.getText();
        		if(doubleOperation){
        			tempDoubleValue += Double.valueOf(enteredText.getText());
        			resultText.setText(tempString + " " + enteredText.getText());
            		enteredText.setText(String.format("%.2f",tempDoubleValue));
            		doubleOperation = false;
        		}
        		else{
	        		tempIntValue += Integer.valueOf(enteredText.getText());
	        		resultText.setText(tempString + " " + enteredText.getText());
	        		enteredText.setText(Integer.toString(tempIntValue));
        		}
        		nextExpected = false;
        		plus = false;
        	}
        	else{
        		resultText.setText(enteredText.getText());
        	}
        }
        else if (buttonString.equals("Sine"))
        {
        	doubleValue = Double.valueOf(enteredText.getText());
        	resultText.setText(String.format("Sine(%.0f)",doubleValue));
        	enteredText.setText(String.format("%.2f", Math.sin(doubleValue.doubleValue())));
        }
        else if (buttonString.equals("Neg")){
        	doubleValue = Double.valueOf(enteredText.getText());
        	if(doubleValue % 1 != 0){
        		resultText.setText(String.format("Neg(%.2f)",doubleValue));
        		if(doubleValue < 0.0){
        			doubleValue *= -1;
        			enteredText.setText(Double.toString(doubleValue));
        		}
        		else
        			enteredText.setText("-" + enteredText.getText());
        	}
        	else{
        		intValue = Integer.valueOf(enteredText.getText());
        		resultText.setText(String.format("Neg(%d)",intValue));
        		if(intValue < 0){
        			intValue *= -1;
        			enteredText.setText(Integer.toString(intValue));
        		}
        		else
        			enteredText.setText("-" + enteredText.getText());
        	}
        	
        }
        else if (buttonString.equals("Clear")){
        	resultText.setText("");
        	enteredText.setText("0");
        	reset = true;
        }
        else if (buttonString.equals(" 1 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("1");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "1");
        	reset = false;
        }
        else if (buttonString.equals(" 2 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("2");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "2");
        	reset = false;
        }
        else if (buttonString.equals(" 3 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("3");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "3");
        	reset = false;
        }
        else if (buttonString.equals(" 4 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("4");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "4");
        	reset = false;
        }
        else if (buttonString.equals(" 5 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("5");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "5");
        	reset = false;
        }
        else if (buttonString.equals(" 6 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("6");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "6");
        	reset = false;
        }
        else if (buttonString.equals(" 7 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("7");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "7");
        	reset = false;
        }
        else if (buttonString.equals(" 8 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("8");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "8");
        	reset = false;
        }
        else if (buttonString.equals(" 9 "))
        {
        	if(reset || nextExpected){
        		enteredText.setText("9");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "9");
        	reset = false;
        }
        else if (buttonString.equals(" 0 "))
        {
        	if(reset || nextExpected){
        		reset = false;
        		enteredText.setText("0");
        		nextExpected = false;
        	}
        	else
        		enteredText.setText(enteredText.getText() + "0");
        }
        else
        {
            System.out.println("Unexpected error.");
        }
    }
    public class About extends JFrame implements ActionListener{

    	public static final int WIDTH = 220;
        public static final int HEIGHT = 200;
        private JTextArea about;
        private JPanel textPanel;
        private JButton okB;
        public String  aboutString= "\n   Calculator program.\n"
        							+ "   Version: 1.0\n"
        							+ "   Author: Daniel Wilson\n"
        							+ "   A simple calculator program.\n"
        							+ "   Features sine function, plus\n"
        							+ "   minus, and negative function.";
        
        public About(){
        	super("About");
            setSize(WIDTH, HEIGHT);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new BorderLayout());
            textPanel = new JPanel();
            textPanel.setLayout(new BorderLayout());
            about = new JTextArea(aboutString);
            about.setEditable(false);
            textPanel.add(about, BorderLayout.CENTER);
           
            okB = new JButton(" OK ");
            okB.addActionListener(this);
            textPanel.add(okB, BorderLayout.SOUTH);
            add(textPanel);
        }
        public void actionPerformed(ActionEvent e)
        {
        	String buttonString = e.getActionCommand( );

            if (buttonString.equals(" OK ")){
            	setVisible(false);
            }
            else{
                System.out.println("Unexpected error.");
            }
        }
    }
}

