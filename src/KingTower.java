public class KingTower extends Building{
    public KingTower(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 2400;
                damage = 50;
                break;
            case 2:
                hp = 2568;
                damage = 53;
                break;
            case 3:
                hp = 2736;
                damage = 57;
                break;
            case 4:
                hp = 2904;
                damage = 60;
                break;
            case 5:
                hp = 3096;
                damage = 64;
        }
        hitSpeed = 1.0;
        target = 2;
        range = 7;
        lifetime = 180;
        zone = 0;
    }

    @Override
    public String toString() {
        return "KINGTOWER";
    }
}
