package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.SLogin;
import valueObject.VLogin;
import valueObject.VPersonalInfo;

public class ULogin extends JFrame {

	public void ULogin() {

		JFrame frame = new JFrame();
		this.setVisible(true); // ȭ�鿡 �׻� ���
		setTitle("������ ������û ���α׷� : Login");
		setSize(600, 400); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ż �� ��

		JPanel panelLo = new JPanel();
		panelLo.setBackground(Color.white);
		// add(panelLo);

		setContentPane(panelLo);
		panelLo.setLayout(null);

		JLabel labelid = new JLabel("ID : ");
		JTextField textid = new JTextField(10);
		JLabel labelpw = new JLabel("PASSWORD : ");
		JPasswordField textpw = new JPasswordField(10);

		JLabel imagelabel = new JLabel(" "); // �̹��� ���̺�

		panelLo.add(labelid);
		labelid.setBounds(301, 102, 30, 28);

		panelLo.add(textid);
		textid.setBounds(336, 96, 154, 41);

		panelLo.add(labelpw);
		labelpw.setBounds(244, 153, 89, 28);

		panelLo.add(textpw);
		textpw.setBounds(336, 147, 154, 41);

		JButton logBtn = new JButton("�α���");
		panelLo.add(logBtn);
		logBtn.setBounds(235, 230, 127, 32);

		JButton registerPerBtn = new JButton("ȸ������");
		panelLo.add(registerPerBtn);
		registerPerBtn.setBounds(374, 230, 127, 32);

		JButton findidBtn = new JButton("���̵� ã��");
		panelLo.add(findidBtn);
		findidBtn.setBounds(235, 272, 127, 23);

		JButton findpwBtn = new JButton("�н����� ã��");
		panelLo.add(findpwBtn);
		findpwBtn.setBounds(374, 272, 127, 23);

		imagelabel.setIcon(new ImageIcon("loginimage.gif"));
		panelLo.add(imagelabel);
		imagelabel.setBounds(43, 53, 192, 194);

		// �α��� �׼�
		logBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				// �α��� ��ư ������ �� ���ϱ�

				VLogin vLogin = new VLogin();
				vLogin.ConfirmId = textid.getText();
				vLogin.ConfirmPassword = textpw.getText();

				if (vLogin.ConfirmId.equals("") || vLogin.ConfirmPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "�α��� ������ ��ĭ�� �ֽ��ϴ�.");
				} else {
					SLogin sLogin = new SLogin();
					VPersonalInfo vPersonalInfo;
					try {
						vPersonalInfo = sLogin.validate(vLogin);
						if (vPersonalInfo == null) {
							JOptionPane.showMessageDialog(null, "�α׾� ������ ��ġ���� �ʽ��ϴ�");
						} else {
							JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�! " + vPersonalInfo.name1 + "�� ȯ���մϴ�!");
							String PersonalData = vPersonalInfo.id1;

							Usugang usugang = new Usugang();
							usugang.Psugangsincheong(PersonalData, vPersonalInfo);
						
							UMyInfo uMyInfo = new UMyInfo();
							uMyInfo.umyinfo(vPersonalInfo);
							
							

							usugang.setVisible(true);
							dispose();

						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		// ȸ������ �׼�
		registerPerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ȸ������ ��ư ������ �� ȸ������
				Register register = new Register();
				register.Pregister();
				// frame.setVisible(false);
				register.setVisible(true);
				dispose();

			}
		});
		// ���̵� ã�� �׼�
		findidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find find = new Find();
				find.findid();
				find.setVisible(true);
			}
		});
		// �н����� ã�� �׼�
		findpwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find find1 = new Find();
				find1.findpw();
				find1.setVisible(true);
			}
		});
	}
}
