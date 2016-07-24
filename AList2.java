package Task;

public class AList2 implements EList
{
	public int[] ar=new int[20];
	int start=0;
	int end=0;

	@Override
	public void clear()
	{
		start=0;
		end=0;
	}

	@Override
	public void init(int[]ini)
	{
		if(ini==null)
		{
			return;
		}
		start=ar.length/2 -ini.length/2;
		end=start+ini.length;
		for(int i=0;i<ini.length;i++)
		{
			ar[i+start]=ini[i];
		}
	}

	@Override
	public int[] toArray()
	{
		int[] tmp=new int[size()];
		for(int i=0;i<tmp.length;i++)
		{
			tmp[i]=ar[i+start];
		}
		return tmp;
	}

	@Override
	public String toString()
	{
		String str="";
		for(int i=start;i<end;i++)
		{
			str+=ar[i];
			if(i < end -1)
				str += ",";
		}
		return str;
	}

	@Override
	public int size()
	{
		return end-start;
	}

	@Override
	public void addStart(int val)
	{
		ar[start-1]=val;
		start--;
	}

	@Override
	public void addEnd(int val)
	{
		ar[end]=val;
		end++;
	}

	@Override
	public void addPos(int pos,int val)
	{
		if(pos<0||pos>size())
		{
			throw new IllegalArgumentException();
		}
		for(int i=end;i>start+pos;i--)
		{
			ar[i]=ar[i-1];
		}
		ar[start+pos]=val;
		end++;
	}

	@Override
	public int delStart()
	{
		if(size()==0)
		{
			throw new IllegalArgumentException();
		}
		int rez=ar[start];
		start++;
		return rez;
	}

	@Override
	public int delEnd()
	{
		if(size()==0)
		{
			throw new IllegalArgumentException();
		}
		end--;
		return ar[end];
	}

	@Override
	public int delPos(int pos)
	{
		if(pos<0||pos>=size())
		{
			throw new IllegalArgumentException();
		}
		end--;
		int rez=ar[start+pos];
		for(int i=start+pos;i<end;i++)
		{
			ar[i]=ar[i+1];
		}
		return rez;
	}

	@Override
	public int min()
	{
		return ar[minPos()+start];
	}

	@Override
	public int max()
	{
		return ar[maxPos()+start];
	}

	@Override
	public int minPos()
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException();
		}
		int rez=start;
		int min=ar[start];
		for(int i=start+1;i<end;i++)
		{
			if(ar[i]<min)
			{
				min=ar[i];
				rez=i;
			}	
		}
		return rez-start;
	}

	@Override
	public int maxPos()
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException();
		}
		int rez=start;
		int max=ar[start];
		for(int i=start+1;i<end;i++)
		{
			if(ar[i]>max)
			{
				max=ar[i];
				rez=i;
			}	
		}
		return rez-start;
	}

	@Override
	public void sort()
	{
		if(size() == 0)
		{
			return;
		}
		for(int i=0;i<size();i++)
		{
			for(int j=start;j<end-i-1;j++)
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
		if(size() == 0)
		{
			return;
		}
		for(int i=start,n=0;i<start+size()/2;i++,n++)
		{
			int tmp=ar[i];
			ar[i]=ar[end-1-n];
			ar[end-1-n]=tmp;
		}
	}

	@Override
	public void halfreverse()
	{
		if(size() == 0)
		{
			return;
		}
		int dx = (size() %2 == 0) ? 0 : 1;
		for(int i =start,s=start+size()/2;i<start+size()/2;i++,s++)
		{
			int tmp=ar[i];
			ar[i]=ar[s+dx];
			ar[s+dx]=tmp;
		}
	}

	@Override
	public int get(int pos)
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException(); 
		}
		return ar[start+pos];
	}

	@Override
	public void set(int pos,int val)
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException(); 
		}
		ar[start+pos]=val;
	}
}
