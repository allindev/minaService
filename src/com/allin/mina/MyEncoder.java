/**
 * 
 */
package com.allin.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * @author allin
 * 
 */
public class MyEncoder extends ProtocolEncoderAdapter {

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		PUD pud = (PUD) message;
		IoBuffer buffer = IoBuffer.allocate(36, false);
		buffer.setAutoExpand(true);
		buffer.putInt(pud.getSession());
		buffer.putInt(pud.getType());
		buffer.putInt(pud.getDirection());
		buffer.putInt(pud.getSpeed());
		buffer.putInt(pud.getAccelerations());
		buffer.putInt(pud.getX1());
		buffer.putInt(pud.getY1());
		buffer.putInt(pud.getX2());
		buffer.putInt(pud.getY2());
		buffer.flip();
		out.write(buffer);

		System.out.println("encode PUD: " + pud.getSession() + "," + pud.getType() + "," + pud.getX1() + "," + pud.getY1() + "," + pud.getX2() + "," + pud.getY2());
	}

}
