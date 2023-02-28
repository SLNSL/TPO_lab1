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
    private List<Paw> paws = new ArrayList<>();
    private Face face;
    private int loudness;
    private HatifnattStatus hatifnattStatus;


    {
        CrowdOfHatifnatts.incrementHatifnatts();
    }


    public Hatifnatt(Location location, int numberOfPaws) throws ImpossibleNumberException {
        this.location = location;
        //hatifnattStatus = HatifnattStatus.LINE_AFTER_LINE;
        if (numberOfPaws<0){
            throw new ImpossibleNumberException(numberOfPaws + " paws can't exist");
        }else {
            for(int i = 0; i < numberOfPaws; i++){
                paws.add(new Paw());
            }
        }
        face = new Face();
        //System.out.println(this.toString());
    }


    @Override
    public void lookAt(Object o) throws ImpossibleNumberException {
        new HatifnattMessages(this).lookAt(o);
    }



    public void hear(boolean heard) throws ImpossibleNumberException {
        HatifnattMessages message = new HatifnattMessages(this);
        message.hear(heard);
    }

    public void approach(Object o) throws ImpossibleNumberException {
        new HatifnattMessages(this).approach(o);
    }



    public void hiss(Adverbs adverb){
        //System.out.println("> Хатифнатты:\n\tШшш-шшш-шшш-шшш!");
        try {
            new HatifnattMessages(this).hiss(adverb);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }

    public void swingPaws(){
        for (Paw paw: paws) {
            paw.move(MovableStatus.WAVE);
        }
        try {
            new HatifnattMessages(this).swingPaws();
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

   /* public void surround(Hemul hemul){
        hatifnattStatus= HatifnattStatus.IN_A_CIRCLE;
        //System.out.println("> Хатифнатты:\n\tокружили Хемуля "+hatifnattStatus);
        try {
            new HatifnattMessages(this).surround(hemul);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
    }*/





    public class Paw {
        private MovableStatus pawStatus;

        public Paw() {
            pawStatus = MovableStatus.MOTIONLESS;
        }

        public void move(MovableStatus pawStatus) {
            this.pawStatus = pawStatus;
            //System.out.println("> Хатифнатты:\n\tЛапы:\t" + getPawStatus());
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
        public void move(MovableStatus facesStatus){
            this.facesStatus = facesStatus;
            //System.out.println("> Хатифнатты:\n\tЛица "+facesStatus);
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

            new HatifnattMessages(this).takeAStepTowards(hemul, hatifnattStatus);
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
    /*public void flash(Location loc, int loudness){
        this.loudness=loudness;
        location = loc;
        face.move(MovableStatus.MOTIONLESS);
        //System.out.println("> Хатифнатты:\n\t"+location+" с громкостью "+loudness+" мелькают всё новые и новые");
        try {
            new HatifnattMessages(this).flash(location,loudness);
        } catch (ImpossibleNumberException e) {
            e.printStackTrace();
        }
        System.out.println("\tНовое колличество:\t"+numberOfHatifnatts);
    }*/



    /*public void move(Hemul hemul, int loudness){
        this.loudness=loudness;
        System.out.println("> Хатифнатты:\n\tгромкость "+loudness);
        int n = (int)Math.round(Math.random()*(5)+3);
        for (int i=0;i<n;i++){
            takeAStepTowards(hemul);
        }
        System.out.println("> Хатифнатты:\n\tв итоге сделали "+n+" шагов в сторону Хемуля "+hatifnattStatus);
    }*/

}