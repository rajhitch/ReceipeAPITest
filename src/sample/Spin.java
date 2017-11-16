package recipe;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
public class Spin extends JPanel{
    private ArrayList<JSpinner> a;
    private ArrayList<JLabel> b;
    private Iterator ii,is,ia,ib;
    private int components;
    public Spin(){components=0;a=new ArrayList<>();b=new ArrayList<>();}
    public Spin(int[] i,String[] s){a=new ArrayList<>();b=new ArrayList<>();
        components=i.length;
        for(int r=0;r<i.length;r++){
            JSpinner temp=new JSpinner();temp.setValue(i[r]);
            a.add(temp);b.add(new JLabel(s[r]));}
        addAll();}
    public Spin(ArrayList<Integer> i,ArrayList<String> s){
        a=new ArrayList<>();b=new ArrayList<>();ii=i.iterator();is=s.iterator();
        components=i.size();
        while(ii.hasNext()&&is.hasNext()){
            JSpinner temp=new JSpinner();temp.setValue(ii.next());
            a.add(temp);b.add(new JLabel((String)is.next()));}
        addAll();}
    public void setTitle(String s){this.setBorder(new TitledBorder(s));}
    synchronized public void addAll(){
        ia=a.iterator();ib=b.iterator();
        this.setLayout(new GridLayout(10,4));
        while(ia.hasNext()&&ib.hasNext()){
            this.add((JSpinner)ia.next());this.add((JLabel)ib.next());}}}
