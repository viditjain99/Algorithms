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
		front=rear=null;
		size=0;
	}
	public void enqueue(int num)
	{
		node temp=new node(num,null);
		if(front==null)
		{
			temp.next=front;
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
	public void dequeue()
	{
		if(front==null)
		{
			return;
		}
		else
		{
			front=front.next;
			size--;
		}
	}
}
public class bfs
{
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		queue q=new queue();
		int nodes=a.nextInt();
		int[][] conn=new int[nodes][nodes];
		int[] visited=new int[nodes];
		for(int i=0;i<nodes;i++)
		{
			for(int j=0;j<nodes;j++)
			{
				conn[i][j]=a.nextInt();
			}
		}
		int element;
		int source=a.nextInt();
		visited[source]=1;
		q.enqueue(source);
		while(q.size!=0)
		{
			element=q.front.data;
			q.dequeue();
			System.out.print(element+" ");
			for(int j=0;j<nodes;j++)
			{
				if(conn[element][j]==1 && visited[j]==0)
				{
					visited[j]=1;
					q.enqueue(j);
				}
			}
		}
		System.out.println();
	}
}
		
