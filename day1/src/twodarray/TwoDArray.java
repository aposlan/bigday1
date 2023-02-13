package twodarray;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		char[][] game = new char[5][9];
		
		for(int i = 0; i < game.length; i++)
			for(int j = 0; j < game[i].length; j++)
				game[i][j] = 'x';
		
		game[2][4] = '.';
		
		for(int i = 0; i < game.length; i++)
			System.out.println(game[i]);
		
		String input = s.nextLine();
		int y = 2, x = 4;
		while(!input.equals("break")) {
			switch(input) {
			case "up":
				y -= 1;
				if(!(y<0)) {
					game[y+1][x] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				} else {
					y = game.length-1;
					game[0][x] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				}
			case "down":
				y += 1;
				if(!(y>game.length-1)) {
					game[y-1][x] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				} else {
					y = 0;
					game[game.length-1][x] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				}
			case "left":
				x -= 1;
				if(!(x<0)) {
					game[y][x+1] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				} else {
					x = game[y].length-1;
					game[y][0] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				}
			case "right":
				x += 1;
				if(!(x>game[y].length-1)) {
					game[y][x-1] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				} else {
					x = 0;
					game[y][game[y].length-1] = 'x';
					game[y][x] = '.';
					for(int i = 0; i < game.length; i++)
						System.out.println(game[i]);
					break;
				}
			}
			input = s.nextLine();
		}
		System.out.println("Game over!");
			
	}

}
