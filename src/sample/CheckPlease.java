package recipe;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class CheckPlease extends JPanel{
    private JTextArea jta;
    private JScrollPane jsp;
    final private JCheckBox jcb;
    private Boolean menu;
    public CheckPlease(){
        jcb=new JCheckBox("Add to Menu");jsp=new JScrollPane();
        jta=new JTextArea();menu=false;
        changeBox();createText();}
    private void changeBox(){
        jcb.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent c){
                if(jcb.isSelected()){menu=true;}
                else if(!jcb.isSelected()){menu=false;}
            }});this.add(jcb);}
    private void createText(){
        jta=new JTextArea(7,64);jsp=new JScrollPane(jta);this.add(jsp);}
    public Boolean getMenu(){return menu;}
    public void setArea(String q){jta.setText(q);}}
