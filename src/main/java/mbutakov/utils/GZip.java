package mbutakov.utils;

import java.io.IOException;
import java.io.InputStream;

public class GZip
  extends InputStream
{
  private final InputStream is;
  private boolean beingRead;
  
  public GZip(InputStream paramInputStream)
  {
    this.is = paramInputStream;
  }
  
  public int read()
    throws IOException
  {
    return this.beingRead ? this.is.read() : (this.is.read() ^ 0xFFFFFFFF) & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.beingRead = true;
    int i = this.is.read(paramArrayOfByte, paramInt1, paramInt2);
    this.beingRead = false;
    for (int j = paramInt1; j < paramInt1 + i; j++) {
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ 0xFFFFFFFF));
    }
    return i;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.is.skip(paramLong);
  }
  
  public int available()
    throws IOException
  {
    return this.is.available();
  }
  
  public void close()
    throws IOException
  {
    this.is.close();
  }
  
  public synchronized void mark(int paramInt)
  {
    this.is.mark(paramInt);
  }
  
  public synchronized void reset()
    throws IOException
  {
    this.is.reset();
  }
  
  public boolean markSupported()
  {
    return this.is.markSupported();
  }
}
