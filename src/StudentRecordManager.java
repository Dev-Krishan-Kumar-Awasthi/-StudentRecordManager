
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRecordManager extends JFrame implements ActionListener {

    JTextField nameField, rollField, marksField;
    JTextArea result;
    JButton addButton, clearButton;

    StudentRecordManager() {
        setTitle("Student Record Manager");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Student Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField(15);
        add(rollField);

        add(new JLabel("Marks:"));
        marksField = new JTextField(15);
        add(marksField);

        addButton = new JButton("Add Student");
        clearButton = new JButton("Clear Fields");

        add(addButton);
        add(clearButton);

        result = new JTextArea(12, 30);
        result.setEditable(false);
        add(new JScrollPane(result));

        addButton.addActionListener(this);
        clearButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String name = nameField.getText().trim();
            String roll = rollField.getText().trim();
            String marks = marksField.getText().trim();

            if (name.isEmpty() || roll.isEmpty() || marks.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill all fields!");
            } else {
                result.append("Name: " + name
                        + "\nRoll No: " + roll
                        + "\nMarks: " + marks
                        + "\n----------------------\n");

                nameField.setText("");
                rollField.setText("");
                marksField.setText("");
            }
        }

        if (e.getSource() == clearButton) {
            nameField.setText("");
            rollField.setText("");
            marksField.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRecordManager();
    }
}
