import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * [従業員情報登録クラス]
 * 
 * 従業員情報の登録をする。
 * 
 * @author yukitoyoshima
 * 
 */
public class SaveEmployeeInfo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * メインメソッド
	 * 
	 * 1、登録人数の設定 ２，従業員情報入力 3，データをファイルに書込
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// 登録人数を設定
		int inputPplNum = inputEntryPplNum();
		
		//従業員格納リストの生成
		ArrayList<Employee> employeeList = new ArrayList<Employee>();

		//指定人数の従業員の情報を設定
		employeeList = setData(inputPplNum, employeeList);

		// ファイルを生成し、従業員情報とタグの書込
		writeData(employeeList);
	}

	/**
	 * 指定された登録人数分のデータ入力
	 * 
	 * １，一人分のデータを入力する。 
	 * ２，Employee型オブジェクトを格納するリストに設定する。 
	 * ３，1,2を人数分繰返す。
	 * 
	 * @param inputPplNum
	 * @param employeeList
	 * @returne employeeList　従業員情報格納リスト
	 * @throws IOException
	 */
	public static ArrayList<Employee> setData(int inputPplNum,
			ArrayList<Employee> employeeList) throws IOException {

		// 指定された登録人数分のデータ入力
		for (int i = 0; i < inputPplNum; i++) {

			// 従業員型オブジェクトの生成
			Employee employee = new Employee();

			System.out.println("****" + (i + 1) + "人目****");

			// 姓の入力
			employee.setFamilyName(inputFamilyName());

			// 名の入力
			employee.setGivenName(inputGivenName());

			// カタカナ姓の入力
			employee.setKanaFamilyName(inputKanaFamilyName());

			// カタカナ名の入力
			employee.setKanaGivenName(inputKanaGivenName());

			// 歳の入力
			employee.setAge(inputAge());

			// 性別の入力
			employee.setGender(inputGender());

			// 誕生日の入力
			employee.setBirthDate(inputBirthDate());

			// 電話番号の入力
			employee.setTellNum(inputTellNum());

			// 住所の入力
			employee.setAddress(inputAddress());

			// 部門の入力
			employee.setWorkDepartment(inputWorkDepartment());

			// 契約コードの入力
			employee.setCodeOfContract(inputCOC());

			// 入社年度の入力
			employee.setCompanyEntryYear(inputEntryYear());

			// 備考の入力
			employee.setOtherInfo(inputOtherInfo());

			// Emailアドレスの入力
			employee.setEMail(inputEmail());

			// 経験年数の入力
			employee.setPastWorkYear(inputPastWorkYear());

			// 最寄駅の入力
			employee.setNearestStation(inputNearestStation());

			// 削除フラグの入力
			employee.setIsDelete(inputIsDelete());

			// 登録日の設定
			employee.setEntryDate(inputEntryDate());

			// リストに設定
			employeeList.add(employee);
		}

		return employeeList;

	}

	/**
	 * [データ書込メソッド]
	 * 
	 * １，一人分のデータを書き込むファイルの生成 ２，一人分のデータをそれぞれのタグと共に書込 ３，人数分１，２の繰返し
	 * 
	 * @param employeeData
	 * @throws IOException
	 */
	public static void writeData(ArrayList<Employee> employeeList)
			throws IOException {
		
		//タグの生成
		String[] strField = { "姓：", "名：", "カタカナ姓：", "カタカナ名：", "年齢：", "性別：",
				"生年月日：", "電話番号：", "住所：", "部署名：", "契約形態コード：", "入社年度：", "備考：",
				"E-Mailアドレス：", "経験年数：", "最寄り駅：", "削除フラグ：", "登録日：" };
		
		//指定人数分の情報を書込
		for (int i = 0; i < employeeList.size(); i++) {

			// 一人分のデータを書き込むファイルの生成
			Writer writer = new FileWriter("Employee_" + (i + 1) + ".txt");
			BufferedWriter bw = new BufferedWriter(writer);
			
			// 書込処理
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
	 * [未入力チェッカー]
	 * 
	 * 入力内容が無い状態で次の項目の入力に移ろうとすると、 例外を投げる。
	 * 
	 * @param strInput
	 */
	public static void isEmptyException(String strInput) {
		if (strInput.length() == 0 || strInput == null) {
			System.out.print("何も入力されていません。");
			throw new EmptyException();
		}
	}

	/**
	 * [登録人数入力メソッド]
	 * 
	 * 登録人数の入力をするメソッド
	 * 
	 * @return inputPplNum　登録人数
	 * @throws IOException
	 */
	public static int inputEntryPplNum() throws IOException {

		// 入力人数
		int inputPplNum = 0;

		// 入力完了フラグ
		boolean isInputComplete = false;

		// 入力有り、かつ入力内容が数値になるまで、ループ処理
		while (!isInputComplete) {
			try {
				System.out.print("登録人数を入力して下さい：");
				String strNum = br.readLine();

				// 入力が無しの場合、例外処理
				isEmptyException(strNum);

				// 文字列を数値に変換
				// 変換出来ない場合、例外処理
				inputPplNum = Integer.parseInt(strNum);

				// 入力有り、かつ入力内容が数値の場合、ループ処理終了
				isInputComplete = true;

				// 登録人数を返却
				return inputPplNum;

				// 入力無しの場合、例外処理
			} catch (EmptyException e) {

				// 数値変換出来ない場合、例外処理
			} catch (NumberFormatException e) {
				System.out.print("数値で");
			}
		}
		System.out.println("");
		return inputPplNum;
	}

	/**
	 * [姓入力メソッド]
	 * 
	 * 姓の入力をするメソッド
	 * 
	 * @return familyName　姓
	 * @throws IOException
	 */
	public static String inputFamilyName() throws IOException {
		String familyName = null;

		boolean isInputComplete = false;

		// 入力内容が有るまで、ループ処理
		while (!isInputComplete) {
			try {
				System.out.print("姓を入力して下さい：");
				familyName = br.readLine();

				// 入力が無しの場合、例外処理
				isEmptyException(familyName);
				isInputComplete = true;

				// 入力が無しの場合、例外処理
			} catch (EmptyException e) {
			}
		}
		return familyName;
	}

	/**
	 * [名入力メソッド]
	 * 
	 * @return givenName　名
	 * @throws IOException
	 */
	public static String inputGivenName() throws IOException {
		String givenName = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("名を入力して下さい：");
				givenName = br.readLine();
				isEmptyException(givenName);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return givenName;
	}

	/**
	 * [カタカナ姓入力メソッド]
	 * 
	 * @return kanaFamilyName　カタカナ姓
	 * @throws IOException
	 */
	public static String inputKanaFamilyName() throws IOException {
		String kanaFamilyName = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("カタナカ姓を入力して下さい：");
				kanaFamilyName = br.readLine();
				isEmptyException(kanaFamilyName);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return kanaFamilyName;
	}

	/**
	 * [カタカナ名入力メソッド]
	 * 
	 * @return inputKanaGivenName カタカナ名
	 * @throws IOException
	 */
	public static String inputKanaGivenName() throws IOException {
		String inputKanaGivenName = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("カタカナ名を入力して下さい：");
				inputKanaGivenName = br.readLine();
				isEmptyException(inputKanaGivenName);
				isInputComplete = true;
			} catch (EmptyException e) {
			}
		}
		return inputKanaGivenName;
	}

	/**
	 * [年齢入力メソッド]
	 * 
	 * @return inputStrAge　年齢
	 * @throws IOException
	 */
	public static String inputAge() throws IOException {
		String inputStrAge = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("年齢を入力して下さい：");
				inputStrAge = br.readLine();
				isEmptyException(inputStrAge);
				int inputAge = Integer.parseInt(inputStrAge);
				isInputComplete = true;
			} catch (NumberFormatException e) {
				System.out.print("数値で");
			} catch (EmptyException e) {
			}
		}
		return inputStrAge;
	}

	/**
	 * [性別入力メソッド]
	 * 
	 * @return inputGender　性別
	 * @throws IOException
	 */
	public static String inputGender() throws IOException {
		String inputGender = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			try {
				System.out.print("性別を入力して下さい：");
				inputGender = br.readLine();
				isEmptyException(inputGender);

				if (inputGender.equals("男") || inputGender.equals("女")) {
					isInputComplete = true;
				} else {
					System.out.print("男か女で");
				}
			} catch (EmptyException e) {

			}
		}
		return inputGender;
	}

	/**
	 * [生年月日入力メソッド]
	 * 
	 * @return inputBirthDate　生年月日
	 * @throws IOException
	 */
	public static String inputBirthDate() throws IOException {
		String inputBirthDate = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("生年月日を西暦で入力して下さい：");
			inputBirthDate = br.readLine();

			try {
				isEmptyException(inputBirthDate);
				int inputBDVal = Integer.parseInt(inputBirthDate);
				if (inputBirthDate.length() == 8) {
					isInputComplete = true;
				} else {
					System.out.print("8桁の数字で");
				}
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.print("数字で");
			}
		}
		return inputBirthDate;
	}

	/**
	 * [電話番号入力メソッド]
	 * 
	 * @return inputTellNum　電話番号
	 * @throws IOException
	 */
	public static String inputTellNum() throws IOException {
		String inputTellNum = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("電話番号を入力して下さい：");
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
	 * [住所入力メソッド]
	 * 
	 * @return inputAddress　住所
	 * @throws IOException
	 */
	public static String inputAddress() throws IOException {
		String inputAddress = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("住所を入力して下さい：");
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
	 * [部署名入力メソッド]
	 * 
	 * @return inputWorkDepartment　部署
	 * @throws IOException
	 */
	public static String inputWorkDepartment() throws IOException {
		String inputWorkDepartment = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("部署名を入力して下さい：");
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
	 * [契約形態入力メソッド]
	 * 
	 * @return inputCodeOfContract　契約形態コード
	 * @throws IOException
	 */
	public static String inputCOC() throws IOException {
		String inputCodeOfContract = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("契約形態コード(0:正社員 1:契約社員)を入力して下さい：");
			inputCodeOfContract = br.readLine();
			try {
				isEmptyException(inputCodeOfContract);
				int intCOC = Integer.parseInt(inputCodeOfContract);
				if (intCOC == 0 || intCOC == 1) {
					isInputComplete = true;
				} else {
					System.out.print("(0:正社員 1:契約社員)の形式で");
				}
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.println("数値で入力して下さい。");
			}
		}
		return inputCodeOfContract;
	}

	/**
	 * [入社年度入力メソッド]
	 * 
	 * @return inputEntryYear　入社年度(YYYY/MM)
	 * @throws IOException
	 */
	public static String inputEntryYear() throws IOException {
		String inputEntryYear = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("入社年度(YYYY/MM)を入力して下さい：");
			inputEntryYear = br.readLine();
			try {
				// 入力が無い場合、例外処理
				isEmptyException(inputEntryYear);

				String[] strSplit = inputEntryYear.split("/");
				int intEY1 = Integer.parseInt(strSplit[0]);
				int intEY2 = Integer.parseInt(strSplit[1]);

				// 「/」で分割した前半部分の文字列数が4の場合
				if (strSplit[0].length() == 4) {

					// 「/」で分割した後半部分の文字列数が2の場合
					if (strSplit[1].length() == 2) {

						// ループ処理終了
						isInputComplete = true;
					}
				} else {
					System.out.print("(YYYY/MM)の形式で");
				}
			} catch (EmptyException e) {
			} catch (Exception e) {
				System.out.print("(YYYY/MM)の形式で");
			}
		}
		return inputEntryYear;
	}

	/**
	 * [備考入力メソッド]
	 * 
	 * @return inputOtherInfo　備考
	 * @throws IOException
	 */
	public static String inputOtherInfo() throws IOException {
		String inputOtherInfo = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("備考を入力して下さい：");
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
	 * [E-Mailアドレス入力メソッド]
	 * 
	 * @return inputEmail　E-mailアドレス
	 * @throws IOException
	 */
	public static String inputEmail() throws IOException {
		String inputEmail = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("E-mailアドレスを入力して下さい：");
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
	 * [経験年数入力メソッド]
	 * 
	 * @return inputPastWorkYear　経験年数
	 * @throws IOException
	 */
	public static String inputPastWorkYear() throws IOException {
		String inputPastWorkYear = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("経験年数を入力して下さい：");
			inputPastWorkYear = br.readLine();
			try {
				isEmptyException(inputPastWorkYear);
				int intPWY = Integer.parseInt(inputPastWorkYear);
				isInputComplete = true;
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.print("数値で");
			}
		}
		return inputPastWorkYear;
	}

	/**
	 * [最寄り駅入力メソッド]
	 * 
	 * @return inputNearestStation　最寄り駅
	 * @throws IOException
	 */
	public static String inputNearestStation() throws IOException {
		String inputNearestStation = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("最寄り駅を入力して下さい：");
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
	 * [削除フラグ入力メソッド]
	 * 
	 * @return isDelete　削除フラグ
	 * @throws IOException
	 */
	public static String inputIsDelete() throws IOException {
		String isDelete = null;

		boolean isInputComplete = false;
		while (!isInputComplete) {
			System.out.print("削除フラグ（0:未削除 1:削除）を入力して下さい：");
			isDelete = br.readLine();
			try {
				isEmptyException(isDelete);
				int intIsDelete = Integer.parseInt(isDelete);
				if (intIsDelete == 0 || intIsDelete == 1) {
					isInputComplete = true;
				} 
			} catch (EmptyException e) {
			} catch (NumberFormatException e) {
				System.out.print("数値で");
			}
		}
		return isDelete;
	}

	/**
	 * [登録日の設定メソッド]
	 * 
	 * @return year + month + date　登録年月日
	 */
	public static String inputEntryDate() {
		Calendar calendar = Calendar.getInstance();

		// 現在年の取得
		String year = Integer.toString(calendar.get(Calendar.YEAR));

		// 現在月の取得
		String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);

		// 現在日の取得
		String date = Integer.toString(calendar.get(Calendar.DATE));

		// 表示形式の調整
		// 月もしくは日の値が一桁であれば0を上一桁に加える。
		if (month.length() == 1) {
			month = "0" + month;
		}
		if (date.length() == 1) {
			date = "0" + date;
		}

		System.out.println("");

		// 年月日を返却
		return year + month + date;
	}

}