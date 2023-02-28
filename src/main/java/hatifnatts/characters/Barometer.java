package hatifnatts.characters;


import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Colour;
import hatifnatts.enums.Location;
import hatifnatts.enums.Material;

public class Barometer{

    private Location location;
    private Colour colour;
    private Material material;
    public Location getLocation(){return location;}

    public Barometer(Location location, Colour colour, Material material) {
        this.location=location;
        this.colour=colour;
        this.material=material;
    }

    public class ClockHand{
        public void show(boolean rain, boolean wind){
            System.out.println("> Barometer:\n\tshows:\train - "+rain+" | wind - "+ wind);
        }
        public void fall(Adverbs adverb){
            show(false,false);
            System.out.println("\tClock hand fell " + adverb);
        }
    }

}