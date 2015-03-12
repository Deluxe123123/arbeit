package swings;
import java.io.*;

public class ReadFiles  {
	
	String string;
	int index = 0, y = 0, x;
	
	public void readfile(Fenster fenster, boolean gameOver) throws IOException{
		FileReader fr;	
		if(gameOver) {
			fr = new FileReader(getClass().getResource("/gameover.txt").getPath());
		}else {
			fr = new FileReader(getClass().getResource("/you-win.txt").getPath());
		}
	    BufferedReader br = new BufferedReader(fr);

	    string = "";

	    while( (string = br.readLine()) != null )
	    {
	    	zeichenGameOver(fenster);
	    	System.out.println(gameOver);
	    	y++;
	    }
	    y = 0;
	    br.close();
	}

	public void zeichenGameOver(Fenster fenster){
		for(x = 13; x < string.length()+13;x++) {
			index = (y+1) * 80 + x;
			fenster.getLblList().get(index).setText("" + string.charAt(x-13));	
		}
	}	
}

