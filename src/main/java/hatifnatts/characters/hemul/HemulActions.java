package hatifnatts.characters.hemul;

import hatifnatts.characters.Barometer;
import hatifnatts.characters.Pole;
import hatifnatts.characters.SunRay;
import hatifnatts.characters.hatifnatt.HatifnattActions;
import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;

public interface HemulActions{
    void goTo(Location location);
    void walk(Location location);
    void lookForPlants(Adverbs adverb);
    void lookUp();
    void crashInto(Pole pole);
    void see(HatifnattActions hatifnatt);
    void think(String text);
    void think(String text, Adverbs adverb);
    void lookAround(Adverbs adverb);
    void inspect(Object o);
    void click(Object o);
    void squint(SunRay sunRay);

    void coward();
    void lookAround(Pole pole);
    void lookForEscape(Pole pole);
    void pickUpSkirts();
    void climb(Pole pole);
    void sitDown();
    void shiver();
    void holdOnTo(Barometer barometer);
}
