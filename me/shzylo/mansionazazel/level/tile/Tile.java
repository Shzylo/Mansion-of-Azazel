package me.shzylo.mansionazazelvisual.level.tile;

import me.shzylo.mansionazazelvisual.gfx.Screen;
import me.shzylo.mansionazazelvisual.gfx.Sprite;

public class Tile {

  public int x, y;
	public Sprite sprite;

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile bush = new BushTile(Sprite.bush);
	
	public static Tile treeTrunk = new TreeTrunkTile(Sprite.treeTrunk);
	public static Tile treeTop = new TreeTopTile(Sprite.treeTop);
	public static Tile treeTop_L = new TreeTop_LeftTile(Sprite.treeTop_L);
	public static Tile treeTop_T = new TreeTop_TopTile(Sprite.treeTop_T);
	public static Tile treeTop_R = new TreeTop_RightTile(Sprite.treeTop_R);
	public static Tile treeTop_B = new TreeTop_BottomTile(Sprite.treeTop_B);
	public static Tile treeTop_TR = new TreeTop_TopRightTile(Sprite.treeTop_TR);
	public static Tile treeTop_TL = new TreeTop_TopLeftTile(Sprite.treeTop_TL);
	public static Tile treeTop_BR = new TreeTop_BottomRightTile(Sprite.treeTop_BR);
	public static Tile treeTop_BL = new TreeTop_BottomLeftTile(Sprite.treeTop_BL);
	
	public static Tile road = new RoadTile(Sprite.road);
	public static Tile roadDash = new RoadDashTile(Sprite.roadDash);
	
	public static Tile water = new WaterTile(Sprite.water);
	
	public static Tile dirtRoadDicipateL = new DirtRoadDicipateLTile(Sprite.dirtRoadDicipateL);
	public static Tile dirtRoad = new DirtRoadTile(Sprite.dirtRoad);
	public static Tile dirtRoadDicipateR = new DirtRoadDicipateRTile(Sprite.dirtRoadDicipateR);
	
	public static Tile cobble = new CobbleTile(Sprite.cobble);
	public static Tile woodPeg = new WoodPegTile(Sprite.woodPeg);
	public static Tile wood = new WoodTile(Sprite.wood);
	public static Tile woodL = new WoodLeftTile(Sprite.woodL);
	
	public static Tile boat = new BoatTile(Sprite.boat);
	public static Tile boat_ = new Boat_Tile(Sprite.boat_);
	
	public static Tile car_0 = new Car_0Tile(Sprite.car_0);
	public static Tile car_1 = new Car_1Tile(Sprite.car_1);
	public static Tile car_2 = new Car_2Tile(Sprite.car_2);
	public static Tile car_3 = new Car_3Tile(Sprite.car_3);
	public static Tile car_4 = new Car_4Tile(Sprite.car_4);
	public static Tile car_5 = new Car_5Tile(Sprite.car_5);

	
	
	public static final int grassColor = 0xFFB6FF00;
	
	public static final int treeTrunkColor = 0xFF7F3300;
	public static final int treeTopColor = 0xFF007F0E;
	public static final int treeTop_LColor = 0xFF00CC06;
	public static final int treeTop_TColor = 0xFF00C610;
	public static final int treeTop_RColor = 0xFF00B70C;
	public static final int treeTop_BColor = 0xFF00A808;
	public static final int treeTop_TLColor = 0xFF00CC0D;
	public static final int treeTop_TRColor = 0xFF00D80A;
	public static final int treeTop_BLColor = 0xFF00E507;
	public static final int treeTop_BRColor = 0xFF00F204;
	
	public static final int roadColor = 0xFF303030;
	public static final int roadDashColor = 0xFF3A3A3A;
	
	public static final int waterColor = 0xFF0026FF;
	
	public static final int dirtRoadColor = 0xFF8C3800;
	public static final int dirtRoadDicipateLColor = 0xFF993A00;
	public static final int dirtRoadDicipateRColor = 0xFFA53C00;
	
	public static final int cobbleColor = 0xFF9E0000;
	public static final int woodPegColor = 0xFFC14D00;
 	public static final int woodColor = 0xFF913A00;
 	public static final int woodLColor = 0xFF993D00;
 	
 	public static final int boatColor = 0xFFD85600;
 	public static final int boat_Color = 0xFFE55700;
	
	public static final int car_0Color = 0xFFFF0000;
	public static final int car_1Color = 0xFFF20000;
	public static final int car_2Color = 0xFFE50000;
	public static final int car_3Color = 0xFFD80000;
	public static final int car_4Color = 0xFFCC0000;
	public static final int car_5Color = 0xFFBF0000;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}
	
	public boolean isSolid() {
		return false;
	}
}
