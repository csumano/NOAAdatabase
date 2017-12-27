package sample;

public class Station {

    private String stationName;
    private Double pcp;

    public Station(String name, Double p){
        stationName = name;
        pcp = p;
    }

    public Double getPcp(){
        return pcp;
    }

    public String getName(){
        return stationName;
    }

    public String toString(){
        return stationName + " | " + pcp;
    }
}
