/* Copyright (c) 2008-2025, Nathan Sweet
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following
 * conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the distribution.
 * - Neither the name of Esoteric Software nor the names of its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.esotericsoftware.kryo.io;

import java.io.DataOutput;
import java.io.IOException;

/** A {@link DataOutput} which writes data to an {@link Output}.
 * @author Robert DiFalco <robert.difalco@gmail.com> */
public class KryoDataOutput implements DataOutput, AutoCloseable {
	protected Output output;

	public KryoDataOutput (Output output) {
		this.output = output;
	}

	public void setOutput (Output output) {
		this.output = output;
	}

	public void write (int b) throws IOException {
		output.write(b);
	}

	public void write (byte[] b) throws IOException {
		output.write(b);
	}

	public void write (byte[] b, int off, int len) throws IOException {
		output.write(b, off, len);
	}

	public void writeBoolean (boolean v) throws IOException {
		output.writeBoolean(v);
	}

	public void writeByte (int v) throws IOException {
		output.writeByte(v);
	}

	public void writeShort (int v) throws IOException {
		output.writeShort(v);
	}

	public void writeChar (int v) throws IOException {
		output.writeChar((char)v);
	}

	public void writeInt (int v) throws IOException {
		output.writeInt(v);
	}

	public void writeLong (long v) throws IOException {
		output.writeLong(v);
	}

	public void writeFloat (float v) throws IOException {
		output.writeFloat(v);
	}

	public void writeDouble (double v) throws IOException {
		output.writeDouble(v);
	}

	public void writeBytes (String s) throws IOException {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			output.write((byte)s.charAt(i));
		}
	}

	public void writeChars (String s) throws IOException {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			int v = s.charAt(i);
			output.write(v & 0xFF);
			output.write((v >>> 8) & 0xFF);
		}
	}

	public void writeUTF (String s) throws IOException {
		output.writeString(s);
	}

	public void close () throws Exception {
		output.close();
	}
}
