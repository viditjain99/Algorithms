//prims
import java.util.Scanner;
import java.util.ArrayList;
public class prims
{
	public static int min(ArrayList<Integer> q,ArrayList<Integer> dist)
	{
		int i=0;
		int index=i;
		int min=dist.get(q.get(i));
		while(i<q.size())
		{
			if(dist.get(q.get(i))<min)
			{
				min=dist.get(q.get(i));
				index=i;
			}
			i++;
		}
		return index;
	}
	public static void Prims(ArrayList<ArrayList<Integer>> conn,ArrayList<ArrayList<Integer>> wei,int N,int source)
	{
		ArrayList<Integer> q=new ArrayList<Integer>();
		ArrayList<Integer> dist=new ArrayList<Integer>();
		int[] prev=new int[N];
		int[] visited=new int[N];
		for(int i=0;i<N;i++)
		{
			q.add(i);
			dist.add(Integer.MAX_VALUE);
			prev[i]=-1;
		}
		dist.set(source,0);
		visited[source]=1;
		while(q.size()!=0)
		{
			int index=min(q,dist);
			int v=q.get(index);
			q.remove(index);
			visited[v]=1;
			for(int i=0;i<conn.get(v).size();i++)
			{
				int d=dist.get(conn.get(v).get(i));
				if(d>wei.get(v).get(i) && visited[conn.get(v).get(i)]==0)
				{
					dist.set(conn.get(v).get(i),wei.get(v).get(i));
					prev[conn.get(v).get(i)]=v;
				}
			}
		}
		for(int i=0;i<N;i++)
		{
			System.out.print(dist.get(i)+" ");
		}
		System.out.println();
		for(int i=0;i<N;i++)
		{
			System.out.print(prev[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		int N=a.nextInt();
		int[][] graph=new int[N][N];
		ArrayList<ArrayList<Integer>> conn=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> wei=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++)
		{
			conn.add(new ArrayList<Integer>());
			wei.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				graph[i][j]=a.nextInt();
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(graph[i][j]!=0)
				{
					conn.get(i).add(j);
					wei.get(i).add(graph[i][j]);
				}
			}
		}
		int source=a.nextInt();
		Prims(conn,wei,N,source);
	}
}
