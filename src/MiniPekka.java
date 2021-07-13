public class MiniPekka extends Warrior {
    public MiniPekka(User user) {
        switch (user.getLevel()) {
            case 1:
                hp = 600;
                damage = 325;
                break;
            case 2:
                hp = 660;
                damage = 357;
                break;
            case 3:
                hp = 726;
                damage = 393;
                break;
            case 4:
                hp = 798;
                damage = 432;
                break;
            case 5:
                hp = 876;
                damage = 474;
        }
        hitSpeed = 1.8;
        speed = 4;
        target = 0;
        range = 0;
        areaSplash = false;
        count = 1;
        cost = 4;
    }
}
