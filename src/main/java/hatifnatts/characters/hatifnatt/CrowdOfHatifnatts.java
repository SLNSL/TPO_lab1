package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.enums.MovableStatus;
import hatifnatts.exceptions.HaveNotBeenNoticedYetException;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;

import java.util.ArrayList;
import java.util.List;

public class CrowdOfHatifnatts implements CrowdOfHatifnattsActions {

    private static int numberOfHatifnatts = 0;
    public static void incrementHatifnatts(){numberOfHatifnatts++;}
    public static int getNumberOfHatifnatts(){return numberOfHatifnatts;}

    private boolean isNoticed = false;
    private HatifnattStatus hatifnattStatus;

    public void setNoticed(boolean isNoticed) {
        this.isNoticed = isNoticed;
    }
    
    public boolean isNoticed(){
        return isNoticed;
    }
    public List<Hatifnatt> crowd = new ArrayList<>();

    public HatifnattStatus getHatifnattStatus() {
        return hatifnattStatus;
    }

    public CrowdOfHatifnatts (Hatifnatt hatifnatt, int initialAmount)throws ImpossibleNumberException {
        if (initialAmount < 2){
            throw new ImpossibleNumberException(initialAmount + " hatifnatts isn't a crowd. It must be at least 2 of them.");
        }
        for (int i = 0; i < initialAmount; i++){
            addItem(hatifnatt);
        }
        hatifnattStatus = HatifnattStatus.LINE_AFTER_LINE;
    }

    public void addItem(Hatifnatt hatifnatt){
        incrementHatifnatts();
        crowd.add(hatifnatt);
    }


    @Override
    public void lookAt(Object o) throws ImpossibleNumberException, HaveNotBeenNoticedYetException {
        if (!isNoticed) throw new HaveNotBeenNoticedYetException("Crowd has not been noticed by Hemul yet.");
        
        new HatifnattMessages(crowd.get(0), this.crowd.size()).lookAt(o);
    }

    @Override
    public void approach(Object o) throws ImpossibleNumberException, HaveNotBeenNoticedYetException {
        if (!isNoticed) throw new HaveNotBeenNoticedYetException("Crowd has not been noticed by Hemul yet.");

        new HatifnattMessages(crowd.get(0), this.crowd.size()).approach(o);
    }


    public void swarm() throws HaveNotBeenNoticedYetException {
        if (!isNoticed) throw new HaveNotBeenNoticedYetException("Crowd has not been noticed by Hemul yet.");
        
        try {
            new HatifnattMessages(crowd.get(0), this.crowd.size()).swarm();
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hear(boolean heard) throws ImpossibleNumberException , HaveNotBeenNoticedYetException {
        if (!isNoticed) throw new HaveNotBeenNoticedYetException("Crowd has not been noticed by Hemul yet.");

        new HatifnattMessages(crowd.get(0), this.crowd.size()).hear(heard);
    }

    @Override
    public void takeAStepTowards(Hemul hemul, HatifnattStatus hatifnattStatus) throws ImpossibleNumberException, HaveNotBeenNoticedYetException {
        if (!isNoticed) throw new HaveNotBeenNoticedYetException("Crowd has not been noticed by Hemul yet.");

        new HatifnattMessages(crowd.get(0), this.crowd.size()).takeAStepTowards(hemul, hatifnattStatus);
    }

    @Override
    public void hiss(Adverbs adverb) throws ImpossibleNumberException {
        this.isNoticed = true;

        new HatifnattMessages(crowd.get(0), this.crowd.size()).hiss(adverb);
    }


    public void surround(Hemul hemul) {
        this.isNoticed = true;
        hatifnattStatus= HatifnattStatus.IN_A_CIRCLE;
        
        try {
            new HatifnattMessages(crowd.get(0), this.crowd.size()).surround(hemul);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void swingPaws() throws ImpossibleNumberException, HaveNotBeenNoticedYetException {
        if (!isNoticed) throw new HaveNotBeenNoticedYetException("Crowd has not been noticed by Hemul yet.");

        new HatifnattMessages(crowd.get(0), this.crowd.size()).swingPaws();
    }


    public void flash(Location loc, int loudness) throws ImpossibleNumberException {

        for (Hatifnatt hatifnatt : crowd){
            hatifnatt.setLoudness(loudness);
            hatifnatt.setLocation(loc);
            hatifnatt.getFace().move(MovableStatus.MOTIONLESS);
        }
        
        try {
            new HatifnattMessages(crowd.get(0), this.crowd.size()).flash(loc, loudness);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < 13; i++){
            crowd.add(new Hatifnatt(crowd.get(0).getLocation(),3));
        }
        
        System.out.println("\tNew size of the crowd:\t"+crowd.size());
    }

    @Override
    public void move(Hemul hemul, int loudness) throws ImpossibleNumberException {
        new HatifnattMessages(crowd.get(0), this.crowd.size()).move(hemul, loudness);
    }

    @Override
    public String toString() {
        return "> CrowdOfHatifnatts:\n" +
                "\thatifnattStatus=" + hatifnattStatus +
                ", \tcrowd=" + crowd;
    }
}