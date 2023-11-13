import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * A GUI program that allows the user to click on rectangular tiles, overlaying on each other
 */
public class TileWorld {

	private ArrayList<Tile> tiles;  // first tile = bottom-most;  last tile = top-most

	/* for keeping track of dragging */
	private Tile dragging;   // if not null, it's the tile being dragged
	private int dragX;   // reference points for drag
	private int dragY;

	/* for keeping track of new drawing */
	private boolean isDrawingNew;
	private int newX;   // reference points for new one being drawn
	private int newY; 
	
	/* the current comparator */
	private Comparator<Tile> comp; 

	
	

	/* constructors */

	public TileWorld() {
		this(new Tile[] {});
	}

	TileWorld(Tile[] tiles) {
		this.tiles = new ArrayList<Tile>(Arrays.asList(tiles));
		this.dragging = null;
		this.isDrawingNew = false;
		this.comp = TilesApp.NAME_C;
	}



	/* helper functions */


	/**
	 * Returns the top-most tile that contains the given point.
	 * Returns `null` if no tiles under the given point.
	 * 
	 */
	public Tile select(int x, int y) {  
		///Tile selected = null;
		//for ( int i = 0 ; i < this.tiles.size() ; i++ ) {

		for ( int i = this.tiles.size() - 1 ; i >= 0 ; i--)  {

			if (this.tiles.get(i).contains(x,  y)) {
				return this.tiles.get(i);

				//selected = this.tiles.get(i);
				//break;
			}
		}

		return null;
		//return selected;
	}


	/**
	 * Returns a list of the tiles that contain the given
	 * point. (May be empty.) The order of tiles in the 
	 * list that is returned preserves the order that the
	 * tiles are in this world. 
	 */
	public ArrayList<Tile> selectAll(int x, int y) {
		ArrayList<Tile> selected = new ArrayList<Tile>();

		//for ( int i = 0 ; i < this.tiles.size() ; i++ ) {
		//	Tile t = this.tiles.get(i);

		for ( Tile t : this.tiles) {		// <-----   "for each" loop
			if (t.contains(x,  y)) {
				selected.add( t );
			}
		}

		return selected;
	}


	/**
	 * Moves the top-most tile that contains the given 
	 * point to the top (end) of the tiles list.
	 * Does nothing if no tiles under the given point.
	 */
	public void raise(int x, int y) {
		// TODO 
		// figure out the selected tile, if any
		// move the selected tile to the *end* of the array list

		Tile selected = this.select(x, y);
		if (selected != null) {
			this.tiles.remove(selected);
			this.tiles.add(selected);
		}
	}


	/**
	 * Moves the top-most tile that contains the given 
	 * point to the bottom (beginning) of the tiles list.
	 * Does nothing if no tiles under the given point.
	 */
	public void lower(int x, int y) {
        Tile selected = select(x, y);
        
        if (selected != null) {
            tiles.remove(selected);
            tiles.add(0, selected);
        }           
	}


	/**
	 * Removes the top-most tile that contains the given point.
	 * Does nothing if no tiles under the given point.
	 */    
	public void delete(int x, int y) {
        Tile selected = select(x, y);
        
        if (selected != null) {
            tiles.remove(selected);
        }           
	}


	/**
	 * Removes all tiles that fall under the given point.
	 */    
	public void deleteAll(int x, int y) {

		tiles.removeAll( selectAll(x, y) );

		/*
		//for ( int i = 0; i < this.tiles.size(); i++ ) {

		for ( int i = this.tiles.size() - 1 ; i >= 0 ; i--)  {
			Tile t  = this.tiles.get(i);
			if (t.contains(x,  y)) {
				this.tiles.remove(i);
			}
		}
		 */

		/*
		for ( Tile t : this.tiles) {		// <-----   "for each" loop
			if (t.contains(x,  y)) {
				this.tiles.remove(t);
			}
		}
		 */

	}



	/**
	 * Rearranges the tiles by placing the bottom-most at
	 * the top-left of the window, and then staggering the
	 * rest of them by the given spacing amount in the
	 * horizontal and vertical directions. 
	 */
	public void rearrange(int spacing) {
		for (int i = 0; i < this.tiles.size(); i++) {
			this.tiles.get(i).moveTo( (i+1)*spacing, (i+1)*spacing );
		}
	}

	/**
	 * Arranges tiles in order whatever the
	 * current comparator is
	 */
	public void sortTiles() {
		Collections.sort(  this.tiles , this.comp );
		this.rearrange(20);
	}
	

	/**
	 * Arranges tiles in reverse order whatever the
	 * current comparator is
	 */
	public void sortReverse() {
		Collections.sort(  this.tiles , this.comp.reversed() );
		this.rearrange(20);
	}
	
	
	/**
	 * saves the state of the tiles in the window to a text file
	 */
	public void saveTiles() {
	    try {
	        String filename = javax.swing.JOptionPane.showInputDialog("Please enter file name:");
	        filename = filename.trim();
	        if (filename.equals("")) {
	            javax.swing.JOptionPane.showMessageDialog(null, "Cannot save to a blank name");
	            return;
	        }
	        if (! filename.endsWith(".txt")) {
	            filename = filename + ".txt";
	        }
	        
    	    PrintWriter pw = new PrintWriter(new File(filename));
    	    
    	    for (Tile t : this.tiles) {    // for-each
    	        t.writeToFile(pw);
    	    }
    	    
    	    pw.close();
	    } catch (IOException exp) {
	        System.out.println("Problem saving tiles: " + exp.getMessage());
	    }
	}
	
	
	/**
	 * restores the state of the tiles in the window from a text file
	 */
	public void loadTiles() {
	    try {
	        String filename = javax.swing.JOptionPane.showInputDialog("Please enter file name:");
            filename = filename.trim();
            if (filename.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Cannot load from a blank name");
                return;
            }
            if (! filename.endsWith(".txt")) {
                filename = filename + ".txt";
            }
            
	        Scanner sc = new Scanner(new File(filename));
	        this.tiles.clear();
	        
	        while (sc.hasNextInt()) {	            
	            Tile t = new Tile(sc);
	            this.tiles.add(t);
	        }
	        
	        sc.close();
	    } catch (IOException exp) {
	        System.out.println("Problem loading tiles: " + exp.getMessage());
	    }
	    
	    
	}



	/* GUI and event-handling methods below */

	public void update() {
		if (!tiles.isEmpty()) {
			tiles.get(tiles.size() - 1).update();
		}
	}

	public void draw(PApplet c) {
		c.background(255);
		for (Tile t : tiles) {
			t.draw(c);
		}

		if (this.isDrawingNew) {
			buildNew(true).draw(c);
		}

	}


	public void mousePressed(MouseEvent mev) {
		int x = mev.getX();
		int y = mev.getY();

		if (mev.getButton() == PApplet.LEFT) {
			this.dragX = x;
			this.dragY = y;
			this.dragging = select(x, y);

			if (mev.isShiftDown()) {
				this.lower(x, y);
			} else if (mev.isMetaDown()) {
				this.dragging = null;
			}else {
				this.raise(x, y);
			}
		} else if (mev.getButton() == PApplet.RIGHT) {
			this.dragging = null;

			if (mev.isShiftDown()) {
				this.deleteAll(x, y);
			} else {
				this.delete(x, y);
			}
		}
	}

	public void mouseReleased(MouseEvent mev) {
		if (this.isDrawingNew) {
			this.tiles.add(buildNew(false));
		}
		this.dragging = null;
		this.isDrawingNew = false;
	}

	public void mouseDragged(MouseEvent mev) {
		int x = mev.getX();
		int y = mev.getY();

		if (this.dragging == null) {
			if (!this.isDrawingNew) {
				this.isDrawingNew = true;
				this.newX = x;
				this.newY = y;
			}
		} else {
			this.dragging.moveBy(x - this.dragX, y - this.dragY);
		}

		this.dragX = x;
		this.dragY = y;
	}

	public void mouseEntered(MouseEvent mev) {
		// nothing
	}

	public void mouseMoved(MouseEvent mev) {
		// nothing
	}

	public void mouseExited(MouseEvent mev) {
		this.dragging = null;
	}

	public void keyPressed(KeyEvent kev) {
		//System.out.println(kev);
		if (kev.getKeyCode() == PApplet.DELETE || kev.getKeyCode() == PApplet.BACKSPACE) {
			if (!tiles.isEmpty()) {
				tiles.remove(tiles.size() - 1);
			}
		} else
			switch (Character.toLowerCase(kev.getKey())) {
				case 'n': tiles.add(new Tile()); break;
				case 'r': this.rearrange(20); break;
				case '>': this.sortTiles(); break;
				case '<': this.sortReverse(); break;
				case '1': this.comp = TilesApp.NAME_C; break;
				case '2': this.comp = TilesApp.AREA_C; break;
				case 's': this.saveTiles(); break;
				case 'o': this.loadTiles(); break;
				// default:  ...  break;
			}
	}


	/* private helper methods */

	/*
	 * Using the (newX, newY) and (dragX, dragY) as the diagonal
	 * endpoints, 
	 * generates a gray, unlabeled tile if 'temporary';
	 * otherwise, generates and returns a randomly-colored
	 * and labeled tile.
	 */
	private Tile buildNew(boolean temporary) {
		if (temporary) {
			return new Tile(Math.min(this.newX, this.dragX), 
					Math.min(this.newY, this.dragY), 
					Math.abs(this.newX - this.dragX),
					Math.abs(this.newY - this.dragY), 
					"", Color.GRAY, 0);
		} else {
			return new Tile(Math.min(this.newX, this.dragX), 
					Math.min(this.newY, this.dragY), 
					Math.abs(this.newX - this.dragX),
					Math.abs(this.newY - this.dragY));
		}
	}

}










