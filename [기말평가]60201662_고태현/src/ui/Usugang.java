package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import service.SBasket;
import service.SHakgwa;
import service.SLecture;
import service.SLogin;
import service.SSugangsincheong;
import valueObject.VBasket;
import valueObject.VHakgwa;
import valueObject.VLecture;
import valueObject.VLogin;
import valueObject.VPersonalInfo;
import valueObject.VSugangsincheong;

public class Usugang extends JFrame {

	private String fileName = "root";
	String fileName5 = null;
	String Id, Name, Professor, Credit, Time = null;
	String Id1, Name1, Professor1, Credit1, Time1 = null;
	// String Id3, Name3, Professor3, Credit3, Time3 = null;
//	int total, total1 = 0;
//	int finaltotal = total - total;
	int finaltotal;

	@SuppressWarnings("unchecked")
	public void Psugangsincheong(String personalData, VPersonalInfo vPersonalInfo) {

		JFrame frame = new JFrame();
		setTitle("������ ������û ���α׷�");
		this.setSize(1000, 700); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ż �� ��

		JPanel panelSugang = new JPanel();
		panelSugang.setBackground(Color.white);
		setContentPane(panelSugang);
		panelSugang.setLayout(null);

		JLabel hellola = new JLabel(vPersonalInfo.name1 + "�� ȯ���մϴ�!");
		hellola.setFont(new Font("����", Font.BOLD, 13));
		panelSugang.add(hellola);
		hellola.setBounds(12, 10, 181, 15);

		JList campuslist = new JList();
		panelSugang.add(campuslist);
		campuslist.setBounds(25, 150, 111, 205);
		campuslist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		campuslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JList collegelist = new JList();
		panelSugang.add(collegelist);
		collegelist.setBounds(151, 150, 165, 205);
		collegelist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		collegelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JList departmentlist = new JList();
		panelSugang.add(departmentlist);
		departmentlist.setBounds(328, 150, 122, 205);
		departmentlist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		departmentlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel campusla = new JLabel("ķ�۽�");
		campusla.setFont(new Font("����", Font.BOLD, 13));
		campusla.setBounds(25, 125, 57, 15);
		panelSugang.add(campusla);

		JLabel collegela = new JLabel("�ܰ���");
		panelSugang.add(collegela);
		collegela.setFont(new Font("����", Font.BOLD, 13));
		collegela.setBounds(154, 125, 57, 15);

		JLabel departmentla = new JLabel("�а�");
		panelSugang.add(departmentla);
		departmentla.setFont(new Font("����", Font.BOLD, 13));
		departmentla.setBounds(328, 125, 57, 15);

		JLabel lecturela = new JLabel("�� ��");
		panelSugang.add(lecturela);
		lecturela.setFont(new Font("����", Font.BOLD, 13));
		lecturela.setBounds(25, 386, 57, 15);

		JLabel image = new JLabel("New label");
		panelSugang.add(image);
		image.setIcon(new ImageIcon("������û�̹���.gif"));
		image.setBounds(12, 32, 356, 83);

		JLabel emergency = new JLabel("* �ٸ� �ܰ��븦 ���ý� 'reset'�� �����ּ���");
		panelSugang.add(emergency);
		emergency.setFont(new Font("����", Font.PLAIN, 12));
		emergency.setBounds(172, 360, 278, 22);

		JButton gobasketBtn = new JButton("���� ���");
		panelSugang.add(gobasketBtn);
		gobasketBtn.setBounds(320, 628, 130, 23);

		JButton logoutBtn = new JButton("�α׾ƿ�");
		panelSugang.add(logoutBtn);
		logoutBtn.setBounds(875, 55, 97, 23);

		JButton clockBtn = new JButton("�����ð�");
		panelSugang.add(clockBtn);
		clockBtn.setBounds(875, 22, 97, 23);

		JLabel basketla = new JLabel("å����");
		panelSugang.add(basketla);
		basketla.setBounds(506, 125, 57, 15);

		JButton deleteBtn = new JButton("�����ϱ�");
		panelSugang.add(deleteBtn);
		deleteBtn.setBounds(857, 360, 97, 23);

		JButton sugangBtn = new JButton("������û");
		panelSugang.add(sugangBtn);
		sugangBtn.setBounds(748, 360, 97, 23);

		JButton sugangdelBtn = new JButton("�����ϱ�");
		panelSugang.add(sugangdelBtn);
		sugangdelBtn.setBounds(857, 628, 97, 23);

		JButton homepageBtn = new JButton("Ȩ������");
		panelSugang.add(homepageBtn);
		homepageBtn.setBounds(766, 22, 97, 23);

		JButton myInfo = new JButton("������");
		panelSugang.add(myInfo);
		myInfo.setBounds(766, 55, 97, 23);

		JLabel mju = new JLabel("�״��      �� ������      �̾��!");
		mju.setFont(new Font("�̼Ҷ�", Font.BOLD, 28));
		panelSugang.add(mju);
		mju.setBounds(377, 44, 382, 47);

		JLabel mju1 = new JLabel("����");
		mju1.setFont(new Font("�̼Ҷ�", Font.BOLD, 28));
		panelSugang.add(mju1);
		mju1.setBounds(465, 47, 87, 40);

		JLabel mju2 = new JLabel("���");
		mju2.setFont(new Font("�̼Ҷ�", Font.BOLD, 28));
		panelSugang.add(mju2);
		mju2.setBounds(629, 48, 98, 39);
		mju2.setForeground(Color.red);

		JLabel sugangla = new JLabel("������û");
		panelSugang.add(sugangla);
		sugangla.setBounds(506, 386, 57, 15);

		JButton numcheBtn = new JButton("���� Ȯ��");
		panelSugang.add(numcheBtn);
		numcheBtn.setBounds(748, 628, 97, 23);

		JButton friendBtn = new JButton("ģ ��");
		panelSugang.add(friendBtn);
		friendBtn.setBounds(875, 88, 97, 23);

		// ģ�� ��ư �׼�
		friendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UFriend uFriend = new UFriend();
				uFriend.ufriend(personalData, vPersonalInfo);
				uFriend.setVisible(true);
			}
		});

		// ���� �ð� ��ư
		clockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						URI uri = new URI("http://time.navyism.com/?host=class.mju.ac.kr");
						desktop.browse(uri);
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		// ������ ��ư �׼�
		myInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UMyInfo uMyInfo = new UMyInfo();
				uMyInfo.umyinfo(vPersonalInfo);
				uMyInfo.setVisible(true);
			}
		});

		// Ȩ������ ��ư �׼�
		homepageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						URI uri = new URI("https://www.mju.ac.kr/sites/mjukr/intro/intro.html");
						desktop.browse(uri);
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		// ���� ���̺�
		JTable table = new JTable();
		JScrollPane scoll = new JScrollPane(table);
		// å���� ���̺�
		JTable btable = new JTable();
		JScrollPane scoll1 = new JScrollPane(btable);

		Vector<String> m = new Vector<String>();
		m.addElement("���� ��ȣ");
		m.addElement("���Ǹ�");
		m.addElement("����");
		m.addElement("����");
		m.addElement("�ð�");
		DefaultTableModel model1 = new DefaultTableModel(m, 0) { // (������, // ������)
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// ������û ���̺�
		JTable stable = new JTable();
		JScrollPane scoll2 = new JScrollPane(stable);
		DefaultTableModel model2 = new DefaultTableModel(m, 0) { // (������, // ������)
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// �α׾ƿ� ��ư �׼�
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ULogin uLogin = new ULogin();
				uLogin.ULogin();
			}
		});

		SHakgwa sHakgwa = new SHakgwa();
		Vector<VHakgwa> vCampuses = sHakgwa.getData(fileName);

		Vector<Object> campus = new Vector<>();

		// ����Ʈ�� ķ�۽��ֱ�
		for (VHakgwa vCampus : vCampuses) {
			campus.add(vCampus.getName());
		}
		campuslist.setListData(campus);
		campus.addElement("reset");

		// ķ�۽� ����
		campuslist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				fileName = (String) campuslist.getSelectedValue();

				for (VHakgwa vCampus : vCampuses) {
					if (vCampus.getName().equals(fileName)) {
						fileName = vCampus.getFileName();

					}
				}

				Vector<VHakgwa> colleges = sHakgwa.getData(fileName);
				Vector<Object> college = new Vector<>();
				// ����Ʈ�� �ܰ��� �ֱ�
				for (VHakgwa vCollege : colleges) {
					college.add(vCollege.getName());
				}

				collegelist.setListData(college);

				collegelist.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {

						String fileName1 = null;

						// ���⼭ �����ϳ����� �޾���
						fileName1 = (String) collegelist.getSelectedValue();

						for (VHakgwa vCollege : colleges) {
							if (vCollege.getName().equals(fileName1)) {
								fileName = vCollege.getFileName();

							}
						}

						Vector<VHakgwa> departments = sHakgwa.getData(fileName);
						Vector<Object> department = new Vector<>();

						// ����Ʈ�� �а� �ֱ�
						for (VHakgwa vDepartment : departments) {
							department.add(vDepartment.getName());
						}

						departmentlist.setListData(department);

						departmentlist.addListSelectionListener(new ListSelectionListener() {
							@SuppressWarnings("serial")
							public void valueChanged(ListSelectionEvent e) {
								String fileName1 = null;
								// ���⼭ �����ϳ����� �޾���
								fileName1 = (String) departmentlist.getSelectedValue();

								for (VHakgwa vDepartmnet : departments) {
									if (vDepartmnet.getName().equals(fileName1)) {
										fileName5 = vDepartmnet.getFileName();

									}
								}
								try {
									SLecture sLecture = new SLecture();
									Vector<VLecture> lectures = sLecture.read(fileName5);

									Vector<String> u = new Vector<String>();
									u.addElement("���� ��ȣ");
									u.addElement("���Ǹ�");
									u.addElement("����");
									u.addElement("����");
									u.addElement("�ð�");

									DefaultTableModel model = new DefaultTableModel(u, 0) { // (������, ������)
										public boolean isCellEditable(int row, int column) {
											return false;
										}
									};
									scoll.setBounds(25, 411, 425, 214);
									scoll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									panelSugang.add(scoll);

									for (VLecture vLecture : lectures) {
										@SuppressWarnings("rawtypes")

										Vector lecture = new Vector();

										lecture.add(vLecture.getId());
										lecture.add(vLecture.getName());
										lecture.add(vLecture.getProfessor());
										lecture.add(vLecture.getCredit());
										lecture.add(vLecture.getTime());

										model.addRow(lecture);
										table.setModel(model);
									}

									table.getColumnModel().getColumn(0).setPreferredWidth(45);
									table.getColumnModel().getColumn(1).setPreferredWidth(170);
									table.getColumnModel().getColumn(2).setPreferredWidth(40);
									table.getColumnModel().getColumn(3).setPreferredWidth(30);
									table.getColumnModel().getColumn(4).setPreferredWidth(90);

									// ���� ���ý�
									table.addMouseListener(new MouseAdapter() {
										public void mousePressed(MouseEvent e) {

											// ���콺 Ŭ���� ���� �ε��� ��
											int idx = table.getSelectedRow();

											// ���̺�.getValueAt(���� �ε��� , �÷��� �ε���)
											Id = table.getValueAt(idx, 0) + "";
											Name = table.getValueAt(idx, 1) + "";
											Professor = table.getValueAt(idx, 2) + "";
											Credit = table.getValueAt(idx, 3) + "";
											Time = table.getValueAt(idx, 4) + "";

										}
									});

								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						});
					}
				});
			}
		});

		// �̸���� ��ư�׼�
		gobasketBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {

				VBasket vBasket = new VBasket();
				vBasket.setId(Id);
				vBasket.setName(Name);
				vBasket.setProfessor(Professor);
				vBasket.setCredit(Credit);
				vBasket.setTime(Time);

				JOptionPane.showMessageDialog(null, "'" + vBasket.getName() + "' ���°� å���濡 �����ϴ�!");
				SBasket sBasket = new SBasket();
				sBasket.write(vBasket, personalData);

				Vector<VBasket> VBaskets = sBasket.read(personalData, Id);

				scoll1.setBounds(506, 151, 448, 204);
				scoll1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				panelSugang.add(scoll1);

				model1.getDataVector().removeAllElements();

				for (VBasket vBasket1 : VBaskets) {
					Vector<String> info = new Vector<String>();

					info.add(vBasket1.getId());
					info.add(vBasket1.getName());
					info.add(vBasket1.getProfessor());
					info.add(vBasket1.getCredit());
					info.add(vBasket1.getTime());

					model1.addRow(info);
					btable.setModel(model1);
				}

				btable.getColumnModel().getColumn(0).setPreferredWidth(45);
				btable.getColumnModel().getColumn(1).setPreferredWidth(170);
				btable.getColumnModel().getColumn(2).setPreferredWidth(40);
				btable.getColumnModel().getColumn(3).setPreferredWidth(30);
				btable.getColumnModel().getColumn(4).setPreferredWidth(90);

			}
		});

		// ������û ���̺� �׼�
		btable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				// ���콺 Ŭ���� ���� �ε��� ��
				int idx = btable.getSelectedRow();

				// ���̺�.getValueAt(���� �ε��� , �÷��� �ε���)
				Id1 = btable.getValueAt(idx, 0) + "";
				Name1 = btable.getValueAt(idx, 1) + "";
				Professor1 = btable.getValueAt(idx, 2) + "";
				Credit1 = btable.getValueAt(idx, 3) + "";
				Time1 = btable.getValueAt(idx, 4) + "";

			}
		});

		// ������û ��ư �׼�
		sugangBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {

				VSugangsincheong vSugangsincheong = new VSugangsincheong();
				vSugangsincheong.setId(Id1);
				vSugangsincheong.setName(Name1);
				vSugangsincheong.setProfessor(Professor1);
				vSugangsincheong.setCredit(Credit1);
				vSugangsincheong.setTime(Time1);

				JOptionPane.showMessageDialog(null, "'" + vSugangsincheong.getName() + "' ���°� å���濡 �����ϴ�!");
				SSugangsincheong sSugangsincheong = new SSugangsincheong();
				sSugangsincheong.write(vSugangsincheong, personalData);

				Vector<VSugangsincheong> VSugangsincheongs = sSugangsincheong.read(personalData);

				scoll2.setBounds(509, 411, 445, 214);
				scoll2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				panelSugang.add(scoll2);

				model2.getDataVector().removeAllElements();
				for (VSugangsincheong vSugangsincheong1 : VSugangsincheongs) {
					Vector<Object> info2 = new Vector<Object>();

					info2.add(vSugangsincheong1.getId());
					info2.add(vSugangsincheong1.getName());
					info2.add(vSugangsincheong1.getProfessor());
					info2.add(vSugangsincheong1.getCredit());
					info2.add(vSugangsincheong1.getTime());

					model2.addRow(info2);
					stable.setModel(model2);

				}
				stable.getColumnModel().getColumn(0).setPreferredWidth(45);
				stable.getColumnModel().getColumn(1).setPreferredWidth(170);
				stable.getColumnModel().getColumn(2).setPreferredWidth(40);
				stable.getColumnModel().getColumn(3).setPreferredWidth(30);
				stable.getColumnModel().getColumn(4).setPreferredWidth(90);

				// ���� Ȯ�� �׼�
				Vector<Integer> credits = new Vector<Integer>();
				numcheBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						for (VSugangsincheong vSugangsincheong1 : VSugangsincheongs) {

							if (vSugangsincheong1.getCredit().equals("2")) {
								credits.add(2);
							} else if (vSugangsincheong1.getCredit().equals("3")) {
								credits.add(3);
							} else if (vSugangsincheong1.getCredit().equals("4")) {
								credits.add(4);
							}
						}

						for (int m = 0; m < credits.size(); m++) {
							finaltotal += credits.get(m);
						}

						JOptionPane.showMessageDialog(null, "���� ������ " + finaltotal + "�Դϴ�");
						numcheBtn.setEnabled(false);
					}
				});

			}
		});
		// å���� �ȿ��ִ� �� ���� �����ϱ�
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btable.getSelectedRow() == -1) {
					return;
				} else {
					model1.removeRow(btable.getSelectedRow());
				}
				btable.setVisible(false);
				btable.setVisible(true);
				SBasket sBasket = new SBasket();
				sBasket.basketDelete(personalData);

				int t = 0;

				// btable�� �ε��� ��ü ũ��
				t = btable.getRowCount();

				for (int h = 0; h < t; h++) {
					VBasket vBasket = new VBasket();
					vBasket.setId(btable.getValueAt(h, 0) + "");
					vBasket.setName(btable.getValueAt(h, 1) + "");
					vBasket.setProfessor(btable.getValueAt(h, 2) + "");
					vBasket.setCredit(btable.getValueAt(h, 3) + "");
					vBasket.setTime(btable.getValueAt(h, 4) + "");

					sBasket.write(vBasket, personalData);
				}
			}
		});

		// ������û �ȿ��ִ� ���� �����ϱ�
		sugangdelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stable.getSelectedRow() == -1) {
					return;
				} else {
					model2.removeRow(stable.getSelectedRow());
				}
				stable.setVisible(false);
				stable.setVisible(true);
				SSugangsincheong sSugangsincheong = new SSugangsincheong();
				sSugangsincheong.basketDelete(personalData);

				int t = 0;

				// btable�� �ε��� ��ü ũ��
				t = stable.getRowCount();

				for (int h = 0; h < t; h++) {
					VSugangsincheong vSugangsincheong = new VSugangsincheong();
					vSugangsincheong.setId(stable.getValueAt(h, 0) + "");
					vSugangsincheong.setName(stable.getValueAt(h, 1) + "");
					vSugangsincheong.setProfessor(stable.getValueAt(h, 2) + "");
					vSugangsincheong.setCredit(stable.getValueAt(h, 3) + "");
					vSugangsincheong.setTime(stable.getValueAt(h, 4) + "");

					sSugangsincheong.write(vSugangsincheong, personalData);
				}

			}
		});
	}

}