/**
 * 
 */
package com.allin.mina;

/**
 * @author allin
 *
 */
public class PUD {
	public PUD(){}
	
	public PUD(int session, int type, int direction, int speed, int accelerations, int x1, int y1, int x2, int y2) {
		this.session = session;
		this.type = type;
		this.direction = direction;
		this.speed = speed;
		this.accelerations = accelerations;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	private int session;				//玩家编号
	private int type;				//类型
	private int direction;			//方向
	private int speed;				//速度
	private int accelerations;		//加速度
	private int x1;					//起点x坐标
	private int y1;					//起点y坐标
	private int x2;					//终点x坐标
	private int y2;					//终点y坐标
	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAccelerations() {
		return accelerations;
	}

	public void setAccelerations(int accelerations) {
		this.accelerations = accelerations;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
