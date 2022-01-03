/*
Name: Connect 4
Date: 2021-04-05
Author: Elill Mathivannan
Version: 1.0.0
*/
import arc.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.image.*;
public class CPTConnect4{

    public static void main(String[] args) {
        Console window = new Console(1280, 720);
        //variables and file for colours
        TextInputFile txtSettings;
		txtSettings = new TextInputFile("settings.txt");
		String strBack;
		int intBack1=0;
		int intBack2=0;
		int intBack3=0;
		String strText; 
		int intText1=255;
		int intText2=255;
		int intText3=255;
		String strBoard; 
		int intBoard1=255;
		int intBoard2=0;
		int intBoard3=0;
		String strPOne; 
		int intPOne1=0;
		int intPOne2=255;
		int intPOne3=0;
		String strPTwo; 
		int intPTwo1=0; 
		int intPTwo2=255;
		int intPTwo3=255;
		//read file and stores results in variables
		while(txtSettings.eof() == false){
			strBack = txtSettings.readLine();
			intBack1 = txtSettings.readInt();
			intBack2 = txtSettings.readInt();
			intBack3 = txtSettings.readInt();
			strText = txtSettings.readLine();
			intText1 = txtSettings.readInt();
			intText2 = txtSettings.readInt();
			intText3 = txtSettings.readInt();
			strBoard = txtSettings.readLine();
			intBoard1 = txtSettings.readInt();
			intBoard2 = txtSettings.readInt();
			intBoard3 = txtSettings.readInt();
			strPOne = txtSettings.readLine();
			intPOne1 = txtSettings.readInt();
			intPOne2 = txtSettings.readInt();
			intPOne3 = txtSettings.readInt();
			strPTwo = txtSettings.readLine();
			intPTwo1 = txtSettings.readInt();
			intPTwo2 = txtSettings.readInt();
			intPTwo3 = txtSettings.readInt();
		}
		txtSettings.close();
		//set text colour
		window.setTextColor(new Color(intText1, intText2, intText3));
		//initialize and create variable for input on home screen
        String strInput = "";
        //variables for player names
        String strName1;
        String strName2;
        //variable for if player wants to play again
        String strChoice = "";
        //variable used when player goes back to the main menu
        String strContinue2 = "";
        //variable for wins of each player
        int intP1Win = 0;
        int intP2Win = 0;
        while (!strInput.equalsIgnoreCase("q")) {
			//main menu
            CPTools.display(window, intBack1, intBack2, intBack3, intText1, intText2, intText3);
            for (int intCount = 0; intCount < 8; intCount++) {
                window.println("");
            }
            window.print("Pick an option: ");
            strInput = window.readLine();
            if (strInput.equalsIgnoreCase("s")) {
				//secret menu
				CPTools.secret(window, intBack1, intBack2, intBack3);
                window.print("Enter any key to continue: ");
                strContinue2 = window.readLine();
			}
            if (strInput.equalsIgnoreCase("h")) {
				//help menu
				CPTools.help(window, intBack1, intBack2, intBack3, intText1, intText2, intText3);
				for (int intCount = 0; intCount < 3; intCount++) {
					window.println("");
				}
                window.print("Enter any key to continue: ");
                strContinue2 = window.readLine();
			}
            if (strInput.equalsIgnoreCase("l")) {
				//leaderboard
				CPTools.leaderboard(window, intBack1, intBack2, intBack3, intText1, intText2, intText3);
                window.print("Enter any key to continue: ");
                strContinue2 = window.readLine();
			}
            if (strInput.equalsIgnoreCase("p")) {
				//ask for names menu
                CPTools.name(window, intBack1, intBack2, intBack3, intText1, intText2, intText3);
                for (int intCount = 0; intCount < 2; intCount++) {
                    window.println("");
                }
                window.print("Player 1's name is: ");
                strName1 = window.readLine();
                for (int intCount = 0; intCount < 5; intCount++) {
                    window.println("");
                }
                window.print("Player 2's name is: ");
                strName2 = window.readLine();
                while (!strChoice.equalsIgnoreCase("n")) {
					//main game
                    String strContinue = "";
                    char chrBoard[][] = new char[6][7];
                    int intPlay = 0;
                    //initialize array
                    for (int intRow = 0; intRow < chrBoard.length; intRow++) {
                        for (int intCol = 0; intCol < chrBoard[0].length; intCol++) {
                            chrBoard[intRow][intCol] = ' ';
                        }
                    }
                    CPTools.board(chrBoard, window, intBack1, intBack2, intBack3, intText1, intText2, intText3, intBoard1, intBoard2, intBoard3);
                    int intTurn = 1;
                    char chrPlayer = '1';
                    boolean blnWinner = false;
                    String strName;
                    strName = strName1;

                    //play a turn
                    while (blnWinner == false && intTurn <= 42) {
                        boolean blnValidPlay;
                        window.clear();
                        do {
                            window.print("                                                         ");
                            window.print("Player " + strName + ", choose a column between 0-6:");
                            intPlay = window.readInt();

                            //validate play
                            blnValidPlay = CPTools.valid(intPlay, chrBoard);
                            //drop piece
                            for (int intRow = chrBoard.length -1; intRow >= 0; intRow--) {
                                if (chrBoard[intRow][intPlay] == ' ') {
                                    chrBoard[intRow][intPlay] = chrPlayer;
                                    break;
                                }
                            }
                            //draw pieces
                            for (int intRow = 5; intRow >= 0; intRow--) {
                                //p1 piece
                                if (chrBoard[intRow][intPlay] == '1') {
                                    window.clear();
                                    window.setDrawColor(new Color(intPOne1, intPOne2, intPOne3));
                                    window.fillOval(((intPlay - 1) * 96) + 96, (intRow * 96) + 40, 96, 96);
                                    window.repaint();
                                    window.sleep(100);
                                    window.repaint();
                                }
                                //p2 piece
                                else if (chrBoard[intRow][intPlay] == '2') {
                                    window.clear();
                                    window.setDrawColor(new Color(intPTwo1, intPTwo2, intPTwo3));
                                    window.fillOval(((intPlay - 1) * 96) + 96, (intRow * 96) + 40, 96, 96);
                                    window.repaint();
                                    window.sleep(100);
                                    window.repaint();
                                }
                            }
                        } while (blnValidPlay == false);

                        //determine if there is a winner
                        blnWinner = CPTools.isWinner(chrPlayer, chrBoard);
                        //switch players
                        if (chrPlayer == '1') {
                            chrPlayer = '2';
                        } else {
                            chrPlayer = '1';
                        }
                        if (strName.equals(strName1)) {
                            strName = strName2;
                        } else {
                            strName = strName1;
                        }
                        intTurn++;
                    }
                    while (!strContinue.equalsIgnoreCase("c")) {
						//p2 win
                        if (blnWinner) {
                            if (chrPlayer == '1') {
                                intP2Win += 1;
                                strName = strName2;
                                CPTools.Font(window, "Roboto-Regular.ttf", 32, strName + " wins!!!!", 690, -10);
                                window.repaint();
                                for (int intCount = 0; intCount < 3; intCount++) {
                                    window.println("");
                                }
                                window.print("                                                         ");
                                window.print("Enter c to continue: ");
                                strContinue = window.readLine();
                                if (strContinue.equalsIgnoreCase("c")) {
									//ask to play again
                                    CPTools.again(window, intBack1, intBack2, intBack3, intText1, intText2, intText3, strName);
                                    for (int intCount = 0; intCount < 3; intCount++) {
                                        window.println("");
                                    }
                                    window.print("Play again any key (yes) / 'n' (no): ");
                                    strChoice = window.readLine();
                                }
                            } else {
								//p1 win
                                intP1Win += 1;
                                strName = strName1;
                                CPTools.Font(window, "Roboto-Regular.ttf", 32, strName + " wins!!!", 690, -10);
                                window.repaint();
                                for (int intCount = 0; intCount < 3; intCount++) {
                                    window.println("");
                                }
                                window.print("                                                         ");
                                window.print("Enter c to continue: ");
                                strContinue = window.readLine();
                                if (strContinue.equalsIgnoreCase("c")) {
									//ask to play again
                                    CPTools.again(window, intBack1, intBack2, intBack3, intText1, intText2, intText3, strName);
                                    for (int intCount = 0; intCount < 3; intCount++) {
                                        window.println("");
                                    }
                                    window.print("Play again any key (yes) / 'n' (no): ");
                                    strChoice = window.readLine();
                                }
                            }
                            if (strChoice.equalsIgnoreCase("n")) {
								//leaderboard
                                TextOutputFile txtHiOut = new TextOutputFile("Highscores.txt", true);
                                txtHiOut.println(strName1);
                                txtHiOut.println(intP1Win);
                                txtHiOut.println(strName2);
                                txtHiOut.println(intP2Win);
                                txtHiOut.close();
                                CPTools.leaderboard(window, intBack1, intBack2, intBack3, intText1, intText2, intText3);
                                window.print("Enter any key to continue: ");
                                strContinue2 = window.readLine();
                            }
                        } else {
							//tie game
                            CPTools.Font(window, "Roboto-Regular.ttf", 32, "Tie game!!!", 690, -10);
                            window.repaint();
                            for (int intCount = 0; intCount < 3; intCount++) {
                                window.println("");
                            }
                            window.print("                                                         ");
                            window.print("Enter c to continue: ");
                            strContinue = window.readLine();
                            if (strContinue.equalsIgnoreCase("c")) {
								//ask to play again
								strName = "No one";
                                CPTools.again(window, intBack1, intBack2, intBack3, intText1, intText2, intText3, strName);
                                for (int intCount = 0; intCount < 3; intCount++) {
                                    window.println("");
                                }
                                window.print("Play again any key (yes) / 'n' (no): ");
                                strChoice = window.readLine();
                                if (strChoice.equalsIgnoreCase("n")) {
									//leaderboard
                                    TextOutputFile txtHiOut = new TextOutputFile("Highscores.txt", true);
                                    txtHiOut.println(strName1);
                                    txtHiOut.println(intP1Win);
                                    txtHiOut.println(strName2);
                                    txtHiOut.println(intP2Win);
                                    txtHiOut.close();
                                    CPTools.leaderboard(window, intBack1, intBack2, intBack3, intText1, intText2, intText3);
                                    window.print("Enter any key to continue: ");
                                    strContinue2 = window.readLine();
                                }
                            }
                        }
                        window.clear();
                    }
                }
            }
        }
        window.closeConsole();
    }
}

