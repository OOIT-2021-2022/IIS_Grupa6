package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtRed;
	protected JTextField txtGreen;
	protected JTextField txtBlue;
	protected boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTest dialog = new DlgTest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTest() {
		setModal(true);
		setTitle("Unos boje");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRed = new JLabel("RED");
			GridBagConstraints gbc_lblRed = new GridBagConstraints();
			gbc_lblRed.insets = new Insets(0, 0, 5, 5);
			gbc_lblRed.gridx = 0;
			gbc_lblRed.gridy = 2;
			contentPanel.add(lblRed, gbc_lblRed);
		}
		{
			txtRed = new JTextField();
			GridBagConstraints gbc_txtRed = new GridBagConstraints();
			gbc_txtRed.insets = new Insets(0, 0, 5, 0);
			gbc_txtRed.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRed.gridx = 2;
			gbc_txtRed.gridy = 2;
			contentPanel.add(txtRed, gbc_txtRed);
			txtRed.setColumns(10);
		}
		{
			JLabel lblGreen = new JLabel("GREEN");
			GridBagConstraints gbc_lblGreen = new GridBagConstraints();
			gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
			gbc_lblGreen.gridx = 0;
			gbc_lblGreen.gridy = 3;
			contentPanel.add(lblGreen, gbc_lblGreen);
		}
		{
			txtGreen = new JTextField();
			GridBagConstraints gbc_txtGreen = new GridBagConstraints();
			gbc_txtGreen.insets = new Insets(0, 0, 5, 0);
			gbc_txtGreen.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGreen.gridx = 2;
			gbc_txtGreen.gridy = 3;
			contentPanel.add(txtGreen, gbc_txtGreen);
			txtGreen.setColumns(10);
		}
		{
			JLabel lblBlue = new JLabel("BLUE");
			GridBagConstraints gbc_lblBlue = new GridBagConstraints();
			gbc_lblBlue.insets = new Insets(0, 0, 0, 5);
			gbc_lblBlue.anchor = GridBagConstraints.WEST;
			gbc_lblBlue.gridx = 0;
			gbc_lblBlue.gridy = 4;
			contentPanel.add(lblBlue, gbc_lblBlue);
		}
		{
			txtBlue = new JTextField();
			GridBagConstraints gbc_txtBlue = new GridBagConstraints();
			gbc_txtBlue.anchor = GridBagConstraints.NORTH;
			gbc_txtBlue.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBlue.gridx = 2;
			gbc_txtBlue.gridy = 4;
			contentPanel.add(txtBlue, gbc_txtBlue);
			txtBlue.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						isOk = true;
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
