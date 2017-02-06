package stickvania;

import org.newdawn.slick.*;

public class BatSpawner extends Thing {

  public int x1;
  public int x2;
  public int delay;

  public BatSpawner(Main main, int x1, int x2) {
    super(main);
    this.x1 = x1;
    this.x2 = x2;
  }

  @Override
  public boolean update(GameContainer gc) throws SlickException {

    if (main.timeFrozen > 0) {
      return true;
    }

    if (main.simon.x < x1 || main.simon.x > x2) {
      return true;
    }

    if (delay == 0) {
      delay = 546;
      if (main.simon.direction == Main.RIGHT) {
        main.pushThing(new Bat(main,
            main.camera + 520, main.simon.y + 8, Main.LEFT));
      } else {
        main.pushThing(new Bat(main,
            main.camera - 40, main.simon.y + 8, Main.RIGHT));
      }
    } else {
      delay--;
    }

    return true;
  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException {
  }
}
