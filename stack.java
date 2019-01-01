import java.util.Scanner;
class array
{
	int arr[];
	int top=-1;
	int n;
	public array()
	{
		System.out.print("Enter the number of records: ");
		Scanner a=new Scanner(System.in);
		n=a.nextInt();
		arr=new int[n];
		System.out.println();
	}
		
	public void push()
	{
		if(top==n-1)
		{
			System.out.println();
			System.out.println("Overflow!!");
			System.out.println();
		}
		else
		{
			top++;
			int num;
			Scanner a=new Scanner(System.in);
			System.out.print("Enter: ");
			num=a.nextInt();
			arr[top]=num;
			System.out.println();
		}
	}
	
	public void pop()
	{
		if(top==-1)
		{
			System.out.println();
			System.out.println("Underflow!!");
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.print("The popped element is: ");
			System.out.println(arr[top]);
			System.out.println();
			top--;
		}
	}
	public void display()
	{
		if(top==-1)
		{
			System.out.println();
			System.out.println("The stack is empty!");
			System.out.println();
		}
		else
		{
			System.out.println();
			for(int i=top;i>=0;i--)
			{
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
};
public class stack
{
	public static void main(String[] args)
	{
		array s=new array();
		int ch;
		do
		{
			System.out.println("1. Add an element");
			System.out.println("2. Delete an element");
			System.out.println("3. Display elements");
			System.out.println("4. Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			Scanner a=new Scanner(System.in);
			ch=a.nextInt();
			System.out.println();
			switch(ch)
			{
				case 1:
						s.push();
						break;
				case 2:
						s.pop();
						break;
				case 3:
						s.display();
						break;
				case 4:
						break;
				default:
						System.out.println();
						System.out.println("Invalid Choice!!");
						System.out.println();
			}
		}while(ch!=4);
	}
}
			
	
