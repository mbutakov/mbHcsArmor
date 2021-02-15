package mbutakov.utils;

public abstract interface ModelRenderPartModel
{
  public abstract String getType();
  
  public abstract void renderAll();
  
  public abstract void renderOnly(String... paramVarArgs);
  
  public abstract void renderPart(String paramString);
  
  public abstract void renderAllExcept(String... paramVarArgs);
}
