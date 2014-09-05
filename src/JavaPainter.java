import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JavaPainter extends JFrame{

	public JavaPainter() {
		setTitle("��ͼ");
		setMinimumSize(new Dimension(1000, 650));
		mainPanel mp = new mainPanel();
		add(mp);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		JavaPainter painter = new JavaPainter();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ��С
		painter.setLocation((screenSize.width - painter.getBounds().width) / 2, (screenSize.height - painter.getBounds().height) / 2);//�����Ӧ��Ļ��С�����λ��
		painter.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
