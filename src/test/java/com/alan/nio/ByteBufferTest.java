package com.alan.nio;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ByteBufferTest {
    @Test
    public void writeFile() throws IOException {
        File file=new File("");
      FileChannel fileChannel=  FileChannel.open(null, StandardOpenOption.WRITE);
      fileChannel.write(ByteBuffer.allocate(2));
    }
    @Test
    public  void main() {
        File file = new File("D://data.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];

        try {
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, len);
            for (int offset = 0; offset < len; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }

            Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
            while (scan.hasNext()) {
                System.out.print(scan.next() + " ");
            }

        } catch (IOException e) {}
    }

    class Solution {
        public boolean isPalindrome(String s) {

            s=s.toLowerCase();
            for(int i=0,j=s.length()-1;i<j;){
//                if(i==j)
//                    return true;
                if(!isNumOrAlphabet(s.charAt(i))){
                    i++;
                    continue;
                }
                if(!isNumOrAlphabet(s.charAt(j)){
                    j--;
                    continue;
                }

                if(s.charAt(i)==s.charAt(j)){
                    i++;j--;
                    continue;
                }

                else
                    return false;

            }
            return true;

        }
        private boolean isNumOrAlphabet(char c){
            return (c>='0'&&c<='9')||(c>='a'&&c<='z');
        }
    }



    @Test
    public void name() {
        "s".equals()
        Solution solution=new Solution();
        boolean b=solution.isPalindrome("OP");
        System.out.println(b);
    }
}
