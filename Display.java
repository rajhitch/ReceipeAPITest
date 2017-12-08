
package school;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    JFrame f;JLabel l;JTabbedPane tp;JOptionPane op;ButtonPanel bp1;
    JPanel main1,main2,main3,sub1,sub2,sub3;
    String s1="Inventory ";String s2="Recipe ";String s3="Menu ";
    String s4=" ";String s5="\n";
    String[] ar={"Update","Add item to inventory: "};
    //ArrayList<RecipeObject> input,menu;
    ArrayList<CheckPanel> cpa;
    ArrayList<SpinnerPanel> spa;
    ArrayList<JComponent> jpa;
    ButtonSet recipeSet,menuSet;
    
    public Display(String s){
        f=new JFrame(s);
        l=new JLabel("Menu Title");
        tp=new JTabbedPane();
        op=new JOptionPane();
        bp1=new ButtonPanel(ar,8);
        cpa=new ArrayList<>();spa=new ArrayList<>();jpa=new ArrayList<>();
        sub1=new JPanel();sub2=new JPanel();sub3=new JPanel();
        recipeSet=new ButtonSet("Generate Recipes","Generate Menu",
                "Clear Selections");
        menuSet=new ButtonSet("Rename Menu","Save Menu","Print Menu");
        setTabs();setAction();runWindow();}
    synchronized public void addArray(ArrayList al,JComponent jc){
        Iterator more;if(al!=null){more=al.iterator();
        while(more.hasNext()){jc.add((JComponent)more.next());}}}
    synchronized public void addTabs(){
        addArray(spa,sub1);addArray(cpa,sub2);addArray(jpa,sub3);}
    synchronized public void setAction(){
        recipeSet.addFunction(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //cpa.get(0).setWords("This occured");
                    setAllFalse();}},3);}
    synchronized public void setAllFalse(){
        if(cpa!=null){Iterator checks=cpa.iterator();
        while(checks.hasNext()){
            CheckPanel temp=(CheckPanel)checks.next();temp.setBox();}}}
    synchronized public void setArrays(ArrayList a,ArrayList b,ArrayList c){
        spa=a;cpa=b;jpa=c;}
    private void setTabs(){
        //FirstTab
        tp.addTab(s1+s3,main1=new JPanel());
        main1.setBorder(new TitledBorder(s1+s3));main1.add(bp1);
        sub1.setLayout(new GridLayout(5,5,5,5));main1.add(sub1);
        //SecondTab
        tp.addTab(s2+s3,main2=new JPanel());
        main2.setBorder(new TitledBorder(s2+s3));
        sub2.setLayout(new GridLayout(2,10));
        main2.add(recipeSet);main2.add(sub2);
        //ThirdTab
        tp.addTab(s3+s3,main3=new JPanel());
        main3.setLayout(new GridLayout(2,3));
        main3.setBorder(new TitledBorder(s3+s3));
        main3.add(menuSet);main3.add(sub3);
        f.add(tp);}
    public void setMenuTitle(String s1){l.setText(s1);}
    public void postText(String s){op.showMessageDialog(op,s);}     
    private void runWindow(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(400,200);f.setSize(800,500);f.setVisible(true);}
    public static void main(String[] scarf){
        Display b=new Display("Test");}}

class ScrollPanel extends JPanel{
    private JScrollPane sp;public JTextArea ta;
    public ScrollPanel(int x,int y){
        ta=new JTextArea(x,y);sp=new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp);}
    public void flipWhite(){setBackground(Color.WHITE);}
    public void flipGray(){setBackground(Color.GRAY);}
    public void flipDark(){setBackground(Color.DARK_GRAY);}
    public String getText(){return ta.getText();}
    public void makeText(String s){ta.setText(s);}}

class ButtonPanel extends JPanel{
    private JButton b;private JTextField tf;private JLabel l;private JSpinner s;
    public ButtonPanel(String[] sa,int i){
        b=new JButton(sa[0]);tf=new JTextField(i);l=new JLabel(sa[1]);
        s=new JSpinner();s.setValue(000);
        setLayout(new FlowLayout());s.setPreferredSize(new Dimension(80,20));
        this.add(l);this.add(s);this.add(tf);this.add(b);}
    private void addFunction(){b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){}});}
    public int getSpin(){return (Integer)s.getValue();}
    public void setSpin(int i){s.setValue(i);}}

class CheckPanel extends ScrollPanel{
    private JCheckBox cb;private Boolean changed;
    public CheckPanel(int x,int y){super(x,y);cb=new JCheckBox();
    changed=false;add(cb);checkCheck();}
    private void checkCheck(){cb.addChangeListener(
            new ChangeListener(){public void stateChanged(ChangeEvent ce){
                if(cb.isSelected()){flipGray();changed=true;}
                else if(!cb.isSelected()){flipWhite();changed=false;}}});}
    public Boolean getChanged(){return changed;}
    public String getWords(){return ta.getText(); }
    public void setWords(String s){ta.setText(s);}
    public Boolean getBox(){return cb.isSelected();}
    public void setBox(){cb.setSelected(false);}}
    
class SpinnerPanel extends JPanel{;private JLabel l;private JSpinner s;
    Boolean changed;private int initial;
    public SpinnerPanel(String s1,int i){
        l=new JLabel(s1);s=new JSpinner();changed=false;initial=i;
        s.setPreferredSize(new Dimension(80,20));add(l);s.setValue(i);add(s);}
    private void checkSpinner(){s.addChangeListener(
            new ChangeListener(){public void stateChanged(ChangeEvent ce){
                if((int)s.getValue()!=initial){changed=true;}}});}
    public Boolean getChange(){return changed;}
    public int getSpin(){return (Integer)s.getValue();}
    public void setSpin(int i){s.setValue(i);}}

class ButtonSet extends JPanel{
    private JButton b1,b2,b3;
    public ButtonSet(String s1,String s2,String s3){
        b1=new JButton(s1);b2=new JButton(s2);b3=new JButton(s3);
        this.add(b1);this.add(b2);this.add(b3);}
    public void addFunction(ActionListener al,int i){
        switch(i){
            case 1: b1.addActionListener(al);break;
            case 2: b2.addActionListener(al);break;
            case 3: b3.addActionListener(al);break;}}}