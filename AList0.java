package Task;

public class AList0 implements EList 
{
	public int[] ar={};

	@Override
	public void clear()
	{
		ar=new int[0];
	}
	
	@Override
	public void init(int[]ini)
	{
		if(ini==null)
		{
			return;
		}
		ar=new int[ini.length];
		for(int i=0;i<ini.length;i++)
		{
			ar[i]=ini[i];
		}
	}
	
	@Override
	public int[] toArray()
	{
		int[] tmp=new int[ar.length];
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
		for(int i=0;i<ar.length;i++)
		{
			str+=ar[i];
			if(i < ar.length -1)
				str += ",";
		}
		return str;
	}
	
	@Override
	public int size()
	{
		return ar.length;
	}
	
	@Override
	public void addStart(int val)
	{
		int[] tmp=new int[ar.length+1];
		for(int i=1;i<tmp.length;i++)
		{
			tmp[i]=ar[i-1];
		}
		tmp[0]=val;
		ar=tmp;
	}
	
	@Override
	public void addEnd(int val)
	{
		int[] tmp=new int[ar.length+1];
		for(int i=0;i<ar.length;i++)
		{
			tmp[i]=ar[i];
		}
		tmp[ar.length]=val;
		ar=tmp;
	}
	
	@Override
	public void addPos(int pos,int val)
	{
		if(pos<0||pos>ar.length)
		{
			throw new IllegalArgumentException();
		}
		int[] tmp=new int[ar.length+1];
		for(int i=0;i<pos;i++)
		{
			tmp[i]=ar[i];
		}
		for(int i=pos+1;i<tmp.length;i++)
		{
			tmp[i]=ar[i-1];
		}
		tmp[pos]=val;
		ar=tmp;
	}
	
	@Override
	public int delStart()
	{
		if(ar.length==0)
		{
			throw new IllegalArgumentException();
		}
		int rez=ar[0];
		int[] tmp=new int[ar.length-1];
		for(int i=0;i<tmp.length;i++)
		{
			tmp[i]=ar[i+1];
		}
		ar=tmp;
		return rez;
	}
	
	@Override
	public int delEnd()
	{
		if(ar.length==0)
		{
			throw new IllegalArgumentException();
		}
		int rez=ar[ar.length-1];
		int[] tmp=new int[ar.length-1];
		for(int i=0;i<tmp.length;i++)
		{
			tmp[i]=ar[i];
		}
		ar=tmp;
		return rez;
	}
	
	@Override
	public int delPos(int pos)
	{
		if(ar.length==0||pos<0||pos>=ar.length)
		{
			throw new IllegalArgumentException();
		}
		int rez=ar[pos];
		int[] tmp=new int[ar.length-1];
		for(int i=0;i<pos;i++)
		{
			tmp[i]=ar[i];
		}
		for(int i=pos;i<tmp.length;i++)
		{
			tmp[i]=ar[i+1];
		}
		ar=tmp;
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
		if(ar.length == 0)
		{
			throw new IllegalArgumentException();
		}
		int rez=0;
		int min=ar[0];
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i]<min)
			{
				min=ar[i];
				rez=i;
			}	
		}
		return rez;
	}
	
	@Override
	public int maxPos()
	{
		if(ar.length == 0)
		{
			throw new IllegalArgumentException();
		}
		int rez=0;
		int max=ar[0];
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i]>max)
			{
				max=ar[i];
				rez=i;
			}	
		}
		return rez;
	}
	
	@Override
	public void sort()
	{
		if(ar.length == 0)
		{
			return;
		}
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar.length-i-1;j++)
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
		if(ar.length == 0)
		{
			return;
		}
		for(int i=0;i<ar.length/2;i++)
		{
			int tmp=ar[i];
			ar[i]=ar[ar.length-1-i];
			ar[ar.length-1-i]=tmp;
		}
	}
	
	@Override
	public void halfreverse()
	{
		if(ar.length == 0)
		{
			return;
		}
		int dx = (ar.length %2 == 0) ? 0 : 1;
		for(int i =0,s=ar.length/2;i<ar.length/2;i++,s++)
		{
			int tmp=ar[i];
			ar[i]=ar[s+dx];
			ar[s+dx]=tmp;
		}
	}
	
	@Override
	public int get(int pos)
	{
		if(pos < 0 || pos >= ar.length)
		{
			throw new IllegalArgumentException(); 
		}
		return ar[pos];
	}
	
	@Override
	public void set(int pos,int val)
	{
		if(pos < 0 || pos >= ar.length)
		{
			throw new IllegalArgumentException(); 
		}
		ar[pos]=val;
	}
}

