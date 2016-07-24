package Task;

public class LList2 implements EList
{
	class Node
	{
		int val;
		Node next = null;
		Node prev = null;
		public Node(int val)
		{
			this.val = val;
		}
	}
	Node first = null;
	Node last = null;

	@Override
	public void clear() 
	{
		first = null;
		last = null;
	}

	@Override
	public void init(int[] ini) 
	{
		if(ini == null)
		{
			ini = new int[0];
		}

		for (int i=0; i<ini.length; i++)
		{
			addEnd(ini[i]);
		}
	}

	@Override
	public int[] toArray() 
	{
		int[] ret = new int[size()];
		Node p = first;
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
		Node p=first;
		for(int i=0;i<size();i++)
		{
			str+=p.val;
			if(i < size()-1)
			{
				str += ",";
			}
			p=p.next;
		}
		return str;
	}

	@Override
	public int size() 
	{
		int count = 0;

		Node p = first;
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
		if(size()==0)
		{
			first = p;
			last = p;
		}
		else
		{
			p.next = first;;
			first = p;
			p.next.prev=p;
		}
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
			Node p = new Node(val);
			p.prev=last;
			p.prev.next=p;
			last=p;
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if(pos<0||pos>size())
		{
			throw new IllegalArgumentException();
		}

		Node p=first;
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
			if(p.next==null)
			{
				addEnd(val);
			}
			else
			{
				Node obj=new Node(val);
				obj.next=p.next;
				obj.prev=p;
				p.next=obj;
				obj.next.prev=obj;
			}
		}
	}

	@Override
	public int delStart() 
	{
		if(size()==0)
		{
			throw new IllegalArgumentException(); 
		}

		Node p = first;
		if(size()==1)
		{
			int rez=p.val;
			clear();
			return rez;
		}
		else
		{
			int rez=p.val;
			p.next.prev=null;
			first=p.next;
			return rez;
		}
	}

	@Override
	public int delEnd() 
	{
		if(size()==0)
		{
			throw new IllegalArgumentException(); 
		}

		if(size()==1)
		{
			return delStart();
		}
		else
		{
			Node p=last;
			int rez=p.val;
			last=p.prev;
			p.prev.next=null;
			return rez;
		}
	}

	@Override
	public int delPos(int pos) 
	{
		if(pos<0||pos>size()||size()==0)
		{
			throw new IllegalArgumentException(); 
		}

		int rez=0;
		Node p=first;
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
			if(p.next.next==null)
			{
				rez=p.next.val;
				p.next=p.next.next;
				last=p;
			}
			else
			{
				rez=p.next.val;
				p.next=p.next.next;
				p.next.prev=p;
			}
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

		Node p=last;
		int min = p.val;
		while(p!=null)
		{
			if(p.val<min)
			{
				min=p.val;
			}
			p=p.prev;
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

		Node p=last;
		int max = p.val;
		while(p!=null)
		{
			if(p.val>max)
			{
				max=p.val;
			}
			p=p.prev;
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

		Node p=first;
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

		Node p=first;
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
		Node p=first;
		for(int i=0;i<size();i++,p=first)
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
		Node p=first;
		Node o=last;
		for(int i=0;i<size()/2;i++,p=p.next,o=o.prev)
		{
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
		Node p=first;
		Node o=first;
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
		
		Node p=first;
		for(int i=0;i<pos;i++)
		{
			p=p.next;
		}
		return p.val;
	}

	@Override
	public void set(int pos, int val) 
	{
		if(pos<0||pos>size())
		{
			throw new IllegalArgumentException();
		}
		Node p=first;
		for(int i=0;i<pos;i++)
		{
			p=p.next;
		}
		p.val=val;
	}
}
