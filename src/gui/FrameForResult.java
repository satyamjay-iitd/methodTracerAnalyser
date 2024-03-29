package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import parser.Parser;

// This frame show the main table using table builder
public class FrameForResult extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8048540120803646699L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public FrameForResult(Parser p) {
		this.setBounds(100, 100, 800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		// Building table of analyzed log file
		TableBuilder table = new TableBuilder(p);
	    this.setSize(300, 300);
	    this.add(new JScrollPane(table.getTable()));
	    this.setVisible(true);
		
	}

}
