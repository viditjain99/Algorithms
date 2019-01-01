import java.util.Scanner;
class Node
{
	int data;
	Node left;
	Node right;
	int height;
	public Node()
	{
		data=0;
		left=null;
		right=null;
		height=0;
	}
	public Node(int d)
	{
		data=d;
		height=0;
		left=null;
		right=null;
	}
}
class avl
{
	Node root;
	public avl()
	{
		root=null;
	}
	public boolean empty()
	{
		return root==null;
	}
	public void insert(int data)
	{
		root=insert(data,root);
	}
	private Node insert(int x,Node t)
	{
		if(t==null)
		{
			t=new Node(x);
		}
		else if(x<=t.data)
		{
			t.left=insert(x,t.left);
			if(height(t.left)-height(t.right)==2)
			{
				if(x<t.left.data)
				{
					t=rotateWithLeftChild(t);
				}
				else
				{
					t=doubleWithLeftChild(t);
				}
			}
		}
		else if(x>t.data)
		{
			t.right=insert(x,t.right);
			if(height(t.right)-height(t.left)==2)
			{
				if(x>t.right.data)
				{
					t=rotateWithRightChild(t);
				}
				else
				{
					t=doubleWithRightChild(t);
				}
			}
			else
				;
			t.height=max(height(t.left),height(t.right))+1;
		}
		return t;
	}
	private Node rotateWithLeftChild(Node k2)//right
	{
		Node k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k2.height=max(height(k2.left),height(k2.right))+1;
		k1.height=max(height(k1.left),k2.height)+1;
		return k1;
	}
	private Node rotateWithRightChild(Node k1)//left
	{
		Node k2=k1.right;
		k1.right=k2.left;
		k2.left=k1;
		k1.height=max(height(k1.left),height(k1.right))+1;
		k2.height=max(height(k2.right),k1.height)+1;
		return k2;
	}
	private Node doubleWithLeftChild(Node k3)//lr
	{
		k3.left=rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	private Node doubleWithRightChild(Node k1)//rl
	{
		k1.right=rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	public int countnodes(Node r)
	{
		if(r==null)
		{
			return 0;
		}
		else
		{
			int l=1;
			l+=countnodes(r.left);
			l+=countnodes(r.right);
			return l;
		}
	}
	public boolean search(int val)
	{
		return search(root,val);
	}
	private boolean search(Node r,int val)
	{
		boolean found=false;
		while(r!=null && !found)
		{
			if(val<r.data)
			{
				return search(r.left,val);
			}
			else if(val>r.data)
			{
				return search(r.right,val);
			}
			else
			{
				found=true;
				break;
			}
		}
		return found;
	}
	public void inorder()
	{
		inorder(root);
	}
	private void inorder(Node r)
	{
		if(r!=null)
		{
			inorder(r.left);
			System.out.print(r.data+" ");
			inorder(r.right);
		}
	}
	public void postorder()
	{
		postorder(root);
	}
	private void postorder(Node r)
	{
		if(r!=null)
		{
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.data+" ");
		}
	}
	public void preorder()
	{
		preorder(root);
	}
	private void preorder(Node r)
	{
		if(r!=null)
		{
			System.out.print(r.data+" ");
			preorder(r.left);
			preorder(r.right);
		}
	}
	private int height(Node t)
	{
		if(t==null)
		{
			return -1;
		}
		else
		{
			return t.height;
		}
	}
	private int max(int lhs,int rhs)
	{
		if(lhs>rhs)
		{
			return lhs;
		}
		else
		{
			return rhs;
		}
	}
}
public class avl_tree
{
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		avl A=new avl();
		int ch;
		do
		{
			System.out.println();
			System.out.println("1.Insert");
			System.out.println("2.Display in inorder");
			System.out.println("3.Display in preorder");
			System.out.println("4.Display in postorder");
			System.out.println("5.Search");
			System.out.println("6.Count Nodes");
			System.out.println("7.Quit");
			System.out.print("Enter your choice: ");
			ch=a.nextInt();
			System.out.println();
			switch(ch)
			{
				case 1:
					System.out.print("Enter the number: ");
					int num=a.nextInt();
					A.insert(num);
					break;
				case 2:
					A.inorder();
					break;
				case 3:
					A.preorder();
					break;
				case 4:
					A.postorder();
					break;
				case 5:
					System.out.print("Enter the number: ");
					num=a.nextInt();
					System.out.println(A.search(num));
					break;
				case 6:
					System.out.println(A.countnodes(A.root));
					break;
			}
		}while(ch!=7);
	}
}

	
