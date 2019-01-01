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
class circular_ll
{
	public node front;
	public node rear;
	int size;
	public circular_ll()
	{
		rear=null;
		size=0;
	}
	public void insertatfront(int num)
	{
		node temp=new node(num,null);
		if(front==null)
		{
			front=temp;
			front.next=front;
			rear=front;
			size++;
		}
		else
		{
			temp.next=front;
			front=temp;
			rear.next=temp;
			size++;
		}
	}
	public void insertatrear(int num)
	{
		node temp=new node(num,null);
		if(front==null)
		{
			front=temp;
			front.next=front;
			rear=front;
			size++;
		}
		else
		{
			temp.next=front;
			rear.next=temp;
			rear=temp;
			size++;
		}
	}
	public void insertatpos(int pos,int num)
	{
		node temp=new node(num,null);
		if(pos==1)
		{
			insertatfront(num);
		}
		else if(pos==size)
		{
			insertatrear(num);
		}
		else
		{
			node ptr=front;
			for(int i=1;i<size;i++)
			{
				if(i==pos-1)
				{
					node n=ptr.next;
					temp.next=n;
					ptr.next=temp;
					size++;
				}
				ptr=ptr.next;
			}
		}
	}
	void deleteatpos(int pos)
	{
		if(size==0)
		{
			System.out.println("EMPTY");
			return;
		}
		else if(pos==1)
		{
			if(size==1)
			{
				front=rear=null;
				size=0;
				return;
			}
			else
			{
				front=front.next;
				rear.next=front;
				size--;
				return;
			}
		}
		else if(pos==size)
		{
			node ptr=front;
			for(int i=1;i<size;i++)
			{
				ptr=ptr.next;
			}
			ptr.next=front;
			size--;
		}
		else
		{
			node ptr=front;
			for(int i=1;i<size;i++)
			{
				if(i==pos-1)
				{
					node n=ptr.next.next;
					ptr.next=n;
					size--;
					return;
				}
				ptr=ptr.next;
			}
		}
	}
	void display()
	{
		if(front==null)
		{
			System.out.println("EMPTY");
			return;
		}
		else
		{
			node ptr=front;
			while(ptr.next!=front)
			{
				System.out.println(ptr.data+" ");
				ptr=ptr.next;
			}
			System.out.println();
		}
	}
}
public class circular
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		circular_ll l=new circular_ll();
		char ch;
		do
		{
			System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. get size");
 
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 :
                System.out.println("Enter integer element to insert");
                l.insertatfront( scan.nextInt() );
                break;
            case 2 :
                System.out.println("Enter integer element to insert");
                l.insertatrear( scan.nextInt() );
                break;
            case 3 :
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos < 1 || pos > l.size )
                    System.out.println("Invalid position\n");
                else
                    l.insertatpos(num, pos);
                break;
            case 4 :
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > l.size )
                    System.out.println("Invalid position\n");
                else
                    l.deleteatpos(p);
                break;
            case 5 :
                System.out.println("Size = "+ l.size +" \n");
                break;
            default :
                System.out.println("Wrong Entry \n ");
                break;
            }
            l.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');
    }
}


