import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField textField1, textField2, operatorField, resultField;

    public CalculatorApp() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 5, 5));

        // Labels and TextFields
        mainPanel.add(new JLabel("Number 1:"));
        textField1 = new JTextField();
        mainPanel.add(textField1);

        mainPanel.add(new JLabel("Number 2:"));
        textField2 = new JTextField();
        mainPanel.add(textField2);

        mainPanel.add(new JLabel("Operator (+,-,*,/,%):"));
        operatorField = new JTextField();
        mainPanel.add(operatorField);

        mainPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        mainPanel.add(resultField);

        // Buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
        mainPanel.add(calculateButton);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                operatorField.setText("");
                resultField.setText("");
            }
        });
        mainPanel.add(refreshButton);

        // Add main panel to the frame
        add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the window
    }

    private void calculateResult() {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            String operator = operatorField.getText();
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero");
                        return;
                    }
                    break;
                case "%":
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero");
                        return;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Error: Invalid operator");
                    return;
            }

            resultField.setText(Double.toString(result));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Invalid input format");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorApp app = new CalculatorApp();
                app.setVisible(true);
            }
        });
    }
}
