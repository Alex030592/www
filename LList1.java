package Task;

public class LList1 implements EList
{
	class Node
	{
		int val;
		Node next = null;
		public Node(int val)
		{
			this.val = val;
		}
	}

	Node root = null;

	@Override
	public void clear() 
	{
		root = null;
	}

	@Override
	public void init(int[] ini) 
	{
		if(ini == null)
		{
			ini = new int[0];
		}

		for (int i = ini.length - 1; i >= 0 ; i--)
		{
			addStart(ini[i]);
		}
	}

	@Override
	public int[] toArray() 
	{
		int[] ret = new int[size()];
		Node p = root;
		for (int i = 0; i < ret.length; i++) 
		{
			ret[i] = p.val;
			p = p.next;
		}
		return ret;
	}

	@Override
	public String toString()
	{
		String str="";
		Node p=root;
		for(int i=0;i<size();i++,p=p.next)
		{
			str+=p.val;
			if(i < size() -1)
				str += ",";
		}
		return str;
	}

	@Override
	public int size() 
	{
		int count = 0;

		Node p = root;
		while( p != null )
		{
			count++;
			p = p.next;
		}
		return count;
	}

	@Override
	public void addStart(int val) 
	{
		Node p = new Node(val);
		p.next = root;
		root = p;
	}

	@Override
	public void addEnd(int val) 
	{
		if(size()==0)
		{
			addStart(val);
		}
		else
		{
			Node p=root;
			while(p.next!=null)
			{
				p=p.next;
			}
			p.next=new Node(val);
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if(pos<0||pos>size())
		{
			throw new IllegalArgumentException();
		}
		
		Node p=root;
		if(pos==0)
		{
			addStart(val);
		}
		else
		{
			for(int i=1;i<pos;i++)
			{
				p=p.next;
			}

			Node obj=new Node(val);
			obj.next=p.next;
			p.next=obj;
		}
	}

	@Override
	public int delStart() 
	{
		if(size()==0)
		{
			throw new IllegalArgumentException(); 
		}

		Node p = root;
		int rez=p.val;
		root=p.next;
		return rez;
	}

	@Override
	public int delEnd() 
	{
		if(size()==0)
		{
			throw new IllegalArgumentException(); 
		}

		Node p=root;
		int rez=0;
		if(size()==1)
		{
			return delStart();
		}
		else
		{
			for(int i=1;i<size()-1;i++)
			{
				p=p.next;
			}
			rez = p.next.val;
			p.next=null;
		}
		return rez;
	}

	@Override
	public int delPos(int pos)
	{
		if(pos<0||pos>size()||size()==0)
		{
			throw new IllegalArgumentException(); 
		}

		int rez=0;
		Node p=root;
		if(pos==0)
		{
			return delStart();
		}
		else
		{
			for(int i=1;i<pos;i++)
			{
				p=p.next;
			}
			rez=p.next.val;
			p.next=p.next.next;
		}
		return rez;
	}

	@Override
	public int min() 
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException();
		}

		Node p=root;
		int min = p.val;
		while(p!=null)
		{
			if(p.val<min)
			{
				min=p.val;
			}
			p=p.next;
		}
		return min;
	}

	@Override
	public int max() 
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException();
		}

		Node p=root;
		int max = p.val;
		while(p!=null)
		{
			if(p.val>max)
			{
				max=p.val;
			}
			p=p.next;
		}
		return max;
	}

	@Override
	public int minPos() 
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException();
		}

		Node p=root;
		int min = p.val;
		int rez=0;
		for(int i=0;i<size();i++)
		{
			if(p.val<min)
			{
				min=p.val;
				rez=i;
			}
			p=p.next;
		}
		return rez;
	}

	@Override
	public int maxPos() 
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException();
		}

		Node p=root;
		int max = p.val;
		int rez=0;
		for(int i=0;i<size();i++)
		{
			if(p.val>max)
			{
				max=p.val;
				rez=i;
			}
			p=p.next;
		}
		return rez;
	}

	@Override
	public void sort() 
	{
		if(size() == 0)
		{
			return;
		}
		Node p=root;
		for(int i=0;i<size();i++,p=root)
		{
			for(int j=0;j<size()-i-1;j++,p=p.next)
			{
				if(p.val>p.next.val)
				{
					int tmp=p.val;
					p.val=p.next.val;
					p.next.val=tmp;
				}
			}
		}
	}

	@Override
	public void reverse() 
	{
		if(size() == 0)
		{
			return;
		}
		Node p=root;
		Node o=root;
		for(int i=0;i<size()/2;i++,p=p.next)
		{
			o=root;
			for(int j=1;j<size()-i;j++)
			{
				o=o.next;
			}
			int tmp=p.val;
			p.val=o.val;
			o.val=tmp;
		}
	}

	@Override
	public void halfreverse() 
	{
		if(size() == 0)
		{
			return;
		}
		Node p=root;
		Node o=root;
		int dx = (size() %2 == 0) ? 0 : 1;
		for(int j=1;j<=size()/2+dx;j++)
		{
			o=o.next;
		}
		for(int i =0;i<size()/2;i++,p=p.next,o=o.next)
		{
			int tmp=p.val;
			p.val=o.val;
			o.val=tmp;
		}
	}

	@Override
	public int get(int pos) 
	{
		if(pos<0||pos>size())
		{
			throw new IllegalArgumentException();
		}

		int rez;
		Node p=root;

		for(int i=1;i<=pos;i++)
		{
			p=p.next;
		}
		rez=p.val;
		return rez;
	}

	@Override
	public void set(int pos, int val) 
	{
		if(pos < 0 || pos >= size())
		{
			throw new IllegalArgumentException(); 
		}
		
		Node p=root;
		for(int i=1;i<=pos;i++)
		{
			p=p.next;
		}
		p.val=val;
	}
}
