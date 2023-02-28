package hatifnatts.characters.hemul;


import hatifnatts.characters.SunRay;
import hatifnatts.characters.common.AbleToGiveEnergy;
import hatifnatts.characters.common.SkirtStatus;
import hatifnatts.characters.hatifnatt.HatifnattActions;
import hatifnatts.enums.Adverbs;
import hatifnatts.enums.Location;
import hatifnatts.exceptions.ImpossibleNumberException;
import hatifnatts.exceptions.NotEnoughEnergyException;
import hatifnatts.characters.Barometer;
import hatifnatts.characters.Pole;

import java.util.ArrayList;
import java.util.List;

public class Hemul implements HemulActions {

    private Location location;
    private HemulStatus hemulStatus = HemulStatus.NOT_SCARED;
    private int energy = 30;

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    //private Fear fear;
    private List<Skirt> skirts = new ArrayList<>();


    public Hemul(Location location, int numberOfSkirts) throws ImpossibleNumberException {
        this.location = location;
        if (numberOfSkirts < 1) {
            throw new ImpossibleNumberException("It can't be less than 1 skirt");
        } else if (numberOfSkirts > 10) {
            throw new ImpossibleNumberException("It can't be more than 10 skirts");
        } else {
            for (int i = 0; i < numberOfSkirts; i++) {
                skirts.add(new Skirt());
            }
        }
        System.out.println(this.toString());
        //System.out.printf("> Хемуль:\n\tКоординаты:\tx = %.3f\ty = %.3f\tz = %.3f\n",x,y,z);
        //System.out.println("\tСостояние:\tЛокация - "+location);
    }

    public void goTo(Location location) {
        this.location = location;
        new HemulMessages(this).goTo(location);
    }

    public void walk(Location location) {
        this.location = location;
        new HemulMessages(this).walk(location);
    }

    public void lookForPlants(Adverbs adverb) {
        new HemulMessages(this).lookForPlants(adverb);
    }

    @Override
    public void lookUp() {
        new HemulMessages(this).lookUp();
    }

    @Override
    public void crashInto(Pole pole) {
        location = Location.BY_THE_POLE;
        new HemulMessages(this).crashInto(pole);
    }

    @Override
    public void see(HatifnattActions hatifnatt) {
        new HemulMessages(this).see(hatifnatt);
    }

    @Override
    public void think(String text) {
        new HemulMessages(this).think(text);
    }

    @Override
    public void think(String text, Adverbs adverb) {
        new HemulMessages(this).think(text, adverb);
    }

    @Override
    public void lookAround(Adverbs adverb) {

    }

    @Override
    public void inspect(Object o) {
        new HemulMessages(this).inspect(o);
    }

    @Override
    public void click(Object o) {
        new HemulMessages(this).click(o);
    }

    @Override
    public void squint(SunRay sunRay) {
        new HemulMessages(this).squint(sunRay);
    }


    public void coward() {
        //new Fear();
        hemulStatus = HemulStatus.SCARED;
        //System.out.println("> Хемуль:\n\t"+hemulStatus+" перетрусил");
        new HemulMessages(this).coward();
    }


    public class Skirt {
        Skirt() {
            status = SkirtStatus.DOWN;
        }

        private SkirtStatus status;

        public SkirtStatus getSkirtsStatus() {
            return status;
        }

        public void pickUp() {
            status = SkirtStatus.UP;
            //System.out.println("> Хемуль:\n\tЮбка:\t"+status);
        }

        @Override
        public String toString() {
            return "Skirt{" +
                    "status=" + status +
                    '}';
        }
    }


    public void lookAround(Pole pole) {
        //System.out.println("> Хемуль:\n\tоглядывается");
        new HemulMessages(this).lookAround(pole);
        lookForEscape(pole);
    }


    public void lookForEscape(Pole pole) {
        new HemulMessages(this).lookForEscape(pole);
        //System.out.println("> Хемуль:\n\tищет куда бы убраться восвояси");

    }


    public void pickUpSkirts() {
        for (Skirt skirt : skirts) {
            skirt.pickUp();
        }
        new HemulMessages(this).pickUpSkirts();
    }


    public void climb(Pole pole) {

        class SkirtsChecker {
            public boolean check(SkirtStatus skirtStatus) {
                boolean valid = true;
                for (Skirt skirt : skirts) {
                    if (skirtStatus != skirt.getSkirtsStatus()) {
                        valid = false;
                        break;
                    }
                }
                return valid;
            }
        }

        SkirtsChecker checker = new SkirtsChecker();
        if (location == Location.BY_THE_POLE && checker.check(SkirtStatus.UP)) {
            location = Location.AT_THE_SIDE_OF_THE_POLE;
            //System.out.println("> Хемуль:\n\t"+location);
            //new HemulMessages(this).climb(pole);
        }
        if (pole.isDirty()) {
            energy--;
        }
        if (pole.isSticky()) {
            energy--;
        }

        if (hemulStatus == HemulStatus.SCARED) {
            //new Fear().giveSuperHemulPower(this);
            AbleToGiveEnergy fear = new AbleToGiveEnergy() {
                @Override
                public void giveSuperHemulPower(Hemul hemul) {
                    hemul.setEnergy(100);
                    //System.out.println("> Страх:\n\tпридаёт Хемулю нехемульскую силу");
                }
            };
            fear.giveSuperHemulPower(this);
        }
        if (energy >= 100) {
            location = Location.ON_TOP_OF_THE_POLE;
            new HemulMessages(this).climb(pole);
        } else {
            throw new NotEnoughEnergyException("Not enough energy to climb!!!!");
        }
    }


    public void sitDown() {
        if (location != Location.ON_TOP_OF_THE_POLE) {
            //System.out.println("> Хемуль:\n\tсел");
            new HemulMessages(this).sitDown();
        }
    }


    public void holdOnTo(Barometer barometer) {
        if (location == barometer.getLocation()) {
            //System.out.println("> Хемуль:\n\tдержится за барометр");
            new HemulMessages(this).holdOnTo(barometer);
        }
    }


    public void shiver() {
        //System.out.println("> Хемуль:\n\tтрясётся");
        new HemulMessages(this).shiver();
    }

    @Override
    public String toString() {
        return "> Hemul:\n" +
                "\tlocation=" + location +
                ",\themulStatus=" + hemulStatus +
                ",\tenergy=" + energy +
                ",\n\tskirts=" + skirts;
    }
}