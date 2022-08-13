// Rabeea Azreik - 211710124 - rabeeaazreik -----  Guy Gavriely - 323832204 - guygavriely

public class DoubleHashTable extends OAHashTable {
	private ModHash mod1;
	private ModHash mod2;
	public DoubleHashTable(int m, long p) {
		super(m);
		this.mod1 = ModHash.GetFunc(m, p);
		this.mod2 = ModHash.GetFunc(m-1, p);
	}

	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((this.mod1.Hash(x)+i*(this.mod2.Hash(x)+1)),this.table.length);
	}
}


