package frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import codes.EncodingReturn;
public class EncoderTool {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public  void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncoderTool window = new EncoderTool();
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
	public EncoderTool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JTextArea txFirst = new JTextArea();
		txFirst.setLineWrap(true);
		txFirst.setRows(7);
		txFirst.setBounds(6, 6, 438, 98);
		layeredPane.add(txFirst);
		
		JTextArea txLast = new JTextArea();
		txLast.setLineWrap(true);
		txLast.setRows(7);
		txLast.setBounds(6, 167, 438, 105);
		layeredPane.add(txLast);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 116, 438, 39);
		layeredPane.add(panel);
		
		JCheckBox chkDec = new JCheckBox("Decoder");
		panel.add(chkDec);
		
		JButton btnUrl = new JButton("URL");
		btnUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chkDec.isSelected())
					txLast.setText(new EncodingReturn().DecodURL(txFirst.getText()));
				
				else
					txLast.setText(new EncodingReturn().EncodURL(txFirst.getText()));
			}
		});
		panel.add(btnUrl);
		
		JButton btnBase = new JButton("Base64");
		btnBase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chkDec.isSelected())
					txLast.setText(new EncodingReturn().DecodBase64(txFirst.getText()));
				
				else
					txLast.setText(new EncodingReturn().EncodBase64(txFirst.getText()));
			}
		});
		panel.add(btnBase);
		
		JButton btnNewButton = new JButton("HEX");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chkDec.isSelected())
					txLast.setText(new EncodingReturn().hTos(txFirst.getText()));
					
				else
					txLast.setText(new EncodingReturn().sToh(txFirst.getText()));
					
			}
		});
		panel.add(btnNewButton);
		
		JButton btnRot = new JButton("ROT 1");
		panel.add(btnRot);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
