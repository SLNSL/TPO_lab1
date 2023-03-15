package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;
import hatifnatts.characters.common.Message;

public class HatifnattMessages extends Message implements HatifnattActions {
    

    public HatifnattMessages(Hatifnatt hatifnatt, int number) throws ImpossibleNumberException {
        super(hatifnatt);
        setCharacterName( number + "/" + CrowdOfHatifnatts.getNumberOfHatifnatts() + " " +getCharacterName()+"(s)");
    }

    public void approach(Object o){
        System.out.println(
                intro() + "approached the " + o.getClass().getSimpleName()
        );
    }
    

    @Override
    public void lookAt(Object o) {
        System.out.println(
                intro() + "are looking at " + o.getClass().getSimpleName()
        );
    }


    @Override
    public void hear(boolean heard) {
        if (heard){
            System.out.println(intro()+" heard Hemul");
            System.exit(0);
        } else{
            System.out.println(intro()+" didn't hear Hemul");
        }
    }

    @Override
    public void takeAStepTowards(Hemul hemul, HatifnattStatus hatifnattStatus) {
        System.out.println(
                intro() + "took a step towards " + hemul.getClass().getSimpleName()+" "+hatifnattStatus
        );
    }

    @Override
    public void hiss(Adverbs adverb) {
        System.out.println(intro()+adverb+"   'Ssssssss-hhhhhhhhh!'");
    }

    public void surround(Hemul hemul) {
        System.out.println(
                intro() + "surrounded " + hemul.getClass().getSimpleName()
        );
    }

    public void swarm() {
        System.out.println( intro() + "are swarming");
    }


    public void flash(Location loc, int loudness) {
        System.out.println(
                intro() + "are flashing " + loc + " with loudness " + loudness
        );
    }

    @Override
    public void swingPaws() {
        System.out.println( intro() + "are swinging paws");
    }

    public void move(Hemul hemul, int loudness) {
        System.out.println(
                intro() + "are moving towards " + hemul.getClass().getSimpleName()
                        + " with " + loudness + " loudness"
        );
    }
}