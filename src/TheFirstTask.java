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
		System.out.print("Enter your Text: ");//вводные данные пользователя
		s=in.nextLine();
		if(s.length()!=0){
			System.out.print("\nYou enter: "+s);
		}
		else {//если пользователь ничего не ввел, то используются стандартные данные
			s="the quick brown fox jumps over the lazy dog";
			System.out.print("\nYou don't enter the text!\n"
					+ "Used standart text: "+s);
		}
		
		for (int i=0;i<n;i++) {
			Check=false;
			s1=s.split(" ");//делим текст на слова
			if(Array1.length!=0)//если до этого не записывали слов, то пропускаем шаг
				for (int j=0;j<Array1.length;j++) {//проверяем встречалось ли слово ранее и записываем сколько раз
					if(Array1[j].equals(s1[i])) {
						Array2[j]++;
						Check=true;//тригер "стречалось ли слово"
					}
				}
			if(!Check){//если не встречалось записываем его в конец списка
				Array1=Array_1(Array1,s1,i);
				Array2=Array_2(Array2);
			}
			n=s1.length;
		}

		//OutPut(Array2,Array1);//результат без сортировки
		Sort(Array1,Array2,Array2.length);//отправка списков на сортировку
		
		OutPutTopTen(Array2,Array1);//вывод конечного результата
		in.close();
	}
	public static String[] Array_1(String[] s,String[] s1,int i) {//добавляем новые встречаемые слова по мере необходимости
		s=Arrays.copyOf(s, s.length+1);
		s[s.length-1]=s1[i];
		return s;
	}
	public static int[] Array_2(int[] a) {//и записываем, что новое слово встретилось 1 раз
		a=Arrays.copyOf(a, a.length+1);
		a[a.length-1]=1;
		return a;
	}
	public static void Sort(String s[],int v[],int n) {
		
		
		int a,i,j,alpha_id,k;
		String c,alpha;
		for (i=0;i<n-1;i++)//методом пузырька отсортировали слова по количеству повторений 
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
		
		for (i=0;i<n-1;i++) {//методом выбора отсортировали слова по алфавиту
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
	
