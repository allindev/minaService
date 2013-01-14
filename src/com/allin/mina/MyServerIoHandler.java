/**
 * 
 */
package com.allin.mina;

import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * @author allin
 * 
 */
public class MyServerIoHandler extends IoHandlerAdapter {
	
	
	public Set<IoSession> sessions = new HashSet<IoSession>();
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession ioSession, Object message) throws Exception {
		
		PUD pud = (PUD)message;
		
		int type = pud.getType();
		
		System.out.println("Received PUD type :"+type);
		
		
		
		for (IoSession session : sessions) {
			session.write(pud);
			System.out.println("session.write(pud)..."+session.getId());
		}
		
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE " + session.getIdleCount(status));
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		System.out.println("sessionClosed -> remove session");
		sessions.remove(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		sessions.add(session);
		System.out.println("sessions.add...");
	}

	@Override
	public void sessionOpened(IoSession ioSession) throws Exception {
		super.sessionOpened(ioSession);
		
		for (IoSession session : sessions) {
			PUD pud;
			if (ioSession == session) {
				pud = new PUD((int) session.getId(), GameConstant.GAME_EVENT_LOGIN_SELF, 0, 0, 0, 400, 500, 10, 10);
				System.out.println("ioSession...GAME_EVENT_LOGIN_SELF");
			}else {
				pud = new PUD((int) session.getId(), GameConstant.GAME_EVENT_LOGIN, 0, 0, 0, 400, 500, 10, 10);
				System.out.println("ioSession...GAME_EVENT_LOGIN");
			}
			ioSession.write(pud);
			
		}
		
		for (IoSession session : sessions) {
			PUD pud;
			if (ioSession != session) {
				pud = new PUD((int) ioSession.getId(), GameConstant.GAME_EVENT_LOGIN, 0, 0, 0, 400, 500, 10, 10);
				System.out.println("session...GAME_EVENT_LOGIN");
				session.write(pud);
			}
			
		}
		
		
		
	}
	
	
}
