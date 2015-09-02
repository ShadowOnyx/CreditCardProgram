import java.util.Scanner;
public class Checker
	{
		static long card [] = new long [16];
		public static void main(String[] args)
			{
			doCreditCheck();
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
				int x=i%2;
				if(x>0)
					{
					card[i] = card[i] *2; 
					if(card[i]>10)
						{
						card[i] = card[i]%10+1;	
						}
					}
				else
					{
						
					}
				}
			}
	}