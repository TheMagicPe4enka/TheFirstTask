import java.util.Arrays;
import java.util.Scanner;

public class TheFirstTask {
	public static void main(String[] atgs) {
		//var
		String s,s1[],
		Array1[]=new String[0];
		int Array2[]=new int[0],
		n=1;
		boolean Check;
		Scanner in=new Scanner(System.in);
		//
		System.out.print("Enter your Text: ");//������� ������ ������������
		s=in.nextLine();
		if(s.length()!=0){
			System.out.print("\nYou enter: "+s);
		}
		else {//���� ������������ ������ �� ����, �� ������������ ����������� ������
			s="the quick brown fox jumps over the lazy dog";
			System.out.print("\nYou don't enter the text!\n"
					+ "Used standart text: "+s);
		}
		
		for (int i=0;i<n;i++) {
			Check=false;
			s1=s.split(" ");//����� ����� �� �����
			if(Array1.length!=0)//���� �� ����� �� ���������� ����, �� ���������� ���
				for (int j=0;j<Array1.length;j++) {//��������� ����������� �� ����� ����� � ���������� ������� ���
					if(Array1[j].equals(s1[i])) {
						Array2[j]++;
						Check=true;//������ "���������� �� �����"
					}
				}
			if(!Check){//���� �� ����������� ���������� ��� � ����� ������
				Array1=Array_1(Array1,s1,i);
				Array2=Array_2(Array2);
			}
			n=s1.length;
		}

		//OutPut(Array2,Array1);//��������� ��� ����������
		Sort(Array1,Array2,Array2.length);//�������� ������� �� ����������
		
		OutPutTopTen(Array2,Array1);//����� ��������� ����������
		in.close();
	}
	public static String[] Array_1(String[] s,String[] s1,int i) {//��������� ����� ����������� ����� �� ���� �������������
		s=Arrays.copyOf(s, s.length+1);
		s[s.length-1]=s1[i];
		return s;
	}
	public static int[] Array_2(int[] a) {//� ����������, ��� ����� ����� ����������� 1 ���
		a=Arrays.copyOf(a, a.length+1);
		a[a.length-1]=1;
		return a;
	}
	public static void Sort(String s[],int v[],int n) {
		
		
		int a,i,j,alpha_id,k;
		String c,alpha;
		for (i=0;i<n-1;i++)//������� �������� ������������� ����� �� ���������� ���������� 
			for (j=0;j<n-1-i;j++) {
				if(v[j]<v[j+1]) {
					a=v[j];
					v[j]=v[j+1];
					v[j+1]=a;
					c=s[j];
					s[j]=s[j+1];
					s[j+1]=c;
				}
			}
		
		for (i=0;i<n-1;i++) {//������� ������ ������������� ����� �� ��������
			alpha=s[i];alpha_id=i;
			for (j=i+1;j<n;j++) {
				if(v[i]==v[j])
				for (k=0;k<alpha.length()&&k<s[j].length();k++) {
					if((k==alpha.length()-1||k==s[j].length()-1)&&alpha.charAt(k)==s[j].charAt(k))
							if(alpha.length()>s[j].length()) {
								alpha=s[j];alpha_id=j;
							}
					if(alpha.charAt(k)==s[j].charAt(k)) continue;
					if(alpha.charAt(k)>s[j].charAt(k)) {
						alpha=s[j];alpha_id=j;break;
					}else break;
				}
			}
			if (alpha_id!=i) {
				c=s[i];
				s[i]=s[alpha_id];
				s[alpha_id]=c;
			}
		}
			
	}
	public static void OutPutTopTen(int v[],String s[]) {
		System.out.print("\nTop10:");
		for(int i=0;i<10;i++) {
			if(i<s.length)
				System.out.print("\n"+v[i]+" - "+s[i]);
			else
				System.out.print("\n"+" - ");
		}
	}
}
	
