package gwt.dojo.charting.client.themes;

import gwt.dojo.charting.client.Theme;
import gwt.dojo.client.Dojo;

public class Wetland extends Theme {
	public static final String MODULE = "dojox/charting/themes/Wetland";

	public static Wetland ref() {
		return Dojo.require(MODULE).cast();
	}

	protected Wetland() {
	}

}
