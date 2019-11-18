package com.goat.chapter235;

import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/15---15:28
 */
public class ByteArrayOutStream implements DataOutput {
    /**
     * 数组
     */
    private byte [] buf;

    /**
     * 下标位置
     */
    private int index;

    public ByteArrayOutStream(byte[] array){
        this.buf = array;
    }


    public ByteArrayOutStream(byte[] array,int offset){
        this.buf = array;
        this.index = offset;
    }

    @Override
    public void write(int b) throws IOException {
        intToBytes(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        if(b == null || b.length == 0){
            return;
        }

        for(byte i : b){
            writeByte(i);
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if(b == null || b.length == 0){
            return;
        }

        if(off+len >= b.length){
            throw new IOException("传入的数组长度不足");
        }

        for(int i=off;i<off+len;i++){
            writeByte(b[i]);
        }

    }

    @Override
    public void writeBoolean(boolean v) throws IOException {
        if(v){
            writeByte(1);
        }else{
            writeByte(0);
        }
    }


    @Override
    public void writeByte(int v) throws IOException {
        this.buf[index] = (byte)v;
        indexInc(1);
    }

    @Override
    public void writeShort(int v) throws IOException {
        shortToBytes(v);
    }

    @Override
    public void writeChar(int v) throws IOException {
        shortToBytes(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        write(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        longToBytes(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        writeInt(Float.floatToIntBits(v));
    }

    @Override
    public void writeDouble(double v) throws IOException {
        writeLong(Double.doubleToLongBits(v));
    }

    @Override
    public void writeBytes(String s) throws IOException {
        writeUTF(s);
    }

    @Override
    public void writeChars(String s) throws IOException {
        writeUTF(s);
    }

    @Override
    public void writeUTF(String s) throws IOException {
        strToBytes(s);
    }


    private void strToBytes(String s)throws IOException{
        int len = s.length();
        if(len > 65535){
            throw new IOException("字符串长度太长");
        }

        writeShort(len);
        for(int i=0;i<len;i++){
            char charAt = s.charAt(i);
            writeShort(charAt);
        }

    }


    private void intToBytes(int v) {
        for(int i = 0; i < 4; i++) {
            buf[index + i] = (byte)(v >>> (24 - i * 8));
        }

        indexInc(4);
    }


    private void shortToBytes(int v){
        for(int i = 0; i < 2; i++) {
            buf[index + i] = (byte)(v >>> (8 - i * 8));
        }

        indexInc(2);
    }

    private void longToBytes(long v){
        for(int i = 0; i < 8; i++) {
            buf[index + i] = (byte)(v >>> (56 - i * 8));
        }

        indexInc(8);
    }



    private void indexInc(int inc){
        this.index += inc;
    }

    public String toString(){
        return Arrays.toString(buf);
    }


    public static void main(String ...args)throws Exception{
        byte [] array = new byte[10];
        ByteArrayOutStream out = new ByteArrayOutStream(array,0);
        out.writeInt(2000);

        System.out.println(out);
    }

    public int getIndex() {
        return index;
    }

}

