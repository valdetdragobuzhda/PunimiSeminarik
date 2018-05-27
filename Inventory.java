import javax.swing.*;
/** Inventory models an Inventory with an identification key. */
public class Inventory
{ private InventoryKey id_number;
  private String name;
  private double wholesale_price;
  private double retail_price;
  private int quantity;
  private String expiration_date; 
  private String origin;
  
  /** Constructor Invetory constructs the Inventory 
    * @param key - the Inventory's id number 
    * @param n - the Inventory's name
    * @param o - the Inventory's origin
    * @param w - the Inventory's wholesale price 
    * @param r - the Inventory's retail price
    * @param q - the Inventory's quantity
    * @param e - the Inventory's expiration date */
  public Inventory(InventoryKey key, String n, double w,
                   double r, int q, String e, String o) 
  { id_number = key;
    name = n;
    wholesale_price = w;
    retail_price = r;
    quantity = q;
    expiration_date = e;
    origin = o;
  }
  
  /** Default Constructor constructs an empty inventory */
  public Inventory()
  {}
  
  /** sell sells amount from Inventory
    * @param num - the quantity to be sold 
    * @return - true if the quantity was sold successfully; false ,otherwise. */
  public boolean  sell(int num)
  { boolean sell = false;
    if(num <= 0)
      { String answer = "sell error: bad amount requested";
        JOptionPane.showMessageDialog(null,answer);
        throw new RuntimeException(answer);}
    else{ if(num > quantity)
            { String answer = "sell error: amount exceeds quantity";
              JOptionPane.showMessageDialog(null,answer);
              throw new RuntimeException(answer);}
          else{ quantity = quantity - num;
                sell = true;
              }  
        }
    return sell;     
  }
  
  /** add adds amount to Inventory
    * @param amount - the quantity to be added 
    * @return - true if the quantity was added successfully; false ,otherwise. */
  public boolean add(int amount)
  { boolean add = false;
    if(amount <= 0)
      { String answer = "add error: bad amount";
        JOptionPane.showMessageDialog(null,answer);
        throw new RuntimeException(answer);}
    else{quantity = quantity + amount;
         add = true;}
    return add;        
  }
  
  //getters
  
  /** getKey returns the key that identifies the inventory
    * @return - the key */
  public InventoryKey getKey() {return id_number;}
  
  /** getName returns the name of the inventory
    * @return - the name */
  public String getName() {return name;}
  
  /** getOrigin returns the origin of the inventory
    * @return - the origin */
  public String getOrigin() {return origin;}
  
  /** getWholsalePrice returns the wholesale price of the Inventory
    * @return - the wholesale price */
  public double getWholesalePrice() {return wholesale_price;}
  
  /** getRetailPrice returns the retail price of the Inventory
    * @return - the retail price */
  public double getRetailPrice() {return retail_price;}
  
  /** getQuantity returns the quantity of the Inventory
    * @return - the quantity */
  public int getQuantity() {return quantity;}
  
  /** getExpirationDate returns the expiration date of the Inventory
    * @return - the expiration date */
  public String getExpirationDate() {return expiration_date;}
  
  /** toString shows the string representation of the object 
    * @return - the string format */
  public String toString()
  {return "Inventory Number: " + id_number.getInt() + "\n" +
          "Name: " + name + "\n" + 
          "Wholesale Price: " + wholesale_price + "\n" + 
          "Retail Price: " + retail_price + "\n" + 
          "Quantity: " + quantity + "\n" +
          "Expiration Date: " + expiration_date + "\n" + 
          "Origin: " + origin + "\n";
  }
}