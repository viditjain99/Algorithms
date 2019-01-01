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
class linked_list
{
	node front;
	node rear;
	int size;
	public linked_list()
	{
		front=null;
		rear=null;
		size=0;
	}
	void insertatfront(int num)
	{
		node temp=new node(num,null);
		if(front==null)
		{
			front=temp;
			rear=front;
			size++;
		}
		else
		{
			temp.next=front;
			front=temp;
			size++;
		}
	}
	void insertatend(int num)
	{
		node temp=new node(num,null);
		if(front==null)
		{
			front=temp;
			rear=front;
			size++;
		}
		else
		{
			rear.next=temp;
			rear=temp;
			size++;
		}
	}
	void insertatpos(int num,int pos)
	{
		node temp=new node(num,null);
		if(pos==1)
		{
			inseratfront(num);
		}
		else if(pos==size)
		{
			insertatend(num);
		}
		else
		{
			node ptr=front;
			for(int i=1;i<pos;i++)
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
				front=null;
				rear=null;
				size=0;
				return;
			}
			else
			{
				front=front.next;
				size--;
				return;
			}
		}
		else if(pos==size)
		{
			size--;
			node ptr=front;
			for(int i=1;i<size-1;i++)
			{
				ptr=ptr.next;
			}
			ptr.next=null;
			rear=ptr;
			size--;
			return;
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
		if(front=null)
		{
			System.out.println("EMPTY");
		}
		else
		{
			node ptr=front;
			while(ptr!=null)
			{
				System.out.print(ptr.data+" ");
				ptr=ptr.next;
			}
			System.out.println();
		}
	}
}
					
				
					
