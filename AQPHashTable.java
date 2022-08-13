// Rabeea Azreik - 211710124 - rabeeaazreik -----  Guy Gavriely - 323832204 - guygavriely

public class AQPHashTable extends OAHashTable {
	private ModHash mod; // this is our hash function
	//  constructor.
	public AQPHashTable(int m, long p) {
		super(m);
		this.mod = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		// returns the value of the hash function when calculated with key = x and i
		if(i%2==0)
		{
			return Math.floorMod((this.mod.Hash(x)+i*i), this.table.length);
		}
		return Math.floorMod((this.mod.Hash(x)+(-1)*i*i), this.table.length);
	}
}