/**
 * Created by User on 05.07.2016.
 */
public class UssrTankFactory implements TankFactory {
    @Override
    public Tank createGermanTank(String typeTank) {
        return null;
    }

    public Tank createUssrTank(String typeTank) {
        {
            Tank ussrTank = null;
            switch (typeTank) {
                case "LIGHT":
                    ussrTank = new UssrLightTank();
                    break;

                case "MEDIUM":
                    ussrTank = new UssrMediumTank();
                    break;

                case "HEAVY":
                    ussrTank = new UssrHeavyTank();
                    break;

                default:
                    throw new IllegalArgumentException("Illegal type of tank: "
                            + typeTank);
                    //throw some exception
            }
            return ussrTank;
        }
    }
}
