package assets;

public enum Shares {
    GOVOR("Говор"),
    GAZPROM("Газпром"),
    RESIDE("Ресайд"),
    TESLA("Тесла"),
    VIVAL("Виваль"),
    WAND("Ванд");

    private final String name;

    Shares(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
    public Company toCompany(Shares active){
        Company company = new Company(active);
        return company;
    }
}
