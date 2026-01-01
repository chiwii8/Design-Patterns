package domain;

/**
 * House.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 31/12/2025
 */

public class House {
    private String direction;
    private String material;
    private boolean isGarden;
    private boolean isPool;
    private boolean isGarage;


    @Override
    public String toString() {
        String garden =isGarden?"with Garden ": "without garden ";
        String pool = isPool?"with Pool ": "without pool ";
        String garage = isGarage?"with garage ":"without Garage ";
        return "My house build material " + material + garage + garden + pool;
    }

    public House(HouseBuilder builder){
        this.direction = builder.direction;
        this.material = builder.material;
        this.isGarden = builder.isGarden;
        this.isPool = builder.isPool;
        this.isGarage = builder.isGarage;
    }

    public static class HouseBuilder{
        private String direction;
        private String material;
        private boolean isGarden;
        private boolean isPool;
        private boolean isGarage;


        public HouseBuilder Direction(String direction) {
            this.direction = direction;
            return this;
        }


        public HouseBuilder Material(String material) {
            this.material = material;
            return this;
        }


        public HouseBuilder IsGarden(boolean isGarden) {
            this.isGarden = isGarden;
            return this;
        }


        public HouseBuilder IsPool(boolean isPool) {
            this.isPool = isPool;
            return this;
        }


        public HouseBuilder IsGarage(boolean isGarage) {
            this.isGarage = isGarage;
            return this;
        }


        public House build(){
            return new House(this);
        }


    }
}
