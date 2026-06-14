import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Login extends JFrame implements ActionListener {
    private JLabel l1,l2;
    private JTextField t1,t2;
    private JButton log,can;
    public Login(){
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2,2));
        l1 = new JLabel("Name : ");
        t1 = new JTextField();
        t1.setBackground(Color.gray);;
        l2 = new JLabel("CNIC : ");
        t2 = new JTextField();
        t2.setBackground(Color.gray);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.setBackground(new Color(1,50,67));
        add(p1,BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setBackground(new Color(1,50,67));
        log = new JButton("Login");
        can = new JButton("Cancel");
        log.setBackground(Color.GREEN);
        can.setBackground(Color.RED);
        log.setForeground(Color.WHITE);
        can.setForeground(Color.WHITE);
        can.addActionListener(this);
        log.addActionListener(this);
        p2.add(log);
        p2.add(can);
        add(p2,BorderLayout.SOUTH);
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1));
        p3.setBackground(Color.WHITE);
        JButton back = new JButton("Back");
        JButton home = new JButton("Home");
        back.setBackground(Color.WHITE);
        home.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        home.setForeground(Color.BLACK);
        back.addActionListener(e -> {
            this.dispose();
            Home h = new Home();
            h.setResizable(false);
            h.setVisible(true);
        });
        home.addActionListener(e -> {
            this.dispose();
            Home h = new Home();
            h.setResizable(false);
            h.setVisible(true);
        });
        p3.add(back);
        p3.add(home);
        add(p3,BorderLayout.EAST);
        pack();
        setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        if (a.equals("Cancel")) {
            this.dispose();
            Home h = new Home();
            h.setResizable(false);
            h.setVisible(true);
        }
        if(a.equals("Login")){
            Admin adm = null;
            try
            {
                FileInputStream file = new FileInputStream("Login.ser");
                ObjectInputStream in = new ObjectInputStream(file);
                adm = (Admin)in.readObject();
                in.close();
                file.close();
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Sorry!!! Here is I/O Exception");
            }
            catch(ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Did not find Class");
            }
            if(adm.name.equals(t1.getText()) &&adm.cnic.equals(t2.getText())){
                this.dispose();
                CarRentalSystem sys = new CarRentalSystem();
                sys.setVisible(true);
                sys.setResizable(false);
            }
            else{
                t1.setText("");
                t2.setText("");
                JOptionPane.showMessageDialog(new JFrame(),"Try Again! Record does not exist");
            }
        }
    }
}