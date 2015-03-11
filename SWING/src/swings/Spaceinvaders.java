package swings;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Spaceinvaders implements KeyListener {

	private Fenster fenster;
	private ReadFiles readFiles;
	private List<ArrayList<Figuren>> listOfAlienList;
	private ArrayList<Shuttle1> shuttleList;
	private ArrayList<Figuren> schussList;
	
	private int tempXAlien = 0, tempYAlien = 0, tempXShuttle = 37, tempYShuttle = 23, tempYSchuss = 23, alienVerzögerung = 150;
	private int	counterAlienBewegung = 0, counterAlienAussehen = 0, counterShuttleAussehen = 0;
	private boolean alienRouteStarten = false, richtung = true, gameFinished = false, gameOver = true;
	private Point tempAlienAchse = new Point();
	
	public Spaceinvaders(Fenster fenster) {
		this.fenster = fenster;
		fenster.addKeyListener(this);
		init();
	}

	public void init() {
		erstellenListen();
		objekteErstellenUndInListenBefüllen();
		abstandSetzenAliens();
		abstandSetzenShuttle(tempXShuttle, tempYShuttle); // bewegt den shuttle in die mitte bevor das spiel startet
	}
	
	public void ticker() {
		fenster.repaint();
		verzögerungAlienBewegung(alienVerzögerung);
		routeAbfahrenSchuss();
		aussehenÄndernFiguren();
		schussEntfernenNachTreffer();
		alienEntfernenNachKompletterAbschuss();
		alleAlienZerstört();
		zeichnenAlles();
	}
	
	public void erstellenListen() {
		listOfAlienList = new ArrayList<ArrayList<Figuren>>();
		shuttleList = new ArrayList<Shuttle1>();
		schussList = new ArrayList<Figuren>();
		
		for (int i = 0; i < 5; i++) {   /* 5 sollte nicht hardcoded sein stattdessen die anzahl der alienfiguren rausfinden*/
			ArrayList<Figuren> alienList = new ArrayList<Figuren>();
			listOfAlienList.add(alienList);
		}
	}	

	public void objekteErstellenUndInListenBefüllen() {
		aliensErstellenUndInListenBefüllen(9);
		shuttleErstellenUndInListenBefüllen();
		filereaderErstellen();
	}
	
	private void filereaderErstellen() {
		readFiles = new ReadFiles();
	}
	
	private void aliensErstellenUndInListenBefüllen(int alienAnzahlProZeile) {
		for (int i = 0; i < alienAnzahlProZeile; i++) {
					
			Alien1 alien1 = new Alien1();
			listOfAlienList.get(0).add(alien1);
		
			Alien2 alien2 = new Alien2();
			listOfAlienList.get(1).add(alien2);
		
			Alien3 alien3 = new Alien3();
			listOfAlienList.get(2).add(alien3);
		
			Alien4 alien4 = new Alien4();
			listOfAlienList.get(3).add(alien4);
		
			Alien5 alien5 = new Alien5();
			listOfAlienList.get(4).add(alien5);
	
		}
	}
	
	private void shuttleErstellenUndInListenBefüllen() {
		Shuttle1 shuttle1 = new Shuttle1();
		shuttleList.add(shuttle1);
	}
	
	private void schussErstellenUndInListenBefüllen(int keyCode) {
		if(keyCode == KeyEvent.VK_SPACE) {
			schussNormalErstellen();
		}	
		if(keyCode == KeyEvent.VK_B) {
			schussBombErstellen();
		}
		if(keyCode == KeyEvent.VK_N) {
			schussNukeErstellen();
		}
	}
	
	public void schussNormalErstellen() {
		SchussNormal schuss1 = new SchussNormal();
		schussList.add(schuss1);
		schuss1.setPosition(shuttleList.get(0).getPosition().x +2,tempYSchuss);
	}
	
	public void schussBombErstellen() {
		SchussBomb schuss2 = new SchussBomb();
		schussList.add(schuss2);
		schuss2.setPosition(shuttleList.get(0).getPosition().x +1,tempYSchuss);
	}
	
	public void schussNukeErstellen() {
		SchussNuke schuss3 = new SchussNuke();
		schussList.add(schuss3);
		schuss3.setPosition(shuttleList.get(0).getPosition().x +2,tempYSchuss);
	}
	
	public boolean schussEntfernenNachTreffer() {
		for (int k = 0; k < listOfAlienList.size(); k++) {
			for (int j = 0; j < listOfAlienList.get(k).size(); j++) {
				
				Figuren schuss = istAlienVonEinSchussGetroffen(listOfAlienList.get(k).get(j),schussList);  
				
				if(schuss != null) {
					schuss.nextAussehen();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Automatisch generierter Erfassungsblock
						e.printStackTrace();
					}	
					schussList.remove(schuss);
					return true;
				}else {
				//TODO
				}
			}
		}
		return false;
	}
	
	public Figuren istAlienVonEinSchussGetroffen(Figuren alien, ArrayList<Figuren> schussList)
	{
		boolean isHit = false;
		for (int i = 0; i < schussList.size(); ++i)	{
			Point schussPosition = schussList.get(i).getPosition();
			isHit = alien.hit(schussPosition);
			if (isHit)	{
				return schussList.get(i);
			}
		}
		return null;
	}
	
	public void aussehenÄndernFiguren() {
		verzögerungAlienAussehen(10);
		verzögerungShuttleAussehen(5);
	}
	
	public void verzögerungAlienBewegung(int alienVerzögerung) {
		if(counterAlienBewegung == alienVerzögerung) {
			if(alienRouteStarten == true) {
				routeAbfahrenAliens(19,8);
			}
			counterAlienBewegung = 0;
		}else {
			counterAlienBewegung++;
		}
	}
	
	public void verzögerungAlienAussehen(int alienAussehenVerzögerung) {
		if(counterAlienAussehen == alienAussehenVerzögerung) {
			aussehenÄndernAlien();
			counterAlienAussehen = 0;
		} else {
			counterAlienAussehen++;
		}	
	}
	
	public void verzögerungShuttleAussehen(int shuttleAussehenVerzögerung) {
		if(counterShuttleAussehen == shuttleAussehenVerzögerung) {
			aussehenÄndernShuttle();
			counterShuttleAussehen = 0;
		} else {
			counterShuttleAussehen++;
		}	
	}
	
	public void cleanUp() {
		for (int i = 0; i < 2000; i++) {
			fenster.getLblList().get(i).setText("");
		}
	}

	public void zeichnenAlles() {
		cleanUp();
		zeichnenAlien();
		zeichnenShuttle();
		zeichnenSchuss();
		if(gameFinished) {
			zeichenGameOver(fenster, gameOver);
		}
	}
	
	public void zeichnenAlien() {
		for (int k = 0; k < listOfAlienList.size(); k++) {
			for (int j = 0; j < listOfAlienList.get(k).size(); j++) {
					listOfAlienList.get(k).get(j).zeichnenFiguren(fenster);
					fenster.repaint();
			}	
		}
	}

	public void zeichnenShuttle() {
		for (int i = 0; i < shuttleList.size(); i++) {	
			shuttleList.get(i).zeichnenFiguren(fenster);
			fenster.repaint();
		}	
	}
	
	public void zeichnenSchuss() {
		for (int i = 0; i < schussList.size(); i++) {	
				schussList.get(i).zeichnenFiguren(fenster);
				fenster.repaint();
		}
	}	
	
	public void zeichenGameOver(Fenster fenster, boolean gameOver) {
		try {
			readFiles.readfile(fenster, gameOver);
		} catch (IOException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}
	}
	
	public void routeAbfahrenAliens(int x, int y) {		
		Point alienMover = bewegenAlien(x,y);
		for (int k = 0; k < listOfAlienList.size(); k++) {
			for (int i = 0; i < listOfAlienList.get(k).size(); i++) {
				listOfAlienList.get(k).get(i).setPosition(listOfAlienList.get(k).get(i).getPosition().x + alienMover.x, listOfAlienList.get(k).get(i).getPosition().y + alienMover.y);
			}
		}
	}
	
	public void routeAbfahrenSchuss() {		
		for (int i = 0; i < schussList.size(); i++) {
			if(schussList.get(i).getPosition().y > 0) {
				schussList.get(i).routeAbfahren();
			}else {
				schussList.remove(i); //entfernt schuss da oberebande
			}
		}
	}
	
	public void abstandSetzenAliens() {
		for (int k = 0; k < listOfAlienList.size(); k++) {
			for (int i = 0; i < listOfAlienList.get(k).size(); i++) {
				listOfAlienList.get(k).get(i).setPosition((i * 7), ((k * 3) +1)); //(k*3) plus eins da die aliens in der zweiten zeile anfangen
				fenster.repaint();
			}
		}
	}
	
	public void abstandSetzenSchuss(int tempXSchuss, int tempYSchuss) {
		for (int i = 0; i < schussList.size(); i++) {	
			schussList.get(i).setPosition(tempXSchuss, tempYSchuss);
			fenster.repaint();
		}
	}
	
	public void aussehenÄndernAlien() {
		for (int k = 0; k < listOfAlienList.size(); k++) {	
			for (int j = 0; j < listOfAlienList.get(k).size(); j++) {
				listOfAlienList.get(k).get(j).nextAussehen();
			}
		}
	}
	
	public void aussehenÄndernShuttle() {
		for (int i = 0; i < shuttleList.size(); i++) {	
			shuttleList.get(i).nextAussehen();	
		}
	}
		
	public Point bewegenAlien(int x,int y) {
		if(richtung == true) {
			if(tempXAlien == x) {
				if(tempYAlien >= y) {
					removeAll();
					gameFinished = true;
					tempAlienAchse.x = 0;
					tempAlienAchse.y = 0;
				}else {
					tempYAlien++;
					tempAlienAchse.y = 1;
					tempAlienAchse.x = 0;
					alienVerzögerung /= 2;
					richtung = false;
				}
			}else {
				tempXAlien++;
				tempAlienAchse.x = 1;
				tempAlienAchse.y = 0;
			}
		
		}else {
			if(tempXAlien == 0) {
				if(tempYAlien >= y) {
					removeAll();
					gameFinished = true;
					tempAlienAchse.x = 0;
					tempAlienAchse.y = 0;
				}else {
					tempYAlien++;
					tempAlienAchse.y = 1;
					tempAlienAchse.x = 0;
					alienVerzögerung /= 2;
					richtung = true;	
				}
			}else {
				tempXAlien--;
				tempAlienAchse.x = -1;
				tempAlienAchse.y = 0;
			}
		}
	return tempAlienAchse;
	}
	
	public void bewegenShuttle(int keyCode) {

		 if (keyCode == KeyEvent.VK_RIGHT) {
			 if (tempXShuttle <= 74) {
				tempXShuttle++;
			 	abstandSetzenShuttle(tempXShuttle,tempYShuttle); 
			 }
		 }else if (keyCode == KeyEvent.VK_LEFT) {		
			 if (tempXShuttle >= 1)	{
				tempXShuttle--;
				abstandSetzenShuttle(tempXShuttle,tempYShuttle); 
			 }	
		 } 
	}
	
	public void abstandSetzenShuttle(int tempXShuttle, int tempYShuttle) {
		for (int i = 0; i < shuttleList.size(); i++) {
			shuttleList.get(i).setPosition((i * 5) + tempXShuttle, tempYShuttle); //((i * 5) + tempXShuttle, tempYShuttle) für den fall das mehrere shuttles existieren sonst kann man es auslassen
			fenster.repaint();
		}
	}
	
	public boolean alienReiheVertikalZerstört(int x) {

			if(listOfAlienList.get(0).size() == 9) {
				return false;
			}
		
		return true;
	}
	
	public boolean alleAlienZerstört() {
		for (int k = 0; k < listOfAlienList.size(); k++) {
			if(!(listOfAlienList.get(k).isEmpty())) { // not empty
				return false;
			}
		}
		gameFinished = true;
		gameOver = false;
		return true;
	}
	
	public void removeAll() {
		schussList.removeAll(schussList);
		listOfAlienList.removeAll(listOfAlienList);
	}
	
	public void alienEntfernenNachKompletterAbschuss() {
		for (int k = 0; k < listOfAlienList.size(); k++) {
			for (int j = 0; j < listOfAlienList.get(k).size(); j++) {
				if(listOfAlienList.get(k).get(j).figurIstKomplettZerstört()) {// ein sysout darf nicht nach object.remove() ausgeführt werden da sonst outOfIndex
					listOfAlienList.get(k).remove(j);
				}
			}
		}	
	}
	
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			alienRouteStarten = true;
		}
		schussErstellenUndInListenBefüllen(e.getKeyCode());
		bewegenShuttle(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Automatisch generierter Methodenstub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Automatisch generierter Methodenstub

	}

}
