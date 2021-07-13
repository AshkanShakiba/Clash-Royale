public class Giant extends Warrior {
    public Giant(User user) {
        switch (user.getLevel()) {
            case 1:
                hp = 2000;
                damage = 126;
                break;
            case 2:
                hp = 2200;
                damage = 138;
                break;
            case 3:
                hp = 2420;
                damage = 152;
                break;
            case 4:
                hp = 2660;
                damage = 167;
                break;
            case 5:
                hp = 2920;
                damage = 183;
        }
        hitSpeed = 1.5;
        speed = 2;
        target = 3;
        range = 0;
        areaSplash = false;
        count = 1;
        cost = 5;
    }
}
