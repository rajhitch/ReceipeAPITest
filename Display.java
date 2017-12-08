
package school;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Display {
    JFrame f;
    JLabel l;
    JTabbedPane tp;
    JOptionPane op;
    BorderFactory bf;
    ButtonPanel bp1;
    CheckPanel cp1;
    ScrollPanel sp1,sp2,sp3;
    JPanel pa,pa1,pa2,pa3;
    SpinnerPanel test1,test2,test3;
    String s1="Inventory ";
    String s2="Recipe ";
    String s3="Menu ";
    String s4=" ";
    String s5="\n";
    String[] ar={"Update","Add item to inventory: "};
    //ArrayList<RecipeObject> input,menu;
    ArrayList<CheckPanel> cpa;
    ArrayList<SpinnerPanel> spa;
    ArrayList<JComponent> jpa;
    
    public Display(String s){
        f=new JFrame(s);
        l=new JLabel("");
        tp=new JTabbedPane();
        op=new JOptionPane();
        bp1=new ButtonPanel(ar,8);
        cpa=new ArrayList<>();spa=new ArrayList<>();jpa=new ArrayList<>();
        setTabs();runWindow();}
    
    synchronized public void addArray(ArrayList al,JComponent jc){
        Iterator more;if(al!=null){more=al.iterator();
        while(more.hasNext()){jc.add((JComponent)more.next());}}}
    
    synchronized public void addTabs(){
        addArray(spa,pa1);addArray(cpa,pa2);addArray(jpa,pa3);}
   
    synchronized public void setArrays(ArrayList a,ArrayList b,ArrayList c){
        spa=a;cpa=b;jpa=c;}
    
    private void setTabs(){
        tp.addTab(s1+s3,pa=new JPanel());pa1=new JPanel();
        pa.setLayout(new GridLayout(1,1));
        pa.add(bp1);pa.add(pa1);
       
        pa1.setLayout(new GridLayout(17,5));
        pa1.setBorder(new TitledBorder(s1+s3));
        
        tp.addTab(s2+s3,pa2=new JPanel());
        pa2.setLayout(new GridLayout(0,1));
        pa2.setBorder(new TitledBorder(s2+s3));
        
        tp.addTab(s3+s3,pa3=new JPanel());
        pa3.setLayout(new GridLayout(0,1));
        pa3.setBorder(new TitledBorder(s3+s3));
    
        f.add(tp);}

    public void setMenuTitle(String s1){l.setText(s1);}
    public void postText(String s){op.showMessageDialog(op,s);}     
    private void runWindow(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(400,200);
        f.setSize(800,500);
        f.setVisible(true);}
    
    public static void main(String[] scarf){
        Display b=new Display("Test");}}

class ScrollPanel extends JPanel{
    private JScrollPane sp;public JTextArea ta;
    public ScrollPanel(int x,int y){
        ta=new JTextArea(x,y);sp=new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp);}
    public void callPaint(){this.repaint();}
    public void flipWhite(){setBackground(Color.WHITE);}
    public void flipGray(){setBackground(Color.GRAY);}
    public void flipDark(){setBackground(Color.DARK_GRAY);}
    public String getText(){return ta.getText();}
    public void makeText(String s){ta.setText(s);}}

class ButtonPanel extends JPanel{
    private JButton b;private JTextField tf;private JLabel l;private JSpinner s;
    public ButtonPanel(String[] sa,int i){
        b=new JButton(sa[0]);
        tf=new JTextField(i);l=new JLabel(sa[1]);
        s=new JSpinner();add(l);add(s);add(tf);add(b);}
    private void addFunction(){b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){}});}
    public int getSpin(){return (Integer)s.getValue();}
    public void setSpin(int i){s.setValue(i);}}

class CheckPanel extends ScrollPanel{
    private JCheckBox cb;
    public CheckPanel(int x,int y){super(x,y);cb=new JCheckBox();add(cb);
    checkCheck();}
    private void checkCheck(){cb.addChangeListener(
            new ChangeListener(){public void stateChanged(ChangeEvent ce){
                if(cb.isSelected()){flipGray();}
                else if(!cb.isSelected()){flipWhite();}}});}
    public String getWords(){return ta.getText(); }
    public void setWords(String s){ta.setText(s);}
    public Boolean getBox(){return cb.isSelected();}}
    
class SpinnerPanel extends JPanel{;private JLabel l;private JSpinner s;
    public SpinnerPanel(String s1,int i){
        l=new JLabel(s1);s=new JSpinner();add(l);s.setValue(i);add(s);}
    public int getSpin(){return (Integer)s.getValue();}
    public void setSpin(int i){s.setValue(i);}}
