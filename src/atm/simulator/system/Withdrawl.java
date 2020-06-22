/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

/**
 *
 * @author sonai priya
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Withdrawl extends JFrame implements ActionListener{
  
     JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JButton b1,b2,b3;
    
    Withdrawl()
    {
    setFont(new Font("System",Font.BOLD,22));
    Font f = getFont();
    FontMetrics fm = getFontMetrics(f);
    int x = fm.stringWidth("WITHDRAWAL"); 
    int y = fm.stringWidth(" ");
    int z = getWidth() - (3*x);
    int w = z/y;
    String pad ="";
        //for(int i=0;i!=w;i++)
    pad = String.format("%"+w+"s", pad);
    setTitle(pad+"WITHDRAWAL");
    
    
    
    l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
    l1.setFont(new Font("Raleway", Font.BOLD, 35));
    
    l2 = new JLabel("IS RS 10000");
    l2.setFont(new Font("Raleway",Font.BOLD, 35));
    
    l3 = new JLabel("Please Enter Your Amount");
    l3.setFont(new Font("Raleway", Font.BOLD, 14));
    
    l4 = new JLabel("Enter Pin");
    l4.setFont(new Font("Raleway", Font.BOLD, 12));
    
    t1=new JTextField();
    t1.setFont(new Font("Raleway", Font.BOLD, 22));
    
    t2=new JTextField();
    t2.setFont(new Font("Raleway", Font.BOLD, 14));
    
     
    b1 = new JButton("WITHDRAW");
    b1.setFont(new Font("Raleway",Font.BOLD,16));
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    
    b2 = new JButton("BACK");
    b2.setFont(new Font("Raleway",Font.BOLD,16));
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    
    b3 = new JButton("EXIT");
    b3.setFont(new Font("Raleway",Font.BOLD,16));
    b3.setBackground(Color.BLACK);
    b3.setForeground(Color.WHITE);
    
    setLayout(null);
   
   
    l3.setBounds(620,110,80,30);
    add(l3);
    
    l4.setBounds(620,10,80,30);
    add(l4);
       
    t2.setBounds(700,10,40,30);
    add(t2);
    
    l2.setBounds(290,210,800,60);
    add(l2);
    
    l1.setBounds(150,150,800,60);
    add(l1);
    
       
    t1.setBounds(250,300,300,50);
    add(t1);
    
    b1.setBounds(240,380,125,50);
    add(b1);
    
    b2.setBounds(415,380,125,50);
    add(b2);
    
    b3.setBounds(300,550,200,50);
    add(b3);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
   
    getContentPane().setBackground(Color.WHITE);
    
    setSize(850,850);
    setLocation(500,90);
    setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        try
        {
            String a = t1.getText();
            String b = t2.getText();
            
            
            if(ae.getSource()==b1)
            {
               if(t1.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Please enter the amount to you want to withdraw");
               }
               else
               {
                   conn c1 = new conn();
                   
                   ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+b+"' ");
                   
                   double balance = 0;
                   
                   if(rs.next())
                   {
                       String pin = rs.getString("pin");
                       
                       balance = rs.getDouble("balance");
                       
                       double d = Double.parseDouble(a);
                       balance -= d;
                       String q1 = "insert into bank values('"+pin+"','"+d+"',null,'"+balance+"')";
                       
                       c1.s.executeUpdate(q1);
  
                   }
                   JOptionPane.showMessageDialog(null,"Rs. "+a+" Debited Successfully");
                   
                   new Transcations().setVisible(true);
                   setVisible(false);
                   
                 }
               }
            
               else if(ae.getSource()==b2)
              { 
               new Transcations().setVisible(true);
               setVisible(false);
              }
               else if(ae.getSource()==b3)
               {
                 System.exit(0);
               }
    
        }
             catch(Exception e)
             {
               e.printStackTrace();
               System.out.println("errors:"+e);
              }
       
    }   
    public static void main(String [] args)
    {
        new Withdrawl().setVisible(true);
    }
    
}


    

