package Task;

public class AList1 implements EList
{
	public int[] ar=new int[10];
	int index=0;

	@Override
	public void clear()
	{
		index=0;
	}
	
	@Override
	public void init(int[]ini)
	{
		if(ini==null)
		{
			return;
		}
		for(int i=0;i<ini.length;i++)
		{
			ar[i]=ini[i];
		}
		index=ini.length;
	}
	
	@Override
	public int[] toArray()
	{
		int[] tmp=new int[index];
		for(int i=0;i<tmp.length;i++)
		{
			tmp[i]=ar[i];
		}
		return tmp;
	}
	
	@Override
	public String toString()
	{
		String str="";
		for(int i=0;i<index;i++)
		{
			str+=ar[i];
			if(i < index -1)
				str += ",";
		}
		return str;
	}
	
	@Override
	public int size()
	{
		return index;
	}
	
	@Override
	public void addStart(int val)
	{
		for (int i = index;i > 0;i--)
		{
			ar[i]=ar[i-1];
		}
		ar[0] = val;
		index++;
	}
	
	@Override
	public void addEnd(int val)
	{
		ar[index]=val;
		index++;
	}
	
	@Override
	public void addPos(int pos,int val)
	{
		for(int i=index;i>pos;i--)
		{
			ar[i]=ar[i-1];
		}
		ar[pos]=val;
		index++;
	}
	
	@Override
	public int delStart()
	{
		if(index==0)
		{
			throw new IllegalArgumentException();
		}
		index--;
		int rez=ar[0];
		int[] tmp=new int[ar.length];
		for(int i=0;i<index;i++)
		{ 
			tmp[i]=ar[i+1];
		}
		ar=tmp;
		return rez;
	}
	
	@Override
	public int delEnd()
	{
		if(index==0)
		{
			throw new IllegalArgumentException();
		}
		index--;
		return ar[index];
	}
	
	@Override
	public int delPos(int pos)
	{
		if(index==0)
		{
			throw new IllegalArgumentException();
		}
		int rez=ar[pos];
		for(int i=pos;i<index-1;i++)
			{
				ar[i]=ar[i+1];
			}
		index--;
		return rez;
	}
	
	@Override
	public int min()
	{
		return ar[minPos()];
	}
	
	@Override
	public int max()
	{
		return ar[maxPos()];
	}
	
	@Override
	public int minPos()
	{
		if(index == 0)
		{
			throw new IllegalArgumentException();
		}
		int x=0;
		int min=ar[0];
		for(int i=1;i<index;i++)
		{
			if(ar[i]<min)
			{
				min=ar[i];
				x=i;
			}	
		}
		return x;
	}
	
	@Override
	public int maxPos()
	{
		if(index == 0)
		{
			throw new IllegalArgumentException();
		}
		int x=0;
		int max=ar[0];
		for(int i=1;i<index;i++)
		{
			if(ar[i]>max)
			{
				max=ar[i];
				x=i;
			}	
		}
		return x;
	}
	
	@Override
	public void sort()
	{
		if(index == 0)
		{
			return;
		}
		for(int i=0;i<index;i++)
		{
			for(int j=0;j<index-i-1;j++)
			{
				if(ar[j]>ar[j+1])
				{
					int tmp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=tmp;
				}
			}
		}
	}
	
	@Override
	public void reverse()
	{
		if(index == 0)
		{
			return;
		}
		for(int i=0;i<index/2;i++)
		{
			int tmp=ar[i];
			ar[i]=ar[index-1-i];
			ar[index-1-i]=tmp;
		}
	}
	
	@Override
	public void halfreverse()
	{
		if(index == 0)
		{
			return;
		}
		int dx = (index %2 == 0) ? 0 : 1;
		for(int i =0,s=index/2;i<index/2;i++,s++)
		{
			int tmp=ar[i];
			ar[i]=ar[s+dx];
			ar[s+dx]=tmp;
		}
	}
	
	@Override
	public int get(int pos)
	{
		if(index == 0)
		{
			throw new IllegalArgumentException(); 
		}
		return ar[pos];
	}
	
	@Override
	public void set(int pos,int val)
	{
		if(index == 0)
		{
			throw new IllegalArgumentException(); 
		}
		ar[pos]=val;
	}
}
