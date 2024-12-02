//Numbersystem
package converterAssistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConverter extends JFrame implements ActionListener {
    private JComboBox comboBox;
    private JTextField inputField;
    private JLabel resultLabel;
    JButton back;

    public NumberSystemConverter() {
        setTitle("Number Conversion");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,1));
        setLocationRelativeTo(null);
        setBackground(Color.PINK);

        String[] conversionOptions = {"Decimal", "Binary", "Hexadecimal", "Octal"};
        comboBox = new JComboBox<>(conversionOptions);
        comboBox.addActionListener(this);

        inputField = new JTextField();
        resultLabel = new JLabel("Converted Value");

        JButton convertButton = new JButton("Convert");
        JButton back = new JButton("back");
        convertButton.addActionListener(this);
        back.addActionListener(this);
         
        setTitle("Number Converter");
        setSize(1120, 630);
        setLocation(0, 0);
        setVisible(true);
        add(comboBox);
        add(inputField);
        add(convertButton);
        add(resultLabel);
        add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) comboBox.getSelectedItem();
        String inputText = inputField.getText().trim();
        try {
            switch (selectedOption) {
                case "Decimal":
                    convertDecimal(inputText);
                    break;
                case "Binary":
                    convertBinary(inputText);
                    break;
                case "Hexadecimal":
                    convertHexadecimal(inputText);
                    break;
                case "Octal":
                    convertOctal(inputText);
                    break;
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainClass();
            }
        });
    }

    private void convertDecimal(String inputText) {
        int decimalValue = Integer.parseInt(inputText);
        resultLabel.setText("Binary: " + Integer.toBinaryString(decimalValue) +"\t"+
                            "  Hexadecimal: " + Integer.toHexString(decimalValue) +"\t"+
                            "  Octal: " + Integer.toOctalString(decimalValue));
    }

    private void convertBinary(String inputText) {
        int decimalValue = Integer.parseInt(inputText, 2);
        resultLabel.setText("Decimal: " + decimalValue +"\n"+
                            "  Hexadecimal: " + Integer.toHexString(decimalValue) +"\n"+
                            "  Octal: " + Integer.toOctalString(decimalValue));
    }

    private void convertHexadecimal(String inputText) {
        int decimalValue = Integer.parseInt(inputText, 16);
        resultLabel.setText("Decimal: " + decimalValue +"\n"+
                            "  Binary: " + Integer.toBinaryString(decimalValue) +"\n"+
                            "  Octal: " + Integer.toOctalString(decimalValue));
    }

    private void convertOctal(String inputText) {
        int decimalValue = Integer.parseInt(inputText, 8);
        resultLabel.setText("Decimal: " + decimalValue +"\n"+
                            "  Binary: " + Integer.toBinaryString(decimalValue) +"\n"+
                            "  Hexadecimal: " + Integer.toHexString(decimalValue));
    }

    public static void main(String[] args) {
         new NumberSystemConverter();
            //app.setVisible(true);
        
    }
}


