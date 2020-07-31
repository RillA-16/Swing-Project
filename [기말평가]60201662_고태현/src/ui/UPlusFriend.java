package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.SPlusfriend;
import valueObject.VFriend;
import valueObject.VPersonalInfo;

public class UPlusFriend extends JFrame {

	public void pulsFriend(String PersonalData) {

		setTitle("ģ�� �߰�");
		this.setSize(400, 200); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����

		JPanel panelplusFri = new JPanel();
		panelplusFri.setBackground(Color.white);
		setContentPane(panelplusFri);
		panelplusFri.setLayout(null);

		JLabel labeltext2 = new JLabel("ģ���� ���̵� �Է����ּ���");
		JLabel labelid = new JLabel("���̵� : ");
		JTextField textid = new JTextField(10);

		panelplusFri.add(labeltext2);
		labeltext2.setBounds(77, 15, 160, 24);

		panelplusFri.add(labelid);
		labelid.setBounds(77, 47, 47, 24);

		panelplusFri.add(textid);
		textid.setBounds(135, 49, 132, 24);

		JButton plusBtn = new JButton("ģ�� �߰�");
		panelplusFri.add(plusBtn);
		plusBtn.setBounds(177, 93, 97, 23);
		
		JButton backBtn = new JButton("�ڷΰ���");
		panelplusFri.add(backBtn);
		backBtn.setBounds(77, 93, 97, 23);
		
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UFriend uFriend = new UFriend();
				uFriend.ufriend(PersonalData, vPersonalInfo);
				uFriend.setVisible(true);
			}
		});
		
		// ģ���߰� �׼�
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					VPersonalInfo vPersonalInfo = new VPersonalInfo();
					VFriend vFriend = new VFriend();

					vPersonalInfo.plusfriend = textid.getText();
					vFriend.setFriendName(textid.getText());

					SPlusfriend sPlusfriend = new SPlusfriend();
					vPersonalInfo = sPlusfriend.plusfriend(vFriend, vPersonalInfo);

					if (vPersonalInfo == null) {
						JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
					
					} else {
						// ���⼭ ���� ������ S WRITE���ؼ� M�� �����ϰ�
						// ��ĳ�ʷ� �о ���ͷ� �����ͼ� ����Ʈ�� �ִ´�(�������� ���� �Ѱ��ֱ�)
						// ���⼭ ���Ϳ� �������� ���� ���п��� �ֱ�
						// �׷��� ����Ʈ ���ý� �װ��� ���� ID�� ������û �������� ã�Ƽ�
						// ���̺� ���
						sPlusfriend.write(vFriend, PersonalData);
						JOptionPane.showMessageDialog(null, "ģ���� ��ϵǾ����ϴ�.");

						dispose();
						UFriend uFriend = new UFriend();
						uFriend.ufriend(PersonalData, vPersonalInfo);
						uFriend.setVisible(true);

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
