package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
//				TODO 전화번호 목록 조회 => 출력 기능 구현
			}
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
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
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}





