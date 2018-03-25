package frm;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

import frm.EncoderTool;
import frm.HASH_Generator;
import frm.TimezoneTool;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MSG_ForensicTool {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MSG_ForensicTool window = new MSG_ForensicTool();
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
	public MSG_ForensicTool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 330, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblMsgforensictool = new JLabel("MSG_ForensicTool");
		lblMsgforensictool.setFont(new Font("Arial", Font.BOLD, 35));
		lblMsgforensictool.setBounds(6, 6, 320, 46);
		layeredPane.add(lblMsgforensictool);
		
		JButton btnHashGenerator = new JButton("HASH Generator");
		btnHashGenerator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HASH_Generator hsg = new HASH_Generator();
				hsg.open();
			}
		});
		btnHashGenerator.setBounds(6, 79, 320, 29);
		layeredPane.add(btnHashGenerator);
		
		JButton btnUtcToRealtime = new JButton("TimeZone Tools");
		btnUtcToRealtime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TimezoneTool tzt = new TimezoneTool();
				tzt.open();
			}
		});
		btnUtcToRealtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUtcToRealtime.setBounds(6, 120, 320, 29);
		layeredPane.add(btnUtcToRealtime);
		
		JButton btnMacTimeInfomation = new JButton("File Infomation Table");
		btnMacTimeInfomation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileInfoTable fit = new FileInfoTable();
				fit.open();
			}
		});
		btnMacTimeInfomation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMacTimeInfomation.setBounds(6, 161, 320, 29);
		layeredPane.add(btnMacTimeInfomation);
		
		JButton btnEncoderdecoder = new JButton("Encoder/Decoder");
		btnEncoderdecoder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EncoderTool().open();
			}
		});
		btnEncoderdecoder.setBounds(6, 200, 320, 29);
		layeredPane.add(btnEncoderdecoder);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 241, 320, 12);
		layeredPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 53, 320, 12);
		layeredPane.add(separator_1);
		
		JLabel lblMakerJwmsg = new JLabel("Maker JWMSG");
		lblMakerJwmsg.setBounds(6, 254, 117, 16);
		layeredPane.add(lblMakerJwmsg);
		
		JButton btnGoDeveloperSite = new JButton("About.");
		btnGoDeveloperSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoDeveloperSite.setBounds(101, 249, 225, 29);
		layeredPane.add(btnGoDeveloperSite);
	}
}
