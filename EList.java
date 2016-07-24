package Task;

public interface EList 
{
		public void clear();
		public void init(int[]ini);
		public int[] toArray();
		public String toString();
		public int size();
		
		public void addStart(int val);
		public void addEnd(int val);
		public void addPos(int pos,int val);
		public int delStart();
		public int delEnd();
		public int delPos(int pos);
		
		public int min();
		public int max();
		public int minPos();
		public int maxPos();
	
		public void sort();
		public void reverse();
		public void halfreverse();

		public int get(int pos);
		public void set(int pos,int val);
}
