package frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import codes.GenHash;

public class HASH_Generator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HASH_Generator window = new HASH_Generator();
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
	public HASH_Generator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 200);
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		JLabel lbfilepath = new JLabel("File open first!!!");
		JButton btnFileOpen = new JButton("File open");
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		btnFileOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setSelectedFile(new File(""));
	            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	            // chooser.setAcceptAllFileFilterUsed(false);
	            if (chooser.showOpenDialog(frame) == JFileChooser.OPEN_DIALOG) {
	            lbfilepath.setText(chooser.getSelectedFile().getAbsolutePath());
	 
	            } else {
	                // do when cancel
	            }
			}
		});
		btnFileOpen.setBounds(6, 16, 488, 29);
		layeredPane.add(btnFileOpen);
		
		
		lbfilepath.setBounds(16, 47, 478, 16);
		layeredPane.add(lbfilepath);
		
		JButton btnNewButton = new JButton("MD5");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenHash hs = new GenHash(lbfilepath.getText());
				hs.fileopen();
				textArea.setText(hs.md5hash());
			}
		});
		btnNewButton.setBounds(127, 75, 75, 29);
		layeredPane.add(btnNewButton);
		
		JButton btnSha = new JButton("SHA1");
		btnSha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenHash hs = new GenHash(lbfilepath.getText());
				hs.fileopen();
				textArea.setText(hs.sha1hash());
			}
		});
		btnSha.setBounds(214, 75, 75, 29);
		layeredPane.add(btnSha);
		
		JButton btnSha_1 = new JButton("SHA256");
		btnSha_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenHash hs = new GenHash(lbfilepath.getText());
				hs.fileopen();
				textArea.setText(hs.sha256hash());
			}
		});
		btnSha_1.setBounds(301, 75, 75, 29);
		layeredPane.add(btnSha_1);
		
		
		textArea.setBounds(6, 109, 488, 63);
		layeredPane.add(textArea);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
