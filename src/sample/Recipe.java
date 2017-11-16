
package recipe;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
public class Recipe {
    private JFrame f;
    private JTabbedPane tp;
    private JComponent c1,c2,c3;
    private CheckPlease cp1,cp2,cp3,cp4,cp5;
    private JPanel p1,p2,p3,p4;
    private Spin s1,s2,s3,s4,s5;
    private Update u1;
    private int[] test1={12,17,40,10,3,2,1,0,2};
    private int[] test2={17,40,10,3,2,30};
    private int[] test3={12,17,40,10,3,2,23};
    private String[] test11={"carrots","potato","apple","flour","tomato","onion",
            "cardamom","lettuce","cilantro"};
    private String[] test22={"potato","apple","tomato","onion","lettuce","cilantro"};
    private String[] test33={"carrots","potato","apple","tomato","onion",
            "cardamom","lettuce"};
    public Recipe(){
        f=new JFrame();p1=new JPanel();p2=new JPanel();p3=new JPanel();
        p4=new JPanel();tp=new JTabbedPane();u1=new Update();
        c1=new JPanel();c2=new JPanel();
        cp1=new CheckPlease();cp2=new CheckPlease();cp3=new CheckPlease();
        cp4=new CheckPlease();cp5=new CheckPlease();
        s1=new Spin(test1,test11);s2=new Spin(test1,test11);
        s3=new Spin(test2,test22);s4=new Spin(test2,test22);
        s5=new Spin(test3,test33);s1.setTitle("Category1");
        s2.setTitle("Category2");s3.setTitle("Category3");
        s4.setTitle("Category4");s5.setTitle("Category5");
        p1.add(s1);p1.add(s2);p1.add(s3);p1.add(s4);p1.add(s5);p2.add(u1);
        c1.setLayout(new GridLayout(2,1));
        c1.add(p1,BorderLayout.NORTH);c1.add(p2,BorderLayout.SOUTH);
        c2.add(cp1);c2.add(cp2);c2.add(cp3);c2.add(cp4);c2.add(cp5);
        tp.addTab("Inventory", c1);
        tp.addTab("Recipe", c2);
        tp.addTab("Menu", c3);
        f.add(tp);
        f.setTitle("Management Menu");
        f.setLocation(200, 300);
        f.setSize(1000,900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);}
    public static void main(String[] args) {Recipe r=new Recipe();}}
