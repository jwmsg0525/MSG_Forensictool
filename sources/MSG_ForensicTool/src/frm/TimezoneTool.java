package frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import codes.TimeReturn;
import javax.swing.SpringLayout;

public class TimezoneTool {

	private JFrame frame;
	private JTextField txutc;
	private JTextField txtime;
	double nowTimezone = 0;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimezoneTool window = new TimezoneTool();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimezoneTool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 250);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 500, 40);
		layeredPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		
		txtime = new JTextField();
		panel_3.add(txtime);
		txtime.setColumns(10);
		
		JLabel lblTime = new JLabel("TIME");
		panel_3.add(lblTime);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		
		JLabel lblUtc = new JLabel("UTC");
		panel_1.add(lblUtc);
		
		txutc = new JTextField();
		panel_1.add(txutc);
		txutc.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JButton btnR = new JButton(">>");
		btnR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
			}
		});
		SpringLayout sl_panel_2 = new SpringLayout();
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnR, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnR, 79, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnR, 40, SpringLayout.NORTH, panel_2);
		panel_2.setLayout(sl_panel_2);
		panel_2.add(btnR);
		
		JButton btnL = new JButton("<<");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnL, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnL, 0, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnL, 40, SpringLayout.NORTH, panel_2);
		btnL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TimeReturn t = new TimeReturn();
				txutc.setText(t.TtoL(txtime.getText()));
			}
		});
		panel_2.add(btnL);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 62, 500, 143);
		layeredPane.add(panel_4);
		
		JRadioButton rdmi = new JRadioButton("-");
		panel_4.add(rdmi);
		JLabel lblutc = new JLabel("(UTC +0)");
		JButton pl0 = new JButton("0");
		pl0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = 0;
				}else {
					nowTimezone = 0;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl0);
		
		JButton pl15 = new JButton("15m");
		pl15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone -= 0.25;
				}else {
					nowTimezone += 0.25;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl15);
		
		JButton pl30 = new JButton("30m");
		pl30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone -= 0.5;
				}else {
					nowTimezone += 0.5;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl30);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JLabel lblNowState = new JLabel("Now State");
		panel_5.add(lblNowState);
		
		
		panel_5.add(lblutc);
		
		JButton pl1 = new JButton("1");
		pl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -1;
				}else {
					nowTimezone = 1;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl1);
		pl1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton pl2 = new JButton("2");
		pl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -2;
				}else {
					nowTimezone = 2;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl2);
		
		JButton pl3 = new JButton("3");
		pl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -3;
				}else {
					nowTimezone = 3;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl3);
		
		JButton pl4 = new JButton("4");
		pl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -4;
				}else {
					nowTimezone = 4;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl4);
		
		JButton pl5 = new JButton("5");
		pl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -5;
				}else {
					nowTimezone = 5;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl5);
		
		JButton pl6 = new JButton("6");
		pl6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -6;
				}else {
					nowTimezone = 6;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		pl6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(pl6);
		
		JButton pl7 = new JButton("7");
		pl7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -7;
				}else {
					nowTimezone = 7;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl7);
		
		JButton pl8 = new JButton("8");
		pl8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -8;
				}else {
					nowTimezone = 8;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl8);
		
		JButton pl9 = new JButton("9");
		pl9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -9;
				}else {
					nowTimezone = 9;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl9);
		
		JButton pl10 = new JButton("10");
		pl10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -10;
				}else {
					nowTimezone = 10;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl10);
		
		JButton pl11 = new JButton("11");
		pl11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -11;
				}else {
					nowTimezone = 11;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl11);
		
		JButton pl12 = new JButton("12");
		pl12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdmi.isSelected()) {
					nowTimezone = -12;
				}else {
					nowTimezone = 12;
				}
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					txtime.setText(t.LtoT(Long.parseLong(txutc.getText()),nowTimezone));
				}
				lblutc.setText("(UTC "+nowTimezone+")");
			}
		});
		panel_4.add(pl12);
		
		JButton btnNowTime = new JButton("Now Time(Local TimeZone)");
		btnNowTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txutc.getText() != "") {
					TimeReturn t = new TimeReturn();
					
					txtime.setText(t.LtoT(System.currentTimeMillis(),nowTimezone));
					txutc.setText(""+System.currentTimeMillis());
				}
			}
		});
		panel_4.add(btnNowTime);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
