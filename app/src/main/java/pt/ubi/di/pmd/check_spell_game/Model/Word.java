package pt.ubi.di.pmd.check_spell_game.Model;

public class Word {
    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Word(String name, String description){
        setName(name);
        setDescription(description);
    }
}
