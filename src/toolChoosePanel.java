
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class toolChoosePanel extends JPanel implements ActionListener{
	JButton pencil, eraser, pline, pcircle, prectangle, filler, clear, undo, redo;
	mainPanel mp;
	String chosentool;
	public toolChoosePanel(mainPanel mp)
	{   
		this.mp = mp;
		setBorder(new TitledBorder("������"));
		pencil = new JButton(new ImageIcon("src/icon/pencil.png"));
		eraser = new JButton(new ImageIcon("src/icon/eraser.png"));
		pline = new JButton(new ImageIcon("src/icon/line.png"));
		pcircle = new JButton(new ImageIcon("src/icon/ellipse.png"));
		prectangle = new JButton(new ImageIcon("src/icon/rectangle.png"));
		filler = new JButton(new ImageIcon("src/icon/filler.png"));
		clear = new JButton(new ImageIcon("src/icon/clear.png"));
		undo = new JButton(new ImageIcon("src/icon/undo.png"));
		redo = new JButton(new ImageIcon("src/icon/redo.png"));
		
		chosentool = "pencil";
		pencil.setBorder(BorderFactory.createLoweredBevelBorder());
		eraser.setBorder(BorderFactory.createRaisedBevelBorder());
		pline.setBorder(BorderFactory.createRaisedBevelBorder());
		pcircle.setBorder(BorderFactory.createRaisedBevelBorder());
		prectangle.setBorder(BorderFactory.createRaisedBevelBorder());
		filler.setBorder(BorderFactory.createRaisedBevelBorder());
		clear.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pencil.setToolTipText("Ǧ�ʹ���");
		eraser.setToolTipText("��Ƥ����");
		pline.setToolTipText("ֱ��");
		pcircle.setToolTipText("Բ��");
		prectangle.setToolTipText("����");
		filler.setToolTipText("������乤��");
		clear.setToolTipText("��ջ���");
		undo.setToolTipText("����");
		redo.setToolTipText("����");
		
		pencil.setPreferredSize(new Dimension(40,30));
		eraser.setPreferredSize(new Dimension(40,30));
		pline.setPreferredSize(new Dimension(40,30));
		pcircle.setPreferredSize(new Dimension(40,30));
		prectangle.setPreferredSize(new Dimension(40,30));
		undo.setPreferredSize(new Dimension(40,30));
		redo.setPreferredSize(new Dimension(40,30));
		filler.setPreferredSize(new Dimension(40,30));
		clear.setPreferredSize(new Dimension(85,30));
		
		pencil.addActionListener(this);
		eraser.addActionListener(this);
		pline.addActionListener(this);
		pcircle.addActionListener(this);
		prectangle.addActionListener(this);
		filler.addActionListener(this);
		undo.addActionListener(this);
		redo.addActionListener(this);
		clear.addActionListener(this);
		
		this.setPreferredSize(new Dimension(100,200));
		this.add(pencil);
		this.add(eraser);
		this.add(pline);
		this.add(pcircle);
		this.add(prectangle);
		this.add(filler);
		this.add(undo);
		this.add(redo);
		this.add(clear);
	}
	
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == pencil)
		{
			mp.paintpanel.paintColor=mp.colorselectpanel.paintcolor;
			chosentool = "pencil";
			pencil.setBorder(BorderFactory.createLoweredBevelBorder());
			eraser.setBorder(BorderFactory.createRaisedBevelBorder());
			pline.setBorder(BorderFactory.createRaisedBevelBorder());
			pcircle.setBorder(BorderFactory.createRaisedBevelBorder());
			prectangle.setBorder(BorderFactory.createRaisedBevelBorder());
			filler.setBorder(BorderFactory.createRaisedBevelBorder());
			clear.setBorder(BorderFactory.createRaisedBevelBorder());
			mp.paintpanel.imgcursor = mp.paintpanel.kit.getImage("src/icon/pencil.png");
			mp.paintpanel.cursorfocus = new Point(6, 24);
			mp.paintpanel.repaint();
			
		}
		else if(e.getSource() == eraser)
		{
			mp.paintpanel.paintColor = Color.white;
			chosentool = "eraser";
			eraser.setBorder(BorderFactory.createLoweredBevelBorder());
			pencil.setBorder(BorderFactory.createRaisedBevelBorder());
			pline.setBorder(BorderFactory.createRaisedBevelBorder());
			pcircle.setBorder(BorderFactory.createRaisedBevelBorder());
			prectangle.setBorder(BorderFactory.createRaisedBevelBorder());
			filler.setBorder(BorderFactory.createRaisedBevelBorder());
			clear.setBorder(BorderFactory.createRaisedBevelBorder());
			mp.paintpanel.imgcursor = mp.paintpanel.kit.getImage("src/icon/eraser.png");
			mp.paintpanel.cursorfocus = new Point(10, 23);
			mp.paintpanel.repaint();
		}
		else if(e.getSource() == pline){
			mp.paintpanel.paintColor=mp.colorselectpanel.paintcolor;
			chosentool = "pline";
			pencil.setBorder(BorderFactory.createRaisedBevelBorder());
			eraser.setBorder(BorderFactory.createRaisedBevelBorder());
			pline.setBorder(BorderFactory.createLoweredBevelBorder());
			pcircle.setBorder(BorderFactory.createRaisedBevelBorder());
			prectangle.setBorder(BorderFactory.createRaisedBevelBorder());
			filler.setBorder(BorderFactory.createRaisedBevelBorder());
			clear.setBorder(BorderFactory.createRaisedBevelBorder());
			mp.paintpanel.imgcursor = mp.paintpanel.kit.getImage("src/icon/pencil.png");
			mp.paintpanel.cursorfocus = new Point(6, 24);
			mp.paintpanel.repaint();
		}
		else if(e.getSource() == pcircle) {
			mp.paintpanel.paintColor=mp.colorselectpanel.paintcolor;
			chosentool = "pcircle";
			pencil.setBorder(BorderFactory.createRaisedBevelBorder());
			eraser.setBorder(BorderFactory.createRaisedBevelBorder());
			pline.setBorder(BorderFactory.createRaisedBevelBorder());
			pcircle.setBorder(BorderFactory.createLoweredBevelBorder());
			prectangle.setBorder(BorderFactory.createRaisedBevelBorder());
			filler.setBorder(BorderFactory.createRaisedBevelBorder());
			clear.setBorder(BorderFactory.createRaisedBevelBorder());
			mp.paintpanel.imgcursor = mp.paintpanel.kit.getImage("src/icon/pencil.png");
			mp.paintpanel.cursorfocus = new Point(6, 24);
			mp.paintpanel.repaint();
		}
		else if(e.getSource() == prectangle) {
			mp.paintpanel.paintColor=mp.colorselectpanel.paintcolor;
			chosentool = "prectangle";
			pencil.setBorder(BorderFactory.createRaisedBevelBorder());
			eraser.setBorder(BorderFactory.createRaisedBevelBorder());
			pline.setBorder(BorderFactory.createRaisedBevelBorder());
			pcircle.setBorder(BorderFactory.createRaisedBevelBorder());
			prectangle.setBorder(BorderFactory.createLoweredBevelBorder());
			filler.setBorder(BorderFactory.createRaisedBevelBorder());
			clear.setBorder(BorderFactory.createRaisedBevelBorder());
			mp.paintpanel.imgcursor = mp.paintpanel.kit.getImage("src/icon/pencil.png");
			mp.paintpanel.cursorfocus = new Point(6, 24);
			mp.paintpanel.repaint();
		}
		else if(e.getSource() == filler) {
			mp.paintpanel.paintColor=mp.colorselectpanel.paintcolor;
			chosentool = "filler";
			pencil.setBorder(BorderFactory.createRaisedBevelBorder());
			eraser.setBorder(BorderFactory.createRaisedBevelBorder());
			pline.setBorder(BorderFactory.createRaisedBevelBorder());
			pcircle.setBorder(BorderFactory.createRaisedBevelBorder());
			prectangle.setBorder(BorderFactory.createRaisedBevelBorder());
			filler.setBorder(BorderFactory.createLoweredBevelBorder());
			clear.setBorder(BorderFactory.createRaisedBevelBorder());
			mp.paintpanel.imgcursor = mp.paintpanel.kit.getImage("src/icon/lasso.png");
			mp.paintpanel.cursorfocus = new Point(8, 31);
			mp.paintpanel.repaint();
		}
		else if(e.getSource() == undo){
			mp.paintpanel.undo();
		}
		else if(e.getSource() == redo) {
			mp.paintpanel.redo();
		}
		else if(e.getSource() == clear)
		{	
			mp.paintpanel.clear();
		}
		
		if(e.getSource() == pcircle) {
			mp.status.setText("��������ΪԲ�ģ��ͷŵ�ΪԲ��һ�㣬��Բ.");
		} else if(e.getSource() == filler) {
			mp.status.setText("�϶������Ȧ��һ������Ϳɫ.");
		} else 
			mp.status.setText("Java��ͼ��    ���ߣ�HIT-CS 1130310217 ��־��");
		
	}

}
