import java.util.*;
import javax.swing.*;
/** Purchase models a Purchase with an identification key. */
public class Purchase
{ private CustomerKey id_number;
  private int[] items;              // id number of the items
  private int[] quantities;         // quantity of each item
  public boolean payed;            
  private String payment;
  private String date;
  private int date2;
    
  /** Constructor Purchase constructs the Purchase
    * @param key - the Purchaser's id number
    * @param payment - the type of payment */
  public Purchase(CustomerKey key, String p, boolean b)
  { id_number = key;
    items = new int[10];
    quantities = new int[10];
    GregorianCalendar c = new GregorianCalendar();
    date = "" + c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
              + c.get(Calendar.YEAR) + "  " + c.get(Calendar.HOUR) + ":"
              + c.get(Calendar.MINUTE);
    String d = "" + c.get(Calendar.DAY_OF_MONTH) + "" + (c.get(Calendar.MONTH) + 1) + ""
                  + c.get(Calendar.YEAR) + "" + c.get(Calendar.HOUR) + ""
                  + c.get(Calendar.MINUTE); 
    date2 = new Integer(d).intValue();
    payment = p;
    payed = b;
  }
  
  /** Default Constructor constructs an empty Purchase */
  public Purchase()
  {}
  
  /** add adds an Item at Purchase
    * @param key - the id number of the Item to be added
    * @param quantity - the quantity of Item
    * @return - true, if the Item is added successfully; false, otherwise */
  public boolean add(InventoryKey key, int quantity)
  { boolean success = false;
    if(key.getInt() > 0 && quantity > 0)
      {boolean found_empty_place = false;
       int i = 0;
       while(!found_empty_place && i < items.length)
            { if(items[i] == 0)
                {found_empty_place = true;}
              else{i = i + 1;}    
            }
        if(found_empty_place)
          {items[i] = key.getInt();
           quantities[i] = quantity;} 
        else{int[] temp1 = new int[items.length * 2];
             int[] temp2 = new int[items.length * 2];
             for(int j = 0; j != items.length; j++)
                {temp1[j] = items[j];
                 temp2[j] = quantities[j];
                }
             temp1[items.length] = key.getInt();
             temp2[items.length] = quantity;   
             items = temp1;
             quantities = temp2;
            }      
        success = true;    
      }
   else{JOptionPane.showMessageDialog(null,"Purchase error: bad amount or wrong key");}
   return success;   
  }
  
  /** changeQuantity changes the quantity of Item 
   * @param key - the id number of Item
   * @param new_quantity - the new quantity
   * @return - true, if quantity successfully changed; false, otherwise */
  public boolean changeQuantity(InventoryKey key, int new_quantity)
  { boolean item_found = false;
    if(new_quantity <= 0)
      { JOptionPane.showMessageDialog(null,"change quantity error: bad amount");}
    else{int i = 0;
         while(!item_found && i != items.length)
              { if(items[i] == key.getInt())
                  {item_found = true;}
                else{i = i + 1;}   
              }
         if(item_found)
           {quantities[i] = new_quantity;}
         else{JOptionPane.showMessageDialog(null,"Item not found");}
        }
    return item_found;
  }
  
  /** delete deletes an Item form Purchase
    * @param key - the id number of Item to bo deleted
    * @return - true, if the Item is successfully deleted; false, otherwise */
  public boolean delete(InventoryKey key)
  { boolean item_found = false;
    int i = 0;
    while(!item_found && i != items.length)
         { if(items[i] == key.getInt())
             {item_found = true;}
           else{i = i + 1;}   
         }
    if(item_found)
      {items[i] = 0;
       quantities[i] = 0;} 
    else{JOptionPane.showMessageDialog(null,"Item not found");}
    return item_found;       
  }       
  
  /** showPurchase shows Items and quantities of Purchase */
  public void showOrder()
  { System.out.println("Items ordered and quantities:" + "\n");
    for(int i = 0; i != items.length; i++)
       {System.out.println("Item " + i + ": " + items[i] 
                            + " : " + quantities[i] + " pcs");}
  }   
  
  /** getKey returns the key of Purchase
    * @return - the key */
  public CustomerKey getKey() {return id_number;}
  
  /** getItems returns the id numbers of Items
    * @return - the id numbers */
  public int[] getItems() {return items;}
  
  /** getQuantities returns the quantities of Items
    * @return - the quantities */
  public int[] getQuantities() {return quantities;}
  
  /** getPayment returns the means of payment
    * @return - the payment */
  public String getPayment() {return payment;}
  
  /** getDate2 returns the date of Purchase
    * @return - the date */
  public int getDate2() {return date2;}

  
  /** getDate returns the date of Purchase
    * @return - the date */
  public String getDate() { return date;}
  
  /** getPayed tells if the Purchase is payed
    * @return - true,if the purchase is payed; false, otherwise */
  public boolean getPayed() {return payed;}  
}