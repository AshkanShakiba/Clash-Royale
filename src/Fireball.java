public class Fireball extends DamagingSpells {
    public Fireball(User user,int x,int y){
        this.arrayX=x;
        this.arrayY =y;
        switch (user.getLevel()){
            case 1:
                areaDamage = 325;
                break;
            case 2:
                areaDamage = 357;
                break;
            case 3:
                areaDamage = 393;
                break;
            case 4:
                areaDamage = 432;
                break;
            case 5:
                areaDamage = 474;
        }
        range = 3;
        imageBlue = "sprites/FireballBlue.gif";
        imageRed = "sprites/FireballRed.gif";
        imageWidth=100;
        imageHeight=100;
        duration = 0;
    }

    @Override
    public String toString() {
        return "Fireball";
    }
}
