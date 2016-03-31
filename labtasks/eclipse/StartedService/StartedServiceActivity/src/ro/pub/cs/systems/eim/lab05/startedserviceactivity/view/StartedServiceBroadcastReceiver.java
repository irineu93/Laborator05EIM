package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 8 - default constructor
    public StartedServiceBroadcastReceiver() {
    	this.messageTextView = null;
    }

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 6 - get the action and the extra information from the intent
        // and set the text on the messageTextView
    	
    	String actionStr = intent.getAction();
    	String dataStr = null;
    	
    	if (actionStr.equals(Constants.ACTION_STRING)) {
    		dataStr = intent.getStringExtra(Constants.DATA);
    	}
    	else if (actionStr.equals(Constants.ACTION_INTEGER)) {
    		dataStr = Integer.toString(intent.getIntExtra(Constants.DATA, -1));
    	}
    	else if (actionStr.equals(Constants.ACTION_ARRAY_LIST)) {
    		dataStr = intent.getStringArrayListExtra(Constants.DATA).toString();
    	}
    	
    	if (messageTextView != null) {
    		messageTextView.setText(messageTextView.getText() + "\n" + dataStr);
    	}

        // TODO: exercise 8 - restart the activity through an intent
        // if the messageTextView is not available
    	else {
	    	Intent startedServiceActivityIntent = new Intent(context, StartedServiceActivity.class);
	    	startedServiceActivityIntent.putExtra(Constants.MESSAGE, dataStr);
	   	  	startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
	   	  	context.startActivity(startedServiceActivityIntent);
    	}
    }

}
