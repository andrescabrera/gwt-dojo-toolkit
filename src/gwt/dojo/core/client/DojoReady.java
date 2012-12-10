package gwt.dojo.core.client;

public class DojoReady extends JsObject {

	public static final String MODULE = "dojo/ready";

	public static void ready(DojoCallback cb) {
		Dojo.require(JsArray.create(MODULE), cb);
	}

	protected DojoReady() {
	}
}
