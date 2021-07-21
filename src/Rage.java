public class Rage extends Spell {
    public Rage(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                duration = 6;
                break;
            case 2:
                duration = 6.5;
                break;
            case 3:
                duration = 7;
                break;
            case 4:
                duration = 7.5;
                break;
            case 5:
                duration = 8;
        }
        range = 5;
        imageBlue = "sprites/Rage.png";
        imageRed = "sprites/Rage.png";
        imageWidth=25;
        imageHeight=25;
    }

    @Override
    public String toString() {
        return "Rage";
    }

    @Override
    public void buildImageView(String color){
        super.buildImageView(color);
        imageView.setX(mapX+15);
        imageView.setY(mapY+15);
    }
}
