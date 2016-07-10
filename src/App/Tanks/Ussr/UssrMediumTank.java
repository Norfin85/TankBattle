package App.Tanks.Ussr;

import App.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public class UssrMediumTank extends Tank {
        private int armor;
        public UssrMediumTank(){
            super(200, 60, 30., 40.);
            this.armor = 10;
        }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public String getName() {
        return "USSR_MEDIUM";
    }
}
