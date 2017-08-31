package iuh.java.btTuan01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongBac2 extends JFrame implements ActionListener{
	private JButton butonGiai;
	private JButton lblThoat;
	private JButton lblXoa;
	private JTextField txta;
	private JTextField txtkq;
	private JTextField txtc;
	private JTextField txtb;
	public  PhuongBac2() {
		setSize(600, 400);
		setTitle("PHƯƠNG TRÌNH BẬC 2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		creatGUI();
	}
	private void creatGUI() {
		JPanel panelN;
		add(panelN = new JPanel(), BorderLayout.NORTH);
		panelN.setBackground(Color.CYAN);
		JLabel lblTieuDe;
		panelN.add(lblTieuDe = new JLabel("Giải Phương Trình Bậc 2"));
		lblTieuDe.setFont(new Font("arial", Font.BOLD,20));
		
		JPanel panelC;
		add(panelC = new JPanel(), BorderLayout.CENTER);
		panelC.setLayout(null);
		JLabel lblA, lblB, lblC, lblKQ;
		panelC.add(lblA = new JLabel("Nhập a"));
		int x=30, y=30, width=100, height=30;
		lblA.setBounds(x, y, width, height);
		panelC.add(lblB = new JLabel("Nhập b"));
		y+=50;
		lblB.setBounds(x, y, width, height);
		panelC.add(lblC = new JLabel("Nhập c"));
		y+=50;
		lblC.setBounds(x, y, width, height);
		panelC.add(lblKQ = new JLabel("Kết quả"));
		y+=50;
		lblKQ.setBounds(x, y, width, height);
		panelC.add(txta = new JTextField());
		x+=50;y=30;width=300;height=30;
		txta.setBounds(x, y, width, height);
		panelC.add(txtb = new JTextField());
		y+=50;
		txtb.setBounds(x, y, width, height);
		panelC.add(txtc = new JTextField());
		y+=50;
		txtc.setBounds(x, y, width, height);
		panelC.add(txtkq = new JTextField());
		y+=50;
		txtkq.setBounds(x, y, width, height);
		txtkq.setEditable(false);
		
		JPanel panelS;
		add(panelS = new JPanel(), BorderLayout.SOUTH);
		panelS.setBorder(BorderFactory.createTitledBorder("Chọn chức năng"));
		panelS.add(butonGiai = new JButton("Giải"));
		panelS.add(lblXoa = new JButton("Xóa"));
		panelS.add(lblThoat = new JButton("Thoát"));
		butonGiai.addActionListener(this);
		lblThoat.addActionListener(this);
		lblXoa.addActionListener(this);
	}
	public static void main(String[] args) {
		new PhuongBac2().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(lblThoat))
		{
			System.out.println("Good Bye");
			System.exit(0);
		}
		else if (o.equals(lblXoa))
		{
			txta.setText("");
			txtb.setText("");
			txtc.setText("");
			txtkq.setText("");
			txta.requestFocus();
		}
		else if (o.equals(butonGiai))
		{
			double delta=0.0;
			int x = new Integer(txta.getText());
			int y = new Integer(txtb.getText());
			int z = new Integer(txtc.getText());
			delta =y*y - 4*x*z;
			txtkq.setText(" " +Math.sqrt(delta));
			
		}
	}





































}