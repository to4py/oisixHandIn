import java.util.ArrayList;
import java.io.*;

/**
 * [�]�ƈ����\���N���X]
 * 
 * @author yukitoyoshima
 *
 */
public class DisplayEmployeeInfo{
 public static void main(String[] args) throws IOException{
 	
	 //�]�ƈ����i�[�t�@�C�����̕\���Ɖ��Ԗڂ̃t�@�C�����e��\�����邩�ݒ�
 	String dispListNum = inputDispNum();
 	
 	//�t�@�C���̓Ǎ�
 	Reader reader = new FileReader("Employee_" + dispListNum + ".txt");
 	BufferedReader br = new BufferedReader(reader);
 	
 	String strData = null;
 	Employee employee = new Employee();
 	ArrayList<Employee> employeeList = new ArrayList<Employee>();
 	
 	//�폜�t���O��1�̏ꍇ�A�����I��
 	try{
 		
 	//�ǂݍ��񂾃t�@�C���̃f�[�^����s�ڂ��珇��strData�ɐݒ�
 	//�ǂݍ��ރf�[�^�������Ȃ�܂Ń��[�v
 	while((strData = br.readLine()) != null){
 		
 		//�f�[�^�̒��́u�F�v�̃C���f�b�N�X���擾
 		int findIndex = strData.indexOf("�F");
 		
 		if(strData.equals("")){
 			employeeList.add(employee);
 			employee = new Employee();
 		}else if(strData.substring(0, findIndex).equals("��")){
 			employee.setFamilyName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("��")){
 			employee.setGivenName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�J�^�J�i��")){
 			employee.setKanaFamilyName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�J�^�J�i��")){
 			employee.setKanaGivenName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�N��")){
 			employee.setAge(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("����")){
 			employee.setGender(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("���N����")){
 			employee.setBirthDate(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�d�b�ԍ�")){
 			employee.setTellNum(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�Z��")){
 			employee.setAddress(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("������")){
 			employee.setWorkDepartment(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�_��`�ԃR�[�h")){ 			
 			if((strData.substring(findIndex + 1)).equals("0")){
 				employee.setCodeOfContract("���Ј�");
 			}else if((strData.substring(findIndex + 1)).equals("1")){
 				employee.setCodeOfContract("�_��Ј�");
 			}
 		}else if(strData.substring(0, findIndex).equals("���ДN�x")){
 			employee.setCompanyEntryYear(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("���l")){
 			employee.setOtherInfo(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("E-Mail�A�h���X")){
 			employee.setEMail(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�o���N��")){
 			employee.setPastWorkYear(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�Ŋ��w")){
 			employee.setNearestStation(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�폜�t���O")){
 			deletedCheck(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("�o�^��")){
 			employee.setEntryDate(strData.substring(findIndex + 1));
	 	}
 	}
 	br.close();
	 	
	System.out.println("�y" + dispListNum + "�l�ځz");
	
	String[] strField = {"���O�F","�J�i�F","�N��F","���ʁF","���N�����F","�d�b�ԍ��F","�Z���F","�������F","�_��`�ԁF","���ДN�x�F","���l�F","E-mail�F","�o���N���F","�Ŋ�w�F","�o�^���F"};
 	
	for(int i = 0 ;  i < employeeList.size() ; i++){
	
		System.out.println(strField[0] + employeeList.get(i).getFamilyName() + employeeList.get(i).getGivenName());
		System.out.println(strField[1] + employeeList.get(i).getKanaFamilyName() + employeeList.get(i).getKanaGivenName());
		System.out.println(strField[2] + employeeList.get(i).getAge() + "��");
		System.out.println(strField[3] + employeeList.get(i).getGender());
		System.out.println(strField[4] + employeeList.get(i).getBirthDate());
		System.out.println(strField[5] + employeeList.get(i).getTellNum());
		System.out.println(strField[6] + employeeList.get(i).getAddress());
		System.out.println(strField[7] + employeeList.get(i).getWorkDepartment());
		System.out.println(strField[8] + employeeList.get(i).getCodeOfContract());
		System.out.println(strField[9] + employeeList.get(i).getCompanyEntryYear());
		System.out.println(strField[10] + employeeList.get(i).getOtherInfo());
		System.out.println(strField[11] + employeeList.get(i).getEMail());
		System.out.println(strField[12] + employeeList.get(i).getPastWorkYear());
		System.out.println(strField[13] + employeeList.get(i).getNearestStation());
		System.out.println(strField[14] + employeeList.get(i).getEntryDate());
		
	}
	
	//�폜�t���O���P�̏ꍇ�A��O����
 	}catch(DeletedException e){
 	}
 	
 }
	
	
	/**
	 * [�����͗�O�N���X]
	 * 
	 * @author yukitoyoshima
	 *
	 */
	static class EmptyException extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
	
	/**
	 * [�폜�ςݏ]�ƈ�������O�N���X]
	 * 
	 * @author yukitoyoshima
	 *
	 */
	static class DeletedException extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = -5347322632196093998L;
	}
	
	/**
	 * [�����̓`�F�b�N���\�b�h]
	 * 
	 * ���͂̒l�������ꍇ�A��O�𓊂���
	 * @param strCheck
	 */
	public static void emptyCheck(String strCheck) throws IOException{
		if(strCheck.length() == 0){
			System.out.println("�������͂���Ă��܂���B");
			throw new EmptyException();
		}
	}
	
	/**
	 * [�폜�t���O�`�F�b�N���\�b�h]
	 * 
	 * �폜�t���O�������Ă��邩�`�F�b�N���s���B
	 * 
	 * �P�C�폜�t���O���P�̏ꍇ�A�폜�Ƃ݂Ȃ���O�𓊂���
	 * @param strCheck
	 */
	public static void deletedCheck(String strCheck){
		if(strCheck.equals("1")){
			System.out.println("�w�肳�ꂽ�f�[�^�͍폜����Ă��܂��B");
			throw new DeletedException();
		}
	}
	
	/**
	 * [Filefilter�N���X]
	 * 
	 * �t�@�C�������uEmployee_�v�Ŏn�܂�A���u.txt�v��
	 * �ŏI���t�@�C���������o
	 * 
	 * @author yukitoyoshima
	 *
	 */
	static class Filefilter implements FilenameFilter{
		public boolean accept(File dir, String name){
			if(name.startsWith("Employee_") && name.endsWith(".txt")){
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * [�\���t�@�C���ԍ����̓��\�b�h]
	 * 
	 * �P�C�t�@�C�������uEmployee_�v�Ŏn�܂�A���u.txt�v�ŏI���t�@�C���������o
	 * �Q�C�t�@�C�����̕\��
	 * �R�C���e��\������t�@�C���̎w��
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String inputDispNum() throws IOException{
		BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));
		
		//�w�肳�ꂽ�t�@�C���i�[�ꏊ����t�@�C���̓ǂݍ���
		//�t�@�C�������uEmployee_�v�Ŏn�܂�A���u.txt�v�ŏI���t�@�C���������o
	 	File file = new File("xxxxxxxxxxxxxxxxxxxxxxxxxx");
	 	File[] fileArray = file.listFiles(new Filefilter());
		
	 	System.out.println(fileArray.length + "�l�̃f�[�^���o�^����Ă��܂��B");
		
		String listNum = null;
		
		boolean notEmptyList = false;
		
		//���͗L��A�����l�ɕϊ��o����܂ŁA���[�v����
		while(!notEmptyList){
		 	System.out.print("���l�ڂ̃f�[�^��\�����܂����H�F");
			try{
		 		listNum = bufferedR.readLine();
		 		
		 		//���͂������ꍇ�A��O����
				emptyCheck(listNum);
				
				//�����񂩂琔�l�ɕϊ��o���Ȃ��ꍇ�A��O����
				int intListNum = Integer.parseInt(listNum);
				
				//���͂��L��A�����l�ɕϊ��o����ꍇ�A���[�v�����I��
				notEmptyList = true;
			}catch(EmptyException e){
			}catch(NumberFormatException e){
				System.out.print("���l�œ��͂��ĉ������B");
			}
		}
		System.out.println("");
		return listNum;
	}
}
