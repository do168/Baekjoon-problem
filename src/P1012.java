
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class P1012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		HashMap<String, Integer> hm = new HashMap<>();

		int start = 1;
		int end = 1;
		int min = 1;
		for(int i=1; i<=gems.length; i++) {
			String temp = gems[i-1];
			if(!hm.containsKey(temp)) {
				hm.put(temp, i);
				end = i;
				start = min;
			}
			else {
				hm.replace(temp, i);
			}
		}
		
	}



}