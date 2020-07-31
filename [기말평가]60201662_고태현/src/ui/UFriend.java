package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import service.SPlusfriend;
import valueObject.VBasket;
import valueObject.VFriend;
import valueObject.VPersonalInfo;
import valueObject.VSugangsincheong;

public class UFriend extends JFrame {

	public void ufriend(String PersonalData, VPersonalInfo vPersonalInfo) {

		setTitle("������ ������û ���α׷� : ģ ��");
		this.setSize(900, 600); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����

		JPanel panelFriend = new JPanel();
		panelFriend.setBackground(Color.white);
		setContentPane(panelFriend);
		panelFriend.setLayout(null);

		JButton plusfriendBtn = new JButton("ģ�� �߰�");
		panelFriend.add(plusfriendBtn);
		plusfriendBtn.setBounds(34, 109, 97, 23);

		JLabel friendlisLa = new JLabel("ģ�� ���");
		panelFriend.add(friendlisLa);
		friendlisLa.setBounds(34, 142, 82, 21);

		JLabel txtLabel = new JLabel("000�� ���� ��û");
		panelFriend.add(txtLabel);
		txtLabel.setBounds(277, 88, 113, 23);

		JButton backBtn = new JButton("�ڷΰ���");
		panelFriend.add(backBtn);
		backBtn.setBounds(753, 531, 97, 23);

		// �ڵ��ư��� ��ư �׼�
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Usugang usugang = new Usugang();
				usugang.Psugangsincheong(PersonalData, vPersonalInfo);
				usugang.setVisible(true);
			}
		});

		JList friendList = new JList();
		panelFriend.add(friendList);
		friendList.setBounds(34, 173, 163, 271);
		friendList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		Vector<String> m = new Vector<String>();
		m.addElement("���� ��ȣ");
		m.addElement("���Ǹ�");
		m.addElement("����");
		m.addElement("����");
		m.addElement("�ð�");

		JTable friendtable = new JTable();
		panelFriend.add(friendtable);
		JScrollPane scoll = new JScrollPane(friendtable);
		scoll.setBounds(277, 113, 573, 408);
		scoll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		friendtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelFriend.add(scoll);

		DefaultTableModel model1 = new DefaultTableModel(m, 0) { // (������, // ������)
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// ģ���߰� ��ư �׼�
		plusfriendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UPlusFriend uPlusFriend = new UPlusFriend();
				uPlusFriend.pulsFriend(PersonalData);
				uPlusFriend.setVisible(true);
			}
		});

		try {
			
			SPlusfriend sPlusfriend = new SPlusfriend();
			Vector<VFriend> friends = sPlusfriend.read(PersonalData);

			Vector<Object> fri = new Vector<Object>();
			for (VFriend vFriend : friends) {
				fri.add(vFriend.getFriendName());
			}
			friendList.setListData(fri);

			// ģ������Ʈ���� ���̵� ������ ��
			friendList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					try {
						String friendData1 = (String) friendList.getSelectedValue();
						
						SPlusfriend sPlusfriend = new SPlusfriend();
						Vector<VFriend> friends = sPlusfriend.getFriend(friendData1);

						for (VFriend vFriend : friends) {
							Vector<String> friends1 = new Vector<String>();

							friends1.add(vFriend.getId());
							friends1.add(vFriend.getName());
							friends1.add(vFriend.getProfessor());
							friends1.add(vFriend.getCredit());
							friends1.add(vFriend.getTime());

							model1.addRow(friends1);
							friendtable.setModel(model1);
						}
						friendtable.getColumnModel().getColumn(0).setPreferredWidth(45);
						friendtable.getColumnModel().getColumn(1).setPreferredWidth(170);
						friendtable.getColumnModel().getColumn(2).setPreferredWidth(40);
						friendtable.getColumnModel().getColumn(3).setPreferredWidth(30);
						friendtable.getColumnModel().getColumn(4).setPreferredWidth(90);

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
