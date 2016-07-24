
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Calculator implements ActionListener {
	private JFrame frame;
	private JTextField display;
	private JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,plus,minus,multiply,divide,decimal,equals,backspace,clear,ans,zero;
	private String expression;
	private String lastResult="";
	private JPanel MainPanel;
	private JPanel GridPanel;
	
	public void buildGui(){
		setDesign();
		expression="";
		frame= new JFrame("Calculator");
		display= new JTextField("0");
		display.setEditable(false);
		frame.add(display,BorderLayout.NORTH);
		MainPanel=new JPanel();
		GridPanel=new JPanel();
		GridPanel.setLayout(new GridLayout(5,4));
		Font font = new Font("Calibri", Font.BOLD, 20);
		display.setFont(font);
		button1=new JButton("1");
		button1.addActionListener(this);
		button2=new JButton("2");
		button2.addActionListener(this);
		button3=new JButton("3");
		button3.addActionListener(this);
		button4=new JButton("4");
		button4.addActionListener(this);
		button5=new JButton("5");
		button5.addActionListener(this);
		button6=new JButton("6");
		button6.addActionListener(this);
		button7=new JButton("7");
		button7.addActionListener(this);
		button8=new JButton("8");
		button8.addActionListener(this);
		button9=new JButton("9");
		button9.addActionListener(this);
		zero=new JButton("0");
		zero.addActionListener(this);
		Font buttonfont = new Font("Arial", Font.BOLD, 20);
		plus=new JButton("+");
		plus.setFont(buttonfont);
		plus.addActionListener(this);
		minus=new JButton("-");
		minus.setFont(buttonfont);
		minus.addActionListener(this);
		multiply=new JButton("*");
		multiply.setFont(buttonfont);
		multiply.addActionListener(this);
		divide=new JButton("/");
		divide.setFont(buttonfont);
		divide.addActionListener(this);
		decimal=new JButton(".");
		decimal.setFont(buttonfont);
		decimal.addActionListener(this);
		clear=new JButton("Clear");
		clear.addActionListener(this);
		backspace=new JButton("Backspace");
		backspace.addActionListener(this);
		ans=new JButton("Last Ans.");
		ans.addActionListener(this);
		equals=new JButton("=");
		equals.addActionListener(this);
		GridPanel.add(button1);
		GridPanel.add(button2);
		GridPanel.add(button3);
		GridPanel.add(divide);
		GridPanel.add(button4);
		GridPanel.add(button5);
		GridPanel.add(button6);
		GridPanel.add(multiply);
		GridPanel.add(button7);
		GridPanel.add(button8);
		GridPanel.add(button9);
		GridPanel.add(minus);
		GridPanel.add(zero);
		GridPanel.add(decimal);
		GridPanel.add(equals);
		GridPanel.add(plus);
		GridPanel.add(clear);
		GridPanel.add(backspace);
		GridPanel.add(ans);
		MainPanel.add(GridPanel);
		frame.getContentPane().add(MainPanel, BorderLayout.CENTER);
		frame.setSize(400,270);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setDisplay(){
		String[] exp=expression.split(",");
		String modified="";
		for(String e:exp)
			modified+=e;
		display.setText(modified);
	}
	
	 public final void setDesign() {
	        try {
	            UIManager.setLookAndFeel(
	                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch(Exception e) {   
	        }
	    }
	
	public void evaluate(){
		try{
			String[] exp=expression.split(",");
			double a=0.0;
			double b=0.0;
			double result=0.0;
			for(int i=0;i<exp.length;){
				if(i<2){
					a=Double.parseDouble(exp[i]);
					b=Double.parseDouble(exp[i+2]);
					if(exp[i+1].equals("+")){
						result=a+b;
					}
					else if(exp[i+1].equals("-")){
						result=a-b;
					}
					else if(exp[i+1].equals("*")){
						result=a*b;
					}
					else if(exp[i+1].equals("/")){
						result=a/b;
					}
					i=3;
				}
				else{
					a=Double.parseDouble(exp[i+1]);
					if(exp[i].equals("+")){
						result=result+a;
						
					}
					else if(exp[i].equals("-")){
						result=result-a;
					}
					else if(exp[i].equals("*")){
						result=result*a;
					}
					else if(exp[i].equals("/")){
						result=result/a;
					}
					i+=2;
				}
			}
			String finalResult="";
			finalResult+=result;  //for converting double to string
			lastResult=finalResult;
			display.setText(finalResult);
			expression="";
		}
		catch(ArrayIndexOutOfBoundsException e){
			display.setText("Please write correct expression");
		}
		catch(NumberFormatException e){
			display.setText("Please write correct expression");
		}
	}
	public void actionPerformed(ActionEvent event){
		switch(event.getActionCommand()){
		case "1":
			expression+="1";
			setDisplay();
			break;
		case "2":
			expression+="2";
			setDisplay();
			break;
		case "3":
			expression+="3";
			setDisplay();
			break;
		case "4":
			expression+="4";
			setDisplay();
			break;
		case "5":
			expression+="5";
			setDisplay();
			break;
		case "6":
			expression+="6";
			setDisplay();
			break;
		case "7":
			expression+="7";
			setDisplay();
			break;
		case "8":
			expression+="8";
			setDisplay();
			break;
		case "9":
			expression+="9";
			setDisplay();
			break;
		case "0":
			expression+="0";
			setDisplay();
			break;
		case "/":
			expression+=",/,";
			setDisplay();
			break;
		case "*":
			expression+=",*,";
			setDisplay();
			break;
		case "-":
			expression+=",-,";
			setDisplay();
			break;
		case "+":
			expression+=",+,";
			setDisplay();
			break;
		case ".":
			expression+=".";
			setDisplay();
			break;
		case "=":
			evaluate();
			break;
		case "Backspace":
			try{
				if(expression!=""){  //so that backspace don't work on empty string or after calculation is over
				String newExpression="";
				newExpression=expression.substring(0, expression.length()-1);
				expression=newExpression;
				if((expression.endsWith("+"))||(expression.endsWith("-"))||(expression.endsWith("*"))||(expression.endsWith("/"))){
					newExpression=expression.substring(0, expression.length()-2);
					expression=newExpression;
				}
				setDisplay();
			}
		}
		catch(StringIndexOutOfBoundsException exception){}
		break;
		case "Clear":
			expression="";
			display.setText("0");
			break;
		case "Last Ans.":
			if(lastResult!=""){
				expression+=lastResult;
				setDisplay();
			}
			break;
		}
	}
	
	public static void main(String[] args){
		Calculator modCal=new Calculator();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				modCal.buildGui();
			}
		});
	}
}


