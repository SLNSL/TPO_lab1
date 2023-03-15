import hatifnatts.characters.Barometer;
import hatifnatts.characters.Pole;
import hatifnatts.characters.common.SkirtStatus;
import hatifnatts.characters.hatifnatt.CrowdOfHatifnatts;
import hatifnatts.characters.hatifnatt.Hatifnatt;
import hatifnatts.characters.hatifnatt.HatifnattStatus;
import hatifnatts.characters.hemul.Hemul;
import hatifnatts.enums.*;
import hatifnatts.exceptions.HaveNotArrivedYetException;
import hatifnatts.exceptions.HaveNotBeenNoticedYetException;
import hatifnatts.exceptions.ImpossibleNumberException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainTest {
    
    static Pole pole;
    static Hemul hemul;
    static CrowdOfHatifnatts crowd;
    static Barometer barometer;
    static Barometer.ClockHand clockHand;

    @BeforeAll
    public static void creation() {
        try {
         pole = new Pole(true, true);
         hemul = new Hemul( 7);
         crowd = new CrowdOfHatifnatts(new Hatifnatt(Location.GLADE_OF_HATIFNATTS, 2, false), 123);
         barometer = new Barometer(Location.ON_TOP_OF_THE_POLE, Colour.RED, Material.WOODEN);
         clockHand = barometer.new ClockHand();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    void checkNumberOfSkirts() {
        Assertions.assertTrue(hemul.getSkirts().size() - 1 > 1);
    }

    @Test
    public void checkSwarming() throws HaveNotBeenNoticedYetException {
        crowd.setNoticed(true);
        crowd.swarm();
    }
    
    @Test
    public void testLooking() throws HaveNotBeenNoticedYetException, ImpossibleNumberException {
        crowd.setNoticed(true);
        crowd.lookAt(hemul);
    }
    
    @Test
    public void testHissing() throws ImpossibleNumberException {
        crowd.setNoticed(false);
        crowd.hiss(Adverbs.TERRIBLY);

        assertTrue(crowd.isNoticed());
    }
    
    @Test
    public void testTakingAStepTowards() throws HaveNotBeenNoticedYetException, ImpossibleNumberException {
        crowd.setNoticed(true);
        crowd.takeAStepTowards(hemul, HatifnattStatus.LINE_AFTER_LINE);
    }
    
    @Test
    public void testHearing() throws HaveNotBeenNoticedYetException, ImpossibleNumberException {
        crowd.setNoticed(true);
        crowd.hear(false);
    }
    
    @Test
    public void swingPaws() throws HaveNotBeenNoticedYetException, ImpossibleNumberException {
        crowd.setNoticed(true);
        crowd.swingPaws();
    }

    @Test
    public void checkLocation(){
        hemul.crashInto(pole);

        assertEquals(hemul.getLocation(), Location.BY_THE_POLE);
    }


    @Test
    public void testIfHatifnattsSurrounded(){
        crowd.surround(hemul);

        assertEquals(HatifnattStatus.IN_A_CIRCLE, crowd.getHatifnattStatus());
    }

    @Test
    public void testFlashing() throws ImpossibleNumberException {
        final var sizeBefore = CrowdOfHatifnatts.getNumberOfHatifnatts();
        crowd.flash(Location.BETWEEN_THE_TREES, 0);

        for (Hatifnatt hatifnatt : crowd.crowd){
            assertEquals(0, hatifnatt.getLoudness());
            assertEquals(Location.BETWEEN_THE_TREES, hatifnatt.getLocation());
            assertEquals(MovableStatus.MOTIONLESS, hatifnatt.getFace().getFacesStatus());
        }
        
        assertEquals(sizeBefore + 13, CrowdOfHatifnatts.getNumberOfHatifnatts());
    }

    @Test
    public void testIfAllSkirtsArePickedUp() {
        hemul.pickUpSkirts();

        for (Hemul.Skirt skirt : hemul.getSkirts()){
            assertEquals(SkirtStatus.UP, skirt.getSkirtsStatus());
        }
    }

    @Test
    public void testIfHemulClimbedUp() {
        hemul.coward();
        hemul.climb(pole);

        assertEquals(Location.ON_TOP_OF_THE_POLE, hemul.getLocation());
    }


    @Test
    public void testSequenceOfActionsOnLocation() throws HaveNotArrivedYetException {
        hemul.goTo(Location.GLADE_OF_HATIFNATTS);
        hemul.walk(Location.GLADE_OF_HATIFNATTS);
    }

    @Test
    public void testSequenceOfActionsWithCrows() throws HaveNotBeenNoticedYetException, ImpossibleNumberException {
        hemul.see(crowd);

        crowd.swarm();
        crowd.lookAt(hemul);
    }
}