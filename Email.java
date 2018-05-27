import java.util.*;
import javax.swing.*;
/** E-mail models an E-mail message with an identification key. */
public class Email 
{ private EmailKey sender;
  private String receiver;
  private String subject;
  private String body;
  
  
  /** Constructor Email constructs an Email 
    * @param key - the sender of Message
    * @param r - the receiver of Message
    * @param s - the subject of Message
    * @param b - the body of the Message
    * @param d - the date of the Message */
  public Email(EmailKey key)
  {sender = key;
   receiver = JOptionPane.showInputDialog("Enter address of receiver");
   subject = JOptionPane.showInputDialog("Enter subject");
   body = JOptionPane.showInputDialog("Write the message");
  }
  
  /** Default Constructor constructs an empty EmailMessage */
  public Email()
  {}
  
  /** sendMail sends an Email 
    * @param key - the address of receiver */
  public void sendEmail(EmailKey key,String r,String s,String b)
  {}
  
  public void receiveEmail(EmailKey key, String sub, String b)
  { sender = key;
    subject = sub;
    body = b;
  }
  
  /** getKey returns the key of EmailMessage
    * @return - the key */
  public EmailKey getKey() {return sender;}
  
  /** getReceiver returns the receiver of Message
    * @return - the address of Receiver */
  public String getReceiver() {return receiver;}
  
  /** getSubject returns the subject of Message
    * @return - the subject */
  public String getSubject() {return subject;}
  
  /** getBody returns the body of Message
    * @return - the Message */
  public String getBody() {return body;}
  
  /** toString shows the string representation of the object 
    * @return - the string format */ 
  public String toString()
  { return "Sender: " + sender.getString() + "\n" +
           "Receiver: " + receiver + "\n" + 
           "Subject: " + subject + "\n" + 
           "Message: " + body + "\n";
  }
} 