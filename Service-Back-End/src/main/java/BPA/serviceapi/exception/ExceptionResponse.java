/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.exception;

/**
 *
 * @author THL
 */
import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
        private boolean success ;
	private String message;
	private String detalles;
	private String httpCodeMessage;

	public ExceptionResponse(Date timestamp, String message, String details,String httpCodeMessage,boolean success) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detalles = details;
		this.httpCodeMessage=httpCodeMessage;
                this.success=success;
	}

	public String getHttpCodeMessage() {
            return httpCodeMessage;
	}

	public Date getTimestamp() {
            return timestamp;
	}

	public String getMessage() {
            return message;
	}

	public String getDetalles() {
            return detalles;
	}
        public boolean getsuccess() {
            return success;
	}

}