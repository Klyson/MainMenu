package gdx2.gdx2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MainMenu extends InputAdapter implements Screen {

    final Game1 game;
    OrthographicCamera camera;
    Texture img1, img2;
    Sprite SongOne, Exit;
    private boolean isSong1, isExit;

    public MainMenu(final Game1 _game) {
        game = _game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        img1 = new Texture("SongOne.jpg");
        SongOne = new Sprite(img1);
        img2 = new Texture("Exit.jpg");
        Exit = new Sprite(img2);
        Gdx.input.setInputProcessor(this);
        SongOne.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        Exit.setPosition(Gdx.graphics.getWidth() / 2, 100);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(SongOne, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        game.batch.draw(Exit, Gdx.graphics.getWidth() / 2, 100);
        game.batch.end();

//        if (isSong1) { //if button pressed go to corresponding screen
//            game.setScreen(new SongOne(game));
//            dispose();
//        }
//        if (isExit) {
//            Gdx.app.exit();
//        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        isSong1 = false;
        isExit = false;
        if (button == Input.Buttons.LEFT && screenX < SongOne.getOriginX() + SongOne.getWidth()
                && screenY < SongOne.getOriginY() + SongOne.getHeight()) { 
            isSong1 = true;
        } else if (button == Input.Buttons.LEFT && screenX < (Exit.getOriginX() + Exit.getWidth())
                && screenY < (Exit.getOriginY() + Exit.getHeight())) {
            isExit = true;
        }
        System.out.println(isSong1);
        System.out.println(isExit);
        return true;
    }
}