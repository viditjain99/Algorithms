import java.util.Scanner;
import java.util.ArrayList;
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
		temp.next=top;
		top=temp;
		size++;
	}
	void pop()
	{
		int ele;
		if(size==0)
		{
			return;
		}
		else
		{
			top=top.next;
			size--;
		}
	}
}
public class dfs
{
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		stack s=new stack();
		int nodes=a.nextInt();
		int[] visited=new int[nodes];
		int[][] conn=new int[nodes][nodes];
		ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<nodes;i++)
		{
			list.add(new ArrayList<Integer>());
			for(int j=0;j<nodes;j++)
			{
				conn[i][j]=a.nextInt();
			}
		}
		for(int i=0;i<nodes;i++)
		{
			for(int j=0;j<nodes;j++)
			{
				if(conn[i][j]==1)
				{
					list.get(i).add(j);
				}
			}
		}
		System.out.println(list);
		int source=a.nextInt();
		s.push(source);
		visited[source]=1;
		System.out.print(source+" ");
		while(s.size!=0)
		{
			int element=s.top.data;
			if(list.get(element).size()>0)
			{
				for(int i=0;i<list.get(element).size();i++)
				{
					if(visited[list.get(element).get(i)]==0)
					{
						s.push(list.get(element).get(i));
						visited[list.get(element).get(i)]=1;
						System.out.print(list.get(element).get(i)+" ");
						break;
					}
					if(i==list.get(element).size()-1)
					{
						s.pop();
					}
				}
			}
			else
			{
				s.pop();
			}
		}
		System.out.println();
	}
}
		
