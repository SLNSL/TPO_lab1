package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;
import hatifnatts.characters.common.Message;

public class HatifnattMessages extends Message implements HatifnattActions {

    public static class MessagesHider{

        private static boolean repetitionAcceptance = true;

        private static int buffer = 0;

        public static void repeat(boolean agreement){
            repetitionAcceptance=agreement;
            if (!agreement){
                setBuffer(0);
            }
        }

        public static boolean repetitionAccepted() {
            return repetitionAcceptance;
        }

        public static int getBuffer() {
            return buffer;
        }

        public static void setBuffer(int buffer) {
            MessagesHider.buffer = buffer;
        }
    }


    static {
        MessagesHider.setBuffer(MessagesHider.getBuffer()+1);
    }

    public HatifnattMessages(Hatifnatt hatifnatt) throws ImpossibleNumberException {
        super(hatifnatt);
        setCharacterName( MessagesHider.getBuffer()+"/"+ CrowdOfHatifnatts.getNumberOfHatifnatts() + " " +getCharacterName()+"(s)");
    }

    public void approach(Object o){
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"approached the "+o.getClass().getSimpleName());}
    }



    @Override
    public void lookAt(Object o) {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"are looking at "+o.getClass().getSimpleName());}
    }


    @Override
    public void hear(boolean heard) {
        if (MessagesHider.repetitionAccepted()){
            if (heard){
                System.out.println(intro()+" heard Hemul");
                System. exit(0);
            } else{
                System.out.println(intro()+" didn't hear Hemul");
            }
        }
    }

    @Override
    public void takeAStepTowards(Hemul hemul, HatifnattStatus hatifnattStatus) {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"took a step towards "+hemul.getClass().getSimpleName()+" "+hatifnattStatus);}
    }

    @Override
    public void hiss(Adverbs adverb) {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+adverb+"   'Ssssssss-hhhhhhhhh!'");}
    }

    public void surround(Hemul hemul) {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"surrounded "+hemul.getClass().getSimpleName());}
    }

    public void swarm() {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"are swarming");}
    }


    public void flash(Location loc, int loudness) {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"are flashing "+ loc +" with loudness "+loudness);}
    }

    @Override
    public void swingPaws() {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"are swinging paws");}
    }

    public void move(Hemul hemul, int loudness) {
        if (MessagesHider.repetitionAccepted()){System.out.println(intro()+"are moving towards "+hemul.getClass().getSimpleName()+" with "+ loudness + " loudness");}
    }
}
