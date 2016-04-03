package model;
import java.util.NoSuchElementException;

/**
 * This class is the model for all the commands/actions that are there in the memory
 * Each action has a commandId, hotResponse and coldResponse.
 * 
 * @author Shashank Shekhar
 *
 */
public enum Actions {

    PUT_ON_FOOTWEAR("sandals", "boots"),
    PUT_ON_SOCKS("fail", "socks"),
    PUT_ON_JACKET("fail", "jacket"),
    PUT_ON_HEAD_WEAR("sun visor", "hat"),
    PUT_ON_SHIRT("t-shirt", "shirt"),
    PUT_ON_PANTS("shorts", "pants"),
    TAKE_OFF_PAJAMAS("Removing PJs", "Removing PJs"),
    LEAVE_HOUSE("leaving house", "leaving house");

    private final String coldResponse;
    private final String hotResponse;

    Actions(String hotDesc, String coldDesc) {
        this.hotResponse = hotDesc;
        this.coldResponse = coldDesc;
    }

    public String getHotDesc() {
        return hotResponse;
    }

    public String getColdDesc() {
        return coldResponse;
    }

    public String getDescription(Temperature temperature){
        if (temperature == Temperature.COLD)
            return getColdDesc();
        else {
            return getHotDesc();
        }
    }
    public static Actions getAction(int number){
       switch(number){
           case 1 :
               return PUT_ON_FOOTWEAR;
           case 2 :
               return PUT_ON_HEAD_WEAR;
           case 3 :
               return PUT_ON_SOCKS;
           case 4 :
               return PUT_ON_SHIRT;
           case 5 :
               return PUT_ON_JACKET;
           case 6 :
               return PUT_ON_PANTS;
           case 7 :
               return LEAVE_HOUSE;
           case 8 :
               return TAKE_OFF_PAJAMAS;
           default :
               throw new NoSuchElementException("You have provided an invalid argument there is no such value as: " + number);//TODO: test this
       }
    }

}
