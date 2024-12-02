//time conversion
package converterAssistant;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
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
public class TimeConversion extends JFrame{
    
    private JComboBox inputUnitComboBox;
    private JComboBox outputUnitComboBox;
    private JTextField inputTimeField;
    private JLabel outputLabel;

    private static final String[] TIME_UNITS = {"Second", "Minitue", "Hour","Day"};

    public TimeConversion() {
        
        
       this.setLayout(new GridLayout(5, 2, 50, 50));
        inputUnitComboBox = new JComboBox(TIME_UNITS);
        outputUnitComboBox = new JComboBox(TIME_UNITS);
        inputTimeField = new JTextField();
        outputLabel = new JLabel("Converted Time: ");

        JButton convertButton = new JButton("Convert");
        setTitle("LengthUnit");
        setSize(1120, 630);
        setLocation(0, 0);
        setVisible(true);
        JButton back = new JButton("back");
        add(new JLabel("Select input unit: "));
        add(inputUnitComboBox);
        add(new JLabel("Select output unit: "));
        add(outputUnitComboBox);
        add(new JLabel("Enter input time: "));
        add(inputTimeField);
        add(convertButton);
        add(outputLabel);
        add(back);
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    convertTime();
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
        
       private void convertTime() throws IOException {
        String inputUnit = (String) inputUnitComboBox.getSelectedItem();
        String outputUnit = (String) outputUnitComboBox.getSelectedItem();

        double inputTime;
        try {
            inputTime = Double.parseDouble(inputTimeField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input temperature!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double convertedTime = convert(inputTime, inputUnit, outputUnit);
        outputLabel.setText("Converted Time: " + convertedTime + " " + outputUnit);
        File file=new File("Data.txt");
        if(!file.equals(file))
        {
              file.createNewFile();
        }
        try (FileWriter fwriter = new FileWriter(file,true)) {
            fwriter.write("The input was : "+inputUnit+"\nthe output was : "+outputUnit+"\n"+"The result "+convertedTime+"\n\n");
        }
    }
        private double convert(double value, String inputUnit, String outputUnit) {
        if (inputUnit.equals(outputUnit)) {
            return value; // No conversion needed if the units are the same
        
        }
        if (inputUnit.equals("Minitue")) {
            value = value*60;
        } else if (inputUnit.equals("Hour")) {
            value = value*3600;
        }
            else if (inputUnit.equals("Day")) {
            value = value*86400;    
        }
        
        if (outputUnit.equals("Minitue")) {
            value = value/60;
        } else if (outputUnit.equals("Hour")) {
            value = value/3600;
        }
            else if (outputUnit.equals("Day")) {
            value = value/86400;    
        }
        return value;
}
        
        


    

public static void main(String[] args) {
        new TimeConversion();
    }
}

    