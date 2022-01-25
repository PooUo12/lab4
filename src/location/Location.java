package location;


import java.util.Objects;

public abstract class Location {
    private String name;

    public Location(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public String toString(){
        return "Локация" + name;
    }

    public int hashCode(){
        return Objects.hash(name, Math.random());
    }

    public boolean equals(Object ob){
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Location that = (Location) ob;
        return Objects.equals(name + this.hashCode(), that.name + that.hashCode());
    }
}
