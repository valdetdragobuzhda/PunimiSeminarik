import javax.swing.*;
import java.util.*;
/** Purchaser models a Purchaser with an identification number */
public class Customer
{ private CustomerKey id_number;
  private String name;
  private String address; // street, house number, and city
  private Purchase[] unpayed;
  private Purchase[] purchase;
  private int[] date; 
  
  public Customer(CustomerKey key, String n, String a)
  { id_number = key;
    name = n; 
    address = a;
    unpayed = new Purchase[100];
    purchase = new Purchase[100];
    date = new int[100];
  }

  public void addPurchase(Purchase p)
  { boolean found_empty_place = false;
    boolean payed = p.getPayed();
    if(!payed)
      {addToUnpayed(p);}
    else{int i = 0;
         while(!found_empty_place && i < purchase.length)
              { if(purchase[i] == null)
                  {found_empty_place = true;}
                else{i = i + 1;}  
              }
         if ( found_empty_place)
            { purchase[i] = p; 
              date[i] = p.getDate2();
            }
         else{ // array is full!  So, create a new one to hold more records:
               Purchase[] temp1 = new Purchase[purchase.length * 2];
               int[] temp2 = new int[date.length * 2];
               for ( int j = 1;  j != purchase.length;  j = j + 1 )
                   { temp1[j] = purchase[j];  // copy  history  into  temp
                     temp2[j] = date[j];} // copy  history  into  temp
               temp1[purchase.length] = p;   // insert  p  in first free element
               temp2[date.length] = p.getDate2();
               purchase = temp1;   // change  history  to hold address of  temp
               date = temp2; // change  history  to hold address of  temp
             }        
        }
  } 
  
  private void addToUnpayed(Purchase p)
  { boolean found_empty_place = false;
    int i = 0;
    while(!found_empty_place && i < unpayed.length)
         { if(unpayed[i] == null)
             {found_empty_place = true;}
           else{i = i + 1;}  
         }
    if ( found_empty_place)
       { unpayed[i] = p;}
    else{ // array is full!  So, create a new one to hold more records:
         Purchase[] temp = new Purchase[unpayed.length * 2];
         for ( int j = 1;  j != unpayed.length;  j = j + 1 )
             { temp[j] = unpayed[j];}  // copy  history  into  temp
         temp[unpayed.length] = p;   // insert  p  in first free element
         unpayed = temp;   // change  history  to hold address of  temp
        }
  }
  
  public boolean payPurchase(Purchase p)
  { boolean found = false;
    int i = 0;
    while(!found && i < unpayed.length)
         { if(unpayed[i].equals(p))
             {unpayed[i] = null;
              purchase[i].payed = true;
             }
           else{i = i + 1;}  
         }
    if(found)
      {JOptionPane.showMessageDialog(null,"Purchase payed");}
    else{JOptionPane.showMessageDialog(null,"Purchase not found");}       
    return found;
  }
  
  public boolean deletePurchase(Purchase p)
  { boolean found = false;
    int i = 0;
    while(!found && i < purchase.length)
         { if(purchase[i].equals(p))
             {purchase[i] = null;
              date[i] = 0;
              if(unpayed[i].equals(p))
                {unpayed[i] = null;}
             }
           else{i = i + 1;}  
         }
    if(found)
      {JOptionPane.showMessageDialog(null,"Purchase deleted");}
    else{JOptionPane.showMessageDialog(null,"Purchase not found");}       
    return found;
  }
  
  public void showUnpayed()
  { System.out.println("Unpayed Purchases:" + "\n");
    for(int i = 0; i != unpayed.length; i = i + 1)
       {if(unpayed[i] != null)
          {System.out.println(i + ": " + unpayed[i] + "\n");}
       }
  }
  
  public void showHistory()
  { GregorianCalendar c = new GregorianCalendar();
    String date2 = "" + c.get(Calendar.DAY_OF_MONTH) + "" + (c.get(Calendar.MONTH) + 1) + ""
                      + (c.get(Calendar.YEAR)-1) + "" + c.get(Calendar.HOUR) + ""
                      + c.get(Calendar.MINUTE);
    long date = new Long(date2).longValue();
    int index = -1;
    int i = 0;
    while(i < purchase.length)
         {if(purchase[i].getDate2() >= date)          
            {System.out.println("The purchases for the past year:");
             index = i;
             for(int j = index; j < purchase.length; j++)
                {System.out.println("Purchase 1  " + "ID: " 
                 + purchase[index].getKey().getInt() + "\n");}
            }
          else{JOptionPane.showMessageDialog(null,"No purchase made for the past year");}
         }   
  }
  
  /** getKey returns the key that identifies the book
    * @return the key */
  public CustomerKey getKey() {return id_number;} 
  
  /** getTitle returns the title of the book
    * @return the title */
  public String getName() {return name;} 
  
  /** getAuthor returns the author of the book
    * @return the author */
  public String getAddress() {return address;}
}