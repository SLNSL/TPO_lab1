package hatifnatts.characters.hatifnatt;

import hatifnatts.enums.Location;
import hatifnatts.exceptions.HaveNotBeenNoticedYetException;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.characters.hemul.Hemul;

public interface CrowdOfHatifnattsActions extends HatifnattActions {
    void swarm() throws HaveNotBeenNoticedYetException;
    void surround(Hemul hemul);
    void flash(Location loc, int loudness) throws ImpossibleNumberException;
    void move(Hemul hemul, int loudness) throws ImpossibleNumberException;
}
