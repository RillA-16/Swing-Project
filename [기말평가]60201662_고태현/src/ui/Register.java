package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import service.SCompare;
import service.SRegistration;
import valueObject.VPersonalInfo;

public class Register extends JFrame {

	boolean click = true;

	@SuppressWarnings("deprecation")
	public void Pregister() {

		JFrame frame = new JFrame();
		setTitle("������ ������û ���α׷� : Register");
		this.setSize(400, 500); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ż �� ��

		JPanel panelRegi = new JPanel();
		panelRegi.setBackground(Color.white);
		setContentPane(panelRegi);
		panelRegi.setLayout(null);

		JLabel labelid = new JLabel("ID : ");
		JTextField textid = new JTextField(10);
		JLabel labelpw = new JLabel("PASSWORD : ");
		JPasswordField textpw = new JPasswordField(10);
		JLabel pwchela = new JLabel("��й�ȣ Ȯ�� :");
		JPasswordField pwchetxt = new JPasswordField(10);
		JLabel labelname = new JLabel("�̸� : ");
		JTextField textname = new JTextField(10);
		JLabel labelnumber = new JLabel("�й� : ");
		JTextField textnumber = new JTextField(10);

		JLabel labelcampus = new JLabel("ķ�۽� ");
		JRadioButton yonginChe = new JRadioButton("���� ķ�۽�");
		yonginChe.setBackground(Color.white);
		JRadioButton seoulChe = new JRadioButton("���� ķ�۽�");
		seoulChe.setBackground(Color.white);

//		JLabel labelcollege = new JLabel("�ܰ��� ");
//		JLabel labelmajor = new JLabel("�а� ");

		panelRegi.add(labelid);
		labelid.setBounds(65, 99, 72, 28);

		panelRegi.add(textid);
		textid.setBounds(136, 103, 116, 21);

		panelRegi.add(labelpw);
		labelpw.setBounds(52, 148, 80, 20);

		panelRegi.add(textpw);
		textpw.setBounds(137, 145, 116, 21);

		panelRegi.add(labelname);
		labelname.setBounds(65, 239, 57, 15);

		panelRegi.add(textname);
		textname.setBounds(136, 236, 116, 21);

		panelRegi.add(labelnumber);
		labelnumber.setBounds(65, 281, 57, 15);

		panelRegi.add(textnumber);
		textnumber.setBounds(136, 278, 116, 21);

		panelRegi.add(labelcampus);
		labelcampus.setBounds(55, 331, 57, 15);

		panelRegi.add(pwchela);
		pwchela.setBounds(27, 194, 85, 15);

		panelRegi.add(pwchetxt);
		pwchetxt.setBounds(136, 191, 116, 21);

		// ������ư
		ButtonGroup group = new ButtonGroup();
		group.add(yonginChe);
		group.add(seoulChe);

		yonginChe.setSelected(true);

		yonginChe.setBounds(130, 327, 88, 23);
		panelRegi.add(yonginChe);

		seoulChe.setBounds(228, 327, 88, 23);
		panelRegi.add(seoulChe);

		JCheckBox personalInfocheck = new JCheckBox("�������� ���� ����");
		personalInfocheck.setBackground(Color.white);
		panelRegi.add(personalInfocheck);
		personalInfocheck.setBounds(136, 359, 129, 23);

		JButton compareBtn = new JButton("���̵� �ߺ�Ȯ��");
		panelRegi.add(compareBtn);
		compareBtn.setBounds(255, 102, 125, 23);

		JButton regiBtn = new JButton("ȸ�� ����");
		panelRegi.add(regiBtn);
		regiBtn.setBounds(228, 388, 97, 23);

		JButton comebackBtn = new JButton("�ڷ� ����");
		panelRegi.add(comebackBtn);
		comebackBtn.setBounds(118, 388, 97, 23);

		JLabel Regiimage = new JLabel("");
		Regiimage.setIcon(new ImageIcon("ȸ�������̹���.gif"));
		panelRegi.add(Regiimage);
		Regiimage.setBounds(12, 10, 362, 85);

		regiBtn.setEnabled(false);

		personalInfocheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkP = personalInfocheck.isSelected();
				regiBtn.setEnabled(checkP);
			}
		});

		// ���̵� �ߺ�Ȯ�� �׼�
		compareBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.compareid = textid.getText();

				try {
					SCompare sCompare = new SCompare();
					vPersonalInfo = sCompare.compare(vPersonalInfo);
					if (vPersonalInfo == null) {
						// ���̵� �԰���
						JOptionPane.showMessageDialog(null, "����� �� �ִ� ���̵��Դϴ�.");
						click = false;
						textid.setEnabled(false);
					} else {
						// ���̵� �ԺҰ��� �ߺ�
						JOptionPane.showMessageDialog(null, "������� ���̵��Դϴ�.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// �ٽ� �α��� �гη� ���ư��� ��ư
		comebackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ULogin uLogin = new ULogin();
				uLogin.ULogin();
			}
		});

		// ȸ������ �׼�
		regiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.id1 = textid.getText();
				vPersonalInfo.password1 = textpw.getText();
				vPersonalInfo.name1 = textname.getText();
				vPersonalInfo.number = textnumber.getText();

//				vPersonalInfo.yonginBtn = yonginChe.isSelected();
//				vPersonalInfo.seoulBtn = seoulChe.isSelected();

				String yongin, seoul;
				if (yonginChe.isSelected()) {
					yongin = "����ķ�۽�";
				} else {
					yongin = "���ξƴ�";
				}
				if (seoulChe.isSelected()) {
					seoul = "����ķ�۽�";
				} else {
					seoul = "����ƴ�";
				}
				vPersonalInfo.yonginBtn = yongin;
				vPersonalInfo.seoulBtn = seoul;

				if (vPersonalInfo.id1.equals("") || vPersonalInfo.password1.equals("") || vPersonalInfo.name1.equals("")
						|| vPersonalInfo.number.equals("") || pwchetxt.getText().equals("")) {
					// ȸ������ ������
					JOptionPane.showMessageDialog(null, "ȸ������ ������ ��ĭ�� �ֽ��ϴ�.");

				} else if (click) {
					// �ߺ�Ȯ�� �� ����
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�Ȯ���� �����ּ���");
				} else if (!pwchetxt.getText().equals(vPersonalInfo.password1)) {
					JOptionPane.showMessageDialog(null, "pw�� pwȮ�ΰ� ��ġ���� �ʽ��ϴ�");
				} else {
					// ȸ������ ����

					SRegistration sRegistration = new SRegistration();
					sRegistration.write(vPersonalInfo);
					JOptionPane.showMessageDialog(null, vPersonalInfo.name1 + "�� ȸ������ �Ǿ����ϴ�");
					dispose();

					ULogin uLogin = new ULogin();
					uLogin.ULogin();
				}
			}
		});
	}
}
