package retroplay.Helper;

import retroplay.models.MessageObject;

public class MessageBuilder {
	
	// Builds Message Object by taking message and status as Input
	public MessageObject buildMessageObject(String message,boolean status){
		MessageObject messageObj = new MessageObject();				
		messageObj.setMessage(message);
		messageObj.setStatus(status);
		return messageObj;
	}

}
