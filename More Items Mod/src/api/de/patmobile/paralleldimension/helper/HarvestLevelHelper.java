package de.patmobile.paralleldimension.helper;


public enum HarvestLevelHelper {

    //Mine
    RUBIN("rubin", 2),
    SAPHIR("saphir", 2),
    
    //Vanilla
    DIAMOND("wood", 3),
    GOLD("wood", 0),
    IRON("wood", 2),
    STONE("wood", 1),
    WOOD("wood", 0);



    public final int harvestLevel;
    public final String name;

    HarvestLevelHelper( String name, int harvestLevel) {
        this.harvestLevel = harvestLevel;
        this.name = name();
    }
}