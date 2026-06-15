import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Home extends JFrame implements ActionListener {
    BufferedImage car;
    JButton reg,log,exit,cars;
    private ImageIcon img,img1,img2,img3;
    public Home(){
        super("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        try{
            car = ImageIO.read(new File("Car.jpg"));
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        DrawPannel dpnl = new DrawPannel(car);
        add(dpnl,BorderLayout.CENTER);
        JPanel p =new JPanel();
        p.setLayout(new GridLayout(4,1));
        p.setBackground(Color.WHITE);
        reg = new JButton("Register");
        log = new JButton("Login");
        cars = new JButton("Cars");
        exit = new JButton("Exit");
        reg.setBackground(Color.WHITE);
        reg.setForeground(Color.BLACK);
        log.setBackground(Color.WHITE);
        log.setForeground(Color.BLACK);
        log.addActionListener(this);
        cars.setBackground(Color.GRAY);
        cars.setForeground(Color.BLACK);
        exit.setBackground(Color.GREEN);
        exit.setForeground(Color.BLACK);
        cars.addActionListener(this);
        img1 = new ImageIcon("Register.png");
        Image image1 = img1.getImage();
        Image nImg1 = image1.getScaledInstance(45,45, java.awt.Image.SCALE_SMOOTH);
        img1 = new ImageIcon(nImg1);
        reg.setIcon(img1);
        reg.addActionListener(this);
        img2 = new ImageIcon("Login.jpg");
        Image image2 = img2.getImage();
        Image nImg2 = image2.getScaledInstance(45,45, java.awt.Image.SCALE_SMOOTH);
        img2 = new ImageIcon(nImg2);
        log.setIcon(img2);
        img = new ImageIcon("cars.jpg");
        Image image = img.getImage();
        Image nImg = image.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(nImg);
        cars.setIcon(img);
        img3 = new ImageIcon("exit.jpg");
        Image image3 = img3.getImage();
        Image nImg3 = image3.getScaledInstance(45,45, java.awt.Image.SCALE_SMOOTH);
        img3 = new ImageIcon(nImg3);
        exit.setIcon(img3);
        exit.addActionListener(this);
        p.add(reg);
        p.add(log);
        p.add(cars);
        p.add(exit);
        add(p,BorderLayout.EAST);
        pack();
        setLocationRelativeTo(null);
    }
    private class DrawPannel extends JPanel {
        Image img;
        public DrawPannel(Image img) {
            this.img = img;
            setPreferredSize(new Dimension(400, 400));
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();
            if (this.img != null) {
                g2d.drawImage(this.img, 0, 0, w, h, null);
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        String a = e.getActionCommand();
        if(a.equals("Login")){
            this.dispose();
            Login l = new Login();
            l.setVisible(true);
            l.setResizable(false);
        }
        if(a.equals("Register")){
            this.dispose();
            Register r = new Register();
            r.setResizable(false);
            r.setVisible(true);
        }
        if(a.equals("Cars")) {
            this.dispose();
            CarsFrame cf = new CarsFrame();
            cf.setVisible(true);
            cf.setResizable(false);
        }
        if(a.equals("Exit")){
            System.exit(0);
        }
    }
}