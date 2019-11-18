package com.goat.chapter235;

import java.io.DataInput;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/15---15:28
 */
public class ByteArrayInStream implements DataInput {

    private byte[] buf;
    private int index;
    private int offset;
    private int length;


    public ByteArrayInStream(byte[] array){
        this.buf = array;
    }


    public ByteArrayInStream(byte[] array,int offset,int length){
        this.buf = array;
        this.offset = offset;
        this.index = offset;
    }


    public boolean isAtEnd(){
        return index - offset == length;
    }

    @Override
    public void readFully(byte[] b) throws IOException {
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
    }

    @Override
    public int skipBytes(int n) throws IOException {
        this.index += n;
        return this.index;
    }

    @Override
    public boolean readBoolean() throws IOException {
        boolean result = false;
        if(buf[index] == 1){
            result = true;
        }
        indexInc(1);
        return result;
    }

    @Override
    public byte readByte() throws IOException {
        byte result = buf[index];
        indexInc(1);
        return result;
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int result = buf[index] & 0xFF;
        indexInc(1);
        return result;
    }

    public byte[] readBytes(int len){
        byte [] result = new byte[len];
        for(int i = index;i<index + len;i++){
            result[i-index] = buf[i];
        }
        return result;
    }

    @Override
    public short readShort() throws IOException {
        return bytesToShort();
    }

    @Override
    public int readUnsignedShort() throws IOException {
        return bytesToUnsignShort();
    }


    @Override
    public char readChar() throws IOException {
        return (char)readShort();
    }

    @Override
    public int readInt() throws IOException {
        return bytesToInt();
    }

    @Override
    public long readLong() throws IOException {
        return bytesToLong();
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override
    public String readLine() throws IOException {
        return readUTF();
    }

    @Override
    public String readUTF() throws IOException {
        return bytesToString();
    }


    private String bytesToString()throws IOException{
        int len = readUnsignedShort();
        char[] array = new char[len];
        for(int i=0;i<len;i++){
            array[i] = readChar();
        }
        return new String(array);
    }

    private long bytesToLong() {
        long num = 0;
        for(int i = index; i < index+8; i++) {
            num <<= 8;
            num |= (buf[i] & 0xff);
        }
        indexInc(8);
        return num;
    }

    private int bytesToInt() {
        int num = 0;
        for(int i = index; i < index+4; i++) {
            num <<= 8;
            num |= (buf[i] & 0xff);
        }
        indexInc(4);
        return num;
    }

    private short bytesToShort() {
        short num = 0;
        for(int i = index; i < index+2; i++) {
            num <<= 8;
            num |= (buf[i] & 0xff);
        }
        indexInc(2);
        return num;
    }


    private int bytesToUnsignShort() {
        int num = 0;
        for(int i = index; i < index+2; i++) {
            num <<= 8;
            num |= (buf[i] & 0xff);
        }
        indexInc(2);
        return num;
    }


    private void indexInc(int n){
        this.index += n;
    }

}

