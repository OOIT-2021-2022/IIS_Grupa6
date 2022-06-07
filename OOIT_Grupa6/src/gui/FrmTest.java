package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<>();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	private JTextField txtDodajBoju;
	private JList lstBoje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		pnlSouth.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 0;
		pnlSouth.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JButton btnIspis = new JButton("Klikni me");
		btnIspis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Antistres dugme", "Poruka", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnIspis = new GridBagConstraints();
		gbc_btnIspis.insets = new Insets(0, 0, 0, 5);
		gbc_btnIspis.gridx = 5;
		gbc_btnIspis.gridy = 0;
		pnlSouth.add(btnIspis, gbc_btnIspis);
		
		JButton btnDodajBoju = new JButton("Dodaj boju");
		btnDodajBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				dlgTest.setVisible(true);
				
				if(dlgTest.isOk == true) {
					dlm.addElement(dlgTest.txtRed.getText() + " " + dlgTest.txtGreen.getText() + " " + dlgTest.txtBlue.getText());
					btnDodajBoju.setBackground(new Color(Integer.parseInt(dlgTest.txtRed.getText()),
							Integer.parseInt(dlgTest.txtGreen.getText()), 
							Integer.parseInt(dlgTest.txtBlue.getText())));
					
				}
			}
		});
		GridBagConstraints gbc_btnDodajBoju = new GridBagConstraints();
		gbc_btnDodajBoju.insets = new Insets(0, 0, 0, 5);
		gbc_btnDodajBoju.anchor = GridBagConstraints.NORTH;
		gbc_btnDodajBoju.gridx = 6;
		gbc_btnDodajBoju.gridy = 0;
		pnlSouth.add(btnDodajBoju, gbc_btnDodajBoju);
		
		JButton btnIzmeniBoju = new JButton("Izmeni boju:");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				
				try {
					String[] rgb = dlm.getElementAt(lstBoje.getSelectedIndex()).toString().split(" ");
					
					dlgTest.txtRed.setText(rgb[0]);
					dlgTest.txtGreen.setText(rgb[1]);
					dlgTest.txtBlue.setText(rgb[2]);
					
					dlgTest.setVisible(true);
					
					if(dlgTest.isOk) {
						dlm.removeElementAt(lstBoje.getSelectedIndex());
						dlm.addElement(dlgTest.txtRed.getText() + " " + dlgTest.txtGreen.getText() + " " + dlgTest.txtBlue.getText());
						
						btnIzmeniBoju.setBackground(new Color(
								Integer.parseInt(dlgTest.txtRed.getText()),
								Integer.parseInt(dlgTest.txtGreen.getText()),
								Integer.parseInt(dlgTest.txtBlue.getText())
								));
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Morate selektovati boju u R G B formatu!");
				}
			}
		});
		GridBagConstraints gbc_btnIzmeniBoju = new GridBagConstraints();
		gbc_btnIzmeniBoju.gridx = 7;
		gbc_btnIzmeniBoju.gridy = 0;
		pnlSouth.add(btnIzmeniBoju, gbc_btnIzmeniBoju);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dlm.addElement(lblCrvena.getText());
				
				lblCrvena.setForeground(Color.RED);
				lblPlava.setForeground(Color.BLACK);
				lblZuta.setForeground(Color.BLACK);
				
			}
		});
		
		JLabel lblDodajBoju = new JLabel("Dodaj boju:");
		GridBagConstraints gbc_lblDodajBoju = new GridBagConstraints();
		gbc_lblDodajBoju.anchor = GridBagConstraints.EAST;
		gbc_lblDodajBoju.insets = new Insets(0, 0, 5, 5);
		gbc_lblDodajBoju.gridx = 0;
		gbc_lblDodajBoju.gridy = 1;
		pnlCenter.add(lblDodajBoju, gbc_lblDodajBoju);
		
		txtDodajBoju = new JTextField();
		txtDodajBoju.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtDodajBoju.getText());
					txtDodajBoju.setText("");
				}
			}
		});
		GridBagConstraints gbc_txtDodajBoju = new GridBagConstraints();
		gbc_txtDodajBoju.insets = new Insets(0, 0, 5, 5);
		gbc_txtDodajBoju.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDodajBoju.gridx = 1;
		gbc_txtDodajBoju.gridy = 1;
		pnlCenter.add(txtDodajBoju, gbc_txtDodajBoju);
		txtDodajBoju.setColumns(10);
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 2;
		pnlCenter.add(tglbtnCrvena, gbc_tglbtnCrvena);
		
		btnGroup.add(tglbtnCrvena);
		
		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 2;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 2;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		lstBoje = new JList();
		scrollPane.setViewportView(lstBoje);
		lstBoje.setModel(dlm);
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlm.addElement(lblPlava.getText());
				
				lblCrvena.setForeground(Color.BLACK);
				lblPlava.setForeground(Color.BLUE);
				lblZuta.setForeground(Color.BLACK);
			}
		});
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 3;
		pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);
		
		btnGroup.add(tglbtnPlava);
		
		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 3;
		pnlCenter.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("\u017Duta");
		tglbtnZuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlm.addElement(lblZuta.getText());
				
				lblCrvena.setForeground(Color.BLACK);
				lblPlava.setForeground(Color.BLACK);
				lblZuta.setForeground(Color.YELLOW);
			}
		});
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 4;
		pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);
		
		btnGroup.add(tglbtnZuta);
		
		lblZuta = new JLabel("\u017Duta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 4;
		pnlCenter.add(lblZuta, gbc_lblZuta);
		
		JLabel lblDodatneBoje = new JLabel("Dodatne boje:");
		GridBagConstraints gbc_lblDodatneBoje = new GridBagConstraints();
		gbc_lblDodatneBoje.anchor = GridBagConstraints.EAST;
		gbc_lblDodatneBoje.insets = new Insets(0, 0, 0, 5);
		gbc_lblDodatneBoje.gridx = 0;
		gbc_lblDodatneBoje.gridy = 5;
		pnlCenter.add(lblDodatneBoje, gbc_lblDodatneBoje);
		
		JComboBox<String> cmbDodatneBoje = new JComboBox<String>();
		cmbDodatneBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlm.addElement(cmbDodatneBoje.getSelectedItem().toString());
				
				switch(cmbDodatneBoje.getSelectedItem().toString()) {
					case "Zelena": 
						lblDodatneBoje.setForeground(Color.GREEN);
						break;
					case "Narandzasta": 
						lblDodatneBoje.setForeground(Color.ORANGE);	
						break;
					case "Ljubicasta": 
						lblDodatneBoje.setForeground(Color.MAGENTA);
						break;
					default: 
						lblDodatneBoje.setForeground(Color.BLACK);
						break;
				}
			}
		});
		cmbDodatneBoje.setModel(new DefaultComboBoxModel<String>(new String[] {"Zelena", "Narandzasta", "Ljubicasta"}));
		GridBagConstraints gbc_cmbDodatneBoje = new GridBagConstraints();
		gbc_cmbDodatneBoje.insets = new Insets(0, 0, 0, 5);
		gbc_cmbDodatneBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDodatneBoje.gridx = 1;
		gbc_cmbDodatneBoje.gridy = 5;
		pnlCenter.add(cmbDodatneBoje, gbc_cmbDodatneBoje);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.GREEN);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Naslov");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		pnlNorth.add(lblNaslov);
	}

}
