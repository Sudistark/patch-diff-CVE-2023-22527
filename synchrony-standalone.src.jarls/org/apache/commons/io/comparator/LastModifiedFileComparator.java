package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class LastModifiedFileComparator extends AbstractFileComparator implements Serializable {
  private static final long serialVersionUID = 7372168004395734046L;
  
  public static final Comparator<File> LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
  
  public static final Comparator<File> LASTMODIFIED_REVERSE = new ReverseFileComparator(LASTMODIFIED_COMPARATOR);
  
  public int compare(File file1, File file2) {
    long result = FileUtils.lastModifiedUnchecked(file1) - FileUtils.lastModifiedUnchecked(file2);
    if (result < 0L)
      return -1; 
    if (result > 0L)
      return 1; 
    return 0;
  }
}
