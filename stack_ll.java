import java.util.Scanner;
class node
{
	int data;
	node next;
	public node()
	{
		data=0;
		next=null;
	}
	public node(int d,node n)
	{
		data=d;
		next=n;
	}
}
class stack
{
	node top;
	int size;
	public stack()
	{
		top=null;
		size=0;
	}
	void push(int num)
	{
		node temp=new node(num,null);
		if(top==null)
		{
			temp.next=top;
			top=temp;
			size++;
		}
		else
		{
			temp.next=top;
			top=temp;
			size++;
		}
	}
	void pop()
	{
		if(top==null)
		{
			System.out.println("Underflow! Stack is empty");
			return;
		}
		else
		{
			int t=top.data;
			top=top.next;
			System.out.println(t);
			return;
		}
	}
	void display()
	{
		if(top==null)
		{
			System.out.println("The stack is empty");
		}
		else
		{
			node temp=top;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
	}
}
public class stack_ll
{
	public static void main(String[] args)
	{
		stack s=new stack();
		int ch;
		Scanner a=new Scanner(System.in);
		do
		{
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Quit");
			System.out.print("Enter your choice: ");
			ch=a.nextInt();
			switch(ch)
			{
				case 1:
					System.out.print("Enter the number: ");
					int num=a.nextInt();
					s.push(num);
					break;
				case 2:
					s.pop();
					break;
				case 3:
					s.display();
					break;
				case 4:
					break;
			}
		}while(ch!=4);
	}
}
		
