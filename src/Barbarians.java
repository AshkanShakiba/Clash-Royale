public class Barbarians extends Warrior {
    public Barbarians(User user) {
        switch (user.getLevel()) {
            case 1:
                hp = 300;
                damage = 75;
                break;
            case 2:
                hp = 330;
                damage = 82;
                break;
            case 3:
                hp = 363;
                damage = 90;
                break;
            case 4:
                hp = 438;
                damage = 99;
                break;
            case 5:
                hp = 480;
                damage = 109;
        }
        hitSpeed = 1.5;
        speed = 3;
        target = 0;
        range = 0;
        areaSplash = false;
        count = 4;
        cost = 5;
    }
}
