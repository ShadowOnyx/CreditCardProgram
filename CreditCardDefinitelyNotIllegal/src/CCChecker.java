import java.lang.String;
import java.util.Scanner;
public class CCChecker 
	{	
	static long card [] = new long [16];
	static int cardRan [] = new int [16];
	static int origRan [] = new int [16];
	public static int finalNum;
	public static int finalNumRan;
	public static int counter;
	public static void main(String[] args)
		{
		doCreditCheck();
		doGenerateNumbers();
		}
	public static void doCreditCheck()
		{
		System.out.println("Enter a 16 digit number (Not illegal:^)");
		Scanner pls = new Scanner(System.in);
		long num = pls.nextLong();
		for(int i=15;i>-1;i--)
			{	
			long fourNumNew = num%10;
			card[i] = fourNumNew; 
			num = num/10;
			}
		for(int i=0;i<16;i++)
			{
			int x=((i+1)%2);
			if(x>0)
				{
				if((card[i]*2)>9)
					{
					card[i] = card[i]*2; 
					card[i] = card[i]%10+1;	
					}
				else
					{
					card[i] = card[i]*2; 
					}
				}
			}
		for(int i=0;i<16;i++)
			{
			finalNum+= card[i];
			}
		if(finalNum%10==0)
			{
			System.out.println("Perfectly valid");
			}
		else
			{
			System.out.println("Not valid");
			}
		}
	public static void doGenerateNumbers()
		{
		while(counter<100)
			{
			for(int i=0;i<16;i++)
				{
				int ran = (int)(Math.random()*10);
				cardRan[i] = ran;
				origRan[i] = ran;
				}
			for(int i=0;i<16;i++)
				{
				int x=((i+1)%2);
				if(x>0)
					{
					if((cardRan[i]*2)>9)
						{
						cardRan[i] = cardRan[i]*2; 
						cardRan[i] = cardRan[i]%10+1;	
						}
					else
						{
						cardRan[i] = cardRan[i]*2; 
						}
					}
				}
			for(int i=0;i<16;i++)
				{
				finalNumRan+=cardRan[i];
				}
			if(finalNumRan%10==0)
				{
				for(int pls:origRan)
					{
					System.out.print(pls);
					}
				System.out.println("");
				counter++;
				}
			}
		}
	}