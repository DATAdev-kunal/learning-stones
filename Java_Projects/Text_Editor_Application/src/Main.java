import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

class Bar extends JFrame implements ActionListener
{
    JToolBar tb;
    JLabel font_style;
    JTextArea ta;
    JButton b1,b2;

    public Bar()
    {
        super("My Toolbar Demo");

        font_style = new JLabel("Font");
        b1 = new JButton();
//        b1=new JButton(new ImageIcon(""));
        b2=new JButton(new ImageIcon(""));

        tb=new JToolBar();
        tb.add(b1);
        tb.add(new JToolBar.Separator());
        tb.add(b1);
        tb.add(new JToolBar.Separator());
        tb.add(b2);

        ta=new JTextArea();
        JScrollPane sp=new JScrollPane(ta);

        JMenuBar mb=new JMenuBar();

        JMenu File =new JMenu("File");
        JMenuItem m1=new JMenuItem("New");
        JMenuItem m2=new JMenuItem("Open");
        JMenuItem m3=new JMenuItem("Save");
        JMenuItem m4=new JMenuItem("Save As");
        JMenuItem m5=new JMenuItem("Rename");
        File.add(m1);
        File.add(m2);
        File.add(m3);
        File.add(m4);
        File.add(m5);

        JMenu Edit = new JMenu("Edit");
        JMenuItem e1 = new JMenuItem("Undo");
        JMenuItem e2 = new JMenuItem("Redo");
        JMenuItem e3 = new JMenuItem("Find & Replace");
        Edit.add(e1);
        Edit.add(e2);
        Edit.add(e3);

        JMenu About = new JMenu("About");
        JMenuItem a1 = new JMenuItem("About us");
        JMenuItem a2 = new JMenuItem("Open Source License");
        About.add(a1);
        About.add(a2);

        mb.add(File);
        mb.add(Edit);
        mb.add(About);
        setJMenuBar(mb);

        add(tb,BorderLayout.NORTH);
        add(sp,BorderLayout.CENTER);

        b2.setActionCommand("Open");

        b2.addActionListener(this);
        m2.addActionListener(this);

        b1.addActionListener(this);
        m1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Open"))
        {
            JFileChooser fc=new JFileChooser();
            fc.showOpenDialog(this);
            File f=fc.getSelectedFile();

            try {
                FileInputStream fis=new FileInputStream(f);
                byte b[]=new byte[fis.available()];
                fis.read(b);

                String str=new String(b);
                ta.setText(str);

                fis.close();

            } catch (Exception e1) {

            }

        }
        else
        {
            new JColorChooser();
            Color col=JColorChooser.showDialog(this, "Font Colour",Color.red);
            ta.setForeground(col);

        }

    }
}

public class Main {
    public static void main(String[] args) {
        Bar b=new Bar();
        b.setSize(700, 700);
        b.setVisible(true);
        b.setDefaultCloseOperation(Bar.EXIT_ON_CLOSE);

    }
}
