package com.accountDetails;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ReadingFile {

	public static void main(String[] args) throws IOException, ParseException {

		System.out.println("Enter file name");
		Scanner s = new Scanner(System.in);
		String file1 = s.next();
		
		File file = new File(file1);
		//File file = new File("/home/valuelabs/workspace/Bs/src/com/accountDetails/abc.txt");
		
		FileToObject fto = new FileToObject();
		
		Map<Integer,ChangedAmount> map =fto.filetoobj(file);
		
		Iterator<Map.Entry<Integer, ChangedAmount>> it = map.entrySet().iterator();
		
		System.out.println("final values are");
		while(it.hasNext()){
			
			Entry<Integer,ChangedAmount> e =it.next();
			System.out.println(e.getKey()+"      "+e.getValue().amount);

		}
	}
}
