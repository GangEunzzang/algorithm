import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double N = Integer.parseInt(br.readLine());		
		System.out.println((Math.sqrt(3) / 4) * Math.pow(N, 2));
	}

}