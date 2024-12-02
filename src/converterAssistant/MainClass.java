
package converterAssistant;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class MainClass extends JFrame implements ActionListener{
    
     JLabel jLabel1;
     JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8,jButton9;
    
    MainClass(){
        setBackground(Color.CYAN);
        setLayout(null);
        jLabel1  = new JLabel("CONVERTER ASISTANT");
        jLabel1.setBounds(200,0,600,100);
        jLabel1.setFont(new Font("Ralway",Font.BOLD,50));
        add(jLabel1);
        
        jButton1 = new JButton("TEMPERATURE");
        //jButton1.setBackground(Color.BLUE);
        jButton1.setBounds(100, 160, 200, 30);
        jButton1.setFocusable(false);
        jButton1.addActionListener(this);
        add(jButton1);
        
        
        jButton2 = new JButton("LAND");
        jButton2.setBounds(450, 160, 200, 30);
        jButton2.setFocusable(false);
        jButton2.addActionListener(this);
        add(jButton2);
        
        
        jButton3 = new JButton("LENGTH");
        jButton3.setBounds(750, 160, 200, 30);
        jButton3.setFocusable(false);
        jButton3.addActionListener(this);
        add(jButton3);
        
        
        jButton4 = new JButton("QUARENCY");
        jButton4.setBounds(100, 300, 200, 30);
        jButton4.setFocusable(false);
        jButton4.addActionListener(this);
        add(jButton4);
        
        
        jButton5 = new JButton("NUMBER");
        jButton5.setBounds(450, 300, 200, 30);
        jButton5.setFocusable(false);
        jButton5.addActionListener(this);
        add(jButton5);
        
        jButton6 = new JButton("TIME");
        jButton6.setBounds(750, 300, 200, 30);
        jButton6.setFocusable(false);
        jButton6.addActionListener(this);
        add(jButton6);
        
        
        jButton7 = new JButton("MASS");
        jButton7.setBounds(100, 460, 200, 30);
        jButton7.setFocusable(false);
        jButton7.addActionListener(this);
        add(jButton7);
        
        jButton8 = new JButton("ANGLE");
        jButton8.setBounds(450, 460, 200, 30);
        jButton8.setFocusable(false);
        jButton8.addActionListener(this);
        add(jButton8);
        
        jButton9 = new JButton("VOLUME");
        jButton9.setBounds(750, 460, 200, 30);
        jButton9.setFocusable(false);
        jButton9.addActionListener(this);
        add(jButton9);
        
        //setBackground(Color.BlUE);
        setTitle("Home");
        setSize(1120, 630);
        setLocation(0, 0);
        setVisible(true);
        

        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jButton1) {
            setVisible(false);
            new Tempcon();

        } else if (ae.getSource() == jButton2) {
            setVisible(false);
            new LandMeasurement();

        } else if (ae.getSource() == jButton3) {
            setVisible(false);
            new LengthUnit();

        } else if (ae.getSource() == jButton4) {
            setVisible(false);
            new MoneyCon();
        }
        else if (ae.getSource() == jButton5) {
            setVisible(false);
            new NumberSystemConverter();
        }
        else if (ae.getSource() == jButton6) {
            setVisible(false);
            new TimeConversion();
        }
        else if (ae.getSource() == jButton7) {
            setVisible(false);
            new MassMeasurementConverter();
        }
        else if (ae.getSource() == jButton8) {
            setVisible(false);
            new AngleConverter();
        }
        else if (ae.getSource() == jButton9) {
            setVisible(false);
            new VolumeConverter();
        }

    }

    public static void main(String[] args) {   
     new MainClass();
        
        
    }
    
}
