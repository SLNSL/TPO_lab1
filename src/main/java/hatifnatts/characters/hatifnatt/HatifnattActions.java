package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Adverbs;
import hatifnatts.exceptions.HaveNotBeenNoticedYetException;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;

public interface HatifnattActions{

    void lookAt(Object o) throws ImpossibleNumberException, HaveNotBeenNoticedYetException;
    //void swarm();
    void approach(Object o) throws ImpossibleNumberException, HaveNotBeenNoticedYetException;

    void hear(boolean heard) throws ImpossibleNumberException, HaveNotBeenNoticedYetException;
    void takeAStepTowards(Hemul hemul, HatifnattStatus hatifnattStatus) throws ImpossibleNumberException, HaveNotBeenNoticedYetException;
    void hiss(Adverbs adverb) throws ImpossibleNumberException, HaveNotBeenNoticedYetException;
    //void surround(Hemul hemul);
    void swingPaws() throws ImpossibleNumberException, HaveNotBeenNoticedYetException;
    //void flash(Location loc, int loudness);
}
