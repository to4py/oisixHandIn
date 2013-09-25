import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * [�]�ƈ����o�^�N���X]
 * 
 * �]�ƈ����̓o�^������B
 * 
 * @author yukitoyoshima
 * 
 */
public class SaveEmployeeInfo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * ���C�����\�b�h
	 * 
	 * 1�A�o�^�l���̐ݒ� �Q�C�]�ƈ������� 3�C�f�[�^���t�@�C���ɏ���
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// �o�^�l����ݒ�
		int inputPplNum = inputEntryPplNum();
		
		//�]�ƈ��i�[���X�g�̐���
		ArrayList<Employee> employeeList = new ArrayList<Employee>();

		//�w��l���̏]�ƈ��̏���ݒ�
		employeeList = setData(inputPplNum, employeeList);

		// �t�@�C���𐶐����A�]�ƈ����ƃ^�O�̏���
		writeData(employeeList);
	}

	/**
	 * �w�肳�ꂽ�o�^�l�����̃f�[�^����
	 * 
	 * �P�C��l���̃f�[�^����͂���B 
	 * �Q�CEmployee�^�I�u�W�F�N�g���i�[���郊�X�g�ɐݒ肷��B 
	 * �R�C1,2��l�����J�Ԃ��B
	 * 
	 * @param inputPplNum
	 * @param employeeList
	 * @returne employeeList�@�]�ƈ����i�[���X�g
	 * @throws IOException
	 */
	public static ArrayList<Employee> setData(int inputPplNum,
			ArrayList<Employee> employeeList) throws IOException {

		// �w�肳�ꂽ�o�^�l�����̃f�[�^����
		for (int i = 0; i < inputPplNum; i++) {

			// �]�ƈ��^�I�u�W�F�N�g�̐���
			Employee employee = new Employee();

			System.out.println("****" + (i + 1) + "�l��****");

			// ���̓���
			employee.setFamilyName(inputFamilyName());

			// ���̓���
			employee.setGivenName(inputGivenName());

			// �J�^�J�i���̓���
			employee.setKanaFamilyName(inputKanaFamilyName());

			// �J�^�J�i���̓���
			employee.setKanaGivenName(inputKanaGivenName());

			// �΂̓���
			employee.setAge(inputAge());

			// ���ʂ̓���
			employee.setGender(inputGender());

			// �a�����̓���
			employee.setBirthDate(inputBirthDate());

			// �d�b�ԍ��̓���
			employee.setTellNum(inputTellNum());

			// �Z���̓���
			employee.setAddress(inputAddress());

			// ����̓���
			employee.setWorkDepartment(inputWorkDepartment());

			// �_��R�[�h�̓���
			employee.setCodeOfContract(inputCOC());

			// ���ДN�x�̓���
			employee.setCompanyEntryYear(inputEntryYear());

			// ���l�̓���
			employee.setOtherInfo(inputOtherInfo());

			// Email�A�h���X�̓���
			employee.setEMail(inputEmail());

			// �o���N���̓���
			employee.setPastWorkYear(inputPastWorkYear());

			// �Ŋ�w�̓���
			employee.setNearestStation(inputNearestStation());

			// �폜�t���O�̓���
			employee.setIsDelete(inputIsDelete());

			// �o�^���̐ݒ�
			employee.setEntryDate(inputEntryDate());

			// ���X�g�ɐݒ�
			employeeList.add(employee);
		}

		return employeeList;

	}

	/**
	 * [�f�[�^�������\�b�h]
	 * 
	 * �P�C��l���̃f�[�^���������ރt�@�C���̐��� �Q�C��l���̃f�[�^�����ꂼ��̃^�O�Ƌ��ɏ��� �R�C�l�����P�C�Q�̌J�Ԃ�
	 * 
	 * @param employeeData
	 * @throws IOException
	 */
	public static void writeData(ArrayList<Employee> employeeList)
			throws IOException {
		
		//�^�O�̐���
		String[] strField = { "���F", "���F", "�J�^�J�i���F", "�J�^�J�i���F", "�N��F", "���ʁF",
				"���N�����F", "�d�b�ԍ��F", "�Z���F", "�������F", "�_��`�ԃR�[�h�F", "���ДN�x�F", "���l�F",
				"E-Mail�A�h���X�F", "�o���N���F", "�Ŋ��w�F", "�폜�t���O�F", "�o�^���F" };
		
		//�w��l�����̏�������
		for (int i = 0; i < employeeList.size(); i++) {

			// ��l���̃f�[�^���������ރt�@�C���̐���
			Writer writer = new FileWriter("Employee_" + (i + 1) + ".txt");
			BufferedWriter bw = new BufferedWriter(writer);
			
			// ��������
			bw.write(strField[0] + employeeList.get(i).getFamilyName());
			bw.newLine();
			bw.write(strField[1] + employeeList.get(i).getGivenName());
			bw.newLine();
			bw.write(strField[2] + employeeList.get(i).getKanaFamilyName());
			bw.newLine();
			bw.write(strField[3] + employeeList.get(i).getKanaGivenName());
			bw.newLine();
			bw.write(strField[4] + employeeList.get(i).getAge());
			bw.newLine();
			bw.write(strField[5] + employeeList.get(i).getGender());
			bw.newLine();
			bw.write(strField[6] + employeeList.get(i).getBirthDate());
			bw.newLine();
			bw.write(strField[7] + employeeList.get(i).getTellNum());
			bw.newLine();
			bw.write(strField[8] + employeeList.get(i).getAddress());
			bw.newLine();
			bw.write(strField[9] + employeeList.get(i).getWorkDepartment());
			bw.newLine();
			bw.write(strField[10] + employeeList.get(i).getCodeOfContract());
			bw.newLine();
			bw.write(strField[11] + employeeList.get(i).getCompanyEntryYear());
			bw.newLine();
			bw.write(strField[12] + employeeList.get(i).getOtherInfo());
			bw.newLine();
			bw.write(strField[13] + employeeList.get(i).getEMail());
			bw.newLine();
			bw.write(strField[14] + employeeList.get(i).getPastWorkYear());
			bw.newLine();
			bw.write(strField[15] + employeeList.get(i).getNearestStation());
			bw.newLine();
			bw.write(strField[16] + employeeList.get(i).getIsDelete());
			bw.newLine();
			bw.write(strField[17] + employeeList.get(i).getEntryDate());
			bw.newLine();
			
			bw.write("");
			bw.newLine();

			bw.close();
			writer.close();

		}

	}

	static class EmptyException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}

	/**
	 * [�����̓`�F�b�J�[]
	 * 
	 * ���͓��e��������ԂŎ��̍��ڂ̓��͂Ɉڂ낤�Ƃ���ƁA ��O�𓊂���B
	 * 
	 * @param strInput
	 */
	public static void isEmptyException(String strInput) {
		if (strInput.length() == 0 || strInput == null) {
			System.out.print("�������͂���Ă��܂���B");
			throw new EmptyException();
		}
	}

	/**
	 * [�o�^�l�����̓��\�b�h]
	 * 
	 * �o�^�l���̓��͂����郁�\�b�h
	 * 
	 * @return inputPplNum�@�o�^�l��
	 * @throws IOException
	 */
	public static int inputEntryPplNum() throws IOException {

		// ���͐l��
		int inputPplNum = 0;

		// ���͊����t���O
		boolean isInputComplete = false;

		// ���͗L��A�����͓��e�����l�ɂȂ�܂ŁA���[�v����
		while (!isInputComplete) {
			try {
				System.out.print("�o�^�l������͂��ĉ������F");
				String strNum = br.readLine();

				// ���͂������̏ꍇ�A��O����
				isEmptyException(strNum);

				// ������𐔒l�ɕϊ�
				// �ϊ��o���Ȃ��ꍇ�A��O����
				inputPplNum = Integer.parseInt(strNum);

				// ���͗L��A�����͓��e�����l�̏ꍇ�A���[�v�����I��
				isInputComplete = true;

				// �o�^�l����ԋp
				return inputPplNum;

				// ���͖����̏ꍇ�A��O����
			} catch (EmptyException e) {

				// ���l�ϊ��o���Ȃ��ꍇ�A��O����
			} catch (NumberFormatException e) {
				System.out.print("���l��");
			}
		}
		System.out.println("");
		return inputPplNum;
	}

	/**
	 * [�����̓��\�b�h]
	 * 
	 * ���̓��͂����郁�\�b�h
	 * 
	 * @return familyName�@��
	 * @throws IOException
	 */
	public static String inputFamilyName() throws IOException {
		String familyName = null;

		boolean isInputComplete = false;

		// ���͓��e���L��܂ŁA���[�v����
		while (!isInputComplete) {
			try {
				System.out.print("������͂��ĉ������F");
				familyName = br.readLine();

				// ���͂������̏ꍇ�A��O����
				isEmptyException(familyName);
				isInputComplete = true;

				// ���͂������̏ꍇ�A��O����
			} catch (EmptyException e) {
			}
		}
		return familyName;
	}

	/**
	 * [�����̓��\�b�h]
	 * 
	 * @return givenName�@��
	 * @throws IOException
	 */
	public static String inputGivenName() throws IOException {
		String givenName = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("������͂��ĉ������F");
				givenName = br.readLine();
				isEmptyException(givenName);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return givenName;
	}

	/**
	 * [�J�^�J�i�����̓��\�b�h]
	 * 
	 * @return kanaFamilyName�@�J�^�J�i��
	 * @throws IOException
	 */
	public static String inputKanaFamilyName() throws IOException {
		String kanaFamilyName = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("�J�^�i�J������͂��ĉ������F");
				kanaFamilyName = br.readLine();
				isEmptyException(kanaFamilyName);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return kanaFamilyName;
	}

	/**
	 * [�J�^�J�i�����̓��\�b�h]
	 * 
	 * @return inputKanaGivenName �J�^�J�i��
	 * @throws IOException
	 */
	public static String inputKanaGivenName() throws IOException {
		String inputKanaGivenName = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("�J�^�J�i������͂��ĉ������F");
				inputKanaGivenName = br.readLine();
				isEmptyException(inputKanaGivenName);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputKanaGivenName;
	}

	/**
	 * [�N����̓��\�b�h]
	 * 
	 * @return inputStrAge�@�N��
	 * @throws IOException
	 */
	public static String inputAge() throws IOException {
		String inputStrAge = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("�N�����͂��ĉ������F");
				inputStrAge = br.readLine();
				isEmptyException(inputStrAge);
				int inputAge = Integer.parseInt(inputStrAge);
				isInputComplete = true;
			} catch (NumberFormatException e) {
				System.out.print("���l��");
			} catch (EmptyException e) {
			}
		}
		return inputStrAge;
	}

	/**
	 * [���ʓ��̓��\�b�h]
	 * 
	 * @return inputGender�@����
	 * @throws IOException
	 */
	public static String inputGender() throws IOException {
		String inputGender = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("���ʂ���͂��ĉ������F");
				inputGender = br.readLine();
				isEmptyException(inputGender);

				if (inputGender.equals("�j") || inputGender.equals("��")) {
					isInputComplete = true;
				} else {
					System.out.print("�j������");
				}
			} catch (EmptyException e) {

			}
		}
		return inputGender;
	}

	/**
	 * [���N�������̓��\�b�h]
	 * 
	 * @return inputBirthDate�@���N����
	 * @throws IOException
	 */
	public static String inputBirthDate() throws IOException {
		String inputBirthDate = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("���N�����𐼗�œ��͂��ĉ������F");
			inputBirthDate = br.readLine();

			try {
				isEmptyException(inputBirthDate);
				int inputBDVal = Integer.parseInt(inputBirthDate);
				if (inputBirthDate.length() == 8) {
					isInputComplete = true;
				} else {
					System.out.print("8���̐�����");
				}
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.print("������");
			}
		}
		return inputBirthDate;
	}

	/**
	 * [�d�b�ԍ����̓��\�b�h]
	 * 
	 * @return inputTellNum�@�d�b�ԍ�
	 * @throws IOException
	 */
	public static String inputTellNum() throws IOException {
		String inputTellNum = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("�d�b�ԍ�����͂��ĉ������F");
			inputTellNum = br.readLine();
			try {
				isEmptyException(inputTellNum);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputTellNum;
	}

	/**
	 * [�Z�����̓��\�b�h]
	 * 
	 * @return inputAddress�@�Z��
	 * @throws IOException
	 */
	public static String inputAddress() throws IOException {
		String inputAddress = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("�Z������͂��ĉ������F");
			inputAddress = br.readLine();
			try {
				isEmptyException(inputAddress);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputAddress;
	}

	/**
	 * [���������̓��\�b�h]
	 * 
	 * @return inputWorkDepartment�@����
	 * @throws IOException
	 */
	public static String inputWorkDepartment() throws IOException {
		String inputWorkDepartment = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("����������͂��ĉ������F");
			inputWorkDepartment = br.readLine();
			try {
				isEmptyException(inputWorkDepartment);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputWorkDepartment;
	}

	/**
	 * [�_��`�ԓ��̓��\�b�h]
	 * 
	 * @return inputCodeOfContract�@�_��`�ԃR�[�h
	 * @throws IOException
	 */
	public static String inputCOC() throws IOException {
		String inputCodeOfContract = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("�_��`�ԃR�[�h(0:���Ј� 1:�_��Ј�)����͂��ĉ������F");
			inputCodeOfContract = br.readLine();
			try {
				isEmptyException(inputCodeOfContract);
				int intCOC = Integer.parseInt(inputCodeOfContract);
				if (intCOC == 0 || intCOC == 1) {
					isInputComplete = true;
				} else {
					System.out.print("(0:���Ј� 1:�_��Ј�)�̌`����");
				}
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.println("���l�œ��͂��ĉ������B");
			}
		}
		return inputCodeOfContract;
	}

	/**
	 * [���ДN�x���̓��\�b�h]
	 * 
	 * @return inputEntryYear�@���ДN�x(YYYY/MM)
	 * @throws IOException
	 */
	public static String inputEntryYear() throws IOException {
		String inputEntryYear = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("���ДN�x(YYYY/MM)����͂��ĉ������F");
			inputEntryYear = br.readLine();
			try {
				// ���͂������ꍇ�A��O����
				isEmptyException(inputEntryYear);

				String[] strSplit = inputEntryYear.split("/");
				int intEY1 = Integer.parseInt(strSplit[0]);
				int intEY2 = Integer.parseInt(strSplit[1]);

				// �u/�v�ŕ��������O�������̕����񐔂�4�̏ꍇ
				if (strSplit[0].length() == 4) {

					// �u/�v�ŕ��������㔼�����̕����񐔂�2�̏ꍇ
					if (strSplit[1].length() == 2) {

						// ���[�v�����I��
						isInputComplete = true;
					}
				} else {
					System.out.print("(YYYY/MM)�̌`����");
				}
			} catch (EmptyException e) {
			} catch (Exception e) {
				System.out.print("(YYYY/MM)�̌`����");
			}
		}
		return inputEntryYear;
	}

	/**
	 * [���l���̓��\�b�h]
	 * 
	 * @return inputOtherInfo�@���l
	 * @throws IOException
	 */
	public static String inputOtherInfo() throws IOException {
		String inputOtherInfo = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("���l����͂��ĉ������F");
			inputOtherInfo = br.readLine();
			try {
				isEmptyException(inputOtherInfo);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputOtherInfo;
	}

	/**
	 * [E-Mail�A�h���X���̓��\�b�h]
	 * 
	 * @return inputEmail�@E-mail�A�h���X
	 * @throws IOException
	 */
	public static String inputEmail() throws IOException {
		String inputEmail = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("E-mail�A�h���X����͂��ĉ������F");
			inputEmail = br.readLine();
			try {
				isEmptyException(inputEmail);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputEmail;
	}

	/**
	 * [�o���N�����̓��\�b�h]
	 * 
	 * @return inputPastWorkYear�@�o���N��
	 * @throws IOException
	 */
	public static String inputPastWorkYear() throws IOException {
		String inputPastWorkYear = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("�o���N������͂��ĉ������F");
			inputPastWorkYear = br.readLine();
			try {
				isEmptyException(inputPastWorkYear);
				int intPWY = Integer.parseInt(inputPastWorkYear);
				isInputComplete = true;
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.print("���l��");
			}
		}
		return inputPastWorkYear;
	}

	/**
	 * [�Ŋ��w���̓��\�b�h]
	 * 
	 * @return inputNearestStation�@�Ŋ��w
	 * @throws IOException
	 */
	public static String inputNearestStation() throws IOException {
		String inputNearestStation = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("�Ŋ��w����͂��ĉ������F");
			inputNearestStation = br.readLine();
			try {
				isEmptyException(inputNearestStation);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputNearestStation;
	}

	/**
	 * [�폜�t���O���̓��\�b�h]
	 * 
	 * @return isDelete�@�폜�t���O
	 * @throws IOException
	 */
	public static String inputIsDelete() throws IOException {
		String isDelete = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("�폜�t���O�i0:���폜 1:�폜�j����͂��ĉ������F");
			isDelete = br.readLine();
			try {
				isEmptyException(isDelete);
				int intIsDelete = Integer.parseInt(isDelete);
				if (intIsDelete == 0 || intIsDelete == 1) {
					isInputComplete = true;
				} 
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.print("���l��");
			}
		}
		return isDelete;
	}

	/**
	 * [�o�^���̐ݒ胁�\�b�h]
	 * 
	 * @return year + month + date�@�o�^�N����
	 */
	public static String inputEntryDate() {
		Calendar calendar = Calendar.getInstance();

		// ���ݔN�̎擾
		String year = Integer.toString(calendar.get(Calendar.YEAR));

		// ���݌��̎擾
		String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);

		// ���ݓ��̎擾
		String date = Integer.toString(calendar.get(Calendar.DATE));

		// �\���`���̒���
		// ���������͓��̒l���ꌅ�ł����0����ꌅ�ɉ�����B
		if (month.length() == 1) {
			month = "0" + month;
		}
		if (date.length() == 1) {
			date = "0" + date;
		}

		System.out.println("");

		// �N������ԋp
		return year + month + date;
	}

}