package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.enums.MovableStatus;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;

import java.util.ArrayList;
import java.util.List;

public class Hatifnatt implements HatifnattActions {

    private Location location;
    private final List<Paw> paws = new ArrayList<>();
    private final Face face;
    private int loudness;
    
    public Hatifnatt(Location location, int numberOfPaws, boolean... increment) throws ImpossibleNumberException {
        this.location = location;
        
        if (numberOfPaws < 0){
            throw new ImpossibleNumberException(numberOfPaws + " paws can't exist");
        }else {
            for(int i = 0; i < numberOfPaws; i++){
                paws.add(new Paw());
            }
        }
        face = new Face();
        
        if (! (increment.length > 0 && !increment[0])){
            CrowdOfHatifnatts.incrementHatifnatts();
        }
    }


    @Override
    public void lookAt(Object o) throws ImpossibleNumberException {
        new HatifnattMessages(this, 1).lookAt(o);
    }



    public void hear(boolean heard) throws ImpossibleNumberException {
        HatifnattMessages message = new HatifnattMessages(this, 1);
        message.hear(heard);
    }

    public void approach(Object o) throws ImpossibleNumberException {
        new HatifnattMessages(this, 1).approach(o);
    }



    public void hiss(Adverbs adverb){
        //System.out.println("> Хатифнатты:\n\tШшш-шшш-шшш-шшш!");
        try {
            new HatifnattMessages(this, 1).hiss(adverb);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    public void swingPaws(){
        for (Paw paw: paws) {
            paw.move(MovableStatus.WAVE);
        }
        try {
            new HatifnattMessages(this, 1).swingPaws();
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }

    }

    public int getLoudness() {
        return loudness;
    }

    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Face getFace() {
        return face;
    }

    public class Paw {
        private MovableStatus pawStatus;

        public Paw() {
            pawStatus = MovableStatus.MOTIONLESS;
        }

        public void move(MovableStatus pawStatus) {
            this.pawStatus = pawStatus;
        }

        public MovableStatus getPawStatus() {
            return pawStatus;
        }

        @Override
        public String toString() {
            return "Paw{" +
                    "pawStatus=" + pawStatus +
                    '}';
        }
    }

    
    public class Face{

        private MovableStatus facesStatus;

        private Face(){ facesStatus = MovableStatus.MOTIONLESS; }

        public MovableStatus getFacesStatus() {
            return facesStatus;
        }
        public void move(MovableStatus facesStatus){
            this.facesStatus = facesStatus;
        }

        @Override
        public String toString() {
            return "Face{" +
                    "facesStatus=" + facesStatus +
                    '}';
        }
    }



    public void takeAStepTowards(Hemul hemul, HatifnattStatus hatifnattStatus) {
        //System.out.println("> Хатифнатты:\n\tсделали шаг в сторону Хемуля "+hatifnattStatus);
        try {

            new HatifnattMessages(this, 1).takeAStepTowards(hemul, hatifnattStatus);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\n> Hatifnatt:\n" +
                "\tlocation=" + location +
                ", paws=" + paws +
                ", face=" + face +
                ", loudness=" + loudness;
    }
}