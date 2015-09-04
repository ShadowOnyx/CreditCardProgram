import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class CheckerFile 
	{	
	static long card [] = new long [16];
	static int cardRan [] = new int [16];
	static int origRan [] = new int [16];
	public static int finalNum;
	public static int finalNumRan;
	public static int counter;
	static long num;
	static int VCounter;
	static int NVCounter;
	public static void main(String[] args) throws IOException
		{
		Scanner pls = new Scanner(new File("ccnumbers.txt"));
		while(pls.hasNext())
			{	
			num = pls.nextLong();	
			doCreditCheck();
			}
		System.out.println("Valid #"+VCounter);
		System.out.println("Not valid #"+NVCounter);
		}
	public static void doCreditCheck() 
		{
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
			VCounter++;
			}
		else
			{
			System.out.println("Not valid");
			NVCounter++;
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