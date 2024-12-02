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




    public class AngleConverter extends JFrame {
    private JComboBox inputUnitComboBox;
    private JComboBox outputUnitComboBox;
    private JTextField inputUnitField;
    private JLabel outputLabel;
    JButton back;

    private static final String[] LENGTH_UNITS = {"Radian","Degree"};

    public AngleConverter() {

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
        if (inputUnit.equals("Degree")) {
             value = (value *3.1416)/180;
        }
        
        // Convert to the target output unit
        if (outputUnit.equals("Degree")) {
           
           value = (value*180)/3.1416;
        }
        

        return value;
    }

    public static void main(String[] args) {
        new AngleConverter();
    }
    
}
    


    

