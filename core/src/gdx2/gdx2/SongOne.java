package gdx2.gdx2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
public class SongOne extends InputAdapter implements Screen {

    final Game1 game;
    private SpriteBatch batch;
    private Texture img1, img2, img3, img4;
    private Sprite sprite1, sprite2, sprite3, sprite4;
    private boolean S;
    private float XMid, YMid;
    private int j = 0;
    private String[] Ars = new String[]{"TR", "TL", "BR", "BL", "TL", "TR", "BL", "BR",};

    public SongOne(final Game1 _game) {
        this.game = _game;
    }

    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        XMid = Gdx.graphics.getWidth() / 2;
        YMid = Gdx.graphics.getHeight() / 2;
        batch = new SpriteBatch();
        img1 = new Texture("Red.png");
        img2 = new Texture("Blue.png");
        img3 = new Texture("green.jpg");
        img4 = new Texture("black.jpg");
        sprite1 = new Sprite(img1);//TL
        sprite2 = new Sprite(img2);//TR
        sprite3 = new Sprite(img3);//BL
        sprite4 = new Sprite(img4);//BR
        sprite1.setSize((w / 2) - 50, h / 2);
        sprite2.setSize((w / 2) - 50, h / 2);
        sprite3.setSize((w / 2) - 50, h / 2);
        sprite4.setSize((w / 2) - 50, h / 2);
        sprite1.setPosition(0, h / 2);
        sprite2.setPosition((w / 2) + 50, h / 2);
        sprite3.setPosition(0, 0);
        sprite4.setPosition((w / 2) + 50, 0);
        Gdx.input.setInputProcessor(this);
        for (int i = 0; i < 8; i++) {
            System.out.println(Ars[i]);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img1.dispose();
        img2.dispose();
        img3.dispose();
        img4.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Ars[j].equals("TL")) {
            Gdx.gl.glClearColor(1, 0, 0, 1);
        }
        if (Ars[j].equals("TR")) {
            Gdx.gl.glClearColor(0, 0, 1, 1);
        }
        if (Ars[j].equals("BL")) {
            Gdx.gl.glClearColor(0, 1, 0, 1);
        }
        if (Ars[j].equals("BR")) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
        }
        batch.begin();
        sprite1.draw(batch);
        sprite2.draw(batch);
        sprite3.draw(batch);
        sprite4.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        S = false;
        if (button == Buttons.LEFT && screenX < XMid && screenY < YMid) {
            if (Ars[j].equals("TL")) {
                S = true;
            }
        } else if (button == Buttons.LEFT && screenX > XMid && screenY < YMid) {
            if (Ars[j].equals("TR")) {
                S = true;
            }
        } else if (button == Buttons.LEFT && screenX < XMid && screenY > YMid) {
            if (Ars[j].equals("BL")) {
                S = true;
            }
        } else if (button == Buttons.LEFT && screenX > XMid && screenY > YMid) {
            if (Ars[j].equals("BR")) {
                S = true;
            }
        }
        if (S) {
            j++;
        }
        System.out.println(j);
        return true;
    }
}
