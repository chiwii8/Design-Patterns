package domain;

/**
 * HouseDirector.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public class HouseDirector {

    public static House createHouse(String typeHouse) throws Exception{
        House.HouseBuilder builder = new House.HouseBuilder();
        House house;
        switch (typeHouse.toLowerCase()){
            case "luxuryhouse":
                 house = builder.Direction("")
                        .IsGarage(true)
                        .IsGarden(true)
                        .IsPool(true)
                        .Material("Bricks")
                        .build();
                break;
            case "lowpricehouse":
                house = builder.Direction("")
                        .IsGarage(false)
                        .IsGarden(false)
                        .IsPool(false)
                        .Material("Wood")
                        .build();
                break;
            default:
                throw new Exception("The House is not find");
        }
        return house;
    }
}
