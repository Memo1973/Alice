package Tello;



import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Main{

    public static void main(String avg[]) throws IOException
    {
        Main abc=new Main();
    }

    public Main() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("C:\\Users\\tello\\Documents\\csis 1400\\img\\alice_img1_3_30.png"));
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(650,450);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
