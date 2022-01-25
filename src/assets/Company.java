package assets;

import java.util.Objects;

public class Company {
    private Shares name;

    public Company(Shares name) {
        this.name = name;
    }

    public Shares getName() {
        return name;
    }

    public String toString() {
        return name.name();
    }

    public int hashCode(){
        return Objects.hash(name);
    }

    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Company that = (Company) ob;
        return Objects.equals(toString() + this.hashCode(), that.toString() + that.hashCode());
    }
}
