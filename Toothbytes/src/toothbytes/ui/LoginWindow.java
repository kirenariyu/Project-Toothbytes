/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothbytes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jolas
 */
public class LoginWindow extends JFrame {
    private JLabel logo, usrLabel, pwdLabel;
    private JPanel form, buttons;
    private JTextField usr;
    private JPasswordField pwd;
    private JButton login, exit;
    private boolean granted;
    
    public LoginWindow() {
        this.setTitle("Toothbytes");
        this.setIconImage(new ImageIcon("src/toothbytes/favicon.png").getImage());
        this.setBounds(200, 200, 300, 400);
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        buttons = new JPanel(new GridLayout(1,2));
        this.getContentPane().add(buttons, BorderLayout.SOUTH);
        
        form = new JPanel(new MigLayout("fillx, wrap 6", "[fill]push[fill]push[fill]push[fill]push[fill]push[fill]", "[]10px[]"));
        form.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(form, BorderLayout.CENTER);
        
        
        logo = new JLabel(new ImageIcon("src\\toothbytes\\res\\icons\\main_logo_w.png"));
        form.add(logo, "span 6");
        
        usrLabel = new JLabel("Username");
        usrLabel.setForeground(Color.white);
        pwdLabel = new JLabel("Password");
        pwdLabel.setForeground(Color.white);
        
        usr = new JTextField();
        pwd = new JPasswordField();
        
        
        form.add(usrLabel, "span 1");
        form.add(usr, "span 5");
        form.add(pwdLabel, "span 1");
        form.add(pwd, "span 5");
        
        login = new JButton("LOGIN");
        exit = new JButton("EXIT");
        buttons.add(login);
        buttons.add(exit);

    }
    
    public void init() {
        this.setVisible(true);
    }
}