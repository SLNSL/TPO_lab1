import hatifnatts.characters.Barometer;
import hatifnatts.characters.Pole;
import hatifnatts.characters.common.SkirtStatus;
import hatifnatts.characters.hatifnatt.CrowdOfHatifnatts;
import hatifnatts.characters.hatifnatt.Hatifnatt;
import hatifnatts.characters.hatifnatt.HatifnattMessages;
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
         crowd = new CrowdOfHatifnatts(new Hatifnatt(Location.GLADE_OF_HATIFNATTS, 2), 123);
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
    public void checkMessageHiderBuffer() throws ImpossibleNumberException, HaveNotBeenNoticedYetException {
        crowd.swarm();
        assertEquals(HatifnattMessages.MessagesHider.getBuffer(), CrowdOfHatifnatts.getNumberOfHatifnatts());

        crowd.lookAt(hemul);
        assertEquals(HatifnattMessages.MessagesHider.getBuffer(), CrowdOfHatifnatts.getNumberOfHatifnatts());

        crowd.hiss(Adverbs.TERRIBLY);
        assertEquals(HatifnattMessages.MessagesHider.getBuffer(), CrowdOfHatifnatts.getNumberOfHatifnatts());

        crowd.takeAStepTowards(hemul, HatifnattStatus.LINE_AFTER_LINE);
        assertEquals(HatifnattMessages.MessagesHider.getBuffer(), CrowdOfHatifnatts.getNumberOfHatifnatts());

        crowd.hear(false);
        assertEquals(HatifnattMessages.MessagesHider.getBuffer(), CrowdOfHatifnatts.getNumberOfHatifnatts());

        crowd.swingPaws();
        assertEquals(HatifnattMessages.MessagesHider.getBuffer(), CrowdOfHatifnatts.getNumberOfHatifnatts());
    }

    @Test
    public void checkLocation(){

        assertEquals(hemul.getLocation(), Location.GLADE_OF_HATIFNATTS);

        hemul.crashInto(pole);

        assertEquals(hemul.getLocation(), Location.BY_THE_POLE);
    }


    @Test
    public void testIfHatifnattsSurrounded(){
        crowd.surround(hemul);

        assertEquals(HatifnattStatus.IN_A_CIRCLE, crowd.getHatifnattStatus());
    }

    @Test
    public void testHatifnattsDescription() throws ImpossibleNumberException {
        crowd.flash(Location.BETWEEN_THE_TREES, 0);

        for (Hatifnatt hatifnatt : crowd.crowd){
            assertEquals(0, hatifnatt.getLoudness());
            assertEquals(Location.BETWEEN_THE_TREES, hatifnatt.getLocation());
            assertEquals(MovableStatus.MOTIONLESS, hatifnatt.getFace().getFacesStatus());
        }
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
