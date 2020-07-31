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

import service.SFind;
import valueObject.VPersonalInfo;

@SuppressWarnings("serial")
public class Find extends JFrame {

	public void findid() {
		JFrame frame = new JFrame();
		setTitle("���̵� ã��");
		this.setSize(400, 200); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����

		JPanel panelfindid = new JPanel();
		panelfindid.setBackground(Color.white);
		setContentPane(panelfindid);
		panelfindid.setLayout(null);

		JLabel labeltext = new JLabel("�й��� �Է����ּ���");
		JLabel labelnum = new JLabel("�й� : ");
		JTextField textnum = new JTextField(10);

		panelfindid.add(labeltext);
		labeltext.setBounds(77, 15, 151, 24);

		panelfindid.add(labelnum);
		labelnum.setBounds(77, 47, 47, 24);

		panelfindid.add(textnum);
		textnum.setBounds(135, 49, 132, 24);

		JButton confirmBtn = new JButton("Ȯ ��");
		confirmBtn.setBounds(177, 93, 97, 23);
		panelfindid.add(confirmBtn);

		// Ȯ�� �������� �˾�â
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.findid = textnum.getText();

				try {
					SFind sFind = new SFind();
					vPersonalInfo = sFind.findid(vPersonalInfo);
					if (vPersonalInfo != null) {
						JOptionPane.showMessageDialog(null,
								vPersonalInfo.name1 + "���� ���̵�� " + "'" + vPersonalInfo.id1 + "'" + "�Դϴ�");
					} else {
						JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Find find = new Find();
				find.findid();
				dispose();
			}
		});

	}

	public void findpw() {

		JFrame frame1 = new JFrame();

		setTitle("�н����� ã��");
		this.setSize(400, 200); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����

		JPanel panelfindpw = new JPanel();
		panelfindpw.setBackground(Color.white);
		setContentPane(panelfindpw);
		panelfindpw.setLayout(null);

		JLabel labeltext2 = new JLabel("���̵� �Է����ּ���");
		JLabel labelid = new JLabel("���̵� : ");
		JTextField textid = new JTextField(10);

		panelfindpw.add(labeltext2);
		labeltext2.setBounds(77, 15, 151, 24);

		panelfindpw.add(labelid);
		labelid.setBounds(77, 47, 47, 24);

		panelfindpw.add(textid);
		textid.setBounds(135, 49, 132, 24);

		JButton confirmBtn = new JButton("Ȯ ��");
		confirmBtn.setBounds(177, 93, 97, 23);
		panelfindpw.add(confirmBtn);

		// Ȯ�� �������� �˾�â
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.findpw = textid.getText();

				try {
					SFind sFind = new SFind();
					vPersonalInfo = sFind.findpw(vPersonalInfo);
					if (vPersonalInfo != null) {
						JOptionPane.showMessageDialog(null,
								vPersonalInfo.name1 + "���� �н������ " + "'" + vPersonalInfo.password1 + "'" + "�Դϴ�");
					} else {
						JOptionPane.showMessageDialog(null, "�������� �ʴ� �н������Դϴ�.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Find find = new Find();
				find.findpw();
				dispose();
			}
		});
	}
}
