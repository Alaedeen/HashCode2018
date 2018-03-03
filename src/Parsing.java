import java.io.File;
import java.util.*;

public class Parsing {
	private Scanner x;
	public int R=0;
	public int C=0;
	public int F=0;
	public int N=0;
	public int B=0;
	public int T=0;
	public int[][] m = new int [10000][6];
	
	public  int[][] parse(String fName){
		
		try{
			x = new Scanner(new File(fName));
		}catch(Exception e){
			System.out.println("could not find the file");
		}
		String a;
		int m1=0;
		int m2=0;
		while(x.hasNext()){
			
			a=x.next();
			if(R==0){
				R=Integer.parseInt(a);
				a = x.next();
			}
			if(C==0){
				C=Integer.parseInt(a);
				a = x.next();
			}if(F==0){
				F=Integer.parseInt(a);
				a = x.next();
			}if(N==0){
				N=Integer.parseInt(a);
				a = x.next();
			}if(B==0){
				B=Integer.parseInt(a);
				a = x.next();
			}if(T==0){
				T=Integer.parseInt(a);
				a = x.next();
			}
			
			m[m1][m2]=Integer.parseInt(a);
			m2++;
			if(m2==6){
				m1++;
				m2=0;
			}
			
		}

		
		return m;
	}
	
}
