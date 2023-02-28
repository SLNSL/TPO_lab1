package hatifnatts.characters;


public final class Pole /*extends NamedExistingObject*/ {
    public Pole(boolean dirty, boolean sticky){
        //System.out.println("Столб:\n\tСостояние:\tГрязный - "+dirty+"\tЛипкий - "+sticky);
        this.dirty = dirty;
        this.sticky = sticky;
        System.out.println(this.toString());
    }
    private static int numberOfObjects = 0;
    static{
        numberOfObjects += 1;
    }

    private final boolean dirty;
    private final boolean sticky;

    public static int getNumberOfObjects(){return numberOfObjects;}
    public boolean isDirty(){return dirty;}
    public boolean isSticky(){return sticky;}

    @Override
    public String toString() {
        return "> Pole:\n" +
                "\tdirty=" + dirty +
                ", \tsticky=" + sticky;
    }
}