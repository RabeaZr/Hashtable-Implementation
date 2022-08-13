// Rabeea Azreik - 211710124 - rabeeaazreik -----  Guy Gavriely - 323832204 - guygavriely
public class ModHash {
	private long a;
	private long b;
	private int m;
	private long p;

	public ModHash(long a, long b , int m, long p)
	{
		this.a = a;
		this.b = b;
		this.m = m;
		this.p = p;
	}

	public static ModHash GetFunc(int m, long p){
		long a = 1 + (long)Math.floor((Math.random() * (p - 1)));
		long b = (long)Math.floor((Math.random() * p));
		ModHash RetFunc = new ModHash(a,b,m,p);
		return RetFunc; // return a random hash function
	}

	public int Hash(long key) {
		// calculate hash(key) and return
		return (int) Math.floorMod(Math.floorMod(a*key+b,p),m);
	}
}