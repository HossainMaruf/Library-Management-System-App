package com.scene;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import com.data.Validator;

class StudentRegistrationFormPanel extends JPanel {
    private JLabel nameLabel, emailLabel, phoneLabel;
    private JTextField nameField, emailField, phoneField;
    private JLabel nameErrorLabel, emailErrorLabel, phoneErrorLabel;
    private JButton registerBtn;

    public StudentRegistrationFormPanel() {
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(32);
        nameErrorLabel = new JLabel();
        nameErrorLabel.setForeground(Color.RED);

        emailLabel = new JLabel("Email: ");
        emailField = new JTextField(32);
        emailErrorLabel = new JLabel(); 
        emailErrorLabel.setForeground(Color.RED);

        phoneLabel = new JLabel("Phone: ");
        phoneField = new JTextField(32);
        phoneErrorLabel = new JLabel();
        phoneErrorLabel.setForeground(Color.RED);

        registerBtn = new JButton("Register");

        // Set the border using BorderFactory
        Border innerBorder = BorderFactory.createTitledBorder("Registration");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        // Set GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        // First Row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,5,0);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameErrorLabel, gc);

        // Second Row
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,5,0);
        add(emailLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailField, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(emailErrorLabel, gc);

        // Third Row
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(phoneLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(phoneField, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(phoneErrorLabel, gc);

        // Fourth Row
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(registerBtn, gc);

        // add button event
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Validator validator = new Validator(); // need singleton
                validator.validateText(nameField.getText(), "name").min(3).max(5);
                validator.validateText(emailField.getText(), "email").min(7).max(5);
                validator.validateText(phoneField.getText(), "phone").min(7).max(5);
                Map<String, String> errors = validator.getErrors();
                nameErrorLabel.setText(errors.get("name"));
                emailErrorLabel.setText(errors.get("email"));
                phoneErrorLabel.setText(errors.get("phone"));
            }
        });
    }
 }

public class StudentRegistration extends JFrame {
    private StudentRegistrationFormPanel formPanel;

    public StudentRegistration(String title) {
        // Frame Creation
        super(title);
        setSize(300, 300);
        setLocation(350, 250);

        // Creating some panel
        formPanel = new StudentRegistrationFormPanel();

        // Setting the layout
        setLayout(new GridLayout());

        // Adding Components to the layout
        add(formPanel);

        setVisible(true);
    }
}