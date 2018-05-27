import javax.swing.*;
/** Appointment models an Appointment with an identification key. */
public class Appointment
{ private AppointmentKey date; //the date of appointment
  private boolean[] time;      // time will be saved in array 
                               // with indexes' numbers representing the hours
  private String[] topic;
  private String[] client;
  
  /** Constructor Appointment constructs the Appointment
    * @param key - the Appointment's date */
  public Appointment(AppointmentKey key)
  { date = key;
    time = new boolean[16];
    topic = new String[16];
    client = new String[16];
  }  

  /** Default Constructor constructs an empty Appointment */
  public Appointment()
  {}
  
  /** makeAppointment makes an Appointment
    * @param t - the desired hour for the appointment 
    * @param client - the client's name
    * @param topic - the topic of the Appointment 
    * @return - true, if the Appointment is made successfully; false, otherwise */ 
  public boolean makeAppointment(int t, String c, String tp)
  { String answer = "makeAppointment error: time must be in range 8-16";
    boolean booked = false;
    if(t < 8 || t > 15)
      {JOptionPane.showMessageDialog(null,answer);
       throw new RuntimeException(answer);}
    else{ boolean found_empty_place = false; 
          if(time[t] == false)  // false means the appointment is free
            {found_empty_place = true;
             time[t] = true;
             client[t] = c;
             topic[t] = tp;
             booked = true;
            }  
          else{ JOptionPane.showMessageDialog(null,
                "Sorry Appointment " + t + " O'clock is taken");
                boolean available = false;
                int i = 8;
                while(!available && i < time.length)
                     { if(time[i] == false)
                         {available = true;
                          JOptionPane.showMessageDialog(null,
                          "Appointment: " + i + " O'clock is free");}
                       else{ i = i + 1;}
                     }
              } 
        }       
    return booked;
  }
  
  /** cancelAppointment cancels an Appointment
    * @param t - the time of the Appointment to be canceled
    * @return - true, if the Appointment is canceled successfully; false, otherwise */
  public boolean cancelAppointment(int t)
  { String answer = "cancelAppointment error: time must be in range 8-16";
    boolean canceled = false;
    if(t < 8 || t > 15)
      {JOptionPane.showMessageDialog(null,answer);
       throw new RuntimeException(answer);}
    else{ time[t] = false;
          topic[t] = null;
          client[t] = null;
          canceled = true;
        }
    return canceled;    
  }
  
  /** changeAppointment changes an Appointment
    * @param a - the old Appointment(date)
    * @param time - the time of the Appointment to be canceled
    * @param b - the new Appointment(date)
    * @param new_time - the time to make the new Appointment
    * @return - true, if the Appointment is changed successfully; false, otherwise */
  public boolean changeAppointment(int t, int new_t)
  { boolean changed = false;
    if((t < 8 && t > 15) && (new_t < 8 && new_t > 15))
      {JOptionPane.showMessageDialog(null,"Appointment error: time must be in range 8-16");}
    else{ boolean booked = makeAppointment(new_t, client[t], topic[t]);
          if(booked)
            { changed = true;
              cancelAppointment(t);}
          else{JOptionPane.showMessageDialog(null,"New Appointment not available");}
        }
    return changed;      
  }
  
  /** showAppointment shows the appointments of the day */
  public void showAppointment()
  { System.out.println("Date: " + date.getString() + "\n" +
                       "Appointments:" + "\n");
    for(int i = 8; i != time.length; i++)
       { if(time[i] == true)
           {System.out.println(i + " O'clock: " + "taken" + "\n" 
                               + "Client: " + client[i] + "\n" 
                               + "Topic: " + topic[i] + "\n");}
         else{System.out.println(i + " o'clock: " + "free" + "\n");}  
       }  
  }
  
  //getters
  
  /** getKey returns that identifies the Appointment
    * @return - the key */
  public AppointmentKey getKey() {return date;}
  
  /** getTime returns the time of  the Appointment
    * @return - the time */
  public boolean[] getTime() {return time;}
  
  /** getTopic returns the topic of  the Appointment
    * @return - the topic */
  public String[] getTopic() {return topic;}
  
  /** getClient returns the Client of  the Appointment
    * @return - the client */
  public String[] getClient() {return client;}
  
  //setters
  
  /** setKey sets the key that identifies the Appointment
    * @param key - the key */
  public void setKey(AppointmentKey key) {date = key;}
  
  /** setTime sets the time of  the Appointment
    * @param time - the time */
  public void setTime(boolean[] time) {this.time = time;}
  
  /** setTopic sets the topic of  the Appointment
    * @return topic - the topic */
  public void setTopic(String[] time) {this.topic = topic;}
  
  /** setClient sets the Client of  the Appointment
    * @return client - the client */
  public void setClient(String[] client) {this.client = client;}
} 