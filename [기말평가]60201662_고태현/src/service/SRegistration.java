package service;

import model.MPersonalInfo;
import valueObject.VPersonalInfo;

// �������� �Է� ����
public class SRegistration {
	public void write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		mPersonalInfo.write(vPersonalInfo);
	}
}
