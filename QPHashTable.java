// Rabeea Azreik - 211710124 - rabeeaazreik -----  Guy Gavriely - 323832204 - guygavriely

public class QPHashTable extends OAHashTable {
	private ModHash mod; // this is our hash function
	public QPHashTable(int m, long p) {
		// constructor.
		super(m);
		this.mod = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		// returns the value of the hash function when calculated with key = x and i
		return Math.floorMod((this.mod.Hash(x)+i*i),this.table.length);
	}
}