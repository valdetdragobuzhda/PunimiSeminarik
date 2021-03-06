/** AppointmentKey models  a string key */
public class AppointmentKey
{ private String k;   // the string key
  
  /** Constructor AppointmentKey constructs the Key
    * @param i - the string that uniquely defines the key */
  public  AppointmentKey(String i)
  {k = i;}
  
  /** equals compares this Key to another for equality
    * @param c - the other key
    * @return true, if this key equals k's; return false, otherwise */
  public boolean equals(AppointmentKey c)
  {return (k.equals(c.getString())); }
  
  /** getString returns the string value held within this key */
  public String getString()
  {return k;}     
}