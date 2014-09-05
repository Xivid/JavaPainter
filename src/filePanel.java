import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

@SuppressWarnings("serial")
public class filePanel extends JPanel implements ActionListener{
	mainPanel mp;
	JButton fileopen, filesave, filesaveas, filenew;
	public filePanel(mainPanel mp){
		setBorder(new TitledBorder("�ļ�"));
		this.mp = mp;
		filenew = new JButton(new ImageIcon("src/icon/new.png"));
		fileopen = new JButton(new ImageIcon("src/icon/open.png"));
		filesave = new JButton(new ImageIcon("src/icon/save.png"));
		filesaveas = new JButton(new ImageIcon("src/icon/saveas.png"));
		
		filenew.setToolTipText("�½�ͼƬ");
		fileopen.setToolTipText("��ͼƬ...");
		filesave.setToolTipText("����ͼƬ");
		filesaveas.setToolTipText("���Ϊ...");
		
		fileopen.setPreferredSize(new Dimension(40,30));
		filesave.setPreferredSize(new Dimension(40,30));
		filesaveas.setPreferredSize(new Dimension(40,30));
		filenew.setPreferredSize(new Dimension(40,30));
		
		fileopen.addActionListener(this);
		filesave.addActionListener(this);
		filesaveas.addActionListener(this);
		filenew.addActionListener(this);
		
		this.setPreferredSize(new Dimension(100, 100));
		this.add(filenew);
		this.add(fileopen);
		this.add(filesave);
		this.add(filesaveas);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == filenew){
			mp.paintpanel.hasimage = false;
			mp.paintpanel.img = null;
			mp.paintpanel.clear();
			mp.paintpanel.undoStack.clear();
			mp.mainwindow.setTitle("�ޱ��� - Java��ͼ��");
			mp.status.setText("Java��ͼ��    ���ߣ�HIT-CS 1130310217 ��־��");
		}
		else if(e.getSource() == fileopen){
			JFileChooser jc = new JFileChooser();
            jc.setFileFilter(new FileFilter() {
                public boolean accept(File f) { // �趨���õ��ļ��ĺ�׺��
                    if (f.getName().endsWith(".jpg") || f.getName().endsWith(".png") || f.isDirectory()|| f.getName().endsWith(".gif")) {
                        return true;
                    }
                    return false;
                }
                public String getDescription() {
                    return "ͼƬ(*.jpg,*.png,*.gif)";
                }
            });
            int returnValue = jc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jc.getSelectedFile();
                if (selectedFile != null) {
                    String fileString = selectedFile.getAbsolutePath();
                    try {
                        BufferedImage newImage = ImageIO.read(new File(fileString));
                        mp.paintpanel.hasimage = true;
                        mp.paintpanel.img = newImage;
                        mp.paintpanel.imgsrc = fileString;
                        mp.mainwindow.setTitle(selectedFile.getName() + " - Java��ͼ��");
                        mp.status.setText(fileString + " �Ѵ�.");
                        mp.paintpanel.repaint();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

                }
            }
		}
		else if (mp.paintpanel.hasimage && e.getSource() == filesave) {
			BufferedImage image = new BufferedImage(mp.paintpanel.getWidth(),mp.paintpanel.getHeight(), BufferedImage.TYPE_INT_RGB);   
			Graphics2D g2 = image.createGraphics();   
			mp.paintpanel.paint(g2);
			try {
				ImageIO.write(image, mp.paintpanel.imgsrc.substring(mp.paintpanel.imgsrc.length()-3), new java.io.File(mp.paintpanel.imgsrc));
				mp.status.setText(mp.paintpanel.imgsrc + " ����ɹ�.");
			} catch (IOException e1) {
				
			}
		}
		else if(e.getSource() == filesaveas || e.getSource() == filesave){
			BufferedImage image = new BufferedImage(mp.paintpanel.getWidth(),mp.paintpanel.getHeight(), BufferedImage.TYPE_INT_RGB);   
			Graphics2D g2 = image.createGraphics();   
			mp.paintpanel.paint(g2);
			JFileChooser FileCh = new JFileChooser();
			
			FileCh.setFileFilter(new FileFilter() {
                public boolean accept(File f) {
                    if (f.isDirectory())
                        return true;
                    return false;
                }

                public String getDescription() {
                    return "PNGͼƬ(*.png)";
                }
            });
			
			FileCh.setFileFilter(new FileFilter() {
                public boolean accept(File f) {
                    if (f.isDirectory())
                        return true;
                    return false;
                }

                public String getDescription() {
                    return "GIFͼƬ(*.gif)";
                }
            });
			
			FileCh.setFileFilter(new FileFilter() {
                public boolean accept(File f) { 
                    if (f.isDirectory())
                        return true;
                    return false;
                }

                public String getDescription() {
                    return "JPEGͼƬ��*.jpg��";
                }
            });
			int returnValue = FileCh.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = FileCh.getSelectedFile();
				if(selectedFile != null){
					String fileString = selectedFile.getAbsolutePath();
					String fileType = "jpg";
					if(FileCh.getFileFilter() == FileCh.getChoosableFileFilters()[1])
						fileType = "png";
					else if(FileCh.getFileFilter() == FileCh.getChoosableFileFilters()[2])
						fileType = "gif";
					
					try {
						ImageIO.write(image, fileType, new java.io.File(fileString+"."+fileType));
		            	mp.paintpanel.hasimage = true;
		            	mp.paintpanel.imgsrc = fileString + "." + fileType;
		            	mp.paintpanel.img = image;
						mp.mainwindow.setTitle(selectedFile.getName()+"."+fileType + " - Java��ͼ��");
						mp.status.setText("�ѱ���Ϊ " + fileString + "." + fileType + ".");
					} catch (IOException e1) {
						
					}
				}
            }
            
		}
	}
}