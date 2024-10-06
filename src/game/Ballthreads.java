package game;

public class Ballthreads extends Thread {
	int[] zid = new int[1];
	int n=0;
	void setzid(int[] zid,int n) {
		this.zid=zid;
		this.n=n;
	}
   @Override
   public void run() {
	   if(n==1)
      zid[0]+=20;
	   else  zid[0]-=20;
   }
}
