package gdxoneb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ScrOneB implements Screen, InputProcessor {

    Game game;
    SpriteBatch batch;
    Texture txBad;
    SprBad sprBad;
    boolean isClick = false;    
    private float fVy;
    private float fVx;

    public ScrOneB(Game _game) {
        game = _game;
        batch = new SpriteBatch();
        txBad = new Texture("badlogic.jpg");
        Gdx.input.setInputProcessor((this));
        sprBad = new SprBad("badlogic.jpg", 0, 0);
        sprBad.setX(0);
        sprBad.setY(0);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (isClick) {
            Gdx.gl.glClearColor(1, 0, 1, 1); // purple???

        } else {
            Gdx.gl.glClearColor(1, 0, 0, 1);
        }
        sprBad.update(fVx, fVy);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprBad.getSprite(), sprBad.getX(), sprBad.getY());
        //imgBad.draw(batch, delta);
        //batch.draw(txBad, nX, nY);
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP) {
            //nY++;
            fVy = 2;
            System.out.println("UP");
        } else if (keycode == Input.Keys.DOWN) {
            //nY--;
            fVy = -2;
        } else if (keycode == Input.Keys.LEFT) {
            //nX--;
            fVx = -2;
        } else if (keycode == Input.Keys.RIGHT) {
            //nX++;
            fVx = 2;
        } else {
            System.out.println("Zappa for President");
        }

        return true;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (screenX > sprBad.getX() && screenX < sprBad.getX() + sprBad.getWidth() && screenY > sprBad.getY() && screenY > sprBad.getY() + sprBad.getHeight()) {
            isClick = true;
        }
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
