package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ContactIntegrationTest {
    private JFrame frame;
    private JPanel panel;
    private JTextField userText;
    private JTextField phoneText;
    private JTextField emailText;
    private JButton addButton;
    private JButton backButton;
    private JButton viewButton;

    @BeforeEach
    void setUp() {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        JLabel userLabel = new JLabel("Name:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 50, 80, 25);
        panel.add(phoneLabel);

        phoneText = new JTextField(20);
        phoneText.setBounds(100, 50, 165, 25);
        panel.add(phoneText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 80, 80, 25);
        panel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(100, 80, 165, 25);
        panel.add(emailText);

        backButton = new JButton("Back to List");
        backButton.setBounds(10, 120, 130, 25);
        backButton.addActionListener(e -> System.out.println("Returning to Contact List"));
        panel.add(backButton);

        addButton = new JButton("Add New Contact");
        addButton.setBounds(150, 120, 140, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New Contact Added: " + userText.getText() + ", " + phoneText.getText() + ", " + emailText.getText());
            }
        });

        panel.add(addButton);

        viewButton = new JButton("View Details");
        viewButton.setBounds(100, 160, 150, 25);
        panel.add(viewButton);

        frame.setVisible(true);
    }

    @Test
    void testContactAdditionIntegration() {

        userText.setText("John Doe");
        phoneText.setText("1234567890");
        emailText.setText("johndoe@example.com");

        ActionEvent event = new ActionEvent(addButton, ActionEvent.ACTION_PERFORMED, "Add New Contact");
        for (ActionListener al : addButton.getActionListeners()) {
            al.actionPerformed(event);
        }


        assertEquals("John Doe", userText.getText());
        assertEquals("1234567890", phoneText.getText());
        assertEquals("johndoe@example.com", emailText.getText());

    }

    @Test
    void testBackButtonAction() {
        ActionEvent event = new ActionEvent(backButton, ActionEvent.ACTION_PERFORMED, "Back to List");
        for (ActionListener al : backButton.getActionListeners()) {
            al.actionPerformed(event);
        }


    }

    @Test
    void testViewButtonAction() {
        ActionEvent event = new ActionEvent(viewButton, ActionEvent.ACTION_PERFORMED, "View Details");
        for (ActionListener al : viewButton.getActionListeners()) {
            al.actionPerformed(event);
        }

    }
}
