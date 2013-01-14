/**
 * 
 */
package com.allin.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * @author allin
 * 
 */
public class MyDecode extends CumulativeProtocolDecoder {

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		System.out.println("remaining:" + in.remaining());
		if (in.remaining() >= 36) {

			int pud_session = in.getInt();
			int type = in.getInt();
			int direction = in.getInt();
			int speed = in.getInt();
			int accelerations = in.getInt();
			int x1 = in.getInt();
			int y1 = in.getInt();
			int x2 = in.getInt();
			int y2 = in.getInt();

			PUD pud = new PUD(pud_session, type, direction, speed, accelerations, x1, y1, x2, y2);
			System.out.println("doDecode PUD: " + pud.getSession() + "," + pud.getType() + "," + pud.getX1() + "," + pud.getY1() + "," + pud.getX2() + "," + pud.getY2());
			out.write(pud);
			return true;
		} else {
			return false;
		}
	}

}
