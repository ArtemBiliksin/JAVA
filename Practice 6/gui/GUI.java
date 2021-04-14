package calculator.gui;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.real.RealValueParser;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenuItem saveMenuItem;

    private JTextField resultField;
    private JTextField fieldVariable1;
    private JTextField fieldVariable2;
    private JButton calc;

    private HashMap<String, AbstractValueParser> dataTypes;
    private HashMap<String, String> operationTypes;
    private JComboBox<Object> dataType;
    private JComboBox<Object> operationType;


    public static void main(String[] args) {
        GUI builder = new GUI();
        builder.go();
    }

    public void go() {
        createPanel();
        createMunuBar();
        createFrame();

        calc.addActionListener(new GUI.GetResultListener());
        saveMenuItem.addActionListener(new GUI.SaveMenuListener());
    }

    public void createMunuBar(){
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        saveMenuItem = new JMenuItem("Save");

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
    }

    public void createFrame(){
        frame = new JFrame("My First Calculator");
        frame.setContentPane(panel);
        frame.setBounds(300, 300, 400, 200);
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        AbstractValueParser[] valueParsers = new AbstractValueParser[]{new IntegerValueParser(),
                new RealValueParser(), new ComplexValueParser()};
        dataTypes = new HashMap();
        for (AbstractValueParser e : valueParsers) {
            dataTypes.put(e.getDatatypeName(), e);
        }
        dataType = new JComboBox<>(dataTypes.keySet().toArray());
        panel.add(dataType);
        panel.add(new JLabel());

        fieldVariable1 = new JTextField(10);
        panel.add(new JLabel("Variable 1:"));
        panel.add(fieldVariable1);

        String[] operation = new String[]{"+", "-", "*", "/"};
        operationTypes = new HashMap();
        for (String e : operation) {
            operationTypes.put(e, e);
        }
        operationType = new JComboBox<>(operationTypes.keySet().toArray());
        panel.add(new JLabel());
        panel.add(operationType);

        fieldVariable2 = new JTextField(10);
        panel.add(new JLabel("Variable 2:"));
        panel.add(fieldVariable2);

        resultField = new JTextField(10);
        panel.add(new JLabel("Result:"));
        panel.add(resultField);

        calc = new JButton("Get result");
        panel.add(calc);
    }

    public class GetResultListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Calculator myCalculator = new Calculator(dataTypes.get(dataType.getSelectedItem()));
            String operation = operationTypes.get(operationType.getSelectedItem());
            String stringvariable1 = fieldVariable1.getText();
            String stringvariable2 = fieldVariable2.getText();
            if (stringvariable1.equals("") || stringvariable2.equals("")) {
                return;
            }
            try {
                resultField.setText(myCalculator.calculate(stringvariable1, operation, stringvariable2));
            } catch (OperationNotSupportedException | ParseValueException | DivisionByZeroException  exception) {
                resultField.setText(exception.getLocalizedMessage());
                //resultField.setText("Error");
                return;
            }
        }
    }

    public class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    private void saveFile(File file) {
        try {
            //FileWriter(file, true) true -- на дозапись.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            String operation = operationTypes.get(operationType.getSelectedItem());
            String stringvariable1 = fieldVariable1.getText();
            String stringvariable2 = fieldVariable2.getText();
            String result = resultField.getText();
            if (stringvariable1.equals("") || stringvariable2.equals("") || result.equals("")) {
                return;
            }

            writer.write(stringvariable1 + " " + operation + " " +
                    stringvariable2 + " = " + result + "\n");
            writer.close();

            fieldVariable1.setText("");
            fieldVariable2.setText("");
            resultField.setText("");

        } catch (IOException ioException) {
            System.out.println("couldn't write out");
            ioException.printStackTrace();
        }
    }
}