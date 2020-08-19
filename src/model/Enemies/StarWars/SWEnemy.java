package model.Enemies.StarWars;

import controller.Main;
import model.Enemies.*;
import model.GameFigure;
import model.Sounds;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SWEnemy extends Enemy {

    private final int VALUE;
    protected boolean REACHED_END = false;
    protected int numberOfTurns = 0;
    protected EnemyAnimStrategy animStrategy;
    protected int SIZE;
    protected static int STATE_MOVING_DOWN = 0;
    protected static int STATE_MOVING_LEFT = 1;
    protected static int STATE_MOVING_RIGHT = 2;
    protected static int STATE_MOVING_UP = 3;
    protected int state;

    public SWEnemy(float x, float y, int unit_move, int damage, int value, int hp) {
        location = new Point2D.Float(x,y);
        super.UNIT_MOVE = unit_move;
        super.DAMAGE = damage;
        VALUE = value;
        super.HP = hp;
        animStrategy = new EnemyAnimMovingRight(this);
        state = STATE_MOVING_RIGHT;
    }

    public boolean collideWith(GameFigure o) {
        double dist = this.location.distance(o.location);
        if (dist <= this.getCollisionRadius() + o.getCollisionRadius())
            return true;
        else
            return false;
    }

    public abstract void render(Graphics2D g2);
    public abstract void update();

    public void updateState(){
        if (this.HP <= 0) {
            super.done = true;
            Main.user.addMoney(VALUE);
        }
        if(selected)
            Main.win.displayTextBox("HP: " + HP + ", Speed: " + UNIT_MOVE + ", Damage: " + DAMAGE);
        if (state == STATE_MOVING_RIGHT){
            if (numberOfTurns == 0) {
                if (location.x >= 223){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingDown(this);
                    state = STATE_MOVING_DOWN;
                }
            }else if (numberOfTurns == 2){
                if (location.x >= 426){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingUp(this);
                    state = STATE_MOVING_UP;
                }
            }else if (numberOfTurns == 4){
                if (location.x >= 662){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingDown(this);
                    state = STATE_MOVING_DOWN;
                }
            }else if (numberOfTurns == 6){
                if (location.x >= 845){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingUp(this);
                    state = STATE_MOVING_UP;
                }
            }else if (numberOfTurns == 8){
                if (location.x >= 1000){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingDown(this);
                    state = STATE_MOVING_DOWN;
                }
            }
        }else if (state == STATE_MOVING_DOWN){
            if (numberOfTurns == 1){
                if (location.y >= 283){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingRight(this);
                    state = STATE_MOVING_RIGHT;
                }
            }else if (numberOfTurns == 5){
                if (location.y >= 279){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingRight(this);
                    state = STATE_MOVING_RIGHT;
                }
            }else if (numberOfTurns == 9){
                if (location.y >= 560){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingLeft(this);
                    state = STATE_MOVING_LEFT;
                }
            }else if (numberOfTurns == 13){
                if (location.y >= 567){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingLeft(this);
                    state = STATE_MOVING_LEFT;
                }
            }else if (numberOfTurns == 17){
                if (location.y >= 555){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingLeft(this);
                    state = STATE_MOVING_LEFT;
                }
            }
        }else if (state == STATE_MOVING_UP){
            if (numberOfTurns == 3){
                if (location.y <= 97){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingRight(this);
                    state = STATE_MOVING_RIGHT;
                }
            }else if (numberOfTurns == 7){
                if (location.y <= 96){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingRight(this);
                    state = STATE_MOVING_RIGHT;
                }
            }else if (numberOfTurns == 11){
                if (location.y <= 419){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingLeft(this);
                    state = STATE_MOVING_LEFT;
                }
            }else if (numberOfTurns == 15){
                if (location.y <= 414){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingLeft(this);
                    state = STATE_MOVING_LEFT;
                }
            }
        }else{
            if (numberOfTurns == 10){
                if (location.x <= 871){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingUp(this);
                    state = STATE_MOVING_UP;
                }
            }else if (numberOfTurns == 12){
                if (location.x <= 681){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingDown(this);
                    state = STATE_MOVING_DOWN;
                }
            }else if (numberOfTurns == 14){
                if (location.x <= 431){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingUp(this);
                    state = STATE_MOVING_UP;
                }
            }else if (numberOfTurns == 16){
                if (location.x <= 200){
                    ++numberOfTurns;
                    animStrategy = new EnemyAnimMovingDown(this);
                    state = STATE_MOVING_DOWN;
                }
            }else if (numberOfTurns == 18){
                if (location.x <= 0){
                    Main.user.removeLives(DAMAGE);
                    if(Main.user.getLives() == Main.user.getMaxLives()/2)
                        Sounds.loadSound(Sounds.halfAShip);
                    REACHED_END = true;
                    numberOfTurns = 0;
                    location.x = 0;
                    location.y = 89;
                    animStrategy = new EnemyAnimMovingRight(this);
                    state = STATE_MOVING_RIGHT;
                }
            }
        }
    }

    @Override
    public String getUpgrade_price(){ return "";}

    @Override
    public String getStats(){return "";}

    @Override
    public void upgrade() {}

    @Override
    public int getCollisionRadius() {
        return SIZE/2;
    }

    @Override
    protected double getCollisionAngle() {
        return 0;
    }

    @Override
    public String getUpgradeStat(){return "";}
}
