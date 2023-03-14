package hatifnatts.characters.hemul;

import hatifnatts.characters.SunRay;
import hatifnatts.characters.hatifnatt.CrowdOfHatifnatts;
import hatifnatts.characters.hatifnatt.Hatifnatt;
import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.characters.Barometer;
import hatifnatts.characters.Pole;
import hatifnatts.characters.common.Message;

public class HemulMessages extends Message implements HemulActions{

    public HemulMessages(Object hemul){
        super(hemul);
    }

    @Override
    public void goTo(Location location) {
        System.out.println(intro()+"went to "+location);
    }

    @Override
    public void walk(Location location) {
        System.out.println(intro()+"is walking in the "+location);
    }

    @Override
    public void lookForPlants(Adverbs adverb) {
        System.out.println(intro()+"is "+adverb+" looking for plants");
    }

    @Override
    public void lookUp() {
        System.out.println(intro()+"looked up");
    }

    @Override
    public void crashInto(Pole pole) {
        System.out.println(intro()+"crashed into the "+pole.getClass().getSimpleName());
    }

    public void see(Hatifnatt hatifnatt) {
        System.out.println(intro()+"saw "+hatifnatt.getClass().getSimpleName());
    }

    @Override
    public void see(CrowdOfHatifnatts hatifnatts) {
        System.out.println(intro()+"saw "+hatifnatts.getClass().getSimpleName());
    }

    @Override
    public void think(String text) {
        System.out.println(intro()+"thought to themselves: '"+text+"'");
    }

    @Override
    public void think(String text, Adverbs adverb) {
        System.out.println(intro()+"thought to themselves "+adverb+": '"+text+"'");
    }

    @Override
    public void lookAround(Adverbs adverb) {
        System.out.println(intro()+"looked around "+adverb);
    }

    @Override
    public void inspect(Object o) {
        System.out.println(intro()+"inspected the "+o.getClass().getSimpleName());
    }

    @Override
    public void click(Object o) {
        System.out.println(intro()+"clicked the "+o.getClass().getSimpleName());
    }

    @Override
    public void squint(SunRay sunRay) {
        System.out.println(intro()+"squinted because of the "+sunRay.getClass().getSimpleName());
    }

    @Override
    public void coward() {
        System.out.println(intro()+"got scared");
    }

    @Override
    public void lookAround(Pole pole) {
        System.out.println(intro()+"looked around");
    }

    @Override
    public void lookForEscape(Pole pole) {
        System.out.println(intro()+"is looking for escape");
    }

    @Override
    public void pickUpSkirts() {
        System.out.println(intro()+"picked up the skirts");
    }

    @Override
    public void climb(Pole pole) {
        System.out.println(intro()+"climbed the "+pole.getClass().getSimpleName());
    }

    @Override
    public void sitDown() {
        System.out.println(intro()+"sat down");
    }

    @Override
    public void shiver() {
        System.out.println(intro()+"is shivering");
    }

    @Override
    public void holdOnTo(Barometer barometer) {
        System.out.println(intro()+"is holding on the " + barometer.getClass().getSimpleName());
    }
}
