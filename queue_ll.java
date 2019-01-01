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
class queue
{
	node front;
	node rear;
	int size;
	public queue()
	{
		front=null;
		rear=null;
		size=0;
	}
	void insert(int num)
	{
		node temp=new node(num,null);
		if(front==null)
		{
			temp.next=front;
			front=temp;
			rear=front;
		}
		else
		{
			temp.next=rear;
			rear=temp;
			size++;
		}
	}
	void delete()
	{
		if(front==null)
		{
			System.out.println("Empty");
		}
		else if(front==rear)
		{
			front=rear=null;
			size--;
		}
		else
		{
			front=front.next;
			size--;
		}
	}
	void reverse()
	{
		node cur=front;
		node prev=null;
		node Next=null;
		while(cur!=null)
		{
			Next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
	}
	void display()
	{
		if(front==null)
		{
			System.out.println("empty");
		}
		else
		{
			node ptr=front;
			while(ptr!=null)
			{
				System.out.println(ptr.data+" ");
				ptr=ptr.next;
			}
		}
	}
}
public class queue_ll
{
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		queue list=new queue();
		int choice;
		do
		{
            System.out.println("1. insert at end");
            System.out.println("2. delete");
            System.out.println("3. display");
			System.out.println("4. reverse");
            System.out.println("5. quit");
            choice=a.nextInt();
            switch(choice)
            {
            	case 1:
            		System.out.print("Enter the number: ");
            		int val=a.nextInt();
            		list.insert(val);
            		break;
				case 2:
					list.delete();
					break;
				case 3:
					list.display();
					break;
				case 4:
					list.reverse();
					break;
				case 5:
					break;
				default:
					System.out.println("Wrong choice!");
					break;
			}
		}while(choice!=5);
	}
}






