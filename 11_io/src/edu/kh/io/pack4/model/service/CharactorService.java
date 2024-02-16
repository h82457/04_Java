package edu.kh.io.pack4.model.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharactorService {
	
	/* 문자 기반 스트림
	 * 
	 * - 2byte 문자(char) 단위로 입/출력하는 스트림
	 * - Reader, Writer 최상위 인터페이스
	 * - 문자만 작성도니 파일, 채팅, 인터넷 요청시 데이터 전달
	 * */
	
	
	/**
	 * 문자 기반 파일 입력
	 * + 보조 스트림 Buffered 사용
	 */
	public void fileInput() {
		
		// 문자 기반 파일 입력 스트림
		FileReader fr = null;
		
		// 문자 기반 보조 스트림
		BufferedReader br = null;
		
		try {
			// 문자 기반 스트림 생성
			fr = new FileReader("/io_test/노래가사2.txt");
			
			// 보조 스트림 생성
			br = new BufferedReader(fr);
			
//			
			
			// 한 줄을 읽어와 저장할 변수
			String line = null;
			
			while(true) {
				
				line = br.readLine(); // readLine() : 읽어올 내용이 없으면 null 반환
				
				if(line == null) break; // 반복 종료
				
				// 읽어온 내용이 있으면 콘솔에 출력
				System.out.println(line);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			// 사용 완료된 스트림 객체 메모리 반환
			// 보조 스트림만 close() 해도 연결된 기반 스트림도 같이 close();
			try {
				if(br != null) br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	/**
	 *  문자 기반 파일 출력
	 *  + 보조 스트림 Buffered 이용
	 */
	public void fileOutput() {
		
		StringBuilder sb = new StringBuilder(); // String의 불변성을 해결하는 객체, 메모리 효율
		
		sb.append("오늘은 2월 16일 금요일 입니다.\n");
		sb.append("벌써 금요일이라니! 기부니가 좋군요!\n");
		sb.append("다들 힘내서 공부합니다\n");
		sb.append("다들 힘내서 공부합니다\n");
		
		String content = sb.toString();
		
		// content에 저장된 문자열을 /io_test/출력테스트.txt 파일로 촐력
		
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			// 파일과 출력 스트림 연결 (파일이 없으면 생성)
			fw = new FileWriter("/io_test/출력테스트.txt" );
			
			bw = new BufferedWriter(fw); // 버퍼를 이용해서 성능 향상
			
			// content에 저장된 내용을 연결된 파일에 출력
			bw.write(content); 

			bw.flush();
			
			System.out.println("출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			
			try {
				
				if(bw != null) bw.close(); // close() 구문 안에 flush()가 내장되어 있음
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
