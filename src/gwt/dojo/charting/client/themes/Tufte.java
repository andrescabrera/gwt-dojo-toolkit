package gwt.dojo.charting.client.themes;

import gwt.dojo.charting.client.Theme;
import gwt.dojo.core.client.Dojo;

public class Tufte extends Theme {
	public static final String MODULE = "dojox/charting/themes/Tufte";

	public static Wetland ref() {
		return Dojo.require(MODULE).cast();
	}

	protected Tufte() {
	}
}
