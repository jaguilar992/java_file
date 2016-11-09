//package rotorhilos;

public class Console {

	public static final int ROWS = 51;
	public static final int COLS = 80;

	private static char[][] screen;
	private static int cursorRow = 0;
	private static int cursorCol = 0;

	public Console ()
	{
		screen = new char[ROWS][COLS];
		initScreen();
	}

	public void initScreen()
	{
		for (int row=0; row<ROWS; row++)
			for (int col=0; col<COLS; col++)
				screen[row][col] = ' ';
		cursorRow = 0;
		cursorCol = 0;
	}

	public void printScreen ()
	{
		String line = "";
		for (int row = 0; row < ROWS; row++) {
			for (int col=0; col<COLS; col++) {
				line += screen[row][col];
			}
		}
		System.out.println(line);
	}


	public void clearScreen ()
	{
		initScreen();
		// for (int i = cursorRow; i<(ROWS-1);i++ ) System.out.println(i);
		// printScreen();
	}

	public void putCharAt(char c, int row, int col)
	{
		if (row < 0 || row > (ROWS-1)) return;
		if (col < 0 || col > (COLS-1)) return;
		screen[row][col] = c;
		// reset cursor
		cursorCol = ++col;
		cursorRow = row;
		if (cursorCol == COLS) {
			cursorCol = 0;
			cursorRow++;
			if (cursorRow == ROWS) cursorRow = 0;
		}
	}

	public void putChar(char c)
	{
		screen[cursorRow][cursorCol++] = c;
		if (cursorCol == COLS) {
			cursorCol = 0;
			cursorRow++;
			if (cursorRow == ROWS) cursorRow = 0;
		}
	}

	public void putStringAt(String s, int row, int col)
	{
		for (int i=0; i<s.length(); i++)
			putCharAt(s.charAt(i), row, col++);
	}

	public void putString(String s)
	{
		putStringAt(s,cursorRow, cursorCol);
	}

	public void gotoXY (int x, int y)
	{
		if (x < 0 || x > (COLS-1)) return;
		if (y < 0 || y > (ROWS-1)) return;
		cursorRow = y;
		cursorCol = x;
	}

}