
package school;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class TestDisplay {
    public static void main(String[] testy){
        ArrayList<JComponent> j=new ArrayList<>();
        ArrayList<CheckPanel> c=new ArrayList<>();
        ArrayList<SpinnerPanel> s=new ArrayList<>();
        j.add(new JLabel("My Menu"));
        j.add(new ScrollPanel(10,15));
        s.add(new SpinnerPanel("ingredient",0));
        s.add(new SpinnerPanel("ingredient",23));
        s.add(new SpinnerPanel("ingredient",12));
        s.add(new SpinnerPanel("ingredient",1));
        s.add(new SpinnerPanel("ingredient",78));
        s.add(new SpinnerPanel("ingredient",45));
        s.add(new SpinnerPanel("ingredient",45));
        s.add(new SpinnerPanel("ingredient",56));
        s.add(new SpinnerPanel("ingredient",500));
        s.add(new SpinnerPanel("ingredient",1));
        s.add(new SpinnerPanel("ingredient",78));
        s.add(new SpinnerPanel("ingredient",43));
        c.add(new CheckPanel(8,16));
        c.add(new CheckPanel(8,16));
        c.add(new CheckPanel(8,16));
        c.add(new CheckPanel(8,16));
        c.add(new CheckPanel(8,16));
        Display d=new Display("Inventory Control Menu");
        d.setArrays(s,c,j);
        d.addTabs();
        }
    
}
