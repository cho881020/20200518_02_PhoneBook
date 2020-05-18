package code.datas;

import java.util.Calendar;

public class User {

//	변수는 private으로 막고, public getter / setter 활용 => 접근제어
	private String name;
	private int birthYear;
	private String phoneNum;
	
	
//	생성자를 만들어서, 이름/생년/폰번을 한번에 같이 넣도록.
//	이클립스에서 제공하는 자동 작성 기능으로 만들었음.
	public User(String name, int birthYear, String phoneNum) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.phoneNum = phoneNum;
	}
	
//	변수의 값 조회 / 대입하는 getter / setter 생성.
//	자동 작성 기능 활용함.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
//	이 사람이 (현재 시점에서) 몇살인지 자동으로 계산해주는 기능.
	public int getKoreanAge() {
		
//		Calendar 객체를 만들면 => 기본값이 현재시간임을 활용.
		Calendar cal = Calendar.getInstance(); 
		
//		현재시간의 년도만 추출 - 생년을빼고 1을 더해서 나이 계산.
		return cal.get(Calendar.YEAR) - this.birthYear + 1;
	}
	
	
//	변수를 그대로 출력하면 실행되는 toString의 내용을 재정의. (오버라이딩)
	@Override
	public String toString() {
		
//		String 클래스의 static 메쏘드 format을 사용해서 양식을 가공해서 리턴.
//		this를 이용해서 내 자신의 멤버변수 / 메쏘드 활용하는 예시.
		return String.format("%s(%d세) : %s", this.name, this.getKoreanAge(), this.phoneNum);
	}
	
	
}









