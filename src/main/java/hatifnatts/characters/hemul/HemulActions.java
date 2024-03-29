package hatifnatts.characters.hemul;

import hatifnatts.characters.Barometer;
import hatifnatts.characters.Pole;
import hatifnatts.characters.SunRay;
import hatifnatts.characters.hatifnatt.CrowdOfHatifnatts;
import hatifnatts.characters.hatifnatt.Hatifnatt;
import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.exceptions.HaveNotArrivedYetException;

public interface HemulActions{
    void goTo(Location location);
    void walk(Location location) throws HaveNotArrivedYetException;
    void lookForPlants(Adverbs adverb);
    void lookUp();
    void crashInto(Pole pole);
    void see(Hatifnatt hatifnatt);

    void see(CrowdOfHatifnatts hatifnatts);
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
