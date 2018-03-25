package frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import codes.FileInfoReturn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FileInfoTable {
	private FileInfoReturn FIR = new FileInfoReturn();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileInfoTable window = new FileInfoTable();
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
	public FileInfoTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 200);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnFileopen = new JButton("Dir Open");
		JButton btnParse = new JButton("Parse!");
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setSelectedFile(new File(""));
	            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            // chooser.setAcceptAllFileFilterUsed(false);
	            if (chooser.showOpenDialog(frame) == JFileChooser.OPEN_DIALOG) {
	            	if(!btnSave.isEnabled())
						return;
					if(FIR.saving(chooser.getSelectedFile().getPath())) {
						JDialog jdi = new JDialog(frame, "ok" );
						jdi.setBounds(100,100,200,100);
		
						jdi.setVisible(true);
					}
	            
	            
	            } else {
	                // do when cancel
	            }
				
			}
		});
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnParse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!btnParse.isEnabled())
					return;
				if(FIR.fileopen()) {
					btnParse.setEnabled(false);
					btnSave.setEnabled(true);
				}
			}
		});
		btnFileopen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!btnFileopen.isEnabled())
					return;
				
				JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setSelectedFile(new File(""));
	            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            // chooser.setAcceptAllFileFilterUsed(false);
	            if (chooser.showOpenDialog(frame) == JFileChooser.OPEN_DIALOG) {
	            FIR.setDir(chooser.getSelectedFile().getPath());
	            btnFileopen.setEnabled(false);
	            btnParse.setEnabled(true);
	            
	            
	            } else {
	                // do when cancel
	            }
			}
		});
		btnFileopen.setBounds(6, 6, 438, 29);
		layeredPane.add(btnFileopen);
		
		
		btnParse.setEnabled(false);
		btnParse.setBounds(6, 47, 438, 29);
		layeredPane.add(btnParse);
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setEnabled(false);
		btnSave.setBounds(6, 89, 438, 29);
		layeredPane.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnParse.setEnabled(false);
				btnSave.setEnabled(false);
				btnFileopen.setEnabled(true);
			}
		});
		btnReset.setBounds(6, 130, 438, 29);
		layeredPane.add(btnReset);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
