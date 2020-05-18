package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import code.datas.User;

public class MainDrive {

	public static void main(String[] args) {
		printMenu();
	}
	
	static void printMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*******전화번호부*******");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전체 목록 조회");
		System.out.println("0. 프로그램 종료");
		System.out.println("*********************");
		
		while (true) {
			System.out.print("메뉴 입력 : ");

			int menuInput = scan.nextInt();
			
			if (menuInput == 0) {
				System.out.println("전화번호부를 종료합니다..");
				break;
			}
			else if (menuInput == 1) {

				writeUserInfoToFile();
				
			}
			else if (menuInput == 2) {

				printAllUsers();
				
			}
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}

		
	}
	
	
	static void printAllUsers() {
		
		File phoneBookFile = new File("phoneBook.csv");
		
		try {
			FileReader fr = new FileReader(phoneBookFile);
			BufferedReader br = new BufferedReader(fr);
			
			while (true) {
				
				String line = br.readLine();
				
				if (line == null) {
					System.out.println("모두 읽었습니다.");
					break;
				}
				
				String[] userInfos = line.split(",");
				
				String userName = userInfos[0];
				String userPhone = userInfos[1];
				int userBirthYear = Integer.parseInt(userInfos[2]);
				
//				System.out.println(String.format("%s(%d세) : %s", userName, userBirthYear, userPhone));
				
				User user = new User(userName, userBirthYear, userPhone);
				
				System.out.println(user);
				
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			
			System.out.println("아직 저장한 사람이 없습니다.");
		} catch (IOException e) {
//			e.printStackTrace();
			
			System.out.println("파일을 읽는중에 문제가 생겼습니다.");
			
		}
		
		
	}
	
	static void writeUserInfoToFile() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		
		System.out.print("폰번 입력 : ");
		String phone = scan.nextLine();
		
		System.out.print("생년 입력 : ");
		int birthYear = scan.nextInt();
		
		
		File phoneBookFile = new File("phoneBook.csv");
		
		try {
			FileWriter fw = new FileWriter(phoneBookFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String inputContent = String.format("%s,%s,%d", name, phone, birthYear);
			
			bw.append(inputContent);
			bw.newLine();
			
			bw.close();
			fw.close();
			
			System.out.println("연락처 저장이 완료 되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}





