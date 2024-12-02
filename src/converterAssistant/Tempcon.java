//Tempcon

package converterAssistant;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



    public class Tempcon extends JFrame implements ActionListener{
    private JComboBox inputUnitComboBox;
    private JComboBox outputUnitComboBox;
    private JTextField inputTemperatureField;
    private JLabel outputLabel;
    JButton back;

    private static final String[] TEMPERATURE_UNITS = {"Celsius", "Fahrenheit", "Kelvin"};

    public Tempcon() {
        
        this.setLayout(new GridLayout(5, 2, 50, 50));

//         back = new JButton("TEMPERATURE");
//        back.setBounds(100, 800, 200, 30);
//        back.setFocusable(false);
//        back.addActionListener(this);
//        add(back);
     
        
       
    

    
        inputUnitComboBox = new JComboBox(TEMPERATURE_UNITS);
        outputUnitComboBox = new JComboBox(TEMPERATURE_UNITS);
        inputTemperatureField = new JTextField();
        outputLabel = new JLabel("Converted temperature: ");

        JButton convertButton = new JButton("Convert");
        JButton back = new JButton("back");
        add(new JLabel("Select input unit: "));
        add(inputUnitComboBox);
        add(new JLabel("Select output unit: "));
        add(outputUnitComboBox);
        add(new JLabel("Enter input temperature: "));
        add(inputTemperatureField);
        add(convertButton);
        add(outputLabel);
        add(back);
        //back.setBackground(Color.BLUE);
        back.addActionListener(this);
    
        setTitle("Admin");
        setSize(1250, 800);
        setLocation(0, 0);
        setVisible(true);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    convertTemperature();

                } catch (IOException ex) {
                    Logger.getLogger(Tempcon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainClass();
            }
        });
        

        
    }
   

    private void convertTemperature() throws IOException {
        String inputUnit = (String) inputUnitComboBox.getSelectedItem();
        String outputUnit = (String) outputUnitComboBox.getSelectedItem();

        double inputTemperature;
        try {
            inputTemperature = Double.parseDouble(inputTemperatureField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input temperature!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double convertedTemperature = convert(inputTemperature, inputUnit, outputUnit);
        outputLabel.setText("Converted temperature: " + convertedTemperature + " " + outputUnit);
       
    }

    private double convert(double value, String inputUnit, String outputUnit) {
        if (inputUnit.equals(outputUnit)) {
            return value; // No conversion needed if the units are the same
        }

        // Convert to Celsius as an intermediate step
        if (inputUnit.equals("Fahrenheit")) {
            value = (value - 32) * 5 / 9;
        } else if (inputUnit.equals("Kelvin")) {
            value = value - 273.15;
        }

        // Convert to the target output unit
        if (outputUnit.equals("Fahrenheit")) {
            value = value * 9 / 5 + 32;
        } else if (outputUnit.equals("Kelvin")) {
            value = value + 273.15;
        }

        return value;
    }

    public static void main(String[] args) {
        new Tempcon();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

