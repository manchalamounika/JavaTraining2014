
import java.sql.Timestamp;

public class BirthdayDetails{
   String name;
   Timestamp timestamp;

   public String getName(){
     return name;
   }
   public void setName(String name){
     this.name = name;
   }
   public Timestamp getTimestamp(){
     return timestamp;
   }
   public void setTimestamp(Timestamp timestamp){
     this.timestamp = timestamp;
   }
}
