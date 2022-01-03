import arc.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.font.*;

public class CPTools{
	public static void display(Console con, int intBack1, int intBack2, int intBack3, int intText1, int intText2, int intText3){
		//main menu
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		con.setDrawColor(new Color(intText1, intText2, intText3));
		BufferedImage imgEnter;
		BufferedImage imgBoard;
		imgBoard = con.loadImage("board.jpg");
		imgEnter = con.loadImage("enter.png");
		CPTools.Font(con, "Oswald-Bold.ttf", 68, "CONNECT 4",0,-10);
		CPTools.Font(con, "Oswald-Regular.ttf", 24, "By: Elill Mathivannan",0,90);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "(P)lay",0,255);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "(H)elp",0,305);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "(L)eaderboard",0,355);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "(Q)uit",0,405);
		con.drawImage(imgEnter, 0, 655);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Confirm",80,655);
		con.drawImage(imgBoard, 700, 95);
		con.repaint();
	}
	public static void name(Console con, int intBack1, int intBack2, int intBack3, int intText1, int intText2, int intText3){
		//name menu
		BufferedImage imgEnter;
		imgEnter = con.loadImage("enter.png");
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		con.setDrawColor(new Color(intText1, intText2, intText3));
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Player 1 what is your name?",0,0);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Player 2 what is your name?",0,135);
		con.drawImage(imgEnter, 0, 655);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Confirm",80,655);
		con.repaint();
	}
	public static void again(Console con, int intBack1, int intBack2, int intBack3, int intText1, int intText2, int intText3, String strName){
		//play again menu
		BufferedImage imgVictory;
		imgVictory = con.loadImage("victory.jpg");
		BufferedImage imgEnter;
		imgEnter = con.loadImage("enter.png");
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		con.setDrawColor(new Color(intText1, intText2, intText3));
		CPTools.Font(con, "Roboto-Regular.ttf", 36, strName + " wins this round!!!",0,0);
		con.drawImage(imgEnter, 0, 655);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Confirm",80,655);
		con.drawImage(imgVictory, 425, 180);
		con.repaint();
	}
	public static void leaderboard(Console con, int intBack1, int intBack2, int intBack3, int intText1, int intText2, int intText3){
		//leaderboard menu
		BufferedImage imgEnter;
		imgEnter = con.loadImage("enter.png");
		TextInputFile txtHiIn;
		txtHiIn = new TextInputFile("Highscores.txt");
		String strScores[][];
		int intRow;
		int intScoreCount = 0;
		int intPosY = 100;
		String strName;
		String strScore;
		while(txtHiIn.eof() == false){
			strName = txtHiIn.readLine();
			strScore = txtHiIn.readLine();
			intScoreCount += 1;
		}
		strScores = new String[intScoreCount][2];
		txtHiIn.close();
		txtHiIn = new TextInputFile("Highscores.txt");
		for(intRow = 0; intRow < intScoreCount; intRow++){
			strScores[intRow][0] = txtHiIn.readLine();
			strScores[intRow][1] = txtHiIn.readLine();
		}
		txtHiIn.close();
		String strTemp;
		String strLeft;
		String strRight;
		int intOut;
		//bubble sort
		for(intOut = 0; intOut < intScoreCount; intOut++){
			for(intRow = 0; intRow < intScoreCount-1; intRow++){
				strLeft = strScores[intRow][1];
				strRight = strScores[intRow+1][1];
				if(Double.parseDouble(strLeft) < Double.parseDouble(strRight)){
					strTemp = strScores[intRow][1];
					strScores[intRow][1] = strScores[intRow+1][1];
					strScores[intRow+1][1] = strTemp;
					
					strTemp = strScores[intRow][0];
					strScores[intRow][0] = strScores[intRow+1][0];
					strScores[intRow+1][0] = strTemp;
				}
			}
		}
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		con.setDrawColor(new Color(intText1, intText2, intText3));
		CPTools.Font(con, "Pacifico.ttf", 48, "Leaderboard",500,0);
		for(intRow = 0; intRow < intScoreCount; intRow++){
			CPTools.Font(con, "Roboto-Regular.ttf", 36, strScores[intRow][0], 500,intPosY);
			CPTools.Font(con, "Roboto-Regular.ttf", 36, strScores[intRow][1], 750,intPosY);
			intPosY += 40;
		}
		con.drawImage(imgEnter, 0, 655);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Confirm",80,655);
		con.repaint();
	}
	public static void help(Console con, int intBack1, int intBack2, int intBack3, int intText1, int intText2, int intText3){
		//help menu
		BufferedImage imgHelp;
		imgHelp = con.loadImage("help.jpeg");
		BufferedImage imgEnter;
		imgEnter = con.loadImage("enter.png");
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		con.setDrawColor(new Color(intText1, intText2, intText3));
		CPTools.Font(con, "Roboto-Regular.ttf", 48, "Help",0,0);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "Welcome to Connect 4!",0,185);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "When playing make sure",0,220);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "to only choose between",0,255);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "coulmns 0-6. Check out",0,290);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "the leaderboard to see",0,325);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "your scores. You could",0,360);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "also change colours in",0,395);
		CPTools.Font(con, "Roboto-Regular.ttf", 32, "settings.txt. Have fun!!!",0,430);
		con.drawImage(imgHelp, 425, 180);
		con.drawImage(imgEnter, 0, 655);
		CPTools.Font(con, "Roboto-Regular.ttf", 36, "Confirm",80,655);
		con.repaint();
	}
	public static void secret(Console con, int intBack1, int intBack2, int intBack3){
		//secret menu
		BufferedImage imgSecret;
		imgSecret = con.loadImage("secret.jpg");
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		con.drawImage(imgSecret, 330, 180);
	}
	public static void board(char chrBoard[][],Console con, int intBack1, int intBack2, int intBack3, int intText1, int intText2, int intText3, int intBoard1, int intBoard2, int intBoard3){
		//draw board
		con.clear();
		con.setBackgroundColor(new Color(intBack1, intBack2, intBack3));
		int startY = 40;
		int startX = 0;
		int cellWidth = 96;
		con.setDrawColor(new Color(intText1, intText2, intText3));
		Font(con, "Oswald-Regular.ttf", 40, "    0         1        2         3        4         5        6",0,-20);
		con.setDrawColor(new Color(intBoard1, intBoard2, intBoard3));
		con.fillRect(0, 40, 672, 576); //560,480
		for(int row = 0; row < chrBoard.length; row++){
			for(int col = 0; col < chrBoard[0].length; col++){
				con.setDrawColor(new Color(255, 255, 255));
				con.fillOval(startX, startY, cellWidth, cellWidth);
				startX = startX + cellWidth;
			}
			startX = 0;
			startY += cellWidth;
		}
	}
	
	public static boolean valid(int intColumn, char chrBoard[][]){
		//valid intColumn?
		if (intColumn < 0 || intColumn > chrBoard[0].length || intColumn >= 7){
			return false;
		}
		//full intColumn?
		if (chrBoard[0][intColumn] != ' '){
			return false;
		}
		
		return true;
	}
	
	public static boolean isWinner(char chrPlayer, char chrBoard[][]){
		//check for 4 across
		for(int intRow = 0; intRow<chrBoard.length; intRow++){
			for (int intCol = 0;intCol < chrBoard[0].length - 3;intCol++){
				if (chrBoard[intRow][intCol] == chrPlayer   && 
					chrBoard[intRow][intCol+1] == chrPlayer &&
					chrBoard[intRow][intCol+2] == chrPlayer &&
					chrBoard[intRow][intCol+3] == chrPlayer){
					return true;
				}
			}			
		}
		//check for 4 up and down
		for(int intRow = 0; intRow < chrBoard.length - 3; intRow++){
			for(int intCol = 0; intCol < chrBoard[0].length; intCol++){
				if (chrBoard[intRow][intCol] == chrPlayer   && 
					chrBoard[intRow+1][intCol] == chrPlayer &&
					chrBoard[intRow+2][intCol] == chrPlayer &&
					chrBoard[intRow+3][intCol] == chrPlayer){
					return true;
				}
			}
		}
		//check upward diagonal
		for(int intRow = 3; intRow < chrBoard.length; intRow++){
			for(int intCol = 0; intCol < chrBoard[0].length - 3; intCol++){
				if (chrBoard[intRow][intCol] == chrPlayer   && 
					chrBoard[intRow-1][intCol+1] == chrPlayer &&
					chrBoard[intRow-2][intCol+2] == chrPlayer &&
					chrBoard[intRow-3][intCol+3] == chrPlayer){
					return true;
				}
			}
		}
		//check downward diagonal
		for(int intRow = 0; intRow < chrBoard.length - 3; intRow++){
			for(int intCol = 0; intCol < chrBoard[0].length - 3; intCol++){
				if (chrBoard[intRow][intCol] == chrPlayer   && 
					chrBoard[intRow+1][intCol+1] == chrPlayer &&
					chrBoard[intRow+2][intCol+2] == chrPlayer &&
					chrBoard[intRow+3][intCol+3] == chrPlayer){
					return true;
				}
			}
		}
		return false;
	}
	public static void Font(Console con, String fontType, int fontSize, String message, int intx, int inty){
		//fonts
        Font newFont = con.loadFont(fontType, fontSize);
        con.setDrawFont(newFont);
        con.drawString(message, intx, inty);

    }
}
