package fr.formation.inti.action;

import com.opensymphony.xwork2.ActionSupport;

import fr.formation.inti.model.MessageStore;

public class HelloStrutsAction extends ActionSupport {
	
	private MessageStore messageStore ; 
	private Personne personne ; 
	
	@Override
	public String execute() throws Exception {
		if(messageStore == null) 
			messageStore = new MessageStore();
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}


	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	

	
}
