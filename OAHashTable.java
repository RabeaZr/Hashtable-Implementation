// Rabeea Azreik - 211710124 - rabeeaazreik -----  Guy Gavriely - 323832204 - guygavriely
public abstract class OAHashTable implements IHashTable {

	protected HashTableElement [] table;
	protected int size; // represents the amount of HashTableElements in table
	protected static HashTableElement deleted = new HashTableElement(69,69); // a special value that means something was deleted in some index

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.size = 0; // sets size field to zero
	}

	@Override
	public HashTableElement Find(long key)
	{ // if exists returns the HashTableElement that upholds HashTableElement.getKey() = key.
		// returns null if no such HashTableElement exists.
		int index;
		for(int i = 0; i<this.table.length;i++)
		{
			index = Hash(key, i);
			if(this.table[index]==null)
			{
				break; // onec we get to null, we know for sure that there is no such HashTableElement
			}
			else // if its not null, check if we found the right HashTableElement we want.
			{
				if(this.table[index]!=deleted)
				{
					if(this.table[index].GetKey()==key)
					{
						return this.table[index];
					}
				}
			}
		}
		return null; // we didnt find the requested HashTableElement.
	}

	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		// inserts HashTableElement into the table.
		// throws TableIsFullException if there is no room to insert hte.
		// throws KeyAlreadyExistsException if there is a HashTableElement in table with the same key as hte
		if(this.size == this.table.length)
		{
			throw new TableIsFullException(hte);
		}
		if(Find(hte.GetKey())!=null)
		{
			throw new KeyAlreadyExistsException(hte);
		}

		int index;
		boolean flag = false; // if flag = false by the end of the insert method, that means we didnt insert hte into the table.
		for(int i = 0; i < this.table.length;i++)
		{
			index = Hash(hte.GetKey(), i);

			if((this.table[index]==null)||(this.table[index]==deleted))
			{
				this.table[index] = hte;
				flag = true; // we need to remember that we inserted hte to the table.
				break;
			}
		}
		this.size++; // inscrease the size of table
		if(flag == false) // if flag = false that means we did, and that means hte can not be inserted because theres no room for it.
		{
			throw new TableIsFullException(hte);
		}
	}

	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		// deletes the HashTableElement that satisfies HashTableElement.getKey() = key
		HashTableElement ToDelete = Find(key); // first we need to check if HashTableElement with that key exist
		if(ToDelete == null)
		{
			throw new KeyDoesntExistException(key);
		}
		int index;
		for(int i = 0; i <this.table.length ;i++)
		{
			index = Hash(key, i);
			if((table[index]!=deleted)&&((this.table[index].GetKey()==key)))
			{
				this.table[index] = deleted;
				break;
			}
		}
		this.size--; // lower the size of table
	}

	/**
	 *
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}