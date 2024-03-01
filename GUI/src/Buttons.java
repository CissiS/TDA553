import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {
    private static final int X = 800;
    private static final int Y = 800;

    int gasAmount = 0;
    int brakeAmount = 0;
    int rampAngle = 0;

    private final JPanel controlPanel = new JPanel();
    private final JPanel gasPanel = new JPanel();
    private final JPanel rampPanel = new JPanel();
    private final JPanel brakePanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");
    JLabel brakeLabel = new JLabel("Amount to brake");
    JLabel rampLabel = new JLabel("Ramp angle change");


    //Buttons
    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton raiseButton = new JButton("Raise");
    private final JButton lowerButton = new JButton("Lower");
    private final JButton turboOnButton = new JButton("Turbo On");
    private final JButton turboOffButton = new JButton("Turbo Off");
    private final JButton addCarButton = new JButton("Add Car");
    private final JButton removeCarButton = new JButton("Remove Car");
    private final JButton startAllButton = new JButton("Start All");
    private final JButton stopAllButton = new JButton("Stop All");


    // Other buttons and components declarations

    public Buttons(CarController carC) {
        initializeButtons(carC);
        controlPanel.add(gasPanel);
        controlPanel.add(brakePanel);
        controlPanel.add(rampPanel);
        controlPanel.add(addCarButton);
        controlPanel.add(removeCarButton);

        turboOnButton.setPreferredSize(new Dimension(200,200));
        controlPanel.add(turboOnButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(gasButton);
        controlPanel.add(brakeButton);
        controlPanel.add(raiseButton);
        controlPanel.add(lowerButton);

        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.setPreferredSize(new Dimension((X), 200));
        controlPanel.setBackground(Color.CYAN);


        startAllButton.setBackground(Color.blue);
        startAllButton.setForeground(Color.green);
        startAllButton.setPreferredSize(new Dimension(X/4,200));
        controlPanel.add(startAllButton);

        stopAllButton.setBackground(Color.red);
        stopAllButton.setForeground(Color.black);
        stopAllButton.setPreferredSize(new Dimension(X/4,200));
        controlPanel.add(stopAllButton);
    }

    public void initializeButtons(CarController carC) {
        SpinnerModel spinnerModelGas =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        SpinnerModel spinnerModelBrake =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step

        SpinnerModel spinnerModelRamp = new SpinnerNumberModel(0, //initial value
                0, //min
                70, //max
                1);//step

        JSpinner gasSpinner = new JSpinner(spinnerModelGas);
        JSpinner brakeSpinner = new JSpinner(spinnerModelBrake);
        JSpinner raiseSpinner = new JSpinner(spinnerModelRamp);
        JSpinner lowerSpinner = new JSpinner(spinnerModelRamp);

        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());
        brakeSpinner.addChangeListener(e -> brakeAmount = (int) ((JSpinner) e.getSource()).getValue());
        raiseSpinner.addChangeListener(e -> rampAngle = (int) ((JSpinner) e.getSource()).getValue());

        turboOnButton.addActionListener(e -> carC.turboOn());
        turboOffButton.addActionListener(e -> carC.turboOff());
        addCarButton.addActionListener(e -> carC.generateRandomVehicle());
        removeCarButton.addActionListener(e -> carC.removeRandomVehicle());
        startAllButton.addActionListener(e -> carC.startAllCars());
        stopAllButton.addActionListener(e -> carC.stopAllCars());
        raiseButton.addActionListener(e -> carC.raise(rampAngle));
        lowerButton.addActionListener(e -> carC.lower(rampAngle));
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        brakePanel.setLayout(new BorderLayout());
        brakePanel.add(brakeLabel, BorderLayout.PAGE_START);
        brakePanel.add(brakeSpinner, BorderLayout.PAGE_END);

        rampPanel.setLayout(new BorderLayout());
        rampPanel.add(raiseSpinner, BorderLayout.PAGE_START);
        rampPanel.add(rampLabel, BorderLayout.PAGE_START);
        rampPanel.add(lowerSpinner, BorderLayout.PAGE_END);

        // ActionListener

        gasButton.addActionListener(e -> carC.gas(gasAmount));
        brakeButton.addActionListener(e -> carC.brake(brakeAmount));
        lowerButton.addActionListener(e -> carC.lower(rampAngle));
        raiseButton.addActionListener(e -> carC.raise(rampAngle));

    }

    public JPanel getControlPanel() {
        return controlPanel;
    }
}