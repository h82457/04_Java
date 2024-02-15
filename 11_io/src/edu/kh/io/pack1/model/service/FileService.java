package edu.kh.io.pack1.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileService {

	/*File 클래스
	 * 
	 * - java.io 패키지
	 * - 파일/디렉토리를 관리하는 클래스 (파일/디렉토리 존재 유무 관계X)
	 * - 파일 생성, 제거, 이름, 크기, 마지막 수정일, 존재여부 ... 기능 제공
	 * 
	 * - File 클래스 메서드
	 * 
	 * boolean  mkdir()          : 디렉토리 생성
	 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
	 * boolean  createNewFile()  : 파일 생성
	 * boolean  delete()         : 파일/디렉토리 삭제
	 * String   getName()        : 파일 이름 반환
	 * String   parent()         : 파일이 저장된 디렉토리 반환
	 * String   getPath()        : 전체 경로 반환
	 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
	 * boolean  isDirectory()    : 현재 File 객체가 관리하는게 디렉토리 true
	 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
	 * long     length()         : 파일 크기 반환
	 * long     lastModified()   : 파일 마지막 수정일 (1970.01.01 09:00 부터 현재까지 지난 시간을 ms 단위로 반환)
	 * String[] list()           : 디렉토리 내 파일 목록을 String[] 배열로 반환 (이름만)
	 * File[]   listFiles()      : 디렉토리 내 파일 목록을 File[] 배열로 반환 (상세정보까지)
	 * */
	
	

	/**
	 * File 클래스로 객체 생성
	 * 	+ 폴더가 존재하지 않으면 폴더 생성
	 */
	public void method1() {
		
		File directory = new File("/io_test/20240215"); // 제일 앞 "/" : 최상위 폴더 (== root, 절대 경로의 기준점)
//		ㄴ> 처음: 존재하지 않는 폴더를 관리하는 File 객체 생성
		
		System.out.println("존재 여부 확인 : " + directory.exists());
		
		if(!directory.exists()) { // 디렉토리가 존재하지 않으면
			
			// 폴더 모두 생성
			directory.mkdirs();
			
			System.out.println(directory.getName());
			System.out.println(directory.getPath());
		}
	}
	
	/**
	 * File 객체를 이용해서 지정된 위치에 파일 생성
	 */
	public void method2() {
		
		File file = new File("\\io_test\\20240215\\파일생성.txt"); // 문자열에서 "\"-> "\\", 이스케이프 문자 사용 필요 
		
		try {
			// 파일이 존재하지 않을떄 생성
			if(!file.exists()) {
				
				// 파일 생성이 성공한 경우
				if(file.createNewFile()) { // createNewFile <- 오류 Unhandled exception type IOException
					System.out.println(file.getName() + " 파일이 생성 되었습니다.");
				}
			}			
		}
		catch(IOException e){	e.printStackTrace(); } // 예외 정보 + 예외가 발생한 위치까지 메서드 추적
	}
	
	/**
	 * File 클래스 제공 메서드 활용하기
	 */
	public void method3() {
		
		// 파일 객체 생성
		File dir = new File("\\workspace\\04_Java\\11_io");
		
		// 지정된 디렉토리에 있는 모든 파일/디렉토리를 File[] 형태로 얻어오기
		File[] files = dir.listFiles();
		
		for(File f : files) {
			
//			System.out.println(f.toString()); // for(요소 저장 변수 : 배열|컬렉션){}
//				ㄴString File.toString() : 지정된 파일/디렉토리의 절대경로
			
			// 파일명 얻어오기
			String fileName = f.getName();
			
			// 마지막으로 수정한 날짜 얻어오기
			long lastModifed = f.lastModified();
			
//			System.out.println(lastModifed);
			
			// 날짜 형식 지정
//				SimpleDateFormat : 간단히 날짜 형식을 지정할수 있는 객체
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm");

//			 String SimpleDateFormat.format(long)
//				ㄴ매개변수 long 값을 지정된 패턴 형식으로 변화, 문자열 형태로 반환
			String date = sdf.format(lastModifed);
			
//			System.out.println(date);
			
			// 파일 유형
			String type = null;
			if(f.isFile())	type = "파일";
			else	type = "폴더";
			
			// 파일 크기(byte)
			String size = f.length() + "B";
			
			if(f.isDirectory())	size=""; // 폴더일때 빈문자열
			
//			System.out.println(size);
			
			String result = String.format("%-15s %-20s %-5s %5s", fileName, date, type, size);
			
			System.out.println(result);
		}
	}
}
	
	/* [개발자 상식]
	 * 
	 * OS : 운영체제
	 * 	(windows) 	  (Linux, Mac)
	 * 		폴더	/	디렉토리
	 * 
	 * - 경로 표기 방법(하위 폴더, 파일 표시)
	 * (\, windows)
	 * (/, Linux, Mac)
	 * 
	 * - Java 언어의 특징 : 플랫폼(OS)에 독립적 -> OS 관계 없이 똑같은 코드 작성 가능
	 * 	ㄴ> 특징 유지를 위해 /,\ 둘다 호환 가능 (런타임 시 실행되는 OS에 맞게 자동으로 변경)
	 * 
	 * ------------------------------------------------------------------------------------
	 * 
	 * - 경로 표기 방법
	 * 1) 절대 경로: 하나의(절대적인) 기준으로 부터 목표까지의 경로를 모두 표기하는 방법
	 * 	- 기준: [windows] : C:/, D:/ 	,[Linux, Mac] : /Users, /
	 * 2) 상대 경로 : 현재 위치를 기준으로 목표까지 경로를 표기하는 방법
	 * */ 

