//Length unit
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




    public class LengthUnit extends JFrame {
    private JComboBox inputUnitComboBox;
    private JComboBox outputUnitComboBox;
    private JTextField inputUnitField;
    private JLabel outputLabel;
    JButton back;

    private static final String[] LENGTH_UNITS = {"Meter", "Inches", "Feet","Centemeter","Kilometer","Miles","Goj"};

    public LengthUnit() {

        this.setLayout(new GridLayout(5, 2, 50, 50));
        inputUnitComboBox = new JComboBox(LENGTH_UNITS);
        outputUnitComboBox = new JComboBox(LENGTH_UNITS);
        inputUnitField = new JTextField();
        outputLabel = new JLabel("Converted LengthUnit: ");
        
        JButton convertButton = new JButton("Convert");
        JButton back = new JButton("back");
        add(new JLabel("Select input unit: "));
        add(inputUnitComboBox);
        add(new JLabel("Select output unit: "));
        add(outputUnitComboBox);
        add(new JLabel("Enter input LengthUnit: "));
        add(inputUnitField);
        add(convertButton);
        add(outputLabel);
        add(back);
        //back.addActionListener(this);
        
        setTitle("LengthUnit");
        setSize(1120, 630);
        setLocation(0, 0);
        setVisible(true);

        //JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    convertUnit();
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

    private void convertUnit() throws IOException {
        String inputUnit = (String) inputUnitComboBox.getSelectedItem();
        String outputUnit = (String) outputUnitComboBox.getSelectedItem();

        double inputLengthUnit;
        try {
            inputLengthUnit = Double.parseDouble(inputUnitField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input Unit!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double convertedUnit = convert(inputLengthUnit, inputUnit, outputUnit);
        outputLabel.setText("Converted LengthUnit: " + convertedUnit + " " + outputUnit);
      
        
    }

    private double convert(double value, String inputUnit, String outputUnit) {
        if (inputUnit.equals(outputUnit)) {
            return value; 
        }

        // Convert to Celsius as an intermediate step
        if (inputUnit.equals("Centemeter")) {
            value = value/100;
        } else if (inputUnit.equals("Inches")) {
            value = value/39.37;
        }
            else if (inputUnit.equals("Feet")) {
            value = value/3.28;    
        }
            else if(inputUnit.equals("Kilometer")){
                value = value*1000;
            }
            else if(inputUnit.equals("Miles")){
                value=value/0.0006214;
            }
            else if(inputUnit.equals("Goj")){
                value=value/1.0936;
            }
                

        // Convert to the target output unit
        if (outputUnit.equals("Centemeter")) {
            value = value * 100;
        } else if (outputUnit.equals("Inches")) {
            value = value *39.37;
        }
        else if (outputUnit.equals("Feet")) {
            value = value *3.28;
        }
        else if(outputUnit.equals("Kilometer"))
        {
            value = value /1000;
        }
        else if(outputUnit.equals("Miles"))
        {
            value = value *0.0006214;
        }
        else if(outputUnit.equals("Goj"))
        {
            value = value *1.0936;
        }
        

        return value;
    }

    public static void main(String[] args) {
        new LengthUnit();
    }
    
}
    

