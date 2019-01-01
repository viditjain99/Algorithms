import java.util.Scanner;
class array
{
	int arr[];
	int front=-1,rear=-1;
	int n;
	public array()
	{
		System.out.print("Enter the number of records: ");
		Scanner a=new Scanner(System.in);
		n=a.nextInt();
		arr=new int[n];
		System.out.println();
	}
	
	public void insert()
	{
		if(front==0 && rear==n-1)
		{
			System.out.println();
			System.out.println("Overflow!!");
			System.out.println();
		}
		else if(front==-1 && rear==-1)
		{
			front=rear=0;
			Scanner a=new Scanner(System.in);
			System.out.print("Enter: ");
			arr[rear]=a.nextInt();
			System.out.println();
		}
		else
		{
			rear++;
			Scanner a=new Scanner(System.in);
			System.out.print("Enter: ");
			arr[rear]=a.nextInt();
			System.out.println();
		}
	}
	
	public void delete()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println();
			System.out.println("UnderFlow!!");
			System.out.println();
		}
		else if(front==rear)
		{
			front=rear=-1;
		}
		else
		{
			System.out.println();
			System.out.print("The deleted element is: ");
			System.out.println(arr[front]);
			front++;
		}
	}
	
	public void display()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println();
			System.out.println("The queue is empty!!");
			System.out.println();
		}
		else
		{
			System.out.println();
			for(int i=front;i<=rear;i++)
			{
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
public class queue
{
	public static void main(String[] args)
	{
		array q=new array();
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
						q.insert();
						break;
				case 2:
						q.delete();
						break;
				case 3:
						q.display();
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
