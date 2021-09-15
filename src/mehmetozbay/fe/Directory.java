package mehmetozbay.fe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import mehmetozbay.contract.Person;
import mehmetozbay.dal.PersonDAL;
import mehmetozbay.utilities.Helper;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Directory extends JFrame {

	private PersonDAL personDal = new PersonDAL();
	private JPanel contentPane;
	private JTable table_directory;
	private JTextField txtName;
	private JLabel lblName;
	private JTextField txtSurname;
	private JLabel lblSurname;
	private JLabel lblTel;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblAdress;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnClear;
	private JScrollPane scrollPane_Adress;
	private JTextArea txtAreaAdress;
	private JFormattedTextField frmtxtTel;
	private DefaultTableModel personModel;
	private Object[] personData;
	static Helper helper = new Helper();
	private JTextField txtId;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directory frame = new Directory();
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
	public Directory() {
		personModel = new DefaultTableModel();
		Object[] colPersonColumn = new Object[6];
		colPersonColumn[0] = "Id";
		colPersonColumn[1] = "Name";
		colPersonColumn[2] = "Surname";
		colPersonColumn[3] = "Tel";
		colPersonColumn[4] = "Email";
		colPersonColumn[5] = "Adress";
		personModel.setColumnIdentifiers(colPersonColumn);
		listAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 539);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(74, 170, 165));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table_directory = new JTable(personModel);
		table_directory.setBounds(563, 44, 156, 376);
		// contentPane.add(table);

		JScrollPane scrollPane_directory = new JScrollPane();
		scrollPane_directory.setBounds(10, 79, 458, 391);
		contentPane.add(scrollPane_directory);
		scrollPane_directory.setViewportView(table_directory);
		// contentPane.add(textArea);

		JButton btnAdd = new JButton("");
		btnAdd.setBounds(530, 345, 73, 44);
		btnAdd.setIcon(helper.iconDimension(35, 35, "/add.png"));
		btnAdd.setBackground(new Color(58, 81, 107));
		contentPane.add(btnAdd);

		txtName = new JTextField();
		txtName.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(602, 35, 157, 35);
		contentPane.add(txtName);

		lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblName.setBounds(530, 35, 64, 35);
		contentPane.add(lblName);

		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		txtSurname.setColumns(10);
		txtSurname.setBounds(602, 80, 157, 35);
		contentPane.add(txtSurname);

		lblSurname = new JLabel("Surname:");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblSurname.setBounds(508, 80, 86, 35);
		contentPane.add(lblSurname);

		lblTel = new JLabel("Tel:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setForeground(Color.WHITE);
		lblTel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblTel.setBounds(508, 125, 86, 35);
		contentPane.add(lblTel);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(602, 170, 157, 35);
		contentPane.add(txtEmail);

		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblEmail.setBounds(508, 170, 86, 35);
		contentPane.add(lblEmail);

		lblAdress = new JLabel("Adress:");
		lblAdress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblAdress.setBounds(508, 215, 86, 35);
		contentPane.add(lblAdress);

		btnDelete = new JButton("");

		btnDelete.setBackground(new Color(58, 81, 107));
		btnDelete.setBounds(613, 345, 73, 44);
		btnDelete.setIcon(helper.iconDimension(35, 35, "/delete.png"));
		contentPane.add(btnDelete);

		btnUpdate = new JButton("");
		btnUpdate.setBackground(new Color(58, 81, 107));
		btnUpdate.setIcon(helper.iconDimension(35, 35, "/update.png"));
		btnUpdate.setBounds(696, 345, 73, 44);
		contentPane.add(btnUpdate);

		btnClear = new JButton("");
		btnClear.setBackground(new Color(58, 81, 107));
		btnClear.setBounds(779, 345, 73, 44);
		btnClear.setIcon(helper.iconDimension(35, 35, "/clear.png"));
		contentPane.add(btnClear);
		// contentPane.add(table);
		txtAreaAdress = new JTextArea();
		txtAreaAdress.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		txtAreaAdress.setBounds(0, 0, 5, 22);
		// contentPane.add(textArea);
		scrollPane_Adress = new JScrollPane();
		scrollPane_Adress.setBounds(602, 215, 157, 110);
		scrollPane_Adress.setViewportView(txtAreaAdress);
		contentPane.add(scrollPane_Adress);
		txtId = new JTextField();
		txtId.setBounds(627, 417, 96, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		txtId.setVisible(false);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("( ### )  ###  ##  ##");
			frmtxtTel = new JFormattedTextField(maskFormatter);
			frmtxtTel.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			frmtxtTel.setBounds(602, 125, 157, 35);
			contentPane.add(frmtxtTel);

			txtSearch = new JTextField();
			txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtSearch.setBounds(108, 44, 360, 25);
			contentPane.add(txtSearch);
			txtSearch.setColumns(10);

			JLabel lblArama = new JLabel("Arama:");
			lblArama.setHorizontalAlignment(SwingConstants.RIGHT);
			lblArama.setForeground(Color.WHITE);
			lblArama.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			lblArama.setBounds(23, 34, 64, 35);
			contentPane.add(lblArama);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// -------------Table click ----------------------------
		table_directory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtId.setText(personModel.getValueAt(table_directory.getSelectedRow(), 0).toString());
				txtName.setText(personModel.getValueAt(table_directory.getSelectedRow(), 1).toString());
				txtSurname.setText(personModel.getValueAt(table_directory.getSelectedRow(), 2).toString());
				frmtxtTel.setText(personModel.getValueAt(table_directory.getSelectedRow(), 3).toString());
				txtEmail.setText(personModel.getValueAt(table_directory.getSelectedRow(), 4).toString());
				txtAreaAdress.setText(personModel.getValueAt(table_directory.getSelectedRow(), 5).toString());
			}
		});

		// Add person to directory---------------------------------------..>>>>>

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = new Person();
				person.setName(txtName.getText());
				person.setSurName(txtSurname.getText());
				person.setTel(frmtxtTel.getText());
				person.setEmail(txtEmail.getText());
				person.setAdress(txtAreaAdress.getText());
				try {
					boolean control = personDal.insert(person);
					if (control) {
						helper.showMsg("success");
						listAll();
						cleanAll();
					} else {
						helper.showMsg("error");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Delete Person------------------------------>>>>
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirm("sure")) {
				
				System.out.println();
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						try {
							boolean control = personDal.delete(id);
							if (control) {
								helper.showMsg("success");
								listAll();
								cleanAll();
							} else {
								helper.showMsg("error");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						helper.showMsg("tablodan bir secim yapiniz");
					}

				}
			}
		});

		// Update person----------------------------->>>>
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirm("sure")) {
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						Person person = new Person(id, txtName.getText(), txtSurname.getText(), frmtxtTel.getText(),
								txtEmail.getText(), txtAreaAdress.getText());

						boolean control;
						try {
							control = personDal.update(person);
							if (control) {
								helper.showMsg("success");

								listAll();
								cleanAll();

							} else {
								helper.showMsg("error");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						helper.showMsg("tablodan bir secim yapiniz");
					}

				}
			}
		});

		// Clear txt-------------------------------------..>>>
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanAll();
			}
		});

		// Search clean
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSearch.setText("");
			}
		});

		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchTxt = txtSearch.getText();
				List<Person> personList;
				if (!searchTxt.equals("")) {
					try {
						personList = personDal.getBySearch(searchTxt);

						personModel.setRowCount(0);
						personData = new Object[6];

						for (int i = 0; i < personList.size(); i++) {

							personData[0] = personList.get(i).getId();
							personData[1] = personList.get(i).getName();
							personData[2] = personList.get(i).getSurName();
							personData[3] = personList.get(i).getTel();
							personData[4] = personList.get(i).getEmail();
							personData[5] = personList.get(i).getAdress();
							personModel.addRow(personData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					listAll();
				}

			}
		});

	}

	// List All Person------------------------------------>>>>>>>>>>
	public void listAll() {
		personModel.setRowCount(0);
		personData = new Object[6];

		try {
			for (int i = 0; i < personDal.getAll().size(); i++) {

				personData[0] = personDal.getAll().get(i).getId();
				personData[1] = personDal.getAll().get(i).getName();
				personData[2] = personDal.getAll().get(i).getSurName();
				personData[3] = personDal.getAll().get(i).getTel();
				personData[4] = personDal.getAll().get(i).getEmail();
				personData[5] = personDal.getAll().get(i).getAdress();
				personModel.addRow(personData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cleanAll() {
		txtAreaAdress.setText("");
		txtEmail.setText("");
		frmtxtTel.setText("");
		txtName.setText("");
		txtSurname.setText("");
		txtId.setText("");
	}
}
