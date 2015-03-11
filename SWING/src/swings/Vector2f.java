package swings;

public class Vector2f {

	public float xPosition;
	public float yPosition;
		
	public Vector2f() {
		this.xPosition = 0.0f;
		this.yPosition = 0.0f;
	}
		
	public Vector2f(float xPosition, float yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}	
	
	
	public void normalizieren() {
		double length = Math.sqrt(xPosition * xPosition + yPosition * yPosition);
	
		if(length != 0.0) {
			float s = 1.0f / (float) length;
			xPosition = xPosition * s;
			yPosition = yPosition * s;
		}
	}
	
	
	public boolean istVektorDeckungsgleich(Vector2f v) {
		return (this.xPosition == v.xPosition && this.yPosition == v.yPosition);
	}
	
	
	public Vector2f kopieren(Vector2f v) {
		
		xPosition = v.xPosition;
		yPosition = v.yPosition;
		return new Vector2f(xPosition, yPosition);
	}
	
	public Vector2f addieren(Vector2f v) {
		
		xPosition = this.xPosition + v.xPosition;
		yPosition = this.yPosition + v.yPosition;
		
		return new Vector2f(xPosition,yPosition);
	}

	public Vector2f subtrahieren(Vector2f v) {
		
		xPosition = this.xPosition - v.xPosition;
		yPosition = this.yPosition - v.yPosition;
		
		return new Vector2f(xPosition,yPosition);
	}

	public static double getDistanze(Vector2f v2, Vector2f v1) {
		float vx = v2.xPosition - v1.xPosition;
		float vy = v2.yPosition - v1.yPosition;
		return Math.sqrt(vx * vx + vy * vy);
	}
	
	
}
