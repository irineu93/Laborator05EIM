package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class ProcessingThread extends Thread {
	
	Context context;
	
	public ProcessingThread(Context context) {
		this.context = context;
	}
	
	@Override
	public void run() {
		while(true) {
			this.sendMessage(Constants.MESSAGE_STRING);
			this.sleep();
			
			this.sendMessage(Constants.MESSAGE_INTEGER);
			this.sleep();
			
			this.sendMessage(Constants.MESSAGE_ARRAY_LIST);
			this.sleep();
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(Constants.SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void sendMessage(int type) {
		
		Intent intent = new Intent();
		switch (type) {
		case Constants.MESSAGE_STRING:
			intent.setAction(Constants.ACTION_STRING);
			intent.putExtra(Constants.DATA, Constants.STRING_DATA);
			break;
		case Constants.MESSAGE_INTEGER:
			intent.setAction(Constants.ACTION_INTEGER);
			intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
			break;
		case Constants.MESSAGE_ARRAY_LIST:
			intent.setAction(Constants.ACTION_ARRAY_LIST);
			intent.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
			break;

		default:
			break;
		}
		
		context.sendBroadcast(intent);
		
	}

}
