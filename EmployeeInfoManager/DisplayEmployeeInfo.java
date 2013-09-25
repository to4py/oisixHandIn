import java.util.ArrayList;
import java.io.*;

/**
 * [従業員情報表示クラス]
 * 
 * @author yukitoyoshima
 *
 */
public class DisplayEmployeeInfo{
 public static void main(String[] args) throws IOException{
 	
	 //従業員情報格納ファイル数の表示と何番目のファイル内容を表示するか設定
 	String dispListNum = inputDispNum();
 	
 	//ファイルの読込
 	Reader reader = new FileReader("Employee_" + dispListNum + ".txt");
 	BufferedReader br = new BufferedReader(reader);
 	
 	String strData = null;
 	Employee employee = new Employee();
 	ArrayList<Employee> employeeList = new ArrayList<Employee>();
 	
 	//削除フラグが1の場合、処理終了
 	try{
 		
 	//読み込んだファイルのデータを一行目から順にstrDataに設定
 	//読み込むデータが無くなるまでループ
 	while((strData = br.readLine()) != null){
 		
 		//データの中の「：」のインデックスを取得
 		int findIndex = strData.indexOf("：");
 		
 		if(strData.equals("")){
 			employeeList.add(employee);
 			employee = new Employee();
 		}else if(strData.substring(0, findIndex).equals("姓")){
 			employee.setFamilyName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("名")){
 			employee.setGivenName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("カタカナ姓")){
 			employee.setKanaFamilyName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("カタカナ名")){
 			employee.setKanaGivenName(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("年齢")){
 			employee.setAge(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("性別")){
 			employee.setGender(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("生年月日")){
 			employee.setBirthDate(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("電話番号")){
 			employee.setTellNum(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("住所")){
 			employee.setAddress(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("部署名")){
 			employee.setWorkDepartment(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("契約形態コード")){ 			
 			if((strData.substring(findIndex + 1)).equals("0")){
 				employee.setCodeOfContract("正社員");
 			}else if((strData.substring(findIndex + 1)).equals("1")){
 				employee.setCodeOfContract("契約社員");
 			}
 		}else if(strData.substring(0, findIndex).equals("入社年度")){
 			employee.setCompanyEntryYear(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("備考")){
 			employee.setOtherInfo(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("E-Mailアドレス")){
 			employee.setEMail(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("経験年数")){
 			employee.setPastWorkYear(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("最寄り駅")){
 			employee.setNearestStation(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("削除フラグ")){
 			deletedCheck(strData.substring(findIndex + 1));
 		}else if(strData.substring(0, findIndex).equals("登録日")){
 			employee.setEntryDate(strData.substring(findIndex + 1));
	 	}
 	}
 	br.close();
	 	
	System.out.println("【" + dispListNum + "人目】");
	
	String[] strField = {"名前：","カナ：","年齢：","性別：","生年月日：","電話番号：","住所：","部署名：","契約形態：","入社年度：","備考：","E-mail：","経験年数：","最寄駅：","登録日："};
 	
	for(int i = 0 ;  i < employeeList.size() ; i++){
	
		System.out.println(strField[0] + employeeList.get(i).getFamilyName() + employeeList.get(i).getGivenName());
		System.out.println(strField[1] + employeeList.get(i).getKanaFamilyName() + employeeList.get(i).getKanaGivenName());
		System.out.println(strField[2] + employeeList.get(i).getAge() + "歳");
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
	
	//削除フラグが１の場合、例外処理
 	}catch(DeletedException e){
 	}
 	
 }
	
	
	/**
	 * [未入力例外クラス]
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
	 * [削除済み従業員検索例外クラス]
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
	 * [未入力チェックメソッド]
	 * 
	 * 入力の値が無い場合、例外を投げる
	 * @param strCheck
	 */
	public static void emptyCheck(String strCheck) throws IOException{
		if(strCheck.length() == 0){
			System.out.println("何も入力されていません。");
			throw new EmptyException();
		}
	}
	
	/**
	 * [削除フラグチェックメソッド]
	 * 
	 * 削除フラグが立っているかチェックを行う。
	 * 
	 * １，削除フラグが１の場合、削除とみなし例外を投げる
	 * @param strCheck
	 */
	public static void deletedCheck(String strCheck){
		if(strCheck.equals("1")){
			System.out.println("指定されたデータは削除されています。");
			throw new DeletedException();
		}
	}
	
	/**
	 * [Filefilterクラス]
	 * 
	 * ファイル名が「Employee_」で始まり、かつ「.txt」で
	 * で終わるファイルだけ抽出
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
	 * [表示ファイル番号入力メソッド]
	 * 
	 * １，ファイル名が「Employee_」で始まり、かつ「.txt」で終わるファイルだけ抽出
	 * ２，ファイル数の表示
	 * ３，内容を表示するファイルの指定
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String inputDispNum() throws IOException{
		BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));
		
		//指定されたファイル格納場所からファイルの読み込み
		//ファイル名が「Employee_」で始まり、かつ「.txt」で終わるファイルだけ抽出
	 	File file = new File("xxxxxxxxxxxxxxxxxxxxxxxxxx");
	 	File[] fileArray = file.listFiles(new Filefilter());
		
	 	System.out.println(fileArray.length + "人のデータが登録されています。");
		
		String listNum = null;
		
		boolean notEmptyList = false;
		
		//入力有り、かつ数値に変換出来るまで、ループ処理
		while(!notEmptyList){
		 	System.out.print("何人目のデータを表示しますか？：");
			try{
		 		listNum = bufferedR.readLine();
		 		
		 		//入力が無い場合、例外処理
				emptyCheck(listNum);
				
				//文字列から数値に変換出来ない場合、例外処理
				int intListNum = Integer.parseInt(listNum);
				
				//入力が有る、かつ数値に変換出来る場合、ループ処理終了
				notEmptyList = true;
			}catch(EmptyException e){
			}catch(NumberFormatException e){
				System.out.print("数値で入力して下さい。");
			}
		}
		System.out.println("");
		return listNum;
	}
}
