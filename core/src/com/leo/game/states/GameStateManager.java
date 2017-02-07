package com.leo.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){

        states = new Stack<State>();

    }

    public void push(State state){ //помещает элемент в вершину стека

        states.push(state);

    }

    public void pop(){ // извлекает верхний элемент удаляя его их стека

        states.pop().dispose();

    }

    public void set(State state){ // удаляет из стека верхний экран, очищает ресурсы и помещает следующий экран в вершину стека

        states.pop().dispose();
        states.push(state);

    }

    public void update(float dt){ // возвращает верхний элемент не удаляя его из стека

        states.peek().update(dt);

    }

    public void render(SpriteBatch sb){

        states.peek().render(sb);

    }

}
