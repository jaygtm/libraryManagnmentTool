package common.service;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validation {
			public static void validateDecimal(JTextField textfield){
				textfield.addKeyListener(new KeyAdapter(){
			    public void keyPressed(KeyEvent e){
			
			        char ch = e.getKeyChar();
			        if(Character.isDigit(ch)|| (ch+"").equals(".")){
			        }
			        else{
			        	String content=textfield.getText();
			        	JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
			        	textfield.setText(content);
			        }
			    }
			});
		}		

			public static void validateNumber(JTextField textfield){
				textfield.addKeyListener(new KeyAdapter(){
			    public void keyPressed(KeyEvent e){
			
			        char ch = e.getKeyChar();
			        if(Character.isDigit(ch)){
			        }
			        else{
			        	String content=textfield.getText();
			        	JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
			        	textfield.setText(content);
			        }
			    }
			});
		}		

			public static void validateMobileNumber(JTextField textfield){
				textfield.addKeyListener(new KeyAdapter(){
			    public void keyPressed(KeyEvent e){
			
			        char ch = e.getKeyChar();
			        if(Character.isDigit(ch) || textfield.getText().length()<=10){
			        }
			        else{
			        	String content=textfield.getText();
			        	JOptionPane.showMessageDialog(null, "Only numbers or 10 Digits are allowed!");
			        	textfield.setText(content);
			        }
			    }
			});
		}	
			
			public static void validateEmail(JTextField textfield){
				textfield.addKeyListener(new KeyAdapter(){
			    public void keyPressed(KeyEvent e){
			
			        char ch = e.getKeyChar();
			        if(Character.isAlphabetic(ch) ||Character.isDigit(ch)|| (ch+"").equals(".") || (ch+"").equals("@")){
			        }
			        else{
			        	String content=textfield.getText();
			        	JOptionPane.showMessageDialog(null, "Only character,number,@,. are allowed!");
			        	textfield.setText(content);
			        }
			    }
			});
		}		

			public static void validateString(JTextField textfield){
				textfield.addKeyListener(new KeyAdapter(){
			    public void keyPressed(KeyEvent e){
			
			        char ch = e.getKeyChar();
			        if(Character.isAlphabetic(ch)){
			        }
			        else{
			        	String content=textfield.getText();
			        	JOptionPane.showMessageDialog(null, "Only Alphabet are allowed!");
			        	textfield.setText(content);
			        }
			    }
			});
		}		

}
