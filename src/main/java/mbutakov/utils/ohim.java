package mbutakov.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.obj.Face;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
public class ohim
  implements ModelRenderPartModel
{
  private static Pattern vertexPattern = Pattern.compile("(v( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(v( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
  private static Pattern vertexNormalPattern = Pattern.compile("(vn( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(vn( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
  private static Pattern textureCoordinatePattern = Pattern.compile("(vt( (\\-){0,1}\\d+\\.\\d+){2,3} *\\n)|(vt( (\\-){0,1}\\d+\\.\\d+){2,3} *$)");
  private static Pattern face_V_VT_VN_Pattern = Pattern.compile("(f( \\d+/\\d+/\\d+){3,4} *\\n)|(f( \\d+/\\d+/\\d+){3,4} *$)");
  private static Pattern face_V_VT_Pattern = Pattern.compile("(f( \\d+/\\d+){3,4} *\\n)|(f( \\d+/\\d+){3,4} *$)");
  private static Pattern face_V_VN_Pattern = Pattern.compile("(f( \\d+//\\d+){3,4} *\\n)|(f( \\d+//\\d+){3,4} *$)");
  private static Pattern face_V_Pattern = Pattern.compile("(f( \\d+){3,4} *\\n)|(f( \\d+){3,4} *$)");
  private static Pattern groupObjectPattern = Pattern.compile("([go]( [\\w\\d]+) *\\n)|([go]( [\\w\\d]+) *$)");
  private static Matcher vertexMatcher;
  private static Matcher vertexNormalMatcher;
  private static Matcher textureCoordinateMatcher;
  private static Matcher face_V_VT_VN_Matcher;
  private static Matcher face_V_VT_Matcher;
  private static Matcher face_V_VN_Matcher;
  private static Matcher face_V_Matcher;
  private static Matcher groupObjectMatcher;
  public ArrayList<Vertex> vertices = new ArrayList();
  public ArrayList<Vertex> vertexNormals = new ArrayList();
  public ArrayList<TextureCoordinate> textureCoordinates = new ArrayList();
  public ArrayList<GroupObject> groupObjects = new ArrayList();
  private GroupObject currentGroupObject;
  private String fileName;
  
  public ohim(String paramString, URL paramURL)
    throws ModelFormatException
  {
    this.fileName = paramString;
    try
    {
      loadObjModel(paramURL.openStream());
    }
    catch (IOException localIOException)
    {
      throw new ModelFormatException("IO Exception reading model format", localIOException);
    }
  }
  
  public ohim(String paramString, InputStream paramInputStream)
    throws ModelFormatException
  {
    this.fileName = paramString;
    loadObjModel(paramInputStream);
  }
  
  private void loadObjModel(InputStream paramInputStream)
    throws ModelFormatException
  {
    BufferedReader localBufferedReader = null;
    String str = null;
    int i = 0;
    try
    {
      byte[] arrayOfByte = readAllFromAndClose(paramInputStream);
      try
      {
        localBufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new GZip(new ByteArrayInputStream(arrayOfByte)))));
        str = localBufferedReader.readLine();
      }
      catch (Throwable localThrowable) {}
      if (str == null)
      {
        localBufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(arrayOfByte)));
        str = localBufferedReader.readLine();
      }
      do
      {
        i++;
        if ((!(str = str.replaceAll("\\s+", " ").trim()).startsWith("#")) && (str.length() != 0))
        {
          Vertex localVertex;
          if (str.startsWith("v "))
          {
            localVertex = parseVertex(str, i);
            if (localVertex != null) {
              this.vertices.add(localVertex);
            }
          }
          else if (str.startsWith("vn "))
          {
            localVertex = parseVertexNormal(str, i);
            if (localVertex != null) {
              this.vertexNormals.add(localVertex);
            }
          }
          else
          {
            Object localObject;
            if (str.startsWith("vt "))
            {
              localObject = parseTextureCoordinate(str, i);
              if (localObject != null) {
                this.textureCoordinates.add((TextureCoordinate) localObject);
              }
            }
            else if (str.startsWith("f "))
            {
              if (this.currentGroupObject == null) {
                this.currentGroupObject = new GroupObject("Default");
              }
              if ((localObject = parseFace(str, i)) != null) {
                this.currentGroupObject.faces.add((Face) localObject);
              }
            }
            else if ((str.startsWith("g ") | str.startsWith("o ")))
            {
              localObject = parseGroupObject(str, i);
              if ((localObject != null) && (this.currentGroupObject != null)) {
                this.groupObjects.add(this.currentGroupObject);
              }
              this.currentGroupObject = ((GroupObject)localObject);
            }
          }
        }
      } while ((str = localBufferedReader.readLine()) != null);
      this.groupObjects.add(this.currentGroupObject);
    }
    catch (IOException localIOException)
    {
      throw new ModelFormatException("IO Exception reading model format", localIOException);
    }
  }
  
  private byte[] readAllFromAndClose(final InputStream inputStream) throws IOException {
      try {
          final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
          final byte[] array = new byte[1024];
          int read;
          while ((read = inputStream.read(array)) != -1) {
              byteArrayOutputStream.write(array, 0, read);
          }
          inputStream.close();
          return byteArrayOutputStream.toByteArray();
      }
      finally {
          try {
              inputStream.close();
          }
          catch (IOException ex) {}
      }
  }
  
  public void renderAll()
  {
    Tessellator localTessellator = Tessellator.instance;
    if (this.currentGroupObject != null) {
      localTessellator.startDrawing(this.currentGroupObject.glDrawingMode);
    } else {
      localTessellator.startDrawing(4);
    }
    tessellateAll(localTessellator);
    
    localTessellator.draw();
  }
  
  public void tessellateAll(Tessellator paramTessellator)
  {
    for (GroupObject localGroupObject : this.groupObjects) {
      localGroupObject.render(paramTessellator);
    }
  }
  
  public void renderOnly(String... paramVarArgs)
  {
    for (GroupObject localGroupObject : this.groupObjects) {
      for (String str : paramVarArgs) {
        if (str.equalsIgnoreCase(localGroupObject.name)) {
          localGroupObject.render();
        }
      }
    }
  }
  
  public void tessellateOnly(Tessellator paramTessellator, String... paramVarArgs)
  {
    for (GroupObject localGroupObject : this.groupObjects) {
      for (String str : paramVarArgs) {
        if (str.equalsIgnoreCase(localGroupObject.name)) {
          localGroupObject.render(paramTessellator);
        }
      }
    }
  }
  
  public void renderPart(String paramString)
  {
    for (GroupObject localGroupObject : this.groupObjects) {
      if (paramString.equalsIgnoreCase(localGroupObject.name)) {
        localGroupObject.render();
      }
    }
  }
  
  public void tessellatePart(Tessellator paramTessellator, String paramString)
  {
    for (GroupObject localGroupObject : this.groupObjects) {
      if (paramString.equalsIgnoreCase(localGroupObject.name)) {
        localGroupObject.render(paramTessellator);
      }
    }
  }
  
  public void renderAllExcept(String... paramVarArgs)
  {
    for (GroupObject localGroupObject : this.groupObjects)
    {
      int i = 0;
      for (String str : paramVarArgs) {
        if (str.equalsIgnoreCase(localGroupObject.name)) {
          i = 1;
        }
      }
      if (i == 0) {
        localGroupObject.render();
      }
    }
  }
  
  public void tessellateAllExcept(Tessellator paramTessellator, String... paramVarArgs)
  {
    for (GroupObject localGroupObject : this.groupObjects)
    {
      int i = 0;
      for (String str : paramVarArgs) {
        if (str.equalsIgnoreCase(localGroupObject.name)) {
          i = 1;
        }
      }
      if (i == 0) {
        localGroupObject.render(paramTessellator);
      }
    }
  }
  
  private Vertex parseVertex(String paramString, int paramInt)
    throws ModelFormatException
  {
    if (isValidVertexLine(paramString))
    {
      paramString = paramString.substring(paramString.indexOf(" ") + 1);
      String[] arrayOfString = paramString.split(" ");
      try
      {
        if (arrayOfString.length == 2) {
          return new Vertex(Float.parseFloat(arrayOfString[0]), Float.parseFloat(arrayOfString[1]));
        }
        if (arrayOfString.length == 3) {
          return new Vertex(Float.parseFloat(arrayOfString[0]), Float.parseFloat(arrayOfString[1]), Float.parseFloat(arrayOfString[2]));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ModelFormatException(String.format("Number formatting error at line %d", new Object[] { Integer.valueOf(paramInt) }), localNumberFormatException);
      }
    }
    else
    {
      throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Incorrect format");
    }
    return null;
  }
  
  private Vertex parseVertexNormal(String paramString, int paramInt)
    throws ModelFormatException
  {
    if (isValidVertexNormalLine(paramString))
    {
      paramString = paramString.substring(paramString.indexOf(" ") + 1);
      String[] arrayOfString = paramString.split(" ");
      try
      {
        if (arrayOfString.length == 3) {
          return new Vertex(Float.parseFloat(arrayOfString[0]), Float.parseFloat(arrayOfString[1]), Float.parseFloat(arrayOfString[2]));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ModelFormatException(String.format("Number formatting error at line %d", new Object[] { Integer.valueOf(paramInt) }), localNumberFormatException);
      }
    }
    else
    {
      throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Incorrect format");
    }
    return null;
  }
  
  private TextureCoordinate parseTextureCoordinate(String paramString, int paramInt)
    throws ModelFormatException
  {
    if (isValidTextureCoordinateLine(paramString))
    {
      paramString = paramString.substring(paramString.indexOf(" ") + 1);
      String[] arrayOfString = paramString.split(" ");
      try
      {
        if (arrayOfString.length == 2) {
          return new TextureCoordinate(Float.parseFloat(arrayOfString[0]), 1.0F - Float.parseFloat(arrayOfString[1]));
        }
        if (arrayOfString.length == 3) {
          return new TextureCoordinate(Float.parseFloat(arrayOfString[0]), 1.0F - Float.parseFloat(arrayOfString[1]), Float.parseFloat(arrayOfString[2]));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ModelFormatException(String.format("Number formatting error at line %d", new Object[] { Integer.valueOf(paramInt) }), localNumberFormatException);
      }
    }
    else
    {
      throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Incorrect format");
    }
    return null;
  }
  
  private Face parseFace(String paramString, int paramInt)
    throws ModelFormatException
  {
    Face localFace;
    if (isValidFaceLine(paramString))
    {
      localFace = new Face();
      
      String str = paramString.substring(paramString.indexOf(" ") + 1);
      String[] arrayOfString1 = str.split(" ");
      if (arrayOfString1.length == 3)
      {
        if (this.currentGroupObject.glDrawingMode == -1) {
          this.currentGroupObject.glDrawingMode = 4;
        } else if (this.currentGroupObject.glDrawingMode != 4) {
          throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 4, found " + arrayOfString1.length + ")");
        }
      }
      else if (arrayOfString1.length == 4) {
        if (this.currentGroupObject.glDrawingMode == -1) {
          this.currentGroupObject.glDrawingMode = 7;
        } else if (this.currentGroupObject.glDrawingMode != 7) {
          throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 3, found " + arrayOfString1.length + ")");
        }
      }
      int i;
      String[] arrayOfString2;
      if (isValidFace_V_VT_VN_Line(paramString))
      {
        localFace.vertices = new Vertex[arrayOfString1.length];
        localFace.textureCoordinates = new TextureCoordinate[arrayOfString1.length];
        localFace.vertexNormals = new Vertex[arrayOfString1.length];
        for (i = 0; i < arrayOfString1.length; i++)
        {
          arrayOfString2 = arrayOfString1[i].split("/");
          
          localFace.vertices[i] = ((Vertex)this.vertices.get(Integer.parseInt(arrayOfString2[0]) - 1));
          localFace.textureCoordinates[i] = ((TextureCoordinate)this.textureCoordinates.get(Integer.parseInt(arrayOfString2[1]) - 1));
          localFace.vertexNormals[i] = ((Vertex)this.vertexNormals.get(Integer.parseInt(arrayOfString2[2]) - 1));
        }
        localFace.faceNormal = localFace.calculateFaceNormal();
      }
      else if (isValidFace_V_VT_Line(paramString))
      {
        localFace.vertices = new Vertex[arrayOfString1.length];
        localFace.textureCoordinates = new TextureCoordinate[arrayOfString1.length];
        for (i = 0; i < arrayOfString1.length; i++)
        {
          arrayOfString2 = arrayOfString1[i].split("/");
          
          localFace.vertices[i] = ((Vertex)this.vertices.get(Integer.parseInt(arrayOfString2[0]) - 1));
          localFace.textureCoordinates[i] = ((TextureCoordinate)this.textureCoordinates.get(Integer.parseInt(arrayOfString2[1]) - 1));
        }
        localFace.faceNormal = localFace.calculateFaceNormal();
      }
      else if (isValidFace_V_VN_Line(paramString))
      {
        localFace.vertices = new Vertex[arrayOfString1.length];
        localFace.vertexNormals = new Vertex[arrayOfString1.length];
        for (i = 0; i < arrayOfString1.length; i++)
        {
          arrayOfString2 = arrayOfString1[i].split("//");
          
          localFace.vertices[i] = ((Vertex)this.vertices.get(Integer.parseInt(arrayOfString2[0]) - 1));
          localFace.vertexNormals[i] = ((Vertex)this.vertexNormals.get(Integer.parseInt(arrayOfString2[1]) - 1));
        }
        localFace.faceNormal = localFace.calculateFaceNormal();
      }
      else if (isValidFace_V_Line(paramString))
      {
        localFace.vertices = new Vertex[arrayOfString1.length];
        for (i = 0; i < arrayOfString1.length; i++) {
          localFace.vertices[i] = ((Vertex)this.vertices.get(Integer.parseInt(arrayOfString1[i]) - 1));
        }
        localFace.faceNormal = localFace.calculateFaceNormal();
      }
      else
      {
        throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Incorrect format");
      }
    }
    else
    {
      throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Incorrect format");
    }
    return localFace;
  }
  
  private GroupObject parseGroupObject(String paramString, int paramInt)
    throws ModelFormatException
  {
    GroupObject localGroupObject = null;
    if (isValidGroupObjectLine(paramString))
    {
      String str = paramString.substring(paramString.indexOf(" ") + 1);
      if (str.length() > 0) {
        localGroupObject = new GroupObject(str);
      }
    }
    else
    {
      throw new ModelFormatException("Error parsing entry ('" + paramString + "', line " + paramInt + ") in file '" + this.fileName + "' - Incorrect format");
    }
    return localGroupObject;
  }
  
  private static boolean isValidVertexLine(String paramString)
  {
    if (vertexMatcher != null) {
      vertexMatcher.reset();
    }
    vertexMatcher = vertexPattern.matcher(paramString);
    return vertexMatcher.matches();
  }
  
  private static boolean isValidVertexNormalLine(String paramString)
  {
    if (vertexNormalMatcher != null) {
      vertexNormalMatcher.reset();
    }
    vertexNormalMatcher = vertexNormalPattern.matcher(paramString);
    return vertexNormalMatcher.matches();
  }
  
  private static boolean isValidTextureCoordinateLine(String paramString)
  {
    if (textureCoordinateMatcher != null) {
      textureCoordinateMatcher.reset();
    }
    textureCoordinateMatcher = textureCoordinatePattern.matcher(paramString);
    return textureCoordinateMatcher.matches();
  }
  
  private static boolean isValidFace_V_VT_VN_Line(String paramString)
  {
    if (face_V_VT_VN_Matcher != null) {
      face_V_VT_VN_Matcher.reset();
    }
    face_V_VT_VN_Matcher = face_V_VT_VN_Pattern.matcher(paramString);
    return face_V_VT_VN_Matcher.matches();
  }
  
  private static boolean isValidFace_V_VT_Line(String paramString)
  {
    if (face_V_VT_Matcher != null) {
      face_V_VT_Matcher.reset();
    }
    face_V_VT_Matcher = face_V_VT_Pattern.matcher(paramString);
    return face_V_VT_Matcher.matches();
  }
  
  private static boolean isValidFace_V_VN_Line(String paramString)
  {
    if (face_V_VN_Matcher != null) {
      face_V_VN_Matcher.reset();
    }
    face_V_VN_Matcher = face_V_VN_Pattern.matcher(paramString);
    return face_V_VN_Matcher.matches();
  }
  
  private static boolean isValidFace_V_Line(String paramString)
  {
    if (face_V_Matcher != null) {
      face_V_Matcher.reset();
    }
    face_V_Matcher = face_V_Pattern.matcher(paramString);
    return face_V_Matcher.matches();
  }
  
  private static boolean isValidFaceLine(String paramString)
  {
    return (isValidFace_V_VT_VN_Line(paramString)) || (isValidFace_V_VT_Line(paramString)) || (isValidFace_V_VN_Line(paramString)) || (isValidFace_V_Line(paramString));
  }
  
  private static boolean isValidGroupObjectLine(String paramString)
  {
    if (groupObjectMatcher != null) {
      groupObjectMatcher.reset();
    }
    groupObjectMatcher = groupObjectPattern.matcher(paramString);
    return groupObjectMatcher.matches();
  }
  
  public String getType()
  {
    return "obj";
  }
}
