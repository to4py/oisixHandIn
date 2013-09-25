/**
 * [従業員クラス]
 * 
 * @author yukitoyoshima
 *
 */
public class Employee{

	private String familyName;		//姓
	private String givenName;		//名
	private String kanaFamilyName;	//カタカナ姓
	private String kanaGivenName;	//カタカナ名
	private String age;				//年齢
	private String gender;			//性別
	private String birthDate;		//生年月日
	private String tellNum;			//電話番号
	private String address;			//住所
	private String workDepartment;	//部署名
	private String codeOfContract;	//契約コード
	private String companyEntryYear;		//入社年度
	private String otherInfo;		//備考
	private String eMail;			//E-mail　アドレス
	private String pastWorkYear; 	//経験年数
	private String nearestStation;	//最寄り駅
	private String isDelete;		//削除フラグ
	private String entryDate;		//登録日

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyNa) {
		this.familyName = familyNa;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenNa) {
		this.givenName = givenNa;
	}
	public String getKanaFamilyName() {
		return kanaFamilyName;
	}
	public void setKanaFamilyName(String familyKana) {
		this.kanaFamilyName = familyKana;
	}
	public String getKanaGivenName() {
		return kanaGivenName;
	}
	public void setKanaGivenName(String givenKana) {
		this.kanaGivenName = givenKana;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getTellNum() {
		return tellNum;
	}
	public void setTellNum(String tellNum) {
		this.tellNum = tellNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorkDepartment() {
		return workDepartment;
	}
	public void setWorkDepartment(String department) {
		this.workDepartment = department;
	}
	public String getCodeOfContract() {
		return codeOfContract;
	}
	public void setCodeOfContract(String codeOfContract) {
		this.codeOfContract = codeOfContract;
	}
	public String getCompanyEntryYear() {
		return companyEntryYear;
	}
	public void setCompanyEntryYear(String companyEntryYear) {
		this.companyEntryYear = companyEntryYear;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPastWorkYear() {
		return pastWorkYear;
	}
	public void setPastWorkYear(String pastWorkYear) {
		this.pastWorkYear = pastWorkYear;
	}
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	
	
}