package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.enums.MovableStatus;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;

import java.util.ArrayList;
import java.util.List;

public class CrowdOfHatifnatts implements CrowdOfHatifnattsActions {

    private static int numberOfHatifnatts = 0;
    public static void incrementHatifnatts(){numberOfHatifnatts++;}
    public static int getNumberOfHatifnatts(){return numberOfHatifnatts;}
    private HatifnattStatus hatifnattStatus;

    public CrowdOfHatifnatts (Hatifnatt hatifnatt, int initialAmount)throws ImpossibleNumberException {
        if (initialAmount<2){
            throw new ImpossibleNumberException(initialAmount + " hatifnatts isn't a crowd. It must be at least 2 of them.");
        }
        for (int i=0; i<(initialAmount-1); i++){
            Hatifnatt h = new Hatifnatt(Location.GLADE_OF_HATIFNATTS, 2);
            h=hatifnatt;
            addItem(h);
        }
        addItem(hatifnatt);
        hatifnattStatus = HatifnattStatus.LINE_AFTER_LINE;
        System.out.println(this.toString());
    }
    public List<Hatifnatt> crowd = new ArrayList<>();

    public void addItem(Hatifnatt hatifnatt){
        crowd.add(hatifnatt);
    }




    @Override
    public void lookAt(Object o) throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).lookAt(o);
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).lookAt(o);
    }

    @Override
    public void approach(Object o) throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).approach(o);
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).approach(o);
    }


    public void swarm() {
        try {
            HatifnattMessages.MessagesHider.repeat(false);
            for (int i =1; i<crowd.size();i++){
                new HatifnattMessages(crowd.get(i)).swarm();
            }
            HatifnattMessages.MessagesHider.repeat(true);
            new HatifnattMessages(crowd.get(0)).swarm();
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hear(boolean heard) throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).hear(heard);
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).hear(heard);
    }

    @Override
    public void takeAStepTowards(Hemul hemul, HatifnattStatus hatifnattStatus) throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        this.hatifnattStatus=hatifnattStatus;
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).takeAStepTowards(hemul, hatifnattStatus);
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).takeAStepTowards(hemul, hatifnattStatus);
    }

    @Override
    public void hiss(Adverbs adverb) throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).hiss(adverb);
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).hiss(adverb);
    }


    public void surround(Hemul hemul) {
        hatifnattStatus= HatifnattStatus.IN_A_CIRCLE;
        //System.out.println("> Хатифнатты:\n\tокружили Хемуля "+hatifnattStatus);
        HatifnattMessages.MessagesHider.repeat(false);
        try {
            for (int i =1; i<crowd.size();i++){
                new HatifnattMessages(crowd.get(i)).surround(hemul);
            }
            HatifnattMessages.MessagesHider.repeat(true);
            new HatifnattMessages(crowd.get(0)).surround(hemul);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void swingPaws() throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).swingPaws();
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).swingPaws();
    }


    public void flash(Location loc, int loudness) throws ImpossibleNumberException {

        for (Hatifnatt hatifnatt:crowd){
            hatifnatt.setLoudness(loudness);
            hatifnatt.setLocation(loc);
            hatifnatt.getFace().move(MovableStatus.MOTIONLESS);
        }

        //System.out.println("> Хатифнатты:\n\t"+location+" с громкостью "+loudness+" мелькают всё новые и новые");
        try {
            HatifnattMessages.MessagesHider.repeat(false);
            for (int i =1; i<crowd.size();i++){
                new HatifnattMessages(crowd.get(i)).flash(loc,loudness);
            }
            HatifnattMessages.MessagesHider.repeat(true);
            new HatifnattMessages(crowd.get(0)).flash(loc,loudness);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
        for (int i=0; i<13; i++){
            addItem(new Hatifnatt(crowd.get(0).getLocation(),3));
        }
        System.out.println("\tNew size of the crowd:\t"+crowd.size());
    }

    @Override
    public void move(Hemul hemul, int loudness) throws ImpossibleNumberException {
        HatifnattMessages.MessagesHider.repeat(false);
        for (int i =1; i<crowd.size();i++){
            new HatifnattMessages(crowd.get(i)).move(hemul, loudness);
        }
        HatifnattMessages.MessagesHider.repeat(true);
        new HatifnattMessages(crowd.get(0)).move(hemul, loudness);
    }

    @Override
    public String toString() {
        return "> CrowdOfHatifnatts:\n" +
                "\thatifnattStatus=" + hatifnattStatus +
                ", \tcrowd=" + crowd;
    }
}
