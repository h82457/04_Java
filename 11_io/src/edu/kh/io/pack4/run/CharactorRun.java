package edu.kh.io.pack4.run;

import edu.kh.io.pack4.model.service.CharactorService;

public class CharactorRun {
	public static void main(String[] args) {
		
		CharactorService service = new CharactorService();
		
//		service.fileInput();
		service.fileOutput();
		
	}
}
