package org.apache.cordova.plugin;

    import org.apache.cordova.CordovaPlugin;
    import org.apache.cordova.CallbackContext;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;
	import android.content.Context;
	import android.os.Vibrator;

    /**
     * This class echoes a string called from JavaScript.
     */
    public class Echo extends CordovaPlugin {
	
	    public Echo() {
    }

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            Vibrator vibrator = (Vibrator) this.cordova.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
			vibrator.vibrate(4500);
			this.echo("bloop", callbackContext);
            return true;
        }

        private void echo(String message, CallbackContext callbackContext) {
            if (message != null && message.length() > 0) {
                callbackContext.success(message);
            } else {
                callbackContext.error("Expected one non-empty string argument.");
            }
        }
    }