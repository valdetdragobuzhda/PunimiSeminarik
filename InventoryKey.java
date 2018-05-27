/** InventoryKey models  an integer key */
public class InventoryKey
{ private int k;   // the integer key
  
  /** Constructor InventoryKey constructs the Key
    * @param i - the integer that uniquely defines the key */
  public InventoryKey(int i)
  {k = i;}
  
  /** equals compares this Key to another for equality
    * @param c - the other key
    * @return true, if this key equals k's; return false, otherwise */
  public boolean equals(InventoryKey c)
  {return (k == c.getInt()); }
  
  /** getInt returns the integer value held within this key */
  public int getInt()
  {return k;}     
}