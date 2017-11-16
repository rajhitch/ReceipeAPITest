package recipe;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
public class Update extends JPanel{
    private JButton b;
    private JTextField f;
    private JSpinner s;
    public Update(){
        b=new JButton("Update");f=new JTextField(12);s=new JSpinner();
        initialize();}
    public void addListener(ActionListener al){
        b.addActionListener(al);}
    public String getValue(){return f.getText();}
    public int getQuantity(){return (Integer)s.getValue();}
    private void initialize(){
        this.setBorder(new TitledBorder("Input Options: "));
        this.setLayout(new GridLayout(1,3));
        this.add(s);this.add(f);this.add(b);}}
