package com.google.code.rapid.queue.model;

import java.io.Serializable;

import com.google.code.rapid.queue.util.HessianUtil;
import com.google.code.rapid.queue.util.JavaSerUtil;


public class Message implements Serializable{

	private static final long serialVersionUID = 7156950587289464765L;
	
	private String exchange; // exchange
	private String routerKey; // 路由key
	private byte[] body; // 消息体
	
	private MessageProperties messageProperties; // 消息附加属性
	
	private String queueName; //message当前所在的队列名称
	
	
	public Message() {
	}

	public Message(byte[] body) {
		super();
		this.body = body;
	}

	public Message(String exchange, String routerKey, byte[] body) {
		super();
		this.exchange = exchange;
		this.routerKey = routerKey;
		this.body = body;
	}

	public String getRouterKey() {
		return routerKey;
	}

	public void setRouterKey(String routerKey) {
		this.routerKey = routerKey;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public MessageProperties getMessageProperties() {
		return messageProperties;
	}

	public void setMessageProperties(MessageProperties messageProperties) {
		this.messageProperties = messageProperties;
	}
	
	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public byte[] toBytes() {
		return JavaSerUtil.toBytes(this, body.length + 500);
	}
	
	public static byte[] toBytes(Message msg) {
		if(msg == null) return null;
		return msg.toBytes();
	}
	
	public static Message fromBytes(byte[] bytes) {
		return JavaSerUtil.fromBytes(bytes, Message.class);
	}

	@Override
	public String toString() {
		return "Message [exchange=" + exchange + ", routerKey=" + routerKey
				+ ", body.length=" + (body == null ? "null" : body.length) + ", messageProperties="
				+ messageProperties + "]";
	}
	
}
