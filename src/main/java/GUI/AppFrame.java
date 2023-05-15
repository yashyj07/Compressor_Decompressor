/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author yash_yj_07
 */


public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    JLabel appName;
    public AppFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLayout(null);
        
        appName = new JLabel();
        appName.setText("File Compressor & Decompressor");
        appName.setForeground(Color.GREEN);
        appName.setBounds(200, 50, 230, 30);
        this.getContentPane().add(appName);
        
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(200, 100, 200, 30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(200, 150, 200, 30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.setSize(600, 400);
        
        this.setUndecorated(true);//to enable the decoration of frame
        this.setBackground(new Color(0.17f,0.25f,0.11f,0.70f)); //in the rgba form where a is opacity
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.getHSBColor(0.17f, 0.20f, 0.11f)));//set frame border color
        
        this.setVisible(true);
        this.setResizable(false);
        
        this.revalidate();
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(this);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null, e1.toString());
                }
                
                JOptionPane.showMessageDialog(null, "File has been compressed");
            }
        }
        
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(this);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.toString());
                }
                
                JOptionPane.showMessageDialog(null, "File has been decompressed");
            }
        }
    }
    
}
