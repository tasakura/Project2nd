package com.example.animalrun.framework.game;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Toast;

import com.example.animalrun.framework.Game;
import com.example.animalrun.framework.Graphics;
import com.example.animalrun.framework.Input.TouchEvent;
import com.example.animalrun.framework.Screen;

public class StartScreen extends Screen {

	public StartScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (isBounds(event, 80, 400, 250, 100)) {
					game.setScreen(new CharaSelectScreen(game));
				} else if(isBounds(event, 80, 500, 320, 100)) {
					game.setScreen(new ScoreRunkingScreen(game));
				} else if(isBounds(event, 80, 600, 260, 100)) {
					System.exit(0);
				}
			}
		}
	}

	private boolean isBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 480, 800, Color.BLACK);
		g.drawPixmap(Assets.buck_StartScreen, 0, 0);
		g.drawPixmap(Assets.bt_start, 80, 400);
		g.drawPixmap(Assets.bt_score, 80, 500);
		g.drawPixmap(Assets.bt_close, 80, 600);
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

}
