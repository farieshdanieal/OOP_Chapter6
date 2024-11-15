/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalcalculator;


// LINK YOUTUBE: https://youtu.be/dfhmTyRTCSQ?si=mXtqsayNBv7gQ2Lr


// Letak library yang related
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FinalCalculator implements ActionListener {

    // Component untuk calculator (butang, panel, textfield dengan frame)
    JFrame frame;  // Window frame untuk calculator punya display
    JTextField textfield;  // Ruang untuk result
    JButton[] numberButtons = new JButton[10];  // Untuk hold digit 0 sampai 9
    JButton[] functionButtons = new JButton[9];  // Untuk function button
    JButton addButton, subButton, mulButton, divButton;  // Untuk operasi tambah tolak bahagi darab
    JButton decButton, equButton, delButton, clrButton, negButton;  // button untuk decimal, equal, delete, clear and negatif
    JPanel panel;  // Panel untuk organize button

    Font myFont = new Font("Tahoma", Font.BOLD, 30);  // Font style untuk button ngan textfield

    double num1 = 0, num2 = 0, result = 0;  // Initialize variable untuk nombor 1, nombor 2 and result
    char operator;  // Variable untuk store operator
    boolean decimalUsed = false;  // Check decimal

    FinalCalculator() {

        // Main Frame untuk window Calculator
        frame = new JFrame("Fariesh's Calculator"); //Nama program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Tutup program bila bak close
        frame.setSize(420, 550);  // Size of window
        frame.setLayout(null);  // Positioning
        frame.getContentPane().setBackground(new Color(0xEADDCA));  // Set background color
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconCalculator.png")));
        
        

        // Setup text field nak display nombor and result
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);  // Position and size untuk textfield
        textfield.setFont(myFont);  // Set font untuk textfield
        textfield.setEditable(false);  // Buat textfield tak boleh nak edit

        // Initialize function button
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CE");
        negButton = new JButton("(-)");

        // Add the function buttons to the functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Loop function button untuk set property yang sama
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);  // Tambah action listener dekat button
            functionButtons[i].setFont(myFont);  // Set font untuk button
            functionButtons[i].setBackground(new Color(0xE1C16E));  // Set background color
            functionButtons[i].setForeground(Color.WHITE);  // Set text color
            functionButtons[i].setFocusable(false);  // buang focus border dekat button
        }

        // Loop number buttons (0-9) untuk set property yang sama
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));  // Create a buttonn tak lebih 10
            numberButtons[i].addActionListener(this);  // Tambah action listener dekat button
            numberButtons[i].setFont(myFont);  // Set font untuk button
            numberButtons[i].setBackground(new Color(0xC19A6B));  // Set background color
            numberButtons[i].setForeground(Color.WHITE);  // Set text color
            numberButtons[i].setFocusable(false);  // // buang focus border dekat button
        }

        // Set border untuk negatif, delete dengan clear button
        negButton.setBounds(50, 430, 100, 50);  // Position untuk negatif button
        delButton.setBounds(150, 430, 100, 50);  // Position untuk delete button
        clrButton.setBounds(250, 430, 100, 50);  // Position untuk clear button

        // Tentukan posisi button nombor dengan button function dalam grid
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);  // Position dengan size panel
        panel.setLayout(new GridLayout(4, 4, 6, 6));  // Grid layout untuk panel (4 row, 4 column, 6px gap)

        //Tambah button ikut urutan dia
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Tambah component dalam frame calculator
        frame.add(panel);  // tambah panel untuk button di atas
        frame.add(negButton);  // Tambah butang negatif
        frame.add(delButton);  // Tambah butang delete 
        frame.add(clrButton);  // Tambah butang clear 
        frame.add(textfield);  // Tambah text field dekat atas
        frame.setVisible(true);  // Set frame visible
    }

    // Main method
    public static void main(String[] args) {
        FinalCalculator calc = new FinalCalculator();  // Create object untuk calculator
    }

    // Action listener untuk button
    @Override
    public void actionPerformed(ActionEvent e) {

        // Check kalau butang dah click
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                // Letak nombor yang di click dekat textfield
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // Check kalau butang decimal di tekan
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));  // Append a decimal point to the textfield
            decimalUsed = true;  // Mark that a decimal has been used
        }

        // Check kalau butang tambah di tekan
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());  // Store the first number
            operator = '+';  // Set the operator to addition
            textfield.setText("");  // Clear the textfield for the next number
            decimalUsed = false;  // Reset decimal usage
        }

        // Check kalau butang tolak di tekan
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
            decimalUsed = false;
        }

        // Check kalau butang darab di tekan
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '×';
            textfield.setText("");
            decimalUsed = false;
        }

        // Check kalau butang bahagi di tekan
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
            decimalUsed = false;
        }

        // Check kalau butang equal di tekan untuk kira result
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());  // Store nombor kedua

            String equation = "";  // String untuk display whole operasi

            // Switch case untuk display result based on button yang ditekan
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    equation = formatNumber(num1) + " + " + formatNumber(num2) + " = ";  
                    break;
                case '-':
                    result = num1 - num2;
                    equation = formatNumber(num1) + " - " + formatNumber(num2) + " = ";
                    break;
                case '×':
                    result = num1 * num2;
                    equation = formatNumber(num1) + " × " + formatNumber(num2) + " = ";
                    break;
                case '÷':
                    result = num1 / num2;
                    equation = formatNumber(num1) + " ÷ " + formatNumber(num2) + " = ";
                    break;
            }

            // Setkan result untuk display sebagai nombor bulat kalau jawapan dia takde decimal
            if (result == (int) result) {
                equation += String.valueOf((int) result);
            } else {
                equation += String.valueOf(result);
            }

            textfield.setText(equation);  //Display whole operasi 
            num1 = result;  //Simpan nombor pertama
        }

        // Check kalau clear button ditekan
        if (e.getSource() == clrButton) {
            textfield.setText("");  // Clear textfield
        }

        // Check kalau delete button ditekan
        if (e.getSource() == delButton) {
            String string = textfield.getText();  // Check current text
            textfield.setText("");  // Clear textfield
            // Buang last character dari textfield
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        // Check kalau negation button ditekan
        if (e.getSource() == negButton) {
            String currentText = textfield.getText();
    
        // Check kalau textfield tak kosong
        if (!currentText.isEmpty()) {
            
            double temp = Double.parseDouble(currentText);
            temp *= -1;  // Negate nombor
            textfield.setText("(" + temp + ")");
        
        // Check kalau it whole number
        if (temp == (int) temp) {
            textfield.setText(String.valueOf((int) temp));  // Display as whole number
        } else {
            textfield.setText(String.valueOf(temp));  // Display as decimal
        }
    }
}
    }

    //Method untuk buang semua decimal kalau jawapan dia whole number
    private String formatNumber(double number) {
        if (number == (int) number) {
            return String.valueOf((int) number);  // Display as whole number
        } else {
            return String.valueOf(number);  // DDisplay as decimal
        }
    }
}
