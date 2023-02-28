package hatifnatts.characters.common;

public abstract class Message {

    public Message(Object o){
        setCharacterName(getCharacterClass(o));
    }

    private String characterName = "";

    public String getCharacterClass(Object o){
        return  o.getClass().getSimpleName();
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String intro(){
        return ("> "+getCharacterName()+":\n\t");
    }

}
