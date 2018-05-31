import java.io.*;
import org.codehaus.plexus.util.FileUtils;

def log = FileUtils.fileRead(new File(basedir, "build.log"));

assert log.contains("Submitted application: validate-job-spark-properties"), "the configured spark properties were not detected"
assert log.contains("BUILD SUCCESS"), "the build was not successful"
