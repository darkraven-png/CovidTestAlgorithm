package com.demo.CoronavirusTest;

import java.util.*;
import java.io.*;

public class CoronavirusTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoronavirusTest coronavirusTest = new CoronavirusTest();
		ArrayList<String> patientCompList = new ArrayList<String>();
		ArrayList<String> resultsList = new ArrayList<String>();
		String virusComp = null, line = null;
		int numberOfRecords = 0, counter = 0;
		try {
			File file = new File("C:\\Users\\Ronnie\\eclipse-workspace\\CoronaVirusTest\\src\\input.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				if (counter == 0) {
					virusComp = line;
				} else if (counter == 1) {
					numberOfRecords = Integer.parseInt(line);
				} else {
					patientCompList.add(line);
				}
				counter++;
			}
			fr.close();
			System.out.println("Virus Comp : " + virusComp);
			System.out.println("Count : " + numberOfRecords);
			System.out.println("Patient Comp : " + patientCompList);

			// will check now with individual patients
			for (String ptComp : patientCompList) {
				String result = coronavirusTest.virusTest(virusComp, ptComp);
				resultsList.add(result);
			}
			System.out.println("Result is : " + resultsList);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String virusTest(String virusComp, String ptComp) {
		// TODO Auto-generated method stub
		String result = "NEGATIVE";
		int flag = 0;
		char [] virusCompCharArr = virusComp.toCharArray();
		char [] ptCompCharArr = ptComp.toCharArray();
		
		for(int i = 0; i<ptCompCharArr.length; i++) {		//rna
			//r
			for (int j = 0; j<virusCompCharArr.length; j++) {		//corona
				
				if(ptCompCharArr[i]==virusCompCharArr[j]) {
					flag = 1;
					//discarding the part of the array that is already tracersed if match is found. Proceeding to search in the rest of the string/charArray
					virusCompCharArr = virusComp.substring(j).toCharArray();
//					System.out.println("i ="+i+" j = "+j+" virusComp = "+Arrays.toString(virusCompCharArr));
				}
				else {
					flag = 0;
				}
			}
		}
		if (flag == 1)
			result = "POSITIVE";
		return result;
	}

}
