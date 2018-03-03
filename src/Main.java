import java.util.Formatter;
import  java.awt.dnd.*;
import java.util.*;

public class Main {
	public static void main(String args[]){
		int[][] m = new int [10000][10];
		Parsing p = new Parsing();
		List<String> T=new ArrayList<String>();
		List<String> nrc=new ArrayList<String>();
		List<String> rc=new ArrayList<String>();
		List<String> N=new ArrayList<String>();
		int[][] posC = new int[400][2];

		m=p.parse("C:\\Users\\alaed\\workspace\\HashCode2018\\src\\c_no_hurry.in");
		Formatter x=null;
		try{
			x=new Formatter("c_no_hurry.out");
		}catch (Exception e){
			System.out.println("ERROR");
		}
		for(int i=0;i<400;i++){
			for(int j=0;j<2;j++){
				posC[i][j]=0;
			}
		}
		for(int i=0;i<p.F;i++){
			T.add(Integer.toString(p.T));
		}
		for(int i=0;i<p.F;i++){
			nrc.add("0");
		}
		for(int i=0;i<p.F;i++){
			rc.add("");
		}
		for(int i=0;i<p.N;i++){
			N.add("0");
		}
		int min;
		int pos;
		int Sc=0;
		int Sr=0;
		boolean car=true;
		boolean ride=true;
		while (car&&ride){
			Sc=0;
			Sr=0;
			for(int i=0;i<p.F;i++){
				min=p.C+p.R;
				pos=0;
				for(int j=0;j<p.N;j++){
					if((N.get(j)=="0")&&((Math.abs(m[j][0]-posC[i][0])+Math.abs(m[j][1]-posC[i][1]))<min)
							&& (Integer.parseInt(T.get(i))>
							(Math.abs(m[j][2]-posC[i][0])+Math.abs(m[j][3]-posC[i][1])))){
						posC[i][0]=m[j][2];
						posC[i][0]=m[j][3];
						pos=j;
						min=Math.abs(m[j][0]-posC[i][0])+Math.abs(m[j][1]-posC[i][1]);
					}
				}
				if (N.get(pos)=="0"){
					nrc.set(i,Integer.toString(Integer.parseInt(nrc.get(i))+1));
					rc.set(i,rc.get(i)+Integer.toString(pos)+" ");
					T.set(i,Integer.toString(Integer.parseInt(T.get(i))-
							(Math.abs(m[pos][2]-posC[i][0])+Math.abs(m[pos][3]-posC[i][1]))));
					N.set(pos,"1");
				}
			}
			for(int k=0;k<p.N;k++){
				Sr=Sr+Integer.parseInt(N.get(k));
			}
			if(Sr==p.N){
				ride=false;
			}
			for(int k=0;k<p.F;k++){
				int count=0;
				for(int j=0;j<p.N;j++){

					if((Integer.parseInt(T.get(k))<
							(Math.abs(m[j][2]-posC[k][0])+Math.abs(m[j][3]-posC[k][1])))){
						count++;
					}
				}
				if(count==p.N)
					Sc++;
			}
			if (Sc==p.F){
				car=false;
			}
		}
		String a="";
		for(int i=0;i<p.F;i++){
			a=a+nrc.get(i)+" "+rc.get(i)+"\n";
			//System.out.println(nrc);
		}
		//System.out.println(T.get(0));
		x.format("%s",a);
		x.close();
	}
}
