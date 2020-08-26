package klib.exceptions

import java.lang.Exception

class ZipTraversalNotAllowedException(filePath: String) : Exception("ZipFile found a path that seems to try to traverse out of the Zip Package: $filePath")
