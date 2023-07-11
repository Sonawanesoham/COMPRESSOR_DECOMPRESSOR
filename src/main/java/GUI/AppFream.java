/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import static java.awt.Color.green;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Soham Sonawane
 */
public class AppFream extends JFrame implements ActionListener {
    
    JButton compressButton;
    JButton decompressButton;
    AppFream(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(250,100,200,30);
        decompressButton.addActionListener(this);
        this.add(compressButton);
         this.add(decompressButton);
         this.setSize(1000,500);
         this.getContentPane().setBackground(green);
         this.setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==compressButton){
        JFileChooser filechooser = new JFileChooser();
        int response  = filechooser.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            File file= new File(filechooser.getSelectedFile().getAbsolutePath());
                   
            System.out.print(file);
            try{
            compressor.method(file);
            }
            catch(IOException ee){
            JOptionPane.showMessageDialog(null, ee.toString());
            }
        }
        
     } 
}
}
